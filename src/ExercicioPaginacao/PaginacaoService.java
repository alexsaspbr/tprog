package ExercicioPaginacao;

import java.util.*;
import java.util.stream.Collectors;

public class PaginacaoService {

    public static List<Produto> paginar(List<Produto> lista, int pagina, int tamanhoPagina) {
        if (pagina < 1 || tamanhoPagina < 1) {
            throw  new IllegalArgumentException("Página e tamanho da página devem ser maiores que 0");
        }

        int skip = (pagina - 1) * tamanhoPagina;

        return lista.stream()
                    .skip(skip)
                    .limit(tamanhoPagina)
                    .collect(Collectors.toList());
    }
}
