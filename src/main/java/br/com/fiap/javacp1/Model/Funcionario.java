package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.seuprojeto.annotations.Tabela;
import com.seuprojeto.annotations.Coluna;

@Entity
@Tabela(nome = "TAB_FUNCIONARIO")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Coluna(nome = "ID")
    private Long id;

    @Coluna(nome = "NOME")
    private String nome;

    @Coluna(nome = "HORAS_TRABALHADAS")
    private int horasTrabalhadas;

    @Coluna(nome = "VALOR_POR_HORA")
    private double valorPorHora;

    // Construtor, getters e setters (implementar)

    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }

    public void imprimirInformacao() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: " + valorPorHora);
        System.out.println("Salário Base: " + calcularSalario());
    }
}