import java.util.Arrays;

public class Service {

        public void mostrarQuadra(Jogador[] timeA, Jogador[] timeB) {

                System.out.println("\n");
                System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
                System.out.println("║                              QUADRA DE VÔLEI                               ║");
                System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                            ║");
                System.out.println("║                   TIME A                         TIME B                    ║");
                System.out.println("║                                                                            ║");

                System.out.println("║          ┌───────────────────────┐      ┌───────────────────────┐          ║");

                System.out.printf(
                        "║          │[4] %-19s│      │[2] %-19s│          ║%n",
                        timeA[3].getNome(),
                        timeB[1].getNome());

                System.out.println("║          │                       │      │                       │          ║");

                System.out.printf(
                        "║          │[3] %-19s│      │[3] %-19s│          ║%n",
                        timeA[2].getNome(),
                        timeB[2].getNome());

                System.out.println("║          │                       │      │                       │          ║");

                System.out.printf(
                        "║          │[2] %-19s│      │[4] %-19s│          ║%n",
                        timeA[1].getNome(),
                        timeB[3].getNome());

                System.out.println("║          └───────────────────────┘      └───────────────────────┘          ║");

                System.out.println("║═══════════════════════════════════ REDE ═══════════════════════════════════║");

                System.out.println("║          ┌───────────────────────┐      ┌───────────────────────┐          ║");

                System.out.printf(
                        "║          │[5] %-19s│      │[5] %-19s│          ║%n",
                        timeA[4].getNome(),
                        timeB[4].getNome());

                System.out.println("║          │                       │      │                       │          ║");

                System.out.printf(
                        "║          │[6] %-19s│      │[6] %-19s│          ║%n",
                        timeA[5].getNome(),
                        timeB[5].getNome());

                System.out.println("║          │                       │      │                       │          ║");

                System.out.printf(
                        "║          │[1] %-19s│      │[1] %-19s│          ║%n",
                        timeA[0].getNome(),
                        timeB[0].getNome());

                System.out.println("║          └───────────────────────┘      └───────────────────────┘          ║");

                System.out.println("║                                                                            ║");
                System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");

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


        public Jogador[] juntarJogadores(Jogador[]... grupos) {
                int tamanhoTotal = 0;
                for (Jogador[] grupo : grupos) {
                        tamanhoTotal += grupo.length;
                }

                Jogador[] todos = new Jogador[tamanhoTotal];
                int posicao = 0;

                for (Jogador[] grupo : grupos) {
                        for (Jogador jogador : grupo) {
                                todos[posicao] = jogador;
                                posicao++;
                        }
                }

                return todos;
        }


        public void ordenarPorPontuacao(Jogador[] jogadores) {
                int n = jogadores.length;

                for (int i = 0; i < n - 1; i++) {
                        int indexMaior = i;

                        for (int j = i + 1; j < n; j++) {
                                if (jogadores[j].getPontos() > jogadores[indexMaior].getPontos()) {
                                        indexMaior = j;
                                }
                        }

                        if (indexMaior != i) {
                                Jogador temp = jogadores[i];
                                jogadores[i] = jogadores[indexMaior];
                                jogadores[indexMaior] = temp;
                        }
                }
        }


        public void mostrarRanking(Jogador[] jogadores) {
                Jogador[] copia = Arrays.copyOf(jogadores, jogadores.length);
                ordenarPorPontuacao(copia);

                System.out.println("\n==============================");
                System.out.println("     MAIORES PONTUADORES");
                System.out.println("==============================");

                for (int i = 0; i < copia.length; i++) {
                        System.out.println((i + 1) + "º - " + copia[i]);
                }
        }


        public int somarPontos(Jogador[] jogadores) {
                int total = 0;
                for (Jogador jogador : jogadores) {
                        total += jogador.getPontos();
                }
                return total;
        }
}
