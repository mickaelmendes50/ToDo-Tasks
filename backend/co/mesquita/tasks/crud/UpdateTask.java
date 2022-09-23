package co.mesquita.tasks.crud;

import co.mesquita.tasks.entity.Task;
import co.mesquita.tasks.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static co.mesquita.tasks.util.Constants.*;

public class UpdateTask {
    public void UpdateTasks() throws IOException {
        FileUtils fu = new FileUtils();
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = fu.ReadTasks();

        System.out.println("--------------------------------------------------------------\n" +
                           "                   Qual Tarefa será alterada?                 ");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ". " + tasks.get(i).toString());
        }
        System.out.println("--------------------------------------------------------------");
        int option = sc.nextInt();
        sc.nextLine();

        System.out.println("------------------------------\n" +
                           " Qual o novo estado da Tarefa?\n" +
                           "-------------------------------\n" +
                           " 1. ToDo\n" +
                           " 2. Doing\n" +
                           " 3. Done");
        int new_status = sc.nextInt();
        sc.nextLine();
        String status = null;
        if (new_status == 1) {
            status = TODO;
        } else if (new_status == 2) {
            status = DOING;
        } else if (new_status == 3) {
            status = DONE;
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (i == option-1) {
                tasks.get(i).setStatus(status);
            }
        }

        fu.OverrideTasks(tasks);
    }
}
