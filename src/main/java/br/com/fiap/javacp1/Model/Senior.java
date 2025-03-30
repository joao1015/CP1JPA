package br.com.fiap.javacp1.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SENIOR")  // Valor textual para a coluna TIPO_FUNCIONARIO
public class Senior extends Funcionario {

    public Senior() {}

    public Senior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora, TipoFuncionario.SENIOR);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorPorHora();
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Sênior");
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}
