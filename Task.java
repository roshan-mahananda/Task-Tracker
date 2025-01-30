import java.util.UUID;

public class Task {
    private String id;
    private String name;
    private Status status;

    public enum Status {NOT_DONE, IN_PROGRESS, DONE}

    public Task(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = Status.NOT_DONE;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ": " + name + " [" + status + "]";
    }
}
