package bubbles.tasks;

import bubbles.exceptions.EmptyTaskException;

public class ToDo extends Task {
    private ToDo(String description, boolean completed) {
        super(description, completed);
    }

    public static ToDo addToDo(String input, boolean completed) throws EmptyTaskException {
        if (input.equals("")) {
            throw new EmptyTaskException("todo");
        }

        ToDo item = new ToDo(input, completed);

        return item;
    }

    @Override
    public String format() {
        String format = "T | ";

        if (this.isDone) {
            format += "1 | ";
        } else {
            format += "0 | ";
        }

        format += this.description;

        return format;
    }

    @Override
    public String toString() {
        String res = "[T] [" + this.getStatus() + "] " + this.description;

        return res;
    }
}