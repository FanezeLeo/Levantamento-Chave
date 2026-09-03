import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Service service = new Service();

        int timeEscolhido;
        int opcao = -1;

        Jogador[] timeA = {
                new Jogador("Joao", 1, "Levantador"),
                new Jogador("Pedro", 2, "Ponteiro"),
                new Jogador("Lucas", 3, "Central"),
                new Jogador("Gabriel", 4, "Oposto"),
                new Jogador("Rafael", 5, "Ponteiro"),
                new Jogador("Mateus", 6, "Central")
        };

        Jogador[] reservasA = {
                new Jogador("Carlos", 7, "Ponteiro"),
                new Jogador("Bruno", 8, "Central"),
                new Jogador("Diego", 9, "Oposto")
        };

        Jogador[] timeB = {
                new Jogador("Arthur", 1, "Levantador"),
                new Jogador("Enzo", 2, "Ponteiro"),
                new Jogador("Henrique", 3, "Central"),
                new Jogador("Gustavo", 4, "Oposto"),
                new Jogador("Felipe", 5, "Ponteiro"),
                new Jogador("Matheus", 6, "Central")
        };

        Jogador[] reservasB = {
                new Jogador("Caio", 7, "Ponteiro"),
                new Jogador("Vitor", 8, "Central"),
                new Jogador("Daniel", 9, "Oposto")
        };

        do {

            System.out.println("\n==============================");
            System.out.println("       O que voce deseja fazer?");
            System.out.println("==============================");

            System.out.println("1 - Jogar rodada");
            System.out.println("2 - Rotacionar Time A");
            System.out.println("3 - Rotacionar Time B");
            System.out.println("4 - Substituir jogador");
            System.out.println("5 - Adicionar um reserva");
            System.out.println("6 - Mostrar jogadores");
            System.out.println("7 - Maiores pontuadores");
            System.out.println("8 - Mostrar quadra");
            System.out.println("9 - Pontuação total dos times");
            System.out.println("0 - Finalizar partida");

            System.out.print("\nEscolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next();
                continue;
            }
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    int selecionaTime = random.nextInt(2);
                    int selecionaJogador = random.nextInt(6);

                    if (selecionaTime == 0) {
                        timeA[selecionaJogador].pontuar();
                        System.out.println("\nPonto para o TIME A: " + timeA[selecionaJogador].getNome() + "!");
                    } else {
                        timeB[selecionaJogador].pontuar();
                        System.out.println("\nPonto para o TIME B: " + timeB[selecionaJogador].getNome() + "!");
                    }
                    break;

                case 2:
                    service.rotacionar(timeA);
                    System.out.println("\nRotação do time A!");
                    break;

                case 3:
                    service.rotacionar(timeB);
                    System.out.println("\nRotação do time B!");
                    break;

                case 4:

                    System.out.println("\n------------------------------");
                    System.out.println("       Placa de Substituição!!");
                    System.out.println("------------------------------");

                    System.out.print("Digite o número do jogador titular que deseja substituir: ");
                    int numeroTitular = scanner.nextInt();

                    System.out.print("Digite o número do jogador reserva que deseja substituir: ");
                    int numeroReserva = scanner.nextInt();

                    System.out.println("Digite 1 para substituir no time A ou 2 para substituir no time B: ");
                    timeEscolhido = scanner.nextInt();

                    if (timeEscolhido == 1) {
                        Jogador jogadorReserva = service.buscarJogadorPorNumero(reservasA, numeroReserva);
                        Jogador jogadorTitular = service.buscarJogadorPorNumero(timeA, numeroTitular);
                        if (jogadorReserva == null || jogadorTitular == null) {
                            System.out.println("Jogador não encontrado!");
                            break;
                        } else {
                            service.substituir(timeA, reservasA, jogadorTitular, jogadorReserva);
                        }
                    } else if (timeEscolhido == 2) {
                        Jogador jogadorReserva = service.buscarJogadorPorNumero(reservasB, numeroReserva);
                        Jogador jogadorTitular = service.buscarJogadorPorNumero(timeB, numeroTitular);
                        if (jogadorReserva == null || jogadorTitular == null) {
                            System.out.println("Jogador não encontrado!");
                            break;
                        } else {
                            service.substituir(timeB, reservasB, jogadorTitular, jogadorReserva);
                        }
                    } else {
                        System.out.println("Time inválido!");
                    }
                    break;

                case 5:
                    System.out.println("\n------------------------------");
                    System.out.println("       Janela de transferencia!!");
                    System.out.println("------------------------------");

                    scanner.nextLine();
                    System.out.print("Digite o nome do jogador reserva que deseja adicionar: ");
                    String nomeReserva = scanner.nextLine();

                    System.out.print("Digite o número do jogador reserva que deseja adicionar: ");
                    int numeroReservaNovo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite a posição do jogador reserva que deseja adicionar: ");
                    String posicaoReserva = scanner.nextLine();

                    System.out.println("Digite 1 para adicionar no time A ou 2 para adicionar no time B: ");
                    timeEscolhido = scanner.nextInt();
                    scanner.nextLine();

                    Jogador novoReserva = new Jogador(nomeReserva, numeroReservaNovo, posicaoReserva);

                    if (timeEscolhido == 1) {
                        reservasA = service.adicionarReserva(reservasA, novoReserva);
                    } else if (timeEscolhido == 2) {
                        reservasB = service.adicionarReserva(reservasB, novoReserva);
                    } else {
                        System.out.println("Time inválido!");
                    }
                    break;

                case 6:
                    service.mostrarJogadores(timeA, reservasA, "TIME A");
                    service.mostrarJogadores(timeB, reservasB, "TIME B");
                    break;

                case 7:
                    Jogador[] todosJogadores = service.juntarJogadores(timeA, reservasA, timeB, reservasB);
                    service.mostrarRanking(todosJogadores);
                    break;

                case 8:
                    service.mostrarQuadra(timeA, timeB);
                    break;

                case 9:
                    int totalA = service.somarPontos(service.juntarJogadores(timeA, reservasA));
                    int totalB = service.somarPontos(service.juntarJogadores(timeB, reservasB));
                    System.out.println("\nPontuação total - TIME A: " + totalA + " pontos");
                    System.out.println("Pontuação total - TIME B: " + totalB + " pontos");
                    break;

                case 0:
                    System.out.println("Partida encerrada.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }
}