import java.util.Arrays;

public class Service {
        public void mostrarQuadra(
                        Jogador[] timeA,
                        Jogador[] timeB,
                        int pontosA,
                        int pontosB) {

                System.out.println();

                System.out.println("╔══════════════════════════════════════════════════════════════════╗");
                System.out.println("║                         🏐 PARTIDA                              ║");
                System.out.println("╠══════════════════════════════════════════════════════════════════╣");

                // =========================
                // PLACAR
                // =========================

                System.out.printf(
                                "║              TIME A          %2d  X  %-2d          TIME B        ║%n",
                                pontosA,
                                pontosB);

                System.out.println("╠══════════════════════════════════════════════════════════════════╣");
                System.out.println("║                                                                  ║");
                System.out.println("║          TIME A                              TIME B              ║");
                System.out.println("║                                                                  ║");

                // =========================
                // QUADRA - ATAQUE
                // =========================

                System.out.println(
                                "║      ┌─────────────────────┐       ┌─────────────────────┐      ║");

                System.out.printf(
                                "║      │   [4] %-12s     │       │   [2] %-12s     │      ║%n",
                                timeA[3].getNome(),
                                timeB[1].getNome());

                System.out.println(
                                "║      │                     │       │                     │      ║");

                System.out.printf(
                                "║      │   [3] %-12s     │       │   [3] %-12s     │      ║%n",
                                timeA[2].getNome(),
                                timeB[2].getNome());

                System.out.println(
                                "║      │                     │       │                     │      ║");

                System.out.printf(
                                "║      │   [2] %-12s     │       │   [4] %-12s     │      ║%n",
                                timeA[1].getNome(),
                                timeB[3].getNome());

                // =========================
                // LINHA DE ATAQUE
                // =========================

                System.out.println(
                                "║      ├─────────────────────┤       ├─────────────────────┤      ║");

                System.out.println(
                                "║      │                     │       │                     │      ║");

                // =========================
                // REDE
                // =========================

                System.out.println(
                                "║══════╪══════════ REDE ═════╪═══════╪══════════ REDE ═════╪══════║");

                // =========================
                // DEFESA
                // =========================

                System.out.println(
                                "║      │                     │       │                     │      ║");

                System.out.printf(
                                "║      │   [5] %-12s     │       │   [5] %-12s     │      ║%n",
                                timeA[4].getNome(),
                                timeB[4].getNome());

                System.out.println(
                                "║      │                     │       │                     │      ║");

                System.out.printf(
                                "║      │   [6] %-12s     │       │   [6] %-12s     │      ║%n",
                                timeA[5].getNome(),
                                timeB[5].getNome());

                System.out.println(
                                "║      │                     │       │                     │      ║");

                System.out.printf(
                                "║      │   [1] %-12s     │       │   [1] %-12s     │      ║%n",
                                timeA[0].getNome(),
                                timeB[0].getNome());

                // =========================
                // FUNDO DA QUADRA
                // =========================

                System.out.println(
                                "║      └─────────────────────┘       └─────────────────────┘      ║");

                System.out.println("║                                                                  ║");
                System.out.println("╚══════════════════════════════════════════════════════════════════╝");

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

        public void substituir(Jogador[] titulares, Jogador[] reservas, Jogador jogadorTitular,
                        Jogador jogadorReserva) {
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

        // JUNTANDO VETORES
        public Jogador[] merge(Jogador[] vetorA, Jogador[] vetorB) {

                Jogador[] resultado = new Jogador[vetorA.length + vetorB.length];

                System.arraycopy(vetorA, 0, resultado, 0, vetorA.length);
                System.arraycopy(vetorB, 0, resultado, vetorA.length, vetorB.length);

                return resultado;
        }

        // CONTANDO PONTOS DE CADA TIME
        public int contaPontos(Jogador[] jogadores) {
                int total = 0;

                for (Jogador jogador : jogadores) {
                        total += jogador.getPontos();
                }

                return total;
        }

        // IDENTIFICANDO TIME
        public String identificarTime(Jogador jogador, Jogador[] timeA, Jogador[] timeB) {
                for (Jogador jogadorA : timeA) {
                        if (jogadorA == jogador) {
                                return "TIME A";
                        }
                        ;
                }
                ;

                for (Jogador jogadorB : timeB) {
                        if (jogadorB == jogador) {
                                return "TIME B";
                        }
                        ;
                }
                ;
                return "SEM TIME";
        }

        // RANKING
        public void exibirRanking(Jogador[] timeA, Jogador[] reservasA, Jogador[] timeB, Jogador[] reservasB) {
                //JUNTA TITULARES E RESERVAS DE CADA TIME
                Jogador[] jogadoresTimeA = merge(timeA, reservasA);
                Jogador[] jogadoresTimeB = merge(timeB, reservasB);

                //JUNTANDO OS TIMES
                Jogador[] jogadores = merge(jogadoresTimeA, jogadoresTimeB);

                //ORDENAÇÃO
                Arrays.sort(jogadores, (j1, j2) -> Integer.compare(j2.getPontos(), j1.getPontos()));

                System.out.println("\n======================");
                System.out.println("RANKING DE PONTUADORES");
                System.out.println("======================\n");

                int posicao = 1;

                for (Jogador jogador : jogadores) {
                        String time = identificarTime(jogador, jogadoresTimeA, jogadoresTimeB);
                        System.out.println(posicao + "° - " + jogador.getNome() + " - " + time + " - "
                                        + jogador.getPontos() + " pontos");
                        posicao++;
                }

                // PONTUAÇÃO DE TIMES
                int pontosTimeA = contaPontos(jogadoresTimeA);
                int pontosTimeB = contaPontos(jogadoresTimeB);

                System.out.println("\n=================");
                System.out.println("RANKING DOS TIMES");
                System.out.println("=================\n");

                if (pontosTimeA > pontosTimeB) {
                        System.out.println("1° - TIME A: " + pontosTimeA + " pontos");
                        System.out.println("2° - TIME B: " + pontosTimeB + " pontos");
                } else if (pontosTimeB > pontosTimeA) {
                        System.out.println("1° - TIME B: " + pontosTimeB + " pontos");
                        System.out.println("2° - TIME A: " + pontosTimeA + " pontos");

                }
        }
}
