package ada.tech.exemplo;
//import scanner
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaNomes {
  public static void main(String[] args) {
    System.out.println("Mapeamento");
    try (Scanner scanner = new Scanner(System.in)) {
      ArrayList<String> listNomes = new ArrayList<>();
      Boolean continuar = true;

      while (continuar) {
        System.out.println("Digite um nome: ");
        String nome = scanner.nextLine();
        listNomes.add(nome);
        System.out.println("Deseja continuar? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("n")) {
          continuar = false;
        }
      }

      List<String> nomesMaiusculos = listNomes.stream()
          .map(nome -> nome.toUpperCase())
          .toList();

      nomesMaiusculos.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
