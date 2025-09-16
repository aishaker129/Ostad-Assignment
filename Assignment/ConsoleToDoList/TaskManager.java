import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskManager {

    private Set<Task> tasks;
    private Map<Long, Task> taskById;
    private Map<String, List<Task>> taskByDate;

    public TaskManager() {
        this.tasks = new HashSet<>();
        this.taskById = new HashMap<>();
        this.taskByDate = new HashMap<>();
    }

    public void addTask(String message, String date) {
        Task task = new Task(message, date);
        tasks.add(task);
        taskById.put(task.getId(), task);
        taskByDate.putIfAbsent(date, new ArrayList<>());
        taskByDate.get(date).add(task);

        System.out.println("\nTask added successfully ...");
        showAllTasks();
    }

    public void viewTaskById(long id) {
        Task task = taskById.get(id);
        if (task != null) {
            System.out.println(task);
            System.out.println();
        } else {
            System.out.println("\nTask with ID " + id + " not found.");
        }
    }

    public void viewTasksByDate(String date) {
        List<Task> list = taskByDate.get(date);
        if (list != null && !list.isEmpty()) {
            System.out.println("\nTasks on " + date + ":");
            list.forEach(System.out::println);
            System.out.println();
        } else {
            System.out.println("\nNo tasks found on " + date);
        }
    }

    public void deleteTaskById(long id) {
        Task task = taskById.get(id);
        if (task != null) {
            tasks.remove(task);
            taskById.remove(id);
            taskByDate.get(task.getDate()).remove(task);

            System.out.println("\nTask deleted successfully ...");
        } else {
            System.out.println("\nTask with ID " + id + " not found.");
        }

        showAllTasks();
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach(System.out::println);
            System.out.println();
        }
    }
}
