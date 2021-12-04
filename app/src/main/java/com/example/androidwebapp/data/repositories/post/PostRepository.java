package com.example.androidwebapp.data.repositories.post;

import android.app.Activity;

import com.example.androidwebapp.domain.models.post.PostModel;

import com.example.androidwebapp.data.services.api.Api;

import java.util.function.Consumer;

public class PostRepository {
    Api api;

    public PostRepository(Activity activity) {
        this.api = new Api(activity);
    }

    public void getPosts(Consumer<String> callback) {
        this.api.get("/post", callback);
    }
}

