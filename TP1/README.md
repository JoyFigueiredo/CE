# Trabalhos 1
O Fast Non-Dominated Sort (FNDS) é um algoritmo essencial em otimização multiobjetivo, especialmente em algoritmos evolutivos como o NSGA-II (Non-dominated Sorting Genetic Algorithm II). Ele organiza uma população de soluções em diferentes frentes de Pareto, permitindo uma seleção eficiente das melhores soluções em termos de dominância.


## Índice
- [Descrição](#Descrição)
- [Parte I](#Parte-I)
- [Parte II](#Parte-II)
- [Contato](#contato)

## Descrição
O FNDS divide a população em várias frentes de Pareto. A primeira frente contém soluções que não são dominadas por nenhuma outra solução. A segunda frente contém soluções que são dominadas apenas por aquelas da primeira frente, e assim por diante. Este método facilita a seleção das melhores soluções e mantém a diversidade dentro da população.

## Parte I
Definição da Primeira Fronteira e das Dominâncias.
### Conceito:
- Dominância de Pareto: Uma solução 𝐴 domina uma solução 𝐵 se 𝐴 é pelo menos tão boa quanto 𝐵 em todos os objetivos e estritamente melhor em pelo menos um objetivo.
- Primeira Frente de Pareto: A primeira frente (F1) é composta por todas as soluções que não são dominadas por nenhuma outra solução na população.

### Primeira Frente:
Processo de identificação da Primeira Frente.
#### Inicialização:
- Numero de soluções que domina.
- A lista das soluções que ela domina.

#### Formação
A solução com 'n' igual a zero formam a primeira frente.

## Parte II

### Conceito
As frentes subsequentes (F2, F3, etc.) são formadas iterativamente a partir da remoção das soluções das frentes anteriores e da atualização das contagens de dominância das soluções dominadas.

### Identificação
- Remoção da Primeira Frente: Remova as soluções da primeira frente e reduza a contagem de dominância das soluções que são dominadas por elas.
- Formação das Próximas Frentes: Soluções cuja contagem de dominância se torna zero após a remoção das soluções da frente anterior formam a próxima frente.
- Repetição: Repita o processo até que todas as soluções sejam classificadas em frentes.

## Contato

Se você tiver alguma dúvida ou sugestão, entre em contato!

---

*Este projeto foi criado por [Joice Barros de Figueiredo](https://github.com/JoyFigueiredo).*
