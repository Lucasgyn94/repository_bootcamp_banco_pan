package dio.pilhasLifo;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha () {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo) {
        // adicianando um no no topo da pilha
        No refAuxiliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxiliar);
    }

    public No pop() {
        if (!this.IsEmpty()) {
            No noRetirado = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noRetirado;
        }
        return null;
    }


    public No top() {
        return refNoEntradaPilha;
    }

    public boolean IsEmpty() {
        /*
        if (refNoEntradaPilha == null) {
            return true;
        }
        return false;
        */
        return refNoEntradaPilha == null ? true : false;
    }

    @Override
    public String toString() {
        String str = "====================\n";
        str += "\t PILHA \n";
        str += "=====================\n";

        No noAuxiliar = refNoEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                str += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }

        }
        str += "\n===================";
        return str;
    }
}
