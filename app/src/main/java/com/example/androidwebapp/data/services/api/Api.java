package com.example.androidwebapp.data.services.api;

import org.json.JSONObject;
import org.json.JSONException;

import com.example.androidwebapp.R;

import android.util.Log;

import android.app.Activity;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

public class Api {
    Activity activity;

    public Api(Activity activity) {
        this.activity = activity;
    }

    public void post(String login, String password) {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("login", login);
            jsonBody.put("password", password);
            final String requestBody = jsonBody.toString();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, this.activity.getString(R.string.endpoint) + "/api/login",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.i("response", response);
                                JSONObject jsonObject = new JSONObject(response);
                            } catch (JSONException e) {
                                Log.i("api-service", e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            ) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException e) {
                        Log.i("api-service", e.toString());
                        return null;
                    }
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this.activity);
            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            Log.i("api-service", e.toString());
        }
    }
}
