package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(true)
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository roleRepository;
	
	@Test // Unit test for RoleRepository
	public void testCreateRoles() {
		// create the roles object
		Role viewStore = new Role("VIEW_STORE");
		Role addStore = new Role("ADD_STORE");
		
		// save the roles object, then store in database
		roleRepository.save(viewStore);
		roleRepository.save(addStore);
		
		// retrieve the roles object
		List<Role> roles = roleRepository.findAll();
		
		// test & validate
		assertThat(roles.size()).isEqualTo(2);
	}
}
