package br.com.fiap.javacp1.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JUNIOR")  // Valor textual para a coluna TIPO_FUNCIONARIO
public class Junior extends Funcionario {

    public Junior() {}

    public Junior(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora, TipoFuncionario.JUNIOR);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorPorHora();
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Júnior");
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}
