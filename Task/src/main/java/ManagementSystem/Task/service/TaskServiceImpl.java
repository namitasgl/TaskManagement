package ManagementSystem.Task.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ManagementSystem.Task.entities.Task;
import ManagementSystem.Task.exception.TaskDoesnotExistException;
import ManagementSystem.Task.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	@Autowired
	TaskRepository taskRepository;
	
	 // save operation
    public Task saveTask(Task task) {    	
    	return taskRepository.save(task);
    }
 
    // read operation
    public List<Task> fetchTaskList(){
    	List<Task> tasks = new ArrayList<Task>();
    	taskRepository.findAll().forEach(tasks::add);
    	return tasks;
    	
    }
    
    public Task fetchTaskOnId(Long taskId) {
    	Optional<Task> task = taskRepository.findById(taskId);
    	if(task.isPresent()) {
    		return task.get();
    	}
    	throw new TaskDoesnotExistException("Task :"+taskId + " does not exist");   	
    }
    
  public //fetch operation on task title bases
    List<Task> fetchTaskOnTitle(String title){
	  List<Task> tasks = new ArrayList<Task>();
	  taskRepository.findByTitleContaining(title).forEach(tasks::add);
	  return tasks;
    }
 
    // update operation
    public boolean updateTask(Task task, Long taskId) {
    	Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task taskOldStatus = optionalTask.get();
            taskOldStatus.setTitle(task.getTitle());

            String description = task.getDescription();
            if (description != null)
            	taskOldStatus.setDescription(description);

            taskOldStatus.setCompleted(task.isCompleted());
            taskRepository.save(optionalTask.get());
            return true;
            }
        else {
        	throw new TaskDoesnotExistException(" Task does not exist:" + taskId);
        }
        
    }
    
    public void deleteAll() {
    	 taskRepository.deleteAll();
    }
    
    public List<Task> getByDateAfter(Date date){
    	Iterable<Task> articlesIterable = taskRepository.findByCreatedAtAfter(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    	 List<Task> articleList = new ArrayList<>();
         articlesIterable.forEach(articleList::add);
         return articleList;
    }
    
    
    public  List<Task> getByDateBefore(Date date){
    	 Iterable<Task> articlesIterable = taskRepository.findByCreatedAtBefore(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
         List<Task> articleList = new ArrayList<>();
         articlesIterable.forEach(articleList::add);
         return articleList;
    }

 
    // delete operation
    public void deletTasktById(Long taskId) {
    	 Optional<Task> task = taskRepository.findById(taskId);
         if (task.isPresent()) {
        	 taskRepository.delete(task.get());
        	 
         } 
         else
        	 throw new TaskDoesnotExistException("Not able to delete task :"+taskId);
    	
    }
    
    //fetch operation on task completion bases
    public List<Task> fetchTaskOnStatus(boolean isCompleted){
    	return taskRepository.findByCompleted(true);
    }

}
