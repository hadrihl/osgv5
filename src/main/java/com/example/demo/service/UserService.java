package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
	private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    // save new user
	public User saveNewUser(User user) {
		return userRepository.save(user);
	}

}
