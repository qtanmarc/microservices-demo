package com.example.msuser.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.msuser.entities.User;

/**
 * @author taq
 */
public interface IUserRepository extends CrudRepository<User, Long> {
}
