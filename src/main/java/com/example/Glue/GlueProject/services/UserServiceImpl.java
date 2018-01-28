package com.example.Glue.GlueProject.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Glue.GlueProject.model.*;

import com.example.Glue.GlueProject.repository.RoleRepository;
import com.example.Glue.GlueProject.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository,
						   RoleRepository roleRepository,
						   BCryptPasswordEncoder bCryptPasswordEncoder){
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}