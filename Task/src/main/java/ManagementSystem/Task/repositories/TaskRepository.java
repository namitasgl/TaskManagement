package ManagementSystem.Task.repositories;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ManagementSystem.Task.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	@Query("select new Task(t.id, t.title, t.completed, t.createdAt, t.updatedAt) from Task t where t.completed = :completed")
	List<Task> findByCompleted( @Param("completed") boolean completed);

	@Query("select new Task(t.id, t.title, t.completed, t.createdAt, t.updatedAt) from Task t where t.title = :title")
      List<Task> findByTitleContaining(@Param("title") String title);
	  
	  List<Task> findByCreatedAtAfter(LocalDateTime date);

	    List<Task> findByCreatedAtBefore(LocalDateTime date);

}
