import java.util.*;

public class TaskManager {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, String> tasks = new HashMap<>();
    static int taskId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addTask();
                case 2 -> showTasks();
                case 3 -> deleteTask();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.put(taskId, task);
        System.out.println("Task added with ID: " + taskId);
        taskId++;
    }

    static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            for (int id : tasks.keySet()) {
                System.out.println(id + ": " + tasks.get(id));
            }
        }
    }

    static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            System.out.println("Task " + id + " deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}
