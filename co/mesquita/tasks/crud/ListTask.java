package co.mesquita.tasks.crud;

import co.mesquita.tasks.entity.Task;
import co.mesquita.tasks.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;

public class ListTask {

    public void ListTasks() throws IOException {
        FileUtils fu = new FileUtils();
        ArrayList<Task> tasks;

        tasks = fu.ReadTasks();

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).toString());
        }
    }
}
