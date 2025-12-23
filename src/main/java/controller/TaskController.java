package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dto.Task;
import io.swagger.v3.oas.annotations.Operation;
import service.TaskService;
import util.ResponseStructure;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Operation(summary = "Create Task", description = "Manager creates a new task")
    @PostMapping("/create")
    public ResponseStructure<Task> createTask(@RequestBody Task task, @RequestParam String currentRole) {
        return taskService.createTask(task, currentRole).getBody();
    }

    @Operation(summary = "Assign Task", description = "Admin or Manager assigns a task to a user")
    @PutMapping("/{taskId}/assign/{userId}")
    public Task assignTask(@PathVariable int taskId, @PathVariable int userId, @RequestParam String currentRole) {
        return taskService.assignTask(taskId, userId, currentRole);
    }

    @Operation(summary = "Update Task", description = "Manager or User updates task details/status")
    @PutMapping("/{taskId}/update")
    public ResponseStructure<Task> updateTask(@PathVariable int taskId, @RequestBody Task task,
            @RequestParam String currentRole) {
        return taskService.updateTask(taskId, task, currentRole).getBody();
    }

    @Operation(summary = "Fetch User Tasks", description = "Fetch all tasks assigned to a user")
    @GetMapping("/user/{userId}")
    public List<Task> fetchTasksByUser(@PathVariable int userId) {
        return taskService.fetchTasksByUser(userId);
    }

    @Operation(summary = "Fetch All Tasks", description = "Fetch all tasks")
    @GetMapping("/all")
    public List<Task> fetchAllTasks() {
        return taskService.fetchAllTasks();
    }
}
