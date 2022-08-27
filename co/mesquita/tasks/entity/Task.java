package co.mesquita.tasks.entity;

public class Task {
    private String name;
    private String description;
    private String date;
    private String category;
    private int priority;
    private String status;

    public Task(String name, String description, String date, String category, int priority, String status) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.category = category;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String string = category + ": " + name + " | " + date + " | " + status + " | Prioridade: " + priority;
        if (!getDescription().equals("null"))
            string += "\n * " + description;

        return string;
    }
}
