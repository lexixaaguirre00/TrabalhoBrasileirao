package com.arroz;

import java.util.Scanner; // Importa a classe Scanner do pacote java.util

public class brasileirao { // Início da definição da classe TabelaBrasileirao

    public static void main(String[] args) { // Início do método main
        // Lista de times do Brasileirão
        String[] times = { // Declaração e inicialização de uma array de strings chamada "times"
                "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo", // Elementos da array
                "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
                "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
                "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
        };

        int[] pontuacoes = new int[times.length]; // Array para armazenar as pontuações
        int[] cartoesAmarelos = new int[times.length]; // Nova array para armazenar os cartões amarelos
        int[] numeroVitorias = new int[times.length]; // array de armazenamento para o numaro de vitorias

        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para leitura de entrada

        while (true) { // Início do loop while
            // Exibe o menu principal
            System.out.println("\nEscolha uma opção:"); // Imprime uma mensagem
            System.out.println("1 - Visualizar Tabela"); // Imprime uma mensagem
            System.out.println("2 - Editar Pontuação"); // Imprime uma mensagem
            System.out.println("3 - Editar Cartões Amarelos"); // Nova opção de menu: Editar Cartões Amarelos
            System.out.println("4 - Editar número de vitórias"); // nova opção de menu que permite ao usuario inserir o
                                                                 // numero de vitórias
            System.out.println("0 - Sair"); // Imprime uma mensagem

            int opcao = scanner.nextInt(); // Recebe a opção do usuário

            switch (opcao) { // Início da estrutura de seleção switch
                case 0: // Caso a opção seja 0
                    scanner.close(); // Fecha o scanner
                    return; // Encerra o programa
                case 1:
                    exibirTabela(times, pontuacoes, cartoesAmarelos, numeroVitorias); // Chama o módulo para exibir a
                                                                                      // tabela
                    break; // Sai do switch
                case 2:
                    editarPontuacao(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner); // Chama o módulo para
                                                                                                  // editar a pontuação
                    break;
                case 3:
                    editarCartoesAmarelos(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner); // Chama o
                                                                                                        // módulo para
                                                                                                        // editar os
                                                                                                        // cartões
                                                                                                        // amarelos
                    break;
                case 4:
                    editarVitorias(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner); // Chama o módulo para
                                                                                                 // editar o número de
                                                                                                 // vitórias
                default: // Caso a opção não seja nenhuma das anteriores
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem para opção inválida
                    break;
            } // fim do swich
        } // Fim do loop while
    } // Fim do método main

    // Módulo para exibir a tabela
    public static void exibirTabela(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] numeroVitorias) { // Início do método
                                                                                               // exibirTabela
        System.out.println("\nPosição | Time | Pontuação | Cartões Amarelos | Número de Vitórias"); // Imprime uma
                                                                                                    // mensagem
        for (int i = 0; i < times.length; i++) { // Início do loop for
            System.out.println((i + 1) + "  | " + times[i] + " | " + pontuacoes[i] + " | " + cartoesAmarelos[i] + " | " + numeroVitorias[i] ); // Imprime a posição, o time, a pontuação e os cartões amarelos
        } // Fim do loop for
    } // Fim do método exibirTabela

    // Módulo para exibir os times disponíveis para edição
    public static void exibirTimes(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] numeroVitorias) { // Início
                                                                                                                    // do
                                                                                                                    // método
                                                                                                                    // exibirTimes
        for (int i = 0; i < times.length; i++) { // Início do loop for
            System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i] + " | Cartões Amarelos: "
                    + cartoesAmarelos[i] + " | Numero de vitórias: " + numeroVitorias[i]); // Imprime a posição, o time,
                                                                                           // a pontuação e os cartões
                                                                                           // amarelos
        } // Fim do loop for
    } // Fim do método exibirTimes

    // Módulo para editar a pontuação dos times
    public static void editarPontuacao(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] numeroVitorias,
            Scanner scanner) { // Início do método editarPontuacao
        while (true) { // Início do loop while
            // Exibe os times disponíveis para edição
            System.out.println("\nTimes disponíveis para edição:"); // Imprime uma mensagem
            exibirTimes(times, pontuacoes, cartoesAmarelos, numeroVitorias); // Chama o módulo para exibir os times
            System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar):"); // Imprime uma
                                                                                                        // mensagem
            int posicao = scanner.nextInt(); // Recebe a posição escolhida pelo usuário

            if (posicao == 0) { // Se a posição escolhida for 0
                break; // Sai do loop de edição
            }

            if (posicao >= 1 && posicao <= times.length) { // Se a posição estiver dentro do intervalo válido
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":"); // Imprime uma mensagem
                int novaPontuacao = scanner.nextInt(); // Recebe a nova pontuação

                if (novaPontuacao >= 0) { // Se a nova pontuação for não-negativa
                    pontuacoes[posicao - 1] = novaPontuacao; // Atualiza a pontuação
                } else { // Se a nova pontuação for negativa
                    System.out.println("A pontuação não pode ser negativa."); // Mensagem de erro
                }
            } else { // Se a posição escolhida for inválida
                System.out.println("Posição inválida. Tente novamente."); // Mensagem de erro
            }

            scanner.nextLine(); // Limpa o buffer do scanner
            ordenarPorPontuacaoECartoesEvitorias(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner);
        } // Fim do loop while
        
    } // Fim do método editarPontuacao

    // Módulo para editar os cartões amarelos dos times
    public static void editarCartoesAmarelos(String[] times, int[] pontuacoes, int[] cartoesAmarelos,
            int[] numeroVitorias, Scanner scanner) { // Início do método editarCartoesAmarelos
        while (true) { // Início do loop while
            // Exibe os times disponíveis para edição
            System.out.println("\nTimes disponíveis para edição:"); // Imprime uma mensagem
            exibirTimes(times, pontuacoes, cartoesAmarelos, numeroVitorias); // Chama o módulo para exibir os times
            System.out.println("Escolha o número do time para editar os cartões amarelos (ou 0 para voltar):"); // Imprime
                                                                                                                // uma
                                                                                                                // mensagem
            int posicao = scanner.nextInt(); // Recebe a posição escolhida pelo usuário

            if (posicao == 0) { // Se a posição escolhida for 0
                break; // Sai do loop de edição
            }

            if (posicao >= 1 && posicao <= times.length) { // Se a posição estiver dentro do intervalo válido
                System.out.println("Digite o novo número de cartões amarelos para " + times[posicao - 1] + ":"); // Imprime
                                                                                                                 // uma
                                                                                                                 // mensagem
                int novosCartoes = scanner.nextInt(); // Recebe o novo número de cartões amarelos

                if (novosCartoes >= 0) { // Se o novo número de cartões amarelos for não-negativo
                    cartoesAmarelos[posicao - 1] = novosCartoes; // Atualiza o número de cartões amarelos
                } else { // Se o novo número de cartões amarelos for negativo
                    System.out.println("O número de cartões amarelos não pode ser negativo."); // Mensagem de erro
                }
            } else { // Se a posição escolhida for inválida
                System.out.println("Posição inválida. Tente novamente."); // Mensagem de erro
            }

            scanner.nextLine(); // Limpa o buffer do scanner
            ordenarPorPontuacaoECartoesEvitorias(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner);
        } // Fim do loop while
       
    } // Fim do método editarCartoesAmarelos

    // Módulo para editar o numero de vitorias dos times
    public static void editarVitorias(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] numeroVitorias,
            Scanner scanner) { // Início do método editarCartoesAmarelos
        while (true) { // Início do loop while
            // Exibe os times disponíveis para edição
            System.out.println("\nTimes disponíveis para edição:"); // Imprime uma mensagem
            exibirTimes(times, pontuacoes, cartoesAmarelos, numeroVitorias); // Chama o módulo para exibir os times
            System.out.println("Escolha o número do time para editar a quantidade de vitórias (ou 0 para voltar):"); // Imprime
                                                                                                                     // uma
                                                                                                                     // mensagem
            int posicao = scanner.nextInt(); // Recebe a posição escolhida pelo usuário

            if (posicao == 0) { // Se a posição escolhida for 0
                break; // Sai do loop de edição
            }

            if (posicao >= 1 && posicao <= times.length) { // Se a posição estiver dentro do intervalo válido
                System.out.println("Digite o novo número de vitórias para " + times[posicao - 1] + ":"); // Imprime uma
                                                                                                         // mensagem
                int novoNumeroVitorias = scanner.nextInt(); // Recebe o novo número de cartões amarelos

                if (novoNumeroVitorias >= 0) {
                    numeroVitorias[posicao - 1] = novoNumeroVitorias;
                } else {
                    System.out.println("O número de vitórias não pode ser negativo."); // Mensagem de erro
                }
            } else { // Se a posição escolhida for inválida
                System.out.println("Posição inválida. Tente novamente."); // Mensagem de erro
            }

            scanner.nextLine(); // Limpa o buffer do scanner
            ordenarPorPontuacaoECartoesEvitorias(times, pontuacoes, cartoesAmarelos, numeroVitorias, scanner);
        } // Fim do loop while
        
    } // Fim do método editarVitorias

    // Módulo para ordenar os times por pontuação, cartões amarelos e numero de
    // vitórias
    public static void ordenarPorPontuacaoECartoesEvitorias(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] numeroVitorias, Scanner scanner) { // Início do método ordenarPorPontuacaoECartoes
        for (int i = 0; i < pontuacoes.length - 1; i++) { // Início do primeiro loop for
            for (int j = i + 1; j < pontuacoes.length; j++) { // Início do segundo loop for
                if (pontuacoes[i] < pontuacoes[j]|| (pontuacoes[i] == pontuacoes[j] && cartoesAmarelos[i] > cartoesAmarelos[j])
                        || (pontuacoes[i] == pontuacoes[j] && cartoesAmarelos[i] == cartoesAmarelos[j] && numeroVitorias[i] < numeroVitorias[j])) { // Troca as pontuações
                    
                    int tempPontuacao = pontuacoes[i]; // Variável temporária para a pontuação
                    pontuacoes[i] = pontuacoes[j]; // Atualiza a pontuação do time i
                    pontuacoes[j] = tempPontuacao; // Atualiza a pontuação do time j

                    // Troca os cartões amarelos
                    int tempCartoes = cartoesAmarelos[i]; // Variável temporária para os cartões amarelos
                    cartoesAmarelos[i] = cartoesAmarelos[j]; // Atualiza o número de cartões amarelos do time i //se o
                                                             // numero de vitorias de i for maior que j
                    cartoesAmarelos[j] = tempCartoes; // Atualiza o número de cartões amarelos do time j
                    
                    
                    int tempVitorias = numeroVitorias[i]; // Variável temporária para o numero de vitorias
                    numeroVitorias[i] = numeroVitorias[j]; // Atualiza o numero de vitorias do time i 
                                                             // se o numero de vitorias de i for maior que j
                    numeroVitorias[j] = tempVitorias; // Atualiza o número de vitorias1 do time j

                    // Troca os times
                    String tempTime = times[i]; // Variável temporária para o time
                    times[i] = times[j]; // Atualiza o time i
                    times[j] = tempTime; // Atualiza o time j
                }
            } // Fim do segundo loop for
        } // Fim do primeiro loop for
    } // Fim do método ordenarPorPontuacaoECartoes

    // ... (código anterior) ...

} // Fim da definição da classe TabelaBrasileirao
