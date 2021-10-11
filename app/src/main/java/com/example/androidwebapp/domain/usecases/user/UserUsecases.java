package com.example.androidwebapp.domain.usecases.user;

import android.app.Activity;
import android.util.Log;

import com.example.androidwebapp.data.repositories.user.UserRepository;

public class UserUsecases {
    UserRepository userRepository;

    public UserUsecases(Activity activity) {
        this.userRepository = new UserRepository(activity);
    }

    public void login(String login, String password) {
        Log.d("xxx", "xxx:b");
        this.userRepository.login(login, password);
    }
}
