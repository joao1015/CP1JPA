package Model;

public class Junior extends Funcionario {
    private static final double BONUS_JUNIOR = 100.0;

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_JUNIOR;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Júnior | Bônus Fixo: " + BONUS_JUNIOR);
    }
}