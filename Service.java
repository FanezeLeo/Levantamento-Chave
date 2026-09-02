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

        public void substituir(Jogador[] titulares, Jogador[] reservas) {

                System.out.println("\n==============================");
                System.out.println("       SUBSTITUIÇÃO");
                System.out.println("==============================");

                System.out.println("\nTITULARES:");

                for (int i = 0; i < titulares.length; i++) {
                        System.out.println(titulares[i]);
                }

                System.out.println("\nRESERVAS:");

                for (int i = 0; i < reservas.length; i++) {
                        System.out.println(reservas[i]);
                }

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

}
