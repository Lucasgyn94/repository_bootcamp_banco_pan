package one.digitalinnovation;

public class Fila {
    private No referenciaNoEntradaFila;

    public Fila() {
        this.referenciaNoEntradaFila = null;
    }
    // verificando se a fila esta vazia (is empty)
    public boolean isEmpty() {
        return referenciaNoEntradaFila == null ? true : false;
    }
    // metodo infileirar (enqueue)
    public void enqueue(No novoNo) {
        novoNo.setReferenciaNo(referenciaNoEntradaFila);
        referenciaNoEntradaFila = novoNo;
    }
    // retorna o primeiro no da fila (metodo force)
    public No first() {
        if(!this.isEmpty()) {
            No primeiroNo = referenciaNoEntradaFila;
            while(true) {
                // se não e o primeiro no
                if(primeiroNo.getReferenciaNo() != null) {
                    primeiroNo = primeiroNo.getReferenciaNo();
                } else {
                    break;
                }
            }
            return primeiroNo;
        }
        return null;
    }

    public No dequeue() {
        if(!this.isEmpty()) {
            No primeiroNo = referenciaNoEntradaFila;
            No noAuxiliar = referenciaNoEntradaFila;
            while(true) {
                // se não e o primeiro no
                if(primeiroNo.getReferenciaNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getReferenciaNo();
                } else {
                    noAuxiliar.setReferenciaNo(null);
                    break;
                }
            }
            return primeiroNo;
        }
        return null;
    }

    @Override
    public String toString() {
        String strReturn = "";
        No noAuxiliar = referenciaNoEntradaFila;

        if (referenciaNoEntradaFila != null) {
            while(true) {
                strReturn += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if (noAuxiliar.getReferenciaNo() != null) {
                    noAuxiliar = noAuxiliar.getReferenciaNo();
                } else {
                    strReturn += "null";
                    break;
                }
            }
        } else {
            strReturn = "null";
        }

        return strReturn;
    }
}
