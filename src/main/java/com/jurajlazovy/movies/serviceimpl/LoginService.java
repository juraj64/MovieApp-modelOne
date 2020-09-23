package com.jurajlazovy.movies.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validatePassword(String password) {
        String pattern = "123456";  // heslo pre vstup do apky

        return password.matches(pattern);
    }
}
