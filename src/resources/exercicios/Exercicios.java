package resources.exercicios;

import java.util.ArrayList;
import java.util.List;

public class Exercicios {
   public static void main(String[] args) {
      //exec 1
      List<Integer> numInteiros =  List.of(1,2,3,4,5);

      numInteiros.stream().filter(n -> n%2 == 0).forEach(System.out::println);


      //exec 2
      List<String> nomes = List.of("Alice", "Bob", "Charlie", "Diana");

      nomes.stream().map(String::toUpperCase).forEach(System.out::println);

      //exec 3
      List<Double> numerosDecimais = List.of(
              15.7,
              3.14,
              0.5,
              100.0,
              -2.99,
              42.87,
              7.0,
              99.9,
              0.001,
              -123.45
      );


      numerosDecimais.stream().sorted().limit(3).forEach(System.out::println);

      //exec 4

      int sumTotal = numInteiros.stream().mapToInt(Integer::intValue).sum();

      System.out.println("Soma total: " + sumTotal);

   }




}
