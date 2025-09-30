import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        //IO
//        File file = new File("/home/alexaraujo/ada/turmas/1418/tprog/src/resources/nomes.txt");
//        System.out.printf("Arquivo existe %b", file.exists());
//
//        try {
//            Scanner input = new Scanner(file);
//            while (input.hasNext()) {
//                System.out.println(input.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        //NIO
//        Path path = Path.of("/home/alexaraujo/ada/turmas/1418/tprog/src/resources/nomes.txt");
//        Path path2 = Paths.get("home", "alexaraujo", "ada", "turmas", "1418", "tprog", "src", "resources", "nomes.txt");
//
//        System.out.println(file.getParent());
//        System.out.println(file.isAbsolute());
//        String newFile = file.getParent().concat(File.separator).concat("turma1418.txt");
//        File novoArquivo = new File(newFile);
//        try {
//            novoArquivo.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
        //}

        System.out.println("Exercício: Listar diretórios e arquivos em Java (usando File, Path, recursividade e Streams)");
        File tempRoot = new File(System.getProperty("java.io.tmpdir"), "myJavaTempDir_" + System.currentTimeMillis());
    try {
        // Cria a estrutura:
        // myJavaTempDir_.../
        //   dirA/
        //     fileA1.txt
        //   dirB/
        //     dirB1/
        //       fileB1-1.java
        //   file0.log

        if (tempRoot.mkdirs()) {
            // Diretórios
            File dirA = new File(tempRoot, "dirA");
            dirA.mkdirs();
            File dirB = new File(tempRoot, "dirB");
            dirB.mkdirs();
            File dirB1 = new File(dirB, "dirB1");
            dirB1.mkdirs();

            // Arquivos
            new File(dirA, "fileA1.txt").createNewFile();
            new File(dirB1, "fileB1-1.java").createNewFile();
            new File(tempRoot, "file0.log").createNewFile();

            // Define o ponto inicial
            System.out.println("--- Listando a partir de: " + tempRoot.getAbsolutePath() + " ---");

            // Realiza a listagem
            List<String> result = DirectoryLister.listTree(tempRoot, " ", new java.util.ArrayList<>());

            // Imprime o resultado
            for (String line : result) {
                System.out.println(line);
            }

        } else {
            System.out.println("Não foi possível criar o diretório de teste: " + tempRoot.getAbsolutePath());
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Tenta limpar o diretório temporário
        deleteRecursive(tempRoot);
    }
}

// Método auxiliar para limpar o diretório de teste
private static void deleteRecursive(File file) {
    if (file.isDirectory()) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File child : files) {
                deleteRecursive(child);
            }
        }
    }
    file.delete();
}
}
