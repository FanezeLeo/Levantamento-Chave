import java.util.Arrays;

public class Service {
        public void mostrarQuadra(Jogador[] timeA, Jogador[] timeB) {

                System.out.println("\n");
                System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                         QUADRA DE VÔLEI                            ║");
                System.out.println("╠══════════════════════════════════════════════════════════════════════╣");

                System.out.println("║                                                                      ║");
                System.out.println("║              TIME A                               TIME B             ║");
                System.out.println("║                                                                      ║");

                // ==============================
                // PARTE DE CIMA - ATAQUE
                // ==============================

                System.out.printf(
                                "║     ┌───────────────────────┐       ┌───────────────────────┐     ║%n");

                System.out.printf(
                                "║     │  [4] %-13s │       │  [2] %-13s │     ║%n",
                                timeA[3].getNome(),
                                timeB[1].getNome());

                System.out.printf(
                                "║     │                         │       │                         │     ║%n");

                System.out.printf(
                                "║     │  [3] %-13s │       │  [3] %-13s │     ║%n",
                                timeA[2].getNome(),
                                timeB[2].getNome());

                System.out.printf(
                                "║     │                         │       │                         │     ║%n");

                System.out.printf(
                                "║     │  [2] %-13s │       │  [4] %-13s │     ║%n",
                                timeA[1].getNome(),
                                timeB[3].getNome());

                System.out.printf(
                                "║     └───────────────────────┘       └───────────────────────┘     ║%n");

                // ==============================
                // REDE
                // ==============================

                System.out.println(
                                "║═══════════════════════════════ REDE ════════════════════════════════║");

                // ==============================
                // PARTE DE BAIXO - DEFESA
                // ==============================

                System.out.printf(
                                "║     ┌───────────────────────┐       ┌───────────────────────┐     ║%n");

                System.out.printf(
                                "║     │  [5] %-13s │       │  [5] %-13s │     ║%n",
                                timeA[4].getNome(),
                                timeB[4].getNome());

                System.out.printf(
                                "║     │                         │       │                         │     ║%n");

                System.out.printf(
                                "║     │  [6] %-13s │       │  [6] %-13s │     ║%n",
                                timeA[5].getNome(),
                                timeB[5].getNome());

                System.out.printf(
                                "║     │                         │       │                         │     ║%n");

                System.out.printf(
                                "║     │  [1] %-13s │       │  [1] %-13s │     ║%n",
                                timeA[0].getNome(),
                                timeB[0].getNome());

                System.out.printf(
                                "║     └───────────────────────┘       └───────────────────────┘     ║%n");

                System.out.println("║                                                                      ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════════╝");

                System.out.println();
                System.out.println("Posições:");
                System.out.println("  4 → Frente esquerda     |     2 → Frente direita");
                System.out.println("  3 → Frente centro");
                System.out.println("  5 → Fundo esquerda      |     1 → Fundo direita");
                System.out.println("  6 → Fundo centro");
                System.out.println();
        }

        public void rotacionar(Jogador[] time) {
                Jogador auxiliar = time[5];

                time[5] = time[4];
                time[4] = time[3];
                time[3] = time[2];
                time[2] = time[1];
                time[1] = time[0];
                time[0] = auxiliar;
        }

        public void substituir(Jogador[] titulares, Jogador[] reservas, Jogador jogadorTitular, Jogador jogadorReserva) {
                int indexTitular = Arrays.asList(titulares).indexOf(jogadorTitular);
                int indexReserva = Arrays.asList(reservas).indexOf(jogadorReserva);

                if (indexTitular != -1 && indexReserva != -1) {
                        titulares[indexTitular] = jogadorReserva;
                        reservas[indexReserva] = jogadorTitular;
                } else {
                        System.out.println("Jogador não encontrado!");
                }
        }

        public Jogador[] adicionarReserva(Jogador[] reservas, Jogador novoReserva) {
                reservas = Arrays.copyOf(reservas, 1 + reservas.length);
                reservas[reservas.length - 1] = novoReserva;
                return reservas;
        }

        public void mostrarJogadores(Jogador[] titulares, Jogador[] reservas, String nomeTime) {

                System.out.println("\n==============================");
                System.out.println(nomeTime);
                System.out.println("==============================");

                System.out.println("\nTITULARES:");

                for (int i = 0; i < titulares.length; i++) {

                        System.out.println(titulares[i]);
                }

                System.out.println("\nRESERVAS:");

                for (Jogador jogador : reservas) {
                        System.out.println(jogador);
                }
        }

        public Jogador buscarJogadorPorNumero(Jogador[] jogadores, int numero) {
                for (Jogador jogador : jogadores) {
                        if (jogador.getNumero() == numero) {
                                return jogador;
                        }
                }
                return null;
        }

        public void exibirRanking(Jogador[] timeA, Jogador[] timeB) {
                Jogador[] jogadores =  new Jogador[timeA.length + timeB.length];

                for (int i = 0; i < timeA.length; i++) {
                        jogadores[i] = timeA[i];
                };

                for (int i = 0; i < timeB.length; i++) {
                        jogadores[timeA.length + i] = timeB[i];
                }

                Arrays.sort(jogadores, (j1, j2) ->
                        Integer.compare(j2.getPontos(), j1.getPontos())
                );

                System.out.println("\n====================");
                System.out.println("RANKING DE PONTUADORES");
                System.out.println("====================");

                for (Jogador jogador: jogadores) {
                        System.out.println(jogador.getNome() + " - " + jogador.getPontos() + " pontos");
                }
        }
}
