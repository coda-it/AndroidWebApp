package net.coda_it.androidwebapp.data.repositories.user;

import android.app.Activity;

import net.coda_it.androidwebapp.data.services.api.Api;

public class UserRepository {
    Api api;

    public UserRepository(Activity activity) {
        this.api = new Api(activity);
    }

    public void login(String login, String password) {
        this.api.post(login, password);
    }
}
