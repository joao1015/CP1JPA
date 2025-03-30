package Model;

public class Estagiario extends Funcionario {
    @Override
    public void imprimirInformacao() {
        super.imprimirInformacao();
        System.out.println("Cargo: Estagiário");
    }
}
