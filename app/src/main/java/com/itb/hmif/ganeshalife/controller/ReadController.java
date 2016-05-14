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
import com.itb.hmif.ganeshalife.model.Post;

import java.util.Date;
import java.util.Map;

/**
 * Created by Yanfa on 3/14/2016.
 */
public class ReadController {

    public ReadController() {
    }

    public void getPostPerCategory(Activity activity, final String userId, final int kategori, final int offset, final int limit, final OnVolleyCallback onVolleyCallback){
        Log.d("getPostPerCategory", "userId : " + userId);
        Log.d("getPostPerCategory", "userId : " + kategori);
        Log.d("getPostPerCategory", "offset : " + offset);
        Log.d("getPostPerCategory", "limit : " + limit);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/post.json";
        Log.d("getPostPerCategory", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getPostPerCategory", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getPostPerCategory", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getPostPerCategory", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"kategori\":\"" + kategori + "\"" +
                        ",\"offset\":\"" + offset + "\"" +
                        ",\"limit\":\"" + limit + "\"}";
                Log.d("getPostPerCategory", "body : " + sendBody);

                byte[] sendByte = sendBody.getBytes();
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

    public void setBookmark(Activity activity, final String userId, final String postId, final OnVolleyCallback onVolleyCallback){
        Log.d("setbookmark", "userId : " + userId);
        Log.d("setbookmark", "postId : " + postId);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/setbookmark.json";
        Log.d("setbookmark", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("setbookmark", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("setbookmark", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("setbookmark", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"postId\":\"" + postId + "\"}";
                Log.d("setbookmark", "body : " + sendBody);

                byte[] sendByte = sendBody.getBytes();
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

    public void setRating(Activity activity, final String userId, final String postId, final int rating, final String description, final OnVolleyCallback onVolleyCallback){
        Log.d("setrating", "userId : " + userId);
        Log.d("setrating", "postId : " + postId);
        Log.d("setrating", "rating : " + rating);
        Log.d("setrating", "description : " + description);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/rating.json";
        Log.d("setrating", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("setrating", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("setrating", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("setrating", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"postId\":\"" + postId + "\"" +
                        ",\"rating\":\"" + rating + "\"" +
                        ",\"description\":\"" + description + "\"}";
                Log.d("setrating", "body : " + sendBody);

                byte[] sendByte = sendBody.getBytes();
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

    public void searchAllPost(Activity activity, final String userId, final String searchQuery, final int offset, final int limit, final OnVolleyCallback onVolleyCallback){
        Log.d("searchallpost", "userId : " + userId);
        Log.d("searchallpost", "offset : " + offset);
        Log.d("searchallpost", "limit : " + limit);
        Log.d("searchallpost", "searchQuery : " + searchQuery);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/searchpost.json";
        Log.d("searchallpost", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("searchallpost", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("searchallpost", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("searchallpost", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"searchQuery\":\"" + searchQuery + "\"" +
                        ",\"offset\":\"" + offset + "\"" +
                        ",\"limit\":\"" + limit + "\"}";
                Log.d("searchallpost", "body : " + sendBody);

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

    public void getMyBookmarkPost(Activity activity, final String userId, final int kategori, final int offset, final int limit, final OnVolleyCallback onVolleyCallback){
        Log.d("getmybookmarkpost", "userId : " + userId);
        Log.d("getmybookmarkpost", "userId : " + kategori);
        Log.d("getmybookmarkpost", "offset : " + offset);
        Log.d("getmybookmarkpost", "limit : " + limit);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/bookmark.json";
        Log.d("getmybookmarkpost", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getmybookmarkpost", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getmybookmarkpost", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getmybookmarkpost", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId + "\"}";
                Log.d("getmybookmarkpost", "body : " + sendBody);

                byte[] sendByte = sendBody.getBytes();
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

    public void searchMyBookmarkPost(Activity activity, final String userId, final String searchQuery, final int offset, final int limit, final OnVolleyCallback onVolleyCallback){
        Log.d("searchbookmark", "userId : " + userId);
        Log.d("searchbookmark", "offset : " + offset);
        Log.d("searchbookmark", "limit : " + limit);
        Log.d("searchbookmark", "searchQuery : " + searchQuery);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/searchbookmark.json";
        Log.d("searchbookmark", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("searchbookmark", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("searchbookmark", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("searchbookmark", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"searchQuery\":\"" + searchQuery + "\"" +
                        ",\"offset\":\"" + offset + "\"" +
                        ",\"limit\":\"" + limit + "\"}";
                Log.d("searchbookmark", "body : " + sendBody);

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
}
