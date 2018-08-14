package com.example.amin.twiter_amin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class post_show_list extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;
    String user_name;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_show_list);

        textView=findViewById(R.id.txtv);
        recyclerView=findViewById(R.id.rv_activty_post_show);

        Bundle extras = getIntent().getExtras();
        user_name=extras.getString("username");
        password=extras.getString("password");

        get_posts();

    }

    public void get_posts()
    {
        web_api_get_post get_post=new web_api_get_post(post_show_list.this);
        get_post.get_post(new web_api_get_post.reult_callback() {
            @Override
            public void send_lock(List<POSTS> posts)
            {
                setRecyclerView(posts);

            }
        });
    }



    public void setRecyclerView(List<POSTS> postsList)
    {

        recyclerView.setLayoutManager(new LinearLayoutManager(post_show_list.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        Post_Adapter post_adapter = new Post_Adapter(post_show_list.this, postsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(post_show_list.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        post_adapter.notifyDataSetChanged();
        recyclerView.setAdapter(post_adapter);

    }

    public void on_add(View view)
    {
         Intent intent=new Intent(post_show_list.this,set_post_activity.class);
        intent.putExtra("username",user_name);
        startActivity(intent);
    }





}
