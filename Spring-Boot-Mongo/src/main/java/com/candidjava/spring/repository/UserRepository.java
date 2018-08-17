package com.candidjava.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.candidjava.spring.bean.User;
public interface UserRepository extends MongoRepository<User, String>{

}
