package ManagementSystem.Task.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ManagementSystem.Task.entities.Task;
import ManagementSystem.Task.service.TaskService;


//@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {
	
		
	@Autowired
	TaskService taskService;
	
	
	@GetMapping("/ping")
	public Boolean isAlive() {
		return true;
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTutorials(@RequestParam(required = false) String title) {
		try {
			List<Task> tasks = new ArrayList<Task>();

			if (title == null)
				tasks = taskService.fetchTaskList();
			else
				tasks = taskService.fetchTaskOnTitle(title);

			if (tasks.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> getTutorialById(@PathVariable("id") long id) {
	
			return new ResponseEntity<>(taskService.fetchTaskOnId(id), HttpStatus.OK);
		
	}
	
	

    @GetMapping("/tasks/pending")
    public List<Task> getNotCompletedTodos() {
    	return taskService.fetchTaskOnStatus(false);
    }

    @GetMapping("/tasks/completed")
    public List<Task> getCompletedTodos() {
        return taskService.fetchTaskOnStatus(true);
    }

    @PostMapping("/tasks")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER') and #oauth2.hasScope('write')")
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody Task taskInput) {
    	
    	boolean status = taskService.updateTask(taskInput, id);
    	if(status) {        
            return ResponseEntity.ok(taskInput.getTitle() +": updated");
        } else {
            return new ResponseEntity<>("This task does not exist",HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/tasks/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity delete(@PathVariable("id") Long id) {
    	
    	taskService.deletTasktById(id);
        
            return ResponseEntity.noContent().build();
        
    }

    @DeleteMapping("/tasks")
   @PreAuthorize("hasRole('ROLE_ADMIN') and #oauth2.hasScope('write')")
    public ResponseEntity deleteAll() {
        taskService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/tasks/after/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getByDateAfter(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
      return taskService.getByDateAfter(date);
    }

    @GetMapping(value = "/tasks/before/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getByDateBefore(@PathVariable("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
       return taskService.getByDateBefore(date);
    }

}
