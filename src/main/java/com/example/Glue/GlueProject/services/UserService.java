package com.example.Glue.GlueProject.services;

import com.example.Glue.GlueProject.model.User;

public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user);
}
