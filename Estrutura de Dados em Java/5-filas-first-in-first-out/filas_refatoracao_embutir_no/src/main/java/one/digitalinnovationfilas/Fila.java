package one.digitalinnovationfilas;

public class Fila {

    private No referenciaNoDeEntradaFila;

    public Fila() {
        // garantindo que ao instanciar a fila, ela sera vazia
        this.referenciaNoDeEntradaFila = null;
    }

    // metodo enfileirar (enqueue)
    public void enqueue(Object object) {
        // recebi um nono no, o novo no entrou na fila, a referencia de no do proximo no, e o antigo ultimo no da fila, ele aponta pro ultimo da fila
        No novoNo = new No(object);
        novoNo.setRefNo(referenciaNoDeEntradaFila);
        referenciaNoDeEntradaFila = novoNo;
    }
    // metodo desinfileirar
    public Object dequeue(){
        if(!isEmpty()){
            No primeiroNo = referenciaNoDeEntradaFila;
            No noAuxiliar = referenciaNoDeEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    // metodo first(primeiro da fila)
    public Object first() {
        if(!this.isEmpty()) {
            No primeiroNo = referenciaNoDeEntradaFila;
            // loop para parar quando for o primeiro da fila
            while(true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    break;
                }
            }
            return primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty() {
        return referenciaNoDeEntradaFila == null ? true : false;
    }

    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = referenciaNoDeEntradaFila;

        if (referenciaNoDeEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";

                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                }else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }

        return stringRetorno;
    }



}
