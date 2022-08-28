package co.mesquita.tasks.crud;

import co.mesquita.tasks.entity.Task;
import co.mesquita.tasks.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListTask {

    private void listAll(ArrayList<Task> tasks) {
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).toString());
        }
        System.out.println("--------------------------------------------------------------");
    }

    private void listCategory(ArrayList<Task> tasks, String category) {
        int cont = 0;
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getCategory().equals(category)) {
                System.out.println(tasks.get(i).toString());
                cont++;
            }
        }
        System.out.println("--------------------------------------------------------------");
        if (cont == 0) {
            System.out.println("Categoria não encontrada!");
        }
    }

    private void listPriority() {

    }

    private void listStatus() {

    }

    public void ListTasks() throws IOException {
        FileUtils fu = new FileUtils();
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = fu.ReadTasks();

        System.out.println("------------------------------------------\n" +
                           "               Listar Tarefas             \n" +
                           "------------------------------------------");
        System.out.println("1. Todas\n" +
                           "2. Categoria\n" +
                           "3. Prioridade\n" +
                           "4. Status\n" +
                           "0. Voltar ao Menu Princial");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                listAll(tasks);
                break;
            case 2:
                System.out.print("Categoria: ");
                String category = sc.nextLine();
                listCategory(tasks, category);
                break;
            case 3:
                listPriority();
                break;
            case 4:
                listStatus();
                break;
            case 0:
                return;
        }
    }
}
