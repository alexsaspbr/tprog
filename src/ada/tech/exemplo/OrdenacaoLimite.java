package ada.tech.exemplo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrdenacaoLimite {
  public static void main(String[] args) {
    System.out.println("Mapeamento");
    try (Scanner scanner = new Scanner(System.in)) {
      ArrayList<Integer> listNumber = new ArrayList<>();

        System.out.println("Digite um grupo de numeros separados por virgula: ");
        String numeros = scanner.nextLine();
        for (String numero : numeros.split(",")) {
          listNumber.add(Integer.parseInt(numero.trim()));
        }



      List<Integer> numerosOrdenados = listNumber.stream()
          .sorted((n1, n2) -> n2.compareTo(n1))
          .limit(3)
          .toList();

        System.out.println("Os 3 maiores numeros sao: " + numerosOrdenados);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
