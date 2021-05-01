package com.example.msuser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.msuser.entities.User;
import com.example.msuser.kafka.producer.Sender;
import com.example.msuser.repository.IUserRepository;

/**
 * @author taq
 */
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final Sender sender;
    @Value("${spring.kafka.topic.userCreated}")
    private String USER_CREATED_TOPIC;

    @Autowired
    UserService(IUserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Override public User registerUser(User input) {
        User createdUser = userRepository.save(input);
        sender.send(USER_CREATED_TOPIC, createdUser);
        return createdUser;
    }

    @Override public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
