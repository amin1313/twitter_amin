package com.example.amin.twiter_amin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class set_post_activity extends AppCompatActivity {

    static String author;
    static String lock_true="TRUE";
    Post post=new Post(set_post_activity.this);
    EditText et_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_post_activity);

        cast();
        Bundle extras = getIntent().getExtras();
        author=extras.getString("username");

        
    }
    public void cast()
    {
        et_post=findViewById(R.id.et_post_set_post_activity);
    }
    public void on_post(View view)
    {
        post.set_post(et_post.getText().toString(), author, new Login.reult_callback() {
            @Override
            public void send_lock(String lock)
            {
                if(lock_true.equalsIgnoreCase(lock))
                {
                    et_post.setText("");
                    Toast.makeText(set_post_activity.this, "POST", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(set_post_activity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
