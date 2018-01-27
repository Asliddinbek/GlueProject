package com.example.Glue.GlueProject.services;

import com.example.Glue.GlueProject.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
