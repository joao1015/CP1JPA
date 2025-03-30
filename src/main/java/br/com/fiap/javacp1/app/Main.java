package br.com.fiap.javacp1.app;

import br.com.fiap.javacp1.Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static EntityManagerFactory emf;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("FuncionarioPU");
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n=== Sistema de Gestão de Funcionários ===");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Todos os Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Deletar Funcionário");
            System.out.println("5. Calcular Salários");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> atualizarFuncionario();
                case 4 -> deletarFuncionario();
                case 5 -> calcularSalarios();
                case 6 -> {
                    emf.close();
                    System.out.println("Sistema encerrado!");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n=== Cadastro de Funcionário ===");
        System.out.println("1. Estagiário\n2. Júnior\n3. Pleno\n4. Sênior\n5. Especialista");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Horas Trabalhadas: ");
        int horas = scanner.nextInt();

        System.out.print("Valor por Hora: ");
        double valorHora = scanner.nextDouble();
        scanner.nextLine();

        Funcionario func = switch (tipo) {
            case 1 -> new Estagiario(nome, horas, valorHora);
            case 2 -> new Junior(nome, horas, valorHora);
            case 3 -> new Pleno(nome, horas, valorHora);
            case 4 -> new Senior(nome, horas, valorHora);
            case 5 -> new Especialista(nome, horas, valorHora);
            default -> throw new IllegalArgumentException("Tipo inválido!");
        };

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(func);
        em.getTransaction().commit();
        em.close();

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void listarFuncionarios() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery(
                "SELECT f FROM Funcionario f", Funcionario.class).getResultList();

        System.out.println("\n=== Lista de Funcionários ===");
        funcionarios.forEach(f -> {
            f.imprimirInformacao();
            System.out.println("----------------------------");
        });
        em.close();
    }

    private static void atualizarFuncionario() {
        System.out.print("\nDigite o ID do funcionário: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        EntityManager em = emf.createEntityManager();
        Funcionario func = em.find(Funcionario.class, id);

        if (func != null) {
            System.out.print("Novo Nome: ");
            func.setNome(scanner.nextLine());

            System.out.print("Novas Horas: ");
            func.setHorasTrabalhadas(scanner.nextInt());

            System.out.print("Novo Valor Hora: ");
            func.setValorPorHora(scanner.nextDouble());
            scanner.nextLine();

            em.getTransaction().begin();
            em.merge(func);
            em.getTransaction().commit();
            System.out.println("Funcionário atualizado!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
        em.close();
    }

    private static void deletarFuncionario() {
        System.out.print("\nDigite o ID do funcionário: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        EntityManager em = emf.createEntityManager();
        Funcionario func = em.find(Funcionario.class, id);

        if (func != null) {
            em.getTransaction().begin();
            em.remove(func);
            em.getTransaction().commit();
            System.out.println("Funcionário removido!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
        em.close();
    }

    private static void calcularSalarios() {
        EntityManager em = emf.createEntityManager();
        List<Funcionario> funcionarios = em.createQuery(
                "SELECT f FROM Funcionario f", Funcionario.class).getResultList();

        System.out.println("\n=== Cálculo de Salários ===");
        funcionarios.forEach(f -> {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getClass().getSimpleName());
            System.out.println("Salário Total: R$" + f.calcularSalario());
            System.out.println("----------------------------");
        });
        em.close();
    }
}