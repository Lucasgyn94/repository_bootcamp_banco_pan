package one.digitalInnovation;

public class BinNo <T extends Comparable<T>> {
    private T conteudo;
    private BinNo<T> noEsq;
    private BinNo<T> noDir;

    public BinNo(T conteudo) {
        this.conteudo = conteudo;
        noEsq = noDir = null;
    }
    public BinNo() {

    }

    // getters

    public T getConteudo() {
        return conteudo;
    }

    public BinNo<T> getNoEsq() {
        return noEsq;
    }

    public BinNo<T> getNoDir() {
        return noDir;
    }
    // setters

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public void setNoEsq(BinNo<T> noEsq) {
        this.noEsq = noEsq;
    }

    public void setNoDir(BinNo<T> noDir) {
        this.noDir = noDir;
    }

    @Override
    public String toString() {
        return "BinNo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
