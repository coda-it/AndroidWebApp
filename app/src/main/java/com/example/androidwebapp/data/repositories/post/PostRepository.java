package com.example.androidwebapp.data.repositories.post;

import java.util.ArrayList;
import java.util.function.Consumer;

import android.app.Activity;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.androidwebapp.data.services.api.Api;
import com.example.androidwebapp.domain.models.post.PostModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostRepository {
    Api api;

    public PostRepository(Activity activity) {
        this.api = new Api(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getPosts(Consumer<ArrayList<PostModel>> callback) {
        this.api.get("/post", (String value) -> {
            try {
                JSONObject jsonObject = new JSONObject(value);
                JSONArray jsonPosts = jsonObject.getJSONObject("_embedded").getJSONArray("posts");
                ArrayList<PostModel> posts = new ArrayList<PostModel>();

                for (int i = 0; i < jsonPosts.length(); i++) {
                    PostModel post = new PostModel();
                    JSONObject jsonPost = jsonPosts.getJSONObject(i);
                    post.id = jsonPost.getString("id");
                    post.userId = jsonPost.getString("userId");
                    post.categoryId = jsonPost.getString("categoryId");
                    post.title = jsonPost.getString("title");
                    post.description = jsonPost.getString("description");
                    post.image = jsonPost.getString("image");

                    posts.add(post);
                }

                callback.accept(posts);
            } catch (JSONException e) {
                Log.i("post-repository", e.toString());
            }
        });
    }
}
