package ru.netology;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query))
                return true;
        }
        return false;
    }
}

