package ManagementSystem.Task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ManagementSystem.Task.entities.AppUser;
import ManagementSystem.Task.repositories.UserRepository;

@Service(value = "userService")
public class UserService implements UserDetailsService{

	@Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<AppUser> userDetails = repository.findByName(username);
		if (!userDetails.isPresent()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
		 return new AppUser(userDetails.get().getUsername(), userDetails.get().getPassword());
                
		
	}

	/*
	 * private List<SimpleGrantedAuthority> getAuthority() { return
	 * Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")); }
	 */
	    public List<AppUser> findAll() {
	        List<AppUser> list = new ArrayList<>();
	       repository.findAll().iterator().forEachRemaining(list::add);
	        return list;
	    }
	
	
	public String createUser(String userName, String password) {
		 AppUser user = new AppUser(userName, encoder.encode(password));
	         repository.save(user);
        return "User Added Successfully";
    }
	
	 @Autowired
	    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
	        this.encoder = passwordEncoder;
	    }
	 
	public long count() {
        return repository.count();
    }
	
	public Optional<AppUser> findByUsername(String username) {
        return repository.findByName(username);
    }

}
