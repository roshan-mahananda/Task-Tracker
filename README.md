
# Task Tracker CLI

Sample solution for the [Task Tracker](https://roadmap.sh/projects/task-tracker) on [roadmap.sh](https://roadmap.sh).
A simple **Command Line Interface (CLI)** application to manage tasks. This project helps users **track, update, and manage tasks** in a simple, efficient way by storing them in a **JSON file**.

---

## Features

- **Add tasks**: Create a new task with a unique ID.
- **Update tasks**: Change the status of a task (Pending, In Progress, Done).
- **Delete tasks**: Remove a task from the list.
- **List tasks**: Display all tasks, tasks in progress, done tasks, or tasks not done.
- **Task Statuses**: Tasks can have one of three statuses:
  - **Pending**: Task is not started.
  - **In Progress**: Task is being worked on.
  - **Done**: Task is completed.

---

## Requirements

- **Java 8+** (or any other language you're using)
- **JSON file** for storing tasks.
- **Command Line Interface (CLI)** to interact with the program.

---

## Setup

1. **Clone the repository** or create a new directory and add the project files.
2. If using **Java**, ensure you have the Java SDK installed.
3. Add the **Gson** library for JSON handling.
    - For Maven:
        ```xml
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.8</version>
        </dependency>
        ```
    - For Gradle:
        ```groovy
        implementation 'com.google.code.gson:gson:2.8.8'
        ```

4. **Compile and run** the project.

---

## Usage

### Available Commands

1. **Add a task**:
    ```
    add <task-name>
    ```
    Example:
    ```
    add "Finish homework"
    ```

2. **Update task status**:
    ```
    update <task-id> <status>
    ```
    Example:
    ```
    update 1 in_progress
    ```

3. **Delete a task**:
    ```
    delete <task-id>
    ```
    Example:
    ```
    delete 1
    ```

4. **List all tasks**:
    ```
    list
    ```


---

## Example

### **Adding tasks**
```
add "Buy groceries"
add "Clean the house"
```

### **Listing all tasks**
```
list
```
Output:
```
1. Buy groceries - Pending
2. Clean the house - Pending
```

### **Updating task status**
```
update 1 done
```

### **Deleting a task**
```
delete 1
```

---

## File Storage

Tasks are stored in a **JSON file** called `tasks.json`. Each task has the following properties:
- **ID**: A unique identifier for the task.
- **Name**: A description of the task.
- **Status**: The current status of the task (Pending, In Progress, Done).

---

## How It Works

1. **Task IDs** are generated using an **incrementing counter** that ensures unique IDs.
2. The task list is saved in the `tasks.json` file, and it is loaded whenever the program runs.
3. The user can interact with the program via commands in the terminal, such as adding, updating, or deleting tasks.

---

## Contributing

1. Fork this repository.
2. Clone your fork locally.
3. Create a new branch for your changes.
4. Commit your changes.
5. Push to your fork and create a pull request.

---
