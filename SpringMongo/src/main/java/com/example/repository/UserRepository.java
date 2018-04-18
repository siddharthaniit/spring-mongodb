package com.example.repository;


import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;


@Transactional
public interface UserRepository extends MongoRepository<User, UUID> {

}
