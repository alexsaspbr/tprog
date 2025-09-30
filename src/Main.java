import ada.tech.exemplo.Animal;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // lista de animais
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        //normal
        animais.stream();
        //parelela
        animais.parallelStream();

        //Stream de array
        //int [] nums = new int[1,2,3];
        //Arrays.stream(nums);

        //INTERMEDIARIAS

        //map - transformacao
        /* animais.stream()
                            .map(animal -> {
                                animal.setEspecie(animal.getEspecie().toUpperCase());
                                return animal;
                            })
                            .forEach(System.out::println);*/

        //filter
        /*animais.stream()
                .filter(animal -> animal.getEspecie().startsWith("c"))
                .forEach(System.out::println);

        Predicate<Animal> isNadador = Animal::podeNadar;
        Consumer<Animal> consumer = (animal) -> System.out.println(animal.toString().toUpperCase());

        animais.stream()
                .filter(isNadador)
                .forEach(consumer);
*/
        //skip - pular itens
        /*animais.stream()
                .skip(2)
                .forEach(System.out::println);
*/
        //limit - quantidade a retornar
        /*animais.stream()
                .skip(2)
                .limit(3)
                .forEach(System.out::println);*/

        //distinct
/*
        animais.stream()
                .distinct()
                .forEach(System.out::println);
*/

        //sorted

        /*Comparator<Animal> comp = Comparator.comparing(Animal::getEspecie);
        animais.stream()
                .sorted(comp)
                .forEach(System.out::println);*/

        //peek
       /* long count = animais.stream()
                .filter(Animal::podeSaltar)
                .peek(System.out::println)
                .count();
        System.out.println(count);
*/
        //flatMap

        /*List<Animal> animais2 = new ArrayList<>();
        animais2.add(new Animal("tubarao", false, true));
        Animal baleia = new Animal(" baleia", false, true);


        Stream<List<Animal>> listasDeAnimais = Stream.of(animais, animais2, List.of(baleia));
        listasDeAnimais.flatMap(Collection::stream)
                .forEach(System.out::println);
*/

        //TERMINAIS

        //forEach
        //animais.stream().forEach(System.out::println);

        //count
        //System.out.printf("total de itens %d", animais.stream().count());

        //collect
        //Set<Animal> setAnimais = animais.stream().collect(Collectors.toSet());

//        Map<Boolean, List<Animal>> animaisSaltadores = animais.stream()
//                .collect(Collectors.groupingBy(Animal::podeSaltar));
//
//        animaisSaltadores.get(true).stream().forEach(System.out::println);

        //min e max
       /* Comparator<Animal> comp = Comparator.comparing(Animal::getEspecie);
        System.out.printf("\nMinimo %s", animais.stream().min(comp).get().getEspecie());
        System.out.printf("\nMaximo %s", animais.stream().max(comp).get().getEspecie());*/

        //reduce
        /*BigDecimal preco1 = new BigDecimal(5000.0);
        BigDecimal preco2 = new BigDecimal(400.0);
        List<BigDecimal> precos = List.of(preco1, preco2);
        BigDecimal totalPrecos = precos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal de precos %s",
                totalPrecos);*/

        //findFirst e FindAny
     /*   animais.stream()
                .filter(Animal::podeSaltar)
                .findFirst().ifPresent(System.out::println);*/

        //FindAny
     /*   animais.parallelStream()
                //.filter(Animal::podeSaltar)
                .findAny().ifPresent(System.out::println);*/

        //allMatch
       /* System.out.printf("\nTodos animais podem saltar %b",
                animais.stream().allMatch(Animal::podeSaltar));*/

        //anyMatch
       /* System.out.printf("\nAlgum animal pode saltar %b",
                animais.stream().anyMatch(Animal::podeSaltar));*/

        //noneMatch
//        System.out.printf("\nNenhum animal pode saltar %b",
//                animais.stream().noneMatch(Animal::podeSaltar));


     /*   animais.parallelStream().forEach(animal -> {
            System.out.printf("\nNome da Thread %s - ", Thread.currentThread().getName());
            System.out.print(animal.getEspecie());
        });*/

        List<Thread> threads = new ArrayList<>();
        for(Animal animal : animais) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("\nNome da Thread %s - ", Thread.currentThread().getName());
                    System.out.print(animal.getEspecie());
                }
            });
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.start();
            try {
                t.join(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}