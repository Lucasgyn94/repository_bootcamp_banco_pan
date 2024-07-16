package one.digitalInnovation;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<Carro> queueCarros = new LinkedList<>();
        queueCarros.add(new Carro("Ford"));
        queueCarros.add(new Carro("Chevrolet"));
        queueCarros.add(new Carro("Fiat"));

        System.out.println(queueCarros.add(new Carro("Peugeot")));
        System.out.println(queueCarros);

        System.out.println(queueCarros.offer(new Carro("Renault")));
        System.out.println(queueCarros);

        // peek pega o primeiro elemento da fila
        System.out.println("Primeiro = " + queueCarros.peek());
        System.out.println(queueCarros);

        // remover da fila com pool
        System.out.println(queueCarros.poll());
        System.out.println(queueCarros);

        System.out.println("Lista vazia? " + queueCarros.isEmpty());

        System.out.println("Tamanho da fila = " + queueCarros.size());

    }
}
