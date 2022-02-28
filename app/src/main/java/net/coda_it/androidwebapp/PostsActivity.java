package net.coda_it.androidwebapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.os.Build;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.coda_it.androidwebapp.domain.usecases.post.PostUsecases;
import net.coda_it.androidwebapp.domain.usecases.user.UserUsecases;

import net.coda_it.androidwebapp.domain.models.post.PostModel;

public class PostsActivity extends AppCompatActivity {
    UserUsecases userUsecases;
    PostUsecases postUsecases;

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    public PostsActivity() {
        this.userUsecases = new UserUsecases(this);
        this.postUsecases = new PostUsecases(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);

        this.postUsecases.getPosts((ArrayList<PostModel> posts) -> {
            for (int i = 0; i < posts.size(); i++) {
                listItems.add(posts.get(i).title);
            }
            adapter.notifyDataSetChanged();
        });
    }
}