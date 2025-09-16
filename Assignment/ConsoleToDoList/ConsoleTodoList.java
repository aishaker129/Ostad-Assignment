import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleTodoList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.print("\nEnter a command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("a")) {
                System.out.print("Enter task message: ");
                String message = scanner.nextLine();
                System.out.print("Enter task date (DD/MM/YYYY): ");
                String date = scanner.nextLine();
                String normalizedDate = normalizeDate(date);
                taskManager.addTask(message, normalizedDate);
            } else if (command.contains("v")) {
                String param = command.substring(1).trim();
                if (param.contains("/")) {
                    String normalizedDate = normalizeDate(param);
                    taskManager.viewTasksByDate(normalizedDate);
                } else {
                    try {
                        long id = Long.parseLong(param);
                        taskManager.viewTaskById(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Use numeric ID or date in dd/MM/yyyy format.");
                    }
                }
            } else if (command.startsWith("d")) {
                String param = command.substring(1).trim();
                long id = Long.parseLong(param);
                taskManager.deleteTaskById(id);
            } else if (command.equals("q")) {
                System.out.println("\nExiting the application. Goodbye!\n");
                break;
            } else {
                System.out.println("Invalid command! Use:");
                System.out.println("a -> add task");
                System.out.println("v<ID> -> view task by ID");
                System.out.println("v<dd/MM/yyyy> -> view tasks by date");
                System.out.println("d<ID> -> delete task by ID");
            }
        }
    }

    private static String normalizeDate(String date) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        DateTimeFormatter standardFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d = LocalDate.parse(date, inputFormat);
        return d.format(standardFormat);
    }
}
