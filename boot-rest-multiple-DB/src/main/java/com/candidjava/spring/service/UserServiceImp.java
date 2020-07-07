package com.candidjava.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

	public List<User> getUser() {
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(long id) {
		return userRepository.findById(id);

	}

	public User update(User user, long l) {
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

	public User updatePartially(User user, long id) {
		Optional<User> usr = findById(id);
		User newuser = usr.get();
		newuser.setCountry(user.getCountry());
		return userRepository.save(newuser);
	}

}
