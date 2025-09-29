# Exercícios de Stream em Java - Entregar 29/09/2025

Esta lista contém 5 exercícios progressivos sobre o uso de Streams em Java. O objetivo é praticar operações intermediárias e terminais, até chegar em um desafio mais complexo utilizando pipelines compostos.

---

## Exercício 1 - Filtragem Simples
Dada uma lista de números inteiros, use Stream para filtrar apenas os números pares e imprimir cada um deles.

---

## Exercício 2 - Mapeamento
Dada uma lista de nomes, converta todos os nomes para letras maiúsculas utilizando Stream e exiba o resultado.

---

## Exercício 3 - Ordenação e Limite
Dada uma lista de números decimais, ordene-os em ordem crescente, limite o resultado aos 3 primeiros e exiba-os.

---

## Exercício 4 - Redução
Dada uma lista de números inteiros, utilize Stream para calcular a soma de todos os elementos.

---

## Exercício 5 - Desafio Avançado (Pipeline Composto)
Dada uma lista de produtos (classe `Produto` com atributos `nome`, `preco` e `categoria`):

1. Filtrar apenas os produtos da categoria "Eletrônicos" com preço acima de 500.
2. Ordenar os produtos pelo preço em ordem decrescente.
3. Agrupar os produtos por categoria em um `Map<String, List<Produto>>`.
4. Dentro da categoria "Eletrônicos", extrair apenas os nomes dos produtos mais caros (top 2).
5. Exibir o resultado final.  

---

## Exercício de Paginação com Stream (Java) - Produtos
Enunciado
Implemente um sistema simples de paginação em Java utilizando Stream, com os métodos skip e limit.

Regras:
Crie uma classe Produto com os seguintes atributos:
String sku
String descricao
BigDecimal valor
Crie uma lista com 10 produtos fictícios.
Implemente um método paginar(List<Produto> lista, int pagina, int tamanhoPagina) que:
Retorne uma sublista representando os produtos da página solicitada.
Utilize obrigatoriamente os métodos skip e limit de Stream.
Crie uma classe Main que teste a paginação chamando diferentes páginas e exibindo o resultado no console.
Exemplos esperados:
Página 1, tamanho 3 → Exibe 3 primeiros produtos
Página 2, tamanho 3 → Exibe os próximos 3 produtos
Página 4, tamanho 3 → Exibe o último produto
Tarefa: Implemente a classe Produto, o método de paginação e os testes na classe Main.