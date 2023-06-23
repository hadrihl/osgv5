package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
	private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    // save new user
	public User saveNewUser(User user) {
		
		// encrypt the password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// assign default role: VIEW_STORE
		user.addRoles(roleRepository.findById(1).get());
		
		return userRepository.save(user);
	}

}
