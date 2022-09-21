class Task {
    constructor(name, description, date, category, priority, status) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.category = category;
        this.priority = priority;
        this.status = status;
    }

    print() {
        return this.category + ": " + this.name + " | " + this.date + " | " + this.status + " | Prioridade: " + this.priority;
    }
}