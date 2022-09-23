package co.mesquita.tasks.crud;

import co.mesquita.tasks.entity.Task;
import co.mesquita.tasks.util.FileUtils;

import java.io.IOException;
import java.util.Scanner;

import static co.mesquita.tasks.util.Constants.TODO;

public class CreateTask {

    public int CreateTask() {
        Scanner sc = new Scanner(System.in);
        FileUtils fu = new FileUtils();

        System.out.println("------------------------------------------\n" +
                           "             Criar nova Tarefa            \n" +
                           "------------------------------------------\n");

        System.out.print("Categoria: ");
        String category = sc.nextLine();

        System.out.print("Tarefa: ");
        String name = sc.nextLine();

        System.out.print("Data (dd/mm): ");
        String date = sc.nextLine();

        System.out.println("Deseja adicionar uma descrição? (S/N)");
        String option = sc.nextLine();

        String description;
        do {
            System.out.println("Opção inválida! Digite 'S' para Sim ou 'N' para Não ");
            option = sc.nextLine();
            if (option.equals("N"))
                break;
        } while (!option.equals("S"));

        if (option.equals("S")) {
            System.out.print("Descrição: ");
            description = sc.nextLine();
        } else {
            description = null;
        }

        System.out.print("Prioridade (1-5): ");
        int priority = sc.nextInt();

        Task task = new Task(name, description, date, category, priority, TODO);

        try {
            fu.WriteTasks(task);
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo");;
        }
        return 1;
    }
}