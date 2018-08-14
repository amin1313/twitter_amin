package com.example.amin.twiter_amin;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class web_api_get_post
{
    Context context;

    public web_api_get_post(Context context)
    {
        this.context=context;
    }

    public void get_post(final reult_callback reult)
    {
        JsonObjectRequest jsonObject=new JsonObjectRequest(Request.Method.POST, s_params.URL_GET_PSOT,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try {

                    List<POSTS> postsList=new ArrayList<>();
                    JSONArray jsonArray=response.getJSONArray("post");

                    for (int i = 0; i <jsonArray.length() ; i++)
                    {
                        POSTS posts=new POSTS();
                        JSONObject jobj=new JSONObject();
                        jobj=jsonArray.getJSONObject(i);
                        posts.setPost(jobj.getString("post"));
                        posts.setAuthor(jobj.getString("author"));
                        postsList.add(posts);
                    }

                    reult.send_lock(postsList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            },
            new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });





        newRequestQueue(context).add(jsonObject);
    }

    public interface reult_callback
    {
        void send_lock(List<POSTS> posts);
    }




}
