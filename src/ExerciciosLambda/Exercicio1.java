package ExerciciosLambda;

public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Exercício 1 - Interface Conversor");
        System.out.println("=".repeat(50));

        String[] textos = {
                "Hello World",
                "Java Programming",
                "Lambda Expressions",
                "Interface Funcional"
        };

        Conversor conversorMaiuscula = texto ->
                                         texto.toUpperCase();

        Conversor conversorInverter = texto -> {
            StringBuilder sb = new StringBuilder(texto);
            return sb.reverse().toString();
        };

        System.out.println("Testando Conversores:\n");
        System.out.println();

        for (String texto : textos) {
            System.out.println(" * Texto original: \"" + texto + "\"");

            String maiuscula = conversorMaiuscula.converter(texto);
            System.out.println(" * Texto em maiusculas: \"" + maiuscula + "\"");

            String invertido = conversorInverter.converter(texto);
            System.out.println("Invertido: \"" + invertido + "\"");

            System.out.println();
        }

        System.out.println("COMBINANDO CONVERSORES:");
        String textoTeste = "Programming";

        String resultado1 = conversorInverter.converter(
                conversorMaiuscula.converter(textoTeste)
        );
        System.out.println("\"" + textoTeste + "\" -> Maiúscula -> Inverter = \"" + resultado1 + "\"");

        String resultado2 = conversorMaiuscula.converter(
                conversorInverter.converter(textoTeste)
        );
        System.out.println("\"" + textoTeste + "\" -> Inverter -> Maiúscula = \" " + resultado2 + "\"");

        System.out.println("\n OUTROS CONVERSORES POSSÍVEIS:");

        Conversor conversorMinuscula = texto -> texto.toLowerCase();

        Conversor conversorCapitalizar = texto -> {
            if (texto == null || texto.isEmpty()) {
                return texto;
            }
            return texto.substring(0, 1).toUpperCase() +
                    texto.substring(1).toLowerCase();
        };

        Conversor conversorSemEspacos = texto -> texto.replace("", "");

        String exemploTexto = "hello world programming";
        System.out.println("\"" + exemploTexto + "\":");
        System.out.println(" * Minúsculas: \"" + conversorMinuscula.converter(exemploTexto) + "\"");
        System.out.println(" * Capitalizar: \"" + conversorCapitalizar.converter(exemploTexto) + "\"");
        System.out.println(" * Sem espaços: \"" + conversorSemEspacos.converter(exemploTexto) + "\"");
    }
}
