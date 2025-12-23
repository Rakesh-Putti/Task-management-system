package dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.Task;
import dto.User;
import repo.TaskRepo;


@Repository
public class TaskDao {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserDao userDao;

  
    public Task saveTask(Task task) {
        return taskRepo.save(task);
    }

   
    public Task assignTaskToUser(int taskId, int userId) {
        Task task = fetchTaskById(taskId);
        User user = userDao.fetchUserById(userId);
        List<Task> userTasks = user.getTasks();
        userTasks.add(task);
        user.setTasks(userTasks);
        userDao.saveUser(user);
        return task;
    }

   
    public Task fetchTaskById(int taskId) {
        return taskRepo.findById(taskId).get();
    }

  
    public Task updateTaskById(int taskId, Task newTask) {
        newTask.setTaskId(taskId);
        return taskRepo.save(newTask);
    }

    
    public List<Task> fetchAllTasks() {
        return taskRepo.findAll();
    }


    public List<Task> fetchTasksByUserId(int userId) {
        User user = userDao.fetchUserById(userId);
        return user.getTasks();
    }

}
