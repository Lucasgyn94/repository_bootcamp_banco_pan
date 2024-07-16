package one.digitalinnovationfilas;
// refatorando a classe no para receber so um tipo de dados com generics <T>
public class No<T> {

    private T object;
    private No<T> refNo;

    // metodo construtor vazio
    public No () {
    }

    public No (T object) {
        this.refNo = null;
        this.object = object;
    }
    // getters
    public Object getObject() {
        return object;
    }

    public No getRefNo() {
        return refNo;
    }

    // setters

    public void setObject(T object) {
        this.object = object;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
