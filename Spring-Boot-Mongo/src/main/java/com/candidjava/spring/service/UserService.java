package com.candidjava.spring.service;

import java.util.List;
import java.util.Optional;

import com.candidjava.spring.bean.User;

public interface UserService {
	public void createUser(User user);
	public List<User> getUser();
	public Optional<User> findById(String id);
	public User update(User user, String l);
	public void deleteUserById(String id);
	public User updatePartially(User user, String id);
}
