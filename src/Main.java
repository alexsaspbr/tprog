import ada.tech.exemplo.Animal;
import ada.tech.exemplo.Conversor;
import ada.tech.exemplo.Mensagem;
import ada.tech.exemplo.Operacao;
import ada.tech.exemplo.Validador;
import ada.tech.exemplo.VerificaSaltador;
import ada.tech.exemplo.Verificador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Exercício 1
        String Exercicio1 = "Exercício 1";
        Conversor<String> paraMaiusculo = texto -> texto.toUpperCase();
        System.out.println(Exercicio1);
        System.out.println(paraMaiusculo.converter(Exercicio1));
        Conversor<String> inverterString = texto -> new StringBuilder(texto).reverse().toString();
        System.out.println(inverterString.converter(Exercicio1));

        //Exercício 2
        Mensagem<String> mensagem = texto -> System.out.println("Mensagem: " +"<"+ texto +">");
        System.out.println("\nExercício 2");
        mensagem.exibir("este é o retorno do Exercicio 2");

        //Exercício 3 (Desafio)
        Validador<String> notNull = valor -> valor != null && !valor.isEmpty();
        Validador<Integer> isPositive = valor -> valor != null && valor > 0;
        Validador<String> passwordValidator = valor -> {
            if (notNull.validar(valor) && valor.length() >= 8) {
                // The matches() method checks if the string contains at least one digit (\\d)
                return valor.matches(".*\\d.*");
            }
            return false;
        };

        System.out.println("\nExercício 3 - Deseafio");

        String senhaQuePassa = "senha123";
        String senhaQueNaoPassa = "senha";
        String senhaNula = " ";
        String noNumbers = "abcdefgh";

        System.out.printf("A senha '%s' é válida? %b\n", senhaQuePassa, passwordValidator.validar(senhaQuePassa));
        System.out.printf("A senha '%s' é válida? %b\n", senhaQueNaoPassa, passwordValidator.validar(senhaQueNaoPassa));
        System.out.printf("A senha '%s' é válida? %b\n", senhaNula, passwordValidator.validar(senhaNula));
        System.out.printf("A senha '%s' é válida? %b\n", noNumbers, passwordValidator.validar(noNumbers));

        System.out.println("\n_____________________________________________\n");


        // lista de animais
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        // imprime os animais verificados
        //imprimir(animais, new VerificaSaltador());
        imprimir(animais, Animal::podeSaltar);
        imprimir(animais, Animal::podeNadar);


        Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
        List<String> strings = List.of("","");
        //Collections.sort(strings, comp);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
            }
        });

        new Thread(() -> {
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
                System.out.println("Hello World");
        });

        //(parametros) -> expressao
        //(parametros) -> { bloco de codigo }

        Operacao soma = (a, b) -> a + b;
        Operacao multiplicacao = (a, b) -> a * b;

        System.out.printf("\nSoma eh %d", soma.executar(10, 2));
        System.out.printf("\nA multiplicacao eh %d", multiplicacao.executar(10, 2));

        calcular(32,5, (a, b) -> a - b);
    }

    private static void calcular(int a, int b, Operacao op) {
        System.out.printf("\nResultado da operacao eh %d", op.executar(a, b));
    }

    private static void imprimir(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            // verificando
            if (verificador.verificar(animal)) {
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }


}