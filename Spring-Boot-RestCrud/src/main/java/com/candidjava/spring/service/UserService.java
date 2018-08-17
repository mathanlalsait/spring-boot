package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getUser();
	public User findById(int id);
	public void update(User user);
	public void deleteUserById(int id);
	public void updatePartially(User user, int id);
}
