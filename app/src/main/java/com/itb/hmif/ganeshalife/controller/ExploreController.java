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
import com.itb.hmif.ganeshalife.model.Publisher;

import java.util.Date;
import java.util.Map;

/**
 * Created by Yanfa on 3/14/2016.
 */
public class ExploreController {

    public ExploreController() {
    }

    public void getMyLibrary(Activity activity, final String userId, final int type, final OnVolleyCallback onVolleyCallback){
        Log.d("getmylibrary", "userId : " + userId);
        Log.d("getmylibrary", "type : " + type);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/library.json";
        Log.d("getmylibrary", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getmylibrary", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getmylibrary", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getmylibrary", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        ",\"type\":\"" + type + "\"}";
                Log.d("getmylibrary", "body : " + sendBody);

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

    public void searchMyLibrary(Activity activity, final String userId, final String searchQuery, final OnVolleyCallback onVolleyCallback){
        Log.d("searchlibrary", "userId : " + userId);
        Log.d("searchlibrary", "searchQuery : " + searchQuery);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/searchlibrary.json";
        Log.d("searchlibrary", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("searchlibrary", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("searchlibrary", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("searchlibrary", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        ",\"searchQuery\":\"" + searchQuery + "\"}";
                Log.d("searchlibrary", "body : " + sendBody);

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

    public void getAvailablePublisher(Activity activity, final OnVolleyCallback onVolleyCallback){
        Log.d("getavailablepub", "getting list of available publisher");

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/explorekategori.json";
        Log.d("getavailablepub", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getavailablepub", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getavailablepub", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getavailablepub", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }
        };

        postRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1f));

        queue.add(postRequest);
    }

    public void setFollow(Activity activity, final String userId, final String publisherId, final OnVolleyCallback onVolleyCallback){
        Log.d("setfollow", "userId : " + userId);
        Log.d("setfollow", "publisherId : " + publisherId);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/setfollow.json";
        Log.d("setfollow", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("setfollow", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("setfollow", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("setfollow", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"publisherId\":\"" + publisherId + "\"" +
                        ",\"follow\":\"true\"}";
                Log.d("setfollow", "body : " + sendBody);

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

    public void setUnfollow(Activity activity, final String userId, final String publisherId, final OnVolleyCallback onVolleyCallback){
        Log.d("setunfollow", "userId : " + userId);
        Log.d("setunfollow", "publisherId : " + publisherId);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/setfollow.json";
        Log.d("setunfollow", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("setunfollow", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("setunfollow", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("setunfollow", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"userId\":\"" + userId +
                        "\",\"publisherId\":\"" + publisherId + "\"" +
                        ",\"follow\":\"false\"}";
                Log.d("setunfollow", "body : " + sendBody);

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

    public void getPostFromPublisher(Activity activity, final String publisherId, final int kategori, final int offset, final int limit, final OnVolleyCallback onVolleyCallback){
        Log.d("getPostPublisher", "publisherId : " + publisherId);
        Log.d("getPostPublisher", "kategori : " + kategori);
        Log.d("getPostPublisher", "offset : " + offset);
        Log.d("getPostPublisher", "limit : " + limit);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/postpubtop.json";
        Log.d("getPostPublisher", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getPostPublisher", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getPostPublisher", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getPostPublisher", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                String sendBody = "{\"publisherId\":\"" + publisherId +
                        "\",\"kategori\":\"" + kategori + "\"" +
                        ",\"offset\":\"" + offset + "\"" +
                        ",\"limit\":\"" + limit + "\"}";
                Log.d("getPostPublisher", "body : " + sendBody);

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

    public void getPublisherDetail(Activity activity, final String publisherId, final OnVolleyCallback onVolleyCallback){
        Log.d("getpublisherdetail", "publisherId : " + publisherId);

        RequestQueue queue = Volley.newRequestQueue(activity);
        String url = activity.getString(R.string.web_address) + "/publisher.json?publisherId=" + publisherId;
        Log.d("getpublisherdetail", "url : " + url);
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) { // if the request succed
                        Log.d("getpublisherdetail", "response : " + response);
                        onVolleyCallback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getpublisherdetail", "response error : " + error);
                        onVolleyCallback.onError(error.toString());
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> mHeaders = new ArrayMap<>();
                mHeaders.put("Auth-Token", MainController.AUTH_TOKEN);
                Log.d("getpublisherdetail", "token : " + MainController.AUTH_TOKEN);
                return mHeaders;
            }
        };

        postRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1f));

        queue.add(postRequest);
    }
}
