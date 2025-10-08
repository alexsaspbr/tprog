package ExercicioListarDiretorios;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class DirectoryLister {
    /**
     * Lista recursivamente a árvore de diretórios e arquivos.
     *
     * @param start Diretório inicial
     * @param indent String de indentação para controlar profundidade
     * @param out Lista onde serão armazenados os resultados
     */
    public static void listTree(File start, String indent, List<String> out) {
        // Valida se o arquivo/diretório existe
        if (start == null || !start.exists()) {
            return;
        }

        // Adiciona o item atual
        if (start.isDirectory()) {
            out.add(indent + start.getName() + "/");
        } else {
            out.add(indent + start.getName());
            return; // Arquivo não tem filhos
        }

        // Obtém lista de arquivos/diretórios filhos
        File[] children = start.listFiles();

        // Se não há filhos ou houve erro ao listar, retorna
        if (children == null || children.length == 0) {
            return;
        }

        // Usa Streams para processar os filhos de forma elegante
        // Ordena por: diretórios primeiro, depois alfabeticamente
        Stream.of(children)
                .sorted(Comparator
                        .comparing(File::isFile) // false (dir) vem antes de true (file)
                        .thenComparing(File::getName))
                .forEach(child -> listTree(child, indent + "  ", out));
    }

    /**
     * Versão alternativa usando Path e Streams de forma mais funcional
     */
    public static void listTreeWithPath(Path start, String indent, List<String> out) {
        File file = start.toFile();

        if (!file.exists()) {
            return;
        }

        // Adiciona o item atual
        String name = file.getName();
        if (file.isDirectory()) {
            out.add(indent + name + "/");

            // Processa filhos usando Streams
            File[] children = file.listFiles();
            if (children != null) {
                Arrays.stream(children)
                        .sorted(Comparator
                                .comparing(File::isFile)
                                .thenComparing(File::getName))
                        .map(File::toPath)
                        .forEach(childPath -> listTreeWithPath(childPath, indent + "  ", out));
            }
        } else {
            out.add(indent + name);
        }
    }

    /**
     * Método auxiliar para imprimir a árvore de diretórios
     */
    public static void printTree(File start) {
        List<String> result = new ArrayList<>();
        listTree(start, "", result);
        result.forEach(System.out::println);
    }

    /**
     * Método de exemplo e teste
     */
    public static void main(String[] args) {
        // Exemplo 1: Criar estrutura de diretórios temporária para teste
        System.out.println("=== Criando estrutura de teste ===");
        File tempDir = createTestStructure();

        if (tempDir != null) {
            System.out.println("\n=== Listagem usando File ===");
            printTree(tempDir);

            System.out.println("\n=== Listagem usando Path ===");
            List<String> result = new ArrayList<>();
            listTreeWithPath(tempDir.toPath(), "", result);
            result.forEach(System.out::println);

            // Cleanup (opcional)
            // deleteDirectory(tempDir);
        }

        // Exemplo 2: Listar diretório atual
        System.out.println("\n=== Listagem do diretório atual (limitada) ===");
        File currentDir = new File(".");
        List<String> output = new ArrayList<>();
        listTree(currentDir, "", output);

        // Mostra apenas as primeiras 20 linhas para não sobrecarregar a saída
        output.stream()
                .limit(20)
                .forEach(System.out::println);

        if (output.size() > 20) {
            System.out.println("... (mais " + (output.size() - 20) + " itens)");
        }
    }

    /**
     * Cria uma estrutura de diretórios de teste
     */
    private static File createTestStructure() {
        try {
            File tempDir = new File(System.getProperty("java.io.tmpdir"), "mytempdir");

            // Cria estrutura
            new File(tempDir, "docs").mkdirs();
            new File(tempDir, "src").mkdirs();

            // Cria arquivos
            new File(tempDir, "docs/readme.md").createNewFile();
            new File(tempDir, "src/Main.java").createNewFile();
            new File(tempDir, "notes.txt").createNewFile();

            System.out.println("Estrutura criada em: " + tempDir.getAbsolutePath());
            return tempDir;
        } catch (Exception e) {
            System.err.println("Erro ao criar estrutura de teste: " + e.getMessage());
            return null;
        }
    }

    /**
     * Remove recursivamente um diretório (cleanup)
     */
    private static void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            if (children != null) {
                Arrays.stream(children).forEach(DirectoryLister::deleteDirectory);
            }
        }
        dir.delete();
    }
}
