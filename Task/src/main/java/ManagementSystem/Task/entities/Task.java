package ManagementSystem.Task.entities;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "task")
public class Task extends TimestampedEntity{
	
	private String title;

    
    private String description;


    private boolean completed;
    
    
    

    public Task() {
		super();
	}
    
    public Task(String title, String description) {
        this(title, description, false);
    }
    public Task(Long id, String title, boolean completed, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

	public Task(String title, String description, boolean completed) {
	
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	
	

	public Long getId() {
        return id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [title=" + title + ", description=" + description + ", completed=" + completed + ", id=" + id
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    

}
