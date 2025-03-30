package br.com.fiap.javacp1.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLENO")  // Valor textual para a coluna TIPO_FUNCIONARIO
public class Pleno extends Funcionario {

    public Pleno() {}

    public Pleno(String nome, int horasTrabalhadas, double valorPorHora) {
        super(nome, horasTrabalhadas, valorPorHora, TipoFuncionario.PLENO);
    }

    @Override
    public double calcularSalario() {
        return getHorasTrabalhadas() * getValorPorHora();
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Pleno");
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}
