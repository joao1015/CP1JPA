package br.com.fiap.javacp1.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ESPECIALISTA")  // Valor textual para a coluna TIPO_FUNCIONARIO
public class Especialista extends Funcionario {

    public Especialista() {}

    public Especialista(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora, TipoFuncionario.ESPECIALISTA);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorPorHora();
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Especialista");
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}
