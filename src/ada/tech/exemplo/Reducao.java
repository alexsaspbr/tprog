package ada.tech.exemplo;
import java.util.ArrayList;
import java.util.Scanner;

public class Reducao {
  public static void main(String[] args) {
    System.out.println("Redução");
    try (Scanner scanner = new Scanner(System.in)) {
      ArrayList<Integer> listNumber = new ArrayList<>();

      System.out.println("Digite um grupo de numeros separados por virgula: ");
      String numeros = scanner.nextLine();
      for (String numero : numeros.split(",")) {
        listNumber.add(Integer.parseInt(numero.trim()));
      }


      Integer numerosSomados = listNumber.stream().reduce(0, (a, b) -> a + b);

      System.out.println("A soma dos numeros é: " + numerosSomados);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
