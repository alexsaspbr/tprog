package ada.tech.exemplo;

public class VerificaSaltador implements Verificador{

    @Override
    public boolean verificar(Animal a) {
        return a.podeSaltar();
    }
}
