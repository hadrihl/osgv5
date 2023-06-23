package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private TestEntityManager entityManager;
	
	@Test
	public void testcreateAdmin() {
		
		// create admin user object
		User admin = new User();
		admin.setUsername("admin");
		admin.setEmail("admin@example.com");
		admin.setPassword("password");
		
		// save admin user into database
		User savedAdmin = userRepository.save(admin);
		
		// retrieve admin user from database
		//User existedAdmin = userRepository.findById(1).get();
		//User existedAdmin = entityManager.find(User.class, savedAdmin.getEmail());
		User existedAdmin = userRepository.findUserByEmail("admin@example.com");
		
		// test & validate
		assertThat(existedAdmin.getUsername()).isEqualTo(savedAdmin.getUsername());
	}
	
	@Test
	public void testAssignRoletoAdmin() {
		User admin = userRepository.findUserByUsername("admin");
		
		// assign role (VIEW_STORE; ADD_STORE) to admin user
		admin.addRoles(roleRepository.findById(1).get()); // assign VIEW_STORE
		admin.addRoles(roleRepository.findById(2).get()); // assign EDIT_STORE
		
		// test & validate
		assertThat(admin.getRoles().size()).isEqualTo(2);
	}
	
	@Test
	public void testCreateUser() {
		// create user object
		User user = new User();
		user.setUsername("user");
		user.setEmail("user@example.com");
		user.setPassword("password");
		
		// assign role (VIEW_STORE)
		user.addRoles(roleRepository.findById(1).get());
		userRepository.save(user);
		
		// pretrieve user 
		User existedUser = userRepository.findUserByEmail("user@example.com");
		
		// test & validation
		assertThat(existedUser.getEmail()).isEqualTo(user.getEmail());
	}
}
