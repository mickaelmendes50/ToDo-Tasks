package co.mesquita.tasks.util;

import co.mesquita.tasks.entity.Task;

import java.io.*;
import java.util.ArrayList;

import static co.mesquita.tasks.util.Constants.TXT_FILE;

public class FileUtils {
    public void WriteTasks(Task task) throws IOException {
        FileWriter fw = new FileWriter(TXT_FILE, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(task.getName() + ";" +
                 task.getDescription() + ";" +
                 task.getDate() + ";" +
                 task.getCategory() + ";" +
                 task.getPriority() + ";" +
                 task.getStatus());
        pw.println();

        fw.close();
    }

    public ArrayList<Task> ReadTasks() throws IOException {
        ArrayList<Task> tasks = new ArrayList<Task>();

        FileReader fr = new FileReader(TXT_FILE);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            String[] splitLine = line.split(";");
            String name = splitLine[0];
            String description = splitLine[1];
            String date = splitLine[2];
            String category = splitLine[3];
            int priority = Integer.parseInt(splitLine[4]);
            int status = Integer.parseInt(splitLine[5]);

            Task task = new Task(name, description, date, category, priority, status);
            tasks.add(task);

            line = br.readLine();
        }

        br.close();

        return tasks;
    }
}
