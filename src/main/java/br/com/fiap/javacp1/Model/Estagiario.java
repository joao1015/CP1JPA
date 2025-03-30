package br.com.fiap.javacp1.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ESTAGIARIO")  // Valor textual para a coluna TIPO_FUNCIONARIO
public class Estagiario extends Funcionario {

    public Estagiario() {
        super(null, 0, 0.0, TipoFuncionario.ESTAGIARIO);
    }

    public Estagiario(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora, TipoFuncionario.ESTAGIARIO);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorPorHora();
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Estagiário");
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}
