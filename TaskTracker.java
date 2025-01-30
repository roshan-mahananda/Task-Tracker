import java.util.List;
import java.util.Scanner;

public class TaskTracker {
    public static void main(String[] args){

        System.out.println("Welcome to Task Tracker!");
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while(true){
            System.out.print("Enter command (add, list, update, delete, exit): ");
            String command = scanner.nextLine().trim();

            if(command.equalsIgnoreCase("exit")){
                System.out.println("Exiting Task Tracker....");
                break;
            }else if(command.startsWith("add ")){
                String taskName= command.substring(4);
                taskManager.addTask(taskName);
            }else if(command.startsWith("update ")){
                String[] parts = command.split(" ");
                if(parts.length ==3){
                    String id = parts[1];
                    Task.Status status = Task.Status.valueOf(parts[2].toUpperCase());
                    taskManager.updateTask(id, status);
                }else {
                    System.out.println("Invalid format. Use: update <id> <status>");
                }
            }else if(command.equalsIgnoreCase("list")){
                List<Task> tasks = taskManager.listTasks();
                tasks.forEach(System.out::println);
            }else if(command.startsWith("delete ")){
                String id = command.split(" ")[1];
                taskManager.deleteTask(id);
            }else{
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}