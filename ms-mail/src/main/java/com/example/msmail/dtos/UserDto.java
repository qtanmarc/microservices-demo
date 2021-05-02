package com.example.msmail.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author taq
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String password;
}
