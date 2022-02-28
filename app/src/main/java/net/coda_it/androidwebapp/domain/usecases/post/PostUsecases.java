package net.coda_it.androidwebapp.domain.usecases.post;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import net.coda_it.androidwebapp.data.repositories.post.PostRepository;

import java.util.function.Consumer;
import java.util.ArrayList;

import net.coda_it.androidwebapp.domain.models.post.PostModel;

public class PostUsecases {
    PostRepository postRepository;

    public PostUsecases(Activity activity) {
        this.postRepository = new PostRepository(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getPosts(Consumer<ArrayList<PostModel>> callback) {
        this.postRepository.getPosts(callback);
    }
}
