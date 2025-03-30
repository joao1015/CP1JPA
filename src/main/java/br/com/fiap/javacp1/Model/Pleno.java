package Model;

public class Pleno extends Funcionario {
    private static final double BONUS_PERCENTUAL = 0.10; // 10%

    @Override
    public double calcularSalario() {
        return super.calcularSalario() * (1 + BONUS_PERCENTUAL);
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Pleno | Bônus: 10%");
    }
}