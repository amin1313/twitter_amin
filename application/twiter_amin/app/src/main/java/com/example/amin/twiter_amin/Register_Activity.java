package com.example.amin.twiter_amin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    Register register=new Register(Register_Activity.this);
    String LOCK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        et_username=findViewById(R.id.et_username_Register);
        et_password=findViewById(R.id.et_password_Register);
    }

    public void on_register(View view)
    {
        if(et_username.getText().toString().trim().length()>0&&et_password.getText().toString().trim().length()>0)
        {
            register.set_lock(et_username.getText().toString(), et_password.getText().toString(), new Login.reult_callback() {
                @Override
                public void send_lock(String lock)
                {
                    LOCK=lock;
                }
            });
        }
        else
        {
            Toast.makeText(this, "username or password is empty", Toast.LENGTH_SHORT).show();
        }
            Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Register_Activity.this,MainActivity.class);
            startActivity(intent);
    }

}
