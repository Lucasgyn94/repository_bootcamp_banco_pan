package one.digitalinnovationfilas;

public class No {

    private Object object;
    private No refNo;

    // metodo construtor vazio
    public No () {
    }

    public No (Object object) {
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

    public void setObject(Object object) {
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
