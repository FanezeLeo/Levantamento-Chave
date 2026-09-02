public class Jogador {

    private String nome;
    private int numero;
    private String posicao;
    private int pontos;

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

    public int getPontos(){
        return pontos;
    }

    public void setPontos(int pontos){
        this.pontos = pontos;
    }

    public void pontuar(){
        this.pontos++;
    }

    @Override
    public String toString() {
        return numero + " - " + nome;
    }
}