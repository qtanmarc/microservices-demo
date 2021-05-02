package com.example.msmail.services;

import com.example.msmail.dtos.UserDto;

/**
 * @author taq
 */
public interface IEmailService {

    void sendMessage(UserDto input);
}
