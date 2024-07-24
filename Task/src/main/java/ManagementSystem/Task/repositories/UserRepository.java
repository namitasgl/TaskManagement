package ManagementSystem.Task.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ManagementSystem.Task.entities.AppUser;

public interface UserRepository  extends JpaRepository<AppUser, Long>{

	Optional<AppUser> findByName(String name);
}
