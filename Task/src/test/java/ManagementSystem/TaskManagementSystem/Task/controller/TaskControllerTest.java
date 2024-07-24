package ManagementSystem.TaskManagementSystem.Task.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ManagementSystem.Task.controller.TaskController;
import ManagementSystem.Task.entities.Task;
import ManagementSystem.Task.service.TaskService;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

	@Mock
	TaskService taskService;

	@InjectMocks
	TaskController taskController;

	@Test
	public void getAllTask() {

		Task task1 = new Task("TOdo", "Task 1", false);
		Task task2 = new Task("TOdo2", "Task 2", false);
		List<Task> listOfTask = new ArrayList<>();
		listOfTask.add(task1);
		listOfTask.add(task2);
		Mockito.when(taskService.fetchTaskOnTitle(Mockito.anyString())).thenReturn(listOfTask);
		ResponseEntity<List<Task>> actualListOfTask = taskController.getAllTutorials(Mockito.anyString());
		Assert.assertEquals(actualListOfTask.getBody().size(), 2);
		Assert.assertNotNull(actualListOfTask);

	}

	@Test
	public void getEmptyTAsk() {
		List<Task> listOfTask = new ArrayList<>();
		Mockito.when(taskService.fetchTaskOnTitle(Mockito.anyString())).thenReturn(listOfTask);
		ResponseEntity<List<Task>> actualListOfTask = taskController.getAllTutorials(Mockito.anyString());
		Assert.assertEquals(actualListOfTask.getStatusCode(), HttpStatus.NO_CONTENT);

	}

	@Test
	public void exceptionWhenFetchTask() {
		Mockito.when(taskService.fetchTaskOnTitle(Mockito.anyString())).thenThrow(new RuntimeException());
		ResponseEntity<List<Task>> actualListOfTask = taskController.getAllTutorials(Mockito.anyString());
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actualListOfTask.getStatusCode());
	}
}
