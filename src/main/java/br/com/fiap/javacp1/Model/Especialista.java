package Model;

public class Especialista extends Senior {
    private static final double BONUS_ESPECIALIDADE = 500.0;

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + BONUS_ESPECIALIDADE;
    }

    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Bônus Especialidade: " + BONUS_ESPECIALIDADE);
    }
}
