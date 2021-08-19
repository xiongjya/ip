public class ToDoList {
    private Task[] tasks;
    private int count;

    public ToDoList() {
        this.tasks = new Task[100];
        this.count = 0;
    }

    public int taskListener(String input) {
        return (input.equals("list"))
                ? listTasks()
                : toMarkAsDone(input)
                ? markAsDone(input)
                : addTask(input);
    }

    public int listTasks() {
        String separator = "-----------------------------------------------------------------";

        int n = 0;

        System.out.println(separator);
        System.out.println("Below are some of the tasks in your list!");

        while (this.tasks[n] != null) {
            System.out.println((n + 1) + ". " + this.tasks[n]);

            n++;
        }

        System.out.println(separator);

        return 0;
    }

    public int addTask(String input) {
        String separator = "-----------------------------------------------------------------";

        this.tasks[count] = new Task(input);
        count++;

        System.out.println(separator + "\n"
                + "added: " + input + "\n"
                + separator);

        return 0;
    }

    public boolean toMarkAsDone(String input) {
        String[] arr = input.split(" ");

        boolean toDo = false;

        if (arr.length == 2) {
            try {
                Integer.valueOf(arr[1]);
                toDo = true;
            } catch (NumberFormatException e) {

            }
        }

        return toDo;
    }

    public int markAsDone(String input) {
        String separator = "-----------------------------------------------------------------";
        String indentation = "          ";
        String[] arr = input.split(" ");

        Task t = this.tasks[Integer.valueOf(arr[1]) - 1];

        t.markAsDone();

        String encouragement = "Good job! I've marked this task as done:";
        String reward = "Bubbles will reward you with a piece of candy.";

        System.out.println(separator + "\n"
                + encouragement + "\n"
                + indentation + t + "\n"
                + reward + "\n"
                + separator);

        return 0;
    }
}