package co.mesquita.tasks;

import co.mesquita.tasks.crud.CreateTask;
import co.mesquita.tasks.crud.ListTask;
import co.mesquita.tasks.crud.UpdateTask;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int Menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------\n" +
                           "           ToDo - Tasks | Sua lista de Tarefas                \n" +
                           "--------------------------------------------------------------\n" +
                "1. Criar nova Tarefa\n" +
                "2. Listar Tarefas\n" +
                "3. Atualizar Tarefa\n" +
                "0. Sair");

        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public static void main(String[] args) throws IOException {
        CreateTask createTask = new CreateTask();
        ListTask listTask = new ListTask();
        UpdateTask updateTask = new UpdateTask();

        int option;
        do {
            option = Menu();
            switch (option) {
                case 1:
                    createTask.CreateTask();
                    break;
                case 2:
                    listTask.ListTasks();
                    break;
                case 3:
                    updateTask.UpdateTasks();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (option != 0);
    }
}
