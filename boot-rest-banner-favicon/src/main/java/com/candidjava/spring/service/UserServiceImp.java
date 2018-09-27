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
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
		
	}

	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		Optional<User> usr = findById(id);
		User newuser=usr.get();
		newuser.setCountry(user.getCountry());
		return userRepository.save(newuser);
	}



}
