package service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dao.TaskDao;
import dto.Task;
import exception.TaskNotFound;
import exception.UnauthorizedException;
import util.ResponseStructure;



@Service
public class TaskService {

    @Autowired
    TaskDao taskDao;

    @Autowired
    ResponseStructure<Task> responseStructure;

 
    public ResponseEntity<ResponseStructure<Task>> createTask(Task task, String currentRole) {
        if (!currentRole.equals("MANAGER")) {
            throw new UnauthorizedException("Only Manager can create tasks");
        }
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Task created successfully");
        responseStructure.setData(taskDao.saveTask(task));
        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }

    
    public Task assignTask(int taskId, int userId, String currentRole) {
        if (!(currentRole.equals("ADMIN") || currentRole.equals("MANAGER"))) {
            throw new UnauthorizedException("Only Admin or Manager can assign tasks");
        }
        return taskDao.assignTaskToUser(taskId, userId);
    }

   
    public ResponseEntity<ResponseStructure<Task>> updateTask(int taskId, Task newTask, String currentRole) {
        if (!(currentRole.equals("MANAGER") || currentRole.equals("USER"))) {
            throw new UnauthorizedException("Unauthorized to update task");
        }
        Task task = taskDao.fetchTaskById(taskId);
        if (task != null) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("Task updated successfully");
            responseStructure.setData(taskDao.updateTaskById(taskId, newTask));
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            throw new TaskNotFound();
        }
    }

    
    public List<Task> fetchTasksByUser(int userId) {
        return taskDao.fetchTasksByUserId(userId);
    }

  
    public List<Task> fetchAllTasks() {
        return taskDao.fetchAllTasks();
    }

}

