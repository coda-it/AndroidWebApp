package com.example.androidwebapp.data.repositories.post;

import java.util.function.Consumer;

import android.app.Activity;

import com.example.androidwebapp.data.services.api.Api;

public class PostRepository {
    Api api;

    public PostRepository(Activity activity) {
        this.api = new Api(activity);
    }

    public void getPosts(Consumer<String> callback) {
        this.api.get("/post", callback);
    }
}

