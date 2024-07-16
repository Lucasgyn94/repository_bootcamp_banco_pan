package one.digitalInnovation;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> aluno = new HashMap<>();

        aluno.put("Nome: ", "Lucas");
        aluno.put("Idade: ", "'28");
        aluno.put("Média: ", "6");
        aluno.put("Turma", "2023");

        System.out.println(aluno);

        System.out.println(aluno.keySet());
        System.out.println(aluno.values());

        List<Map<String, String>> listaAlunos = new ArrayList<>();

        listaAlunos.add(aluno);

        Map<String, String> aluno2 = new HashMap<>();

        aluno2.put("Nome: ", "Maria");
        aluno2.put("Idade: ", "22");
        aluno2.put("Média: ", "9");
        aluno2.put("Turma", "3d");

        listaAlunos.add(aluno2);

        System.out.println(listaAlunos);

        System.out.println(aluno.containsKey("Nome"));
    }
}
