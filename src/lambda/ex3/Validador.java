package lambda.ex3;

@FunctionalInterface
public interface Validador<T> {
    boolean validar(T valor);
}

