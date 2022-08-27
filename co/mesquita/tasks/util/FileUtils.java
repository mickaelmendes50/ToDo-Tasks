package co.mesquita.tasks.util;

import co.mesquita.tasks.entity.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
    public void WriteTasks(Task task) throws IOException {
        FileWriter fw = new FileWriter("res/assets/tasks.txt", true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(task.getName() + "'" +
                 task.getDescription() + "'" +
                 task.getDate() + "'" +
                 task.getCategory() + "'" +
                 task.getPriority() + "'" +
                 task.getStatus());
        pw.println();

        fw.close();
    }
}
