package ada.tech.exemplo;

import java.util.Objects;

public class Animal {

    private String especie;
    private boolean podeSaltar;
    private boolean podeNadar;

    public Animal(String nomeDaEspecie, boolean saltador, boolean nadador){
        especie = nomeDaEspecie;
        podeSaltar = saltador;
        podeNadar = nadador;
    }

    public boolean podeSaltar() { return podeSaltar; }
    public boolean podeNadar() { return podeNadar; }
    public String toString() { return especie; }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return podeSaltar == animal.podeSaltar && podeNadar == animal.podeNadar && Objects.equals(especie, animal.especie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(especie, podeSaltar, podeNadar);
    }
}
