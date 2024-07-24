package ManagementSystem.Task.service;

import java.util.Date;
import java.util.List;

import ManagementSystem.Task.entities.Task;

public interface TaskService {

	 // save operation
    Task saveTask(Task task);
 
    // read operation
    List<Task> fetchTaskList();
 
    // update operation
    boolean updateTask(Task task, Long taskId);
 
    // delete operation
    void deletTasktById(Long taskId);
    
    //fetch operation on task completion bases
    List<Task> fetchTaskOnStatus(boolean isCompleted);
    
  //fetch operation on task title bases
    List<Task> fetchTaskOnTitle(String title);
    
    Task fetchTaskOnId(Long taskId);
    
    void deleteAll();
    
    List<Task> getByDateAfter(Date date);
    
    List<Task> getByDateBefore(Date date);
}
