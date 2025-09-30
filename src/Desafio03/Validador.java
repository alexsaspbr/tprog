package Desafio03;

@FunctionalInterface
public interface Validador<T> {
    boolean validar(T valor);
}