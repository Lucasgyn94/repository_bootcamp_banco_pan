package one.digitalInnovation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Carro> listCarros = new ArrayList<>();
        listCarros.add(new Carro("Ford"));
        listCarros.add(new Carro("Chevrolet"));
        listCarros.add(new Carro("Fiat"));
        listCarros.add(new Carro("Peugeot"));

        System.out.println(listCarros.contains(new Carro("Ford")));

        System.out.println(listCarros.get(2));

        // saber em qual index esta o carro
        System.out.println(listCarros.indexOf(new Carro("Fiat")));

        System.out.println(listCarros.remove(2));
        System.out.println(listCarros);
    }
}
