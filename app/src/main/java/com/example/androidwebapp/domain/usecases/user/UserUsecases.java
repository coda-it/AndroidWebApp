package com.example.androidwebapp.domain.usecases.user;

import android.app.Activity;

import com.example.androidwebapp.data.repositories.user.UserRepository;

public class UserUsecases {
    UserRepository userRepository;

    public UserUsecases(Activity activity) {
        this.userRepository = new UserRepository(activity);
    }

    public void login(String login, String password) {
        this.userRepository.login(login, password);
    }
}
