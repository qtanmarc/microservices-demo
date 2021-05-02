package com.example.msmail.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.msmail.entities.Mail;

/**
 * @author taq
 */
public interface IMailRepository extends CrudRepository<Mail, Long> {
}
