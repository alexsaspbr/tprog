import java.time.LocalDate;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //functional interfaces

        //supplier
        Supplier<LocalDate> sv = () -> LocalDate.now();
        System.out.println(sv.get());

        //predicate
        Predicate<Integer> isNegative = (Integer a) -> a < 0;
        System.out.println(isNegative.test(-1));

        //bi-predicate
        BiPredicate<Integer, Integer> bi_predicate = (Integer a, Integer b) -> a < 0 && b < 0;
        System.out.println(bi_predicate.test(-1, 9));

        //consumer
        Consumer<String> consumer = (String texto) -> System.out.println(texto);
        consumer.accept("Alex Araujo");

        //bi-consumer
        BiConsumer<String, String> bi_consumer = (String nome, String sobreNome) -> System.out.printf("\n%s %s\n", nome, sobreNome);
        bi_consumer.accept("Joao", "Carlos");

        //function
        Function<String, Integer> function = (String texto) -> texto.length();
        System.out.println(function.apply("Ola mundo!"));

        //bi-function
        BiFunction<String, String, Integer> bi_function = (String texto, String texto2) -> texto.length() + texto2.length();
        System.out.println(bi_function.apply("Ola", "Mundo!"));

        //unaryOperator
        UnaryOperator<String> unaryOperator = (String nome) -> nome.concat("!");
        System.out.println(unaryOperator.apply("Atencao"));

        //binaryOperator
         BinaryOperator<String> binaryOperator = (String nome, String sobreNome) -> nome.concat(" ").concat(sobreNome);
         System.out.println(binaryOperator.apply("Guilherme", "Ariel"));


    }
}