package co.mesquita.tasks.crud;

import co.mesquita.tasks.entity.Task;
import co.mesquita.tasks.util.FileUtils;

import java.io.IOException;
import java.util.Scanner;

public class CreateTask {

    public int CreateTask() {
        Scanner sc = new Scanner(System.in);
        FileUtils fu = new FileUtils();

        System.out.println("Qual o nome da Tarefa?");
        String name = sc.nextLine();

        System.out.println("Defina a data");
        String date = sc.nextLine();

        System.out.println("Deseja definir uma categoria? (S/N)");
        String option = sc.nextLine();
        String category;
        if (option.equals("S")) {
            System.out.print("Categoria: ");
            category = sc.nextLine();
        } else {
            category = null;
        }

        System.out.println("Qual a prioridade? (1-5)");
        int priority = sc.nextInt();

        Task task = new Task(name, date, category, priority);

        try {
            fu.WriteTasks(task);
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo");;
        }
        return 1;
    }
}