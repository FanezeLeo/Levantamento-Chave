import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Service service = new Service();

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

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("       O que voce deseja fazer?");
            System.out.println("==============================");

            System.out.println("1 - Jogar rodada");
            System.out.println("2 - Rotacionar Time A");
            System.out.println("3 - Rotacionar Time B");
            System.out.println("4 - Substituir jogador Time A");
            System.out.println("5 - Substituir jogador Time B");
            System.out.println("6 - Mostrar jogadores");
            System.out.println("7 - Mostrar quadra");
            System.out.println("8 - Maiores pontuadores");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    int selecionaTime = random.nextInt(2);
                    int selecionaJogador = random.nextInt(6);

                    if(selecionaTime == 0){
                        timeA[selecionaJogador].pontuar();
                    }else {
                        timeB[selecionaJogador].pontuar();
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
                    break;

                case 5:
                    break;

                case 6:
                    service.mostrarJogadores(timeA, reservasA, "TIME A");
                    service.mostrarJogadores(timeB, reservasB, "TIME B");
                    break;
                case 7:
                    service.mostrarQuadra(timeA, timeB);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}