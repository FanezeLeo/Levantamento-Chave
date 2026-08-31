public class Jogador {

    private String nome;
    private int numero;
    private String posicao;

    public Jogador(String nome, int numero, String posicao) {
        this.nome = nome;
        this.numero = numero;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public String toString() {
        return numero + " - " + nome;
    }
}