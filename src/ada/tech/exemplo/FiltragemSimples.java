package ada.tech.exemplo;

import java.util.Arrays;
import java.util.function.Predicate;

public class FiltragemSimples {
  public static Integer[]  numeros = {1,2,3,4,5,6,7,8,9,10};
  public static void main(String[] args) {
    System.out.println("Filtragem Simples");
    Predicate<Integer> isPar = numero -> numero % 2 == 0;
    Arrays.stream(numeros).filter(isPar).forEach(System.out::println);
  }



}
