package com.example.androidwebapp.domain.usecases.post;

import android.app.Activity;

import com.example.androidwebapp.data.repositories.post.PostRepository;

import java.util.function.Consumer;

public class PostUsecases {
    PostRepository postRepository;

    public PostUsecases(Activity activity) {
        this.postRepository = new PostRepository(activity);
    }

    public void getPosts(Consumer<String> callback) {
        this.postRepository.getPosts(callback);
    }
}
