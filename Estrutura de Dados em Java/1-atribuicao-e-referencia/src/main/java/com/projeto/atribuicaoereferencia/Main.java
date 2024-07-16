package com.projeto.atribuicaoereferencia;

public class Main {
    public static void main(String[] args) {

        int intA = 1;
        int intB = intA;

        System.out.println("intA = " + intA + " - intB = " + intB);
        intA = 2;
        System.out.println("intA = " + intA + " - intB = " + intB);

        MeuObjeto objA = new MeuObjeto();
        objA.setNumero(1);
        MeuObjeto objB = new MeuObjeto();
        objB = objA;

        System.out.println("objA = " + objA + " - objB = " + objB);
        objA.setNumero(2);
        System.out.println("objA = " + objA + " - objB = " + objB);
    }
}