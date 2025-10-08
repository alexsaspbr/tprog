package CopiaDeImagem;

import java.io.*;

public class ImageCopyMain {
    public static void main(String[] args) {
        // Defina aqui o nome da imagem original e da cópia
        String sourceImage = "src/resources/atem.png";
        String destinationImage = "src/resources/atem_copia.png";

        try {
            copyImage(sourceImage, destinationImage);
            System.out.println("Imagem copiada com sucesso!");
            System.out.println("Origem: " + sourceImage);
            System.out.println("Destino: " + destinationImage);
        } catch (IOException e) {
            System.err.println("Erro ao copiar imagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Copia uma imagem de um arquivo para outro usando InputStream e OutputStream
     *
     * @param source Caminho do arquivo de origem
     * @param destination Caminho do arquivo de destino
     * @throws IOException Se houver erro na leitura ou escrita
     */
    public static void copyImage(String source, String destination) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            // Cria os streams de entrada e saída
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(destination);

            // Buffer para leitura/escrita
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Lê e escreve os dados em blocos
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Cópia concluída!");

        } finally {
            // Fecha os streams no bloco finally para garantir que sejam fechados
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar InputStream: " + e.getMessage());
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar OutputStream: " + e.getMessage());
                }
            }
        }
    }
}
