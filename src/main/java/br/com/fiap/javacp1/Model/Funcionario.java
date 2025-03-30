package br.com.fiap.javacp1.Model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "TIPO_FUNCIONARIO",  // Nome da coluna discriminadora
        discriminatorType = DiscriminatorType.STRING,
        columnDefinition = "VARCHAR2(20)"  // Tipo de dado no Oracle
)
@Table(name = "TAB_FUNCIONARIO")
public abstract class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int horasTrabalhadas;
    private double valorPorHora;

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipoFuncionario;

    public Funcionario() {}

    public Funcionario(String nome, int horasTrabalhadas, double valorPorHora, TipoFuncionario tipoFuncionario) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
        this.tipoFuncionario = tipoFuncionario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public abstract double calcularSalario();

    public void imprimirInformacao() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$" + valorPorHora);
    }
}
