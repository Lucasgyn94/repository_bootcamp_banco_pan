package one.digitalInnovation;

public class NoDuplo <T> {

    private T conteudo;
    private NoDuplo<T> noProximo;
    private NoDuplo<T> noPrevio;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    // getters

    public T getConteudo() {
        return conteudo;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }
    public NoDuplo<T> getNoPrevio() {
        return noPrevio;
    }

    // setters

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {
        this.noPrevio = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
