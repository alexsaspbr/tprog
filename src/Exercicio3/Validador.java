package Exercicio3;

@FunctionalInterface
interface Validador<T> {
    boolean validar(T valor);
}
