package com.example.msuser.services;

import com.example.msuser.entities.User;

/**
 * @author taq
 */
public interface IUserService {

    User registerUser(User input);
    Iterable<User> findAll();
}
