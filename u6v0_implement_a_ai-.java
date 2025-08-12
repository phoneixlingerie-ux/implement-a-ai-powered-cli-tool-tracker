import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tracker {

    // Define a map to store tasks with their status
    private Map<String, Boolean> taskTracker;

    // AI-powered task recommendation system
    private AiManager aiManager;

    public Tracker() {
        this.taskTracker = new HashMap<>();
        this.aiManager = new AiManager();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Tracker CLI Tool");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Get Task Recommendation");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    getTaskRecommendation();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String taskName = scanner.next();
        taskTracker.put(taskName, false);
        System.out.println("Task added successfully!");
    }

    private void removeTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String taskName = scanner.next();
        taskTracker.remove(taskName);
        System.out.println("Task removed successfully!");
    }

    private void listTasks() {
        System.out.println("Tasks:");
        for (Map.Entry<String, Boolean> entry : taskTracker.entrySet()) {
            System.out.println(entry.getKey() + " - " + (entry.getValue() ? "Completed" : "In Progress"));
        }
    }

    private void getTaskRecommendation() {
        String recommendedTask = aiManager.getRecommendedTask(taskTracker);
        System.out.println("Recommended task: " + recommendedTask);
    }

    private class AiManager {
        public String getRecommendedTask(Map<String, Boolean> taskTracker) {
            // Implement AI-powered task recommendation logic here
            // For now, return a random task
            return taskTracker.keySet().iterator().next();
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.run();
    }
}