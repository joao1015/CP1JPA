package Model;

public class Senior extends Funcionario {
    private static final double BONUS_POR_15H = 200.0;

    @Override
    public double calcularSalario() {
        int ciclosBonus = horasTrabalhadas / 15;
        return super.calcularSalario() + (ciclosBonus * BONUS_POR_15H);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Sênior | Bônus: " + ((horasTrabalhadas / 15) * BONUS_POR_15H));
    }
}
