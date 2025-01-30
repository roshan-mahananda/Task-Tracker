import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TaskManager {

    private static final String FILE_NAME = "tasks.json";

    private List<Task> tasks;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public TaskManager() {
        this.tasks = loadTasks();
    }

    public void addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
        saveTasks();
        System.out.println("Task added : " + task);
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public void updateTask(String id, Task.Status status) {
        Optional<Task> taskOpt = tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
        if (taskOpt.isPresent()) {
            taskOpt.get().setStatus(status);
            saveTasks();
            System.out.println("Task Updated: " + taskOpt.get());
        } else {
            System.out.println("Task Not Found.");
        }
    }

    public void deleteTask(String id) {
        tasks.removeIf(t -> t.getId().equals(id));
        saveTasks();
        System.out.println("Task Deleted.");
    }

    public void saveTasks() {
        try (FileWriter writer = new FileWriter(FILE_NAME);) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private List<Task> loadTasks() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<Task>>() {
            }.getType();
            List<Task> loadedTasks = gson.fromJson(reader, listType);
            return loadedTasks != null ? loadedTasks : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
