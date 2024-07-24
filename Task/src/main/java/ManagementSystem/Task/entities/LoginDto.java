package ManagementSystem.Task.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDto {
	@NotBlank
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank
    @Size(min = 3, max = 40)
    private String password;

    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
