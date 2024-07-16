package com.projeto.atribuicaoereferencia;

public class MeuObjeto {
    private Integer numero;

    public MeuObjeto() {
        // contrutor vazio
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "MeuObjeto {" +
                " numero = " + this.numero.toString() +
                " }";
    }
}
