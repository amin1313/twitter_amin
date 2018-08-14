package com.example.amin.twiter_amin;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class Login
{
    Context context;


    public Login(Context context)
    {
        this.context=context;
    }


    public void get_lock(final String username, final String password, final reult_callback send_lock)
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, s_params.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        send_lock.send_lock(response);
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                send_lock.send_lock(error.toString());
            }
        })

        {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> MyData = new HashMap<>();
                MyData.put("username", username); //Add the data you'd like to send to the server.
                MyData.put("password", password); //Add the data you'd like to send to the server.
                return MyData;
            }
        };
        newRequestQueue(context).add(stringRequest);

    }

    public interface reult_callback
    {
        void send_lock(String lock);
    }





}
