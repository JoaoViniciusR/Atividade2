import java.util.List;

public class TaskController {
    private TaskList model;
    private TaskView view;

    public TaskController(TaskList model, TaskView view) {
        this.model = model;
        this.view = view;
    }

    public void addTask() {
        String title = view.getInput("Digite o título da tarefa: ");
        Task task = new Task(title);
        model.addTask(task);
        view.showMessage("Tarefa adicionada com sucesso!");
    }

    public void showTasks() {
        List<Task> tasks = model.getTasks();
        view.showTasks(tasks);
    }

    public void markTaskCompleted() {
        int taskIndex = Integer.parseInt(view.getInput("Digite o número da tarefa concluída: ")) - 1;
        List<Task> tasks = model.getTasks();

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).setCompleted(true);
            view.showMessage("Tarefa marcada como concluída.");
        } else {
            view.showMessage("Número de tarefa inválido.");
        }
    }
}
