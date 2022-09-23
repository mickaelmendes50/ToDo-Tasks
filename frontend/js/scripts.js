const tasks = []

// Funções para habilitar e desabilitar a visibilidade de um elemento
function displayEnable(element) {
    document.getElementById(element).style.display = 'block';
    document.getElementById("return-info").innerHTML = ""
    document.getElementById("submit-button").innerHTML = "Criar Tarefa"
}

function displayDisable(element) {
    document.getElementById(element).style.display = 'none';
}

function deleteTask() {
    var name = document.getElementById("name").value;
    for (var j = 0; j < tasks.length; j++) {
        if (name == tasks[j].name) {
            tasks.splice(j, 1)
            break;
        }
    }

    document.getElementById("delete-button").style.display = 'none';
    document.getElementById("submit-button").innerHTML = "Criar Tarefa";

    document.getElementById("return-info").innerHTML = "Tarefa excluída com sucesso!";
    document.getElementById("return-info").style.color = "green"
}

function editTask(indice) {
    var text = document.getElementById("submit-button").innerHTML
    if (text == "Criar Tarefa") {
        document.getElementById("return-info").innerHTML = "Tarefa já cadastrada!";
        document.getElementById("return-info").style.color = "orange"
        document.getElementById("submit-button").innerHTML = "Atualizar"
        document.getElementById("delete-button").style.display = 'inline-block';
    }
    if (text == "Atualizar") {
        tasks[indice].name = document.getElementById("name").value;
        tasks[indice].description = document.getElementById("description").value;
        tasks[indice].date = document.getElementById("date").value;
        tasks[indice].category = document.getElementById("category").value;

        var priority = document.getElementsByName('priority');
        for (var i = 0; i <= 5; i++) {
            if (priority[i].checked) {
                priority = i+1;
                break;
            }
        }
        tasks[indice].priority = priority;
        tasks[indice].status = document.getElementById("status").value;

        document.getElementById("return-info").innerHTML = "Tarefa atualizada com sucesso!";
        document.getElementById("return-info").style.color = "green"
        document.getElementById("submit-button").innerHTML = "Criar Tarefa"
    }
}

// Quando submeter nova tarefa, vamos criar um objeto 'Task' com ela
// e então adicionar ao nosso array de Task
function submitForm() {
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;
    var date = document.getElementById("date").value;
    var category = document.getElementById("category").value;

    var priority = document.getElementsByName('priority');
    for (var i = 0; i <= 5; i++) {
        if (priority[i].checked) {
            priority = i+1;
            break;
        }
    }
    
    // Uma Tarefa criada é sempre ToDo inicialmente
    var status = document.getElementById("status").value;

    // Se a tarefa já existir, executa a função de update
    for (var j = 0; j < tasks.length; j++) {
        if (name == tasks[j].name) {
            editTask(j);            
            return;
        }
    }

    var newTask = new Task(name, description, date, category, priority, status);

    if (newTask != null) {
        tasks.push(newTask);
        document.getElementById("return-info").innerHTML = "Tarefa criada com sucesso!";
        document.getElementById("return-info").style.color = "green"
    } else {
        document.getElementById("return-info").innerHTML = "Falha ao criar tarefa!";
        document.getElementById("return-info").style.color = "red"
    }
    return;
}

function showList() {

    var element_tasks = document.getElementById("tasks");
    if (element_tasks != null) {
        document.getElementById("tasks").innerHTML = "";
    }
    var tag = document.createElement("div");
    tag.setAttribute("id", "tasks");

    var element = document.getElementById("list");
    element.appendChild(tag);
    for (var i = 0; i < tasks.length; i++) {
        tag = document.createElement("p");
        var text = document.createTextNode(tasks[i].print());
        tag.appendChild(text);
        element = document.getElementById("tasks");
        element.appendChild(tag);

        if (tasks[i].description != undefined) {
            tag = document.createElement("li");
            text = document.createTextNode(tasks[i].description);
            tag.appendChild(text);
            element = document.getElementById("tasks");
            element.appendChild(tag);
        }
    }
}
