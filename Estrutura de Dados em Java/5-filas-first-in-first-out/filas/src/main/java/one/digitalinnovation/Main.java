package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        Fila minhaFila = new Fila();
        minhaFila.enqueue(new No("Primeiro"));
        minhaFila.enqueue(new No("Segundo"));
        minhaFila.enqueue(new No("Terceiro"));
        minhaFila.enqueue(new No("Quarto"));

        System.out.println(minhaFila.toString());

        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila.dequeue());

        System.out.println(minhaFila.toString());

        minhaFila.enqueue(new No("Ultimo"));

        System.out.println(minhaFila.toString());

        System.out.println(minhaFila.first());

        System.out.println(minhaFila.toString());
    }
}
