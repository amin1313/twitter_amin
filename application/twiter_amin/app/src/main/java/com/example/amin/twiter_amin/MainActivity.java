package com.example.amin.twiter_amin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView txtv_twitter_amin;
    TextView txt_toolbar;
    static String lock_true="TRUE";
    TextView txt_view;
    EditText et_username;
    EditText et_password;
    Login login=new Login(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cast();

    }

    public void cast()
    {
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/twitter_amin.ttf");
        txt_view = findViewById(R.id.txtv);
        et_username=findViewById(R.id.et_username_MainActivity);
        et_password=findViewById(R.id.et_password_MainActivity);
        txtv_twitter_amin=findViewById(R.id.txtv_twitter_amin);
        txt_toolbar=findViewById(R.id.txt_toolbar);
        txt_toolbar.setTypeface(typeface);
        txtv_twitter_amin.setTypeface(typeface);
    }
    public void on_login(View view)
    {
        if(et_username.getText().toString().trim().length()>0&&et_password.getText().toString().trim().length()>0)
        {
            login.get_lock(et_username.getText().toString(), et_password.getText().toString(), new Login.reult_callback() {
                @Override
                public void send_lock(String lock)
                {
                    if(lock_true.equalsIgnoreCase(lock))
                    {
                       // Intent intent=new Intent(MainActivity.this,set_post_activity.class);
                        //intent.putExtra("username",et_username.getText().toString());
                        //startActivity(intent);
                        Intent intent=new Intent(MainActivity.this,post_show_list.class);
                        intent.putExtra("username",et_username.getText().toString());
                        intent.putExtra("password",et_username.getText().toString());
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "username OR password incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(this, "username or password is empty", Toast.LENGTH_SHORT).show();
        }
    }
    public void on_signup(View view)
    {
        Intent intent=new Intent(MainActivity.this,Register_Activity.class);
        startActivity(intent);
    }





}
