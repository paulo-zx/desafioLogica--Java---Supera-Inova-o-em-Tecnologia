# Desafios em Java

## Desafio 1: Resistores – Código de Cores

### Introdução
Os resistores são componentes elétricos que possuem listras coloridas para indicar o valor de sua resistência em ohms, bem como a tolerância permitida. Este desafio consiste em implementar um programa que, a partir de um valor fornecido, retorne a sequência de cores correta dos resistores.

### Código de Cores dos Resistores
- 0: preto
- 1: marrom
- 2: vermelho
- 3: laranja
- 4: amarelo
- 5: verde
- 6: azul
- 7: violeta
- 8: cinza
- 9: branco

### Regras de Entrada
A entrada do programa será uma string contendo o valor de resistência seguido da palavra "ohms", como em `47 ohms`. Algumas regras específicas:
- Para resistores menores que 1000 ohms, o valor será dado apenas como um número. Exemplo: `47 ohms` -> "amarelo violeta preto dourado".
- Para resistores maiores ou iguais a 1000 ohms, mas menores que 1.000.000 ohms, o valor será dado em `k ohms`. Exemplo: `4.7k ohms` -> "amarelo violeta vermelho dourado".
- Para resistores maiores ou iguais a 1.000.000 ohms, o valor será dado em `M ohms`. Exemplo: `1M ohms` -> "marrom preto verde dourado".

### Exemplos de Entrada e Saída
- `10 ohms` -> "marrom preto preto dourado"
- `100 ohms` -> "marrom preto marrom dourado"
- `220 ohms` -> "vermelho vermelho marrom dourado"
- `330 ohms` -> "laranja laranja marrom dourado"
- `1k ohms` -> "marrom preto vermelho dourado"
- `2M ohms` -> "vermelho preto verde dourado"

- ## Desafio 2: Padrão Caracol em Matrizes

### Introdução
Este desafio envolve percorrer uma matriz NxN, retornando os elementos da borda externa para o centro em um padrão de caracol no sentido horário.

### Exemplo

- Para a matriz abaixo:

1 | 2 | 3 

4 | 5 | 6

7 | 8 | 9

O resultado será: `[1, 2, 3, 6, 9, 8, 7, 4, 5]`.

- Para a matriz abaixo:

1 | 2 | 3 

4 | 10 | 12

6 | 7 | 33

O resultado será: `[1, 2, 3, 12, 33, 7, 6, 4, 10]`.

- Para a matriz abaixo:

1 | 2 | 3 | 1

4 | 5 | 6 | 4

7 | 8 | 9 | 7

7 | 8 | 9 | 7

O resultado será: `[1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8]`.


### Como Executar

- Compile o código em qualquer IDE de Java.

- Execute o programa, fornecendo os valores de entrada conforme necessário.




