package com.itb.hmif.ganeshalife.controller;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.fragment.LoadingFragment;
import com.itb.hmif.ganeshalife.model.User;

import java.util.Map;

/**
 * Created by Yanfa on 3/10/2016.
 */
public class MainController {

    public static String AUTH_TOKEN = "";
    public static User CURRENT_USER;

    public MainController() {
    }

    public void login(Activity activity, final String username, final String password, final OnVolleyCallback onVolleyCallback){
        Log.d("login", "username : " + username);
        Log.d("login", "password : " + password);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/login.json";
        Log.d("login", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("login", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("login", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"username\":\"" + username +
                        "\",\"password\":\"" + password + "\"}";
                Log.d("login", "body : " + sendBody);

                byte[] sendByte = sendBody.getBytes();

//                byte[] sendByte = new byte[0];
//                try {
//                    sendByte = sendBody.getBytes("utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
                return  sendByte;
            }
            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        postRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1f));

        queue.add(postRequest);
    }

    public void changePassword(AppCompatActivity activity, final String username, final String oldPassword, final String newPassword){
        final FragmentManager fm = activity.getSupportFragmentManager();
        User user = new User("USER1234", "box.xod", "Anta Sula",100);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);
    }

    public void forgotPassword(AppCompatActivity activity, final String email){

    }

    public void signUp(AppCompatActivity activity, User user){

    }
}
