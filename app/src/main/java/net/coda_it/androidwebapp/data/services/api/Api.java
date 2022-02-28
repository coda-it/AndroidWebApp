package net.coda_it.androidwebapp.data.services.api;

import org.json.JSONObject;
import org.json.JSONException;

import net.coda_it.androidwebapp.R;

import android.os.Build;
import android.util.Log;

import android.app.Activity;

import androidx.annotation.RequiresApi;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;

import java.nio.charset.StandardCharsets;

import java.util.function.Consumer;

public class Api {
    Activity activity;

    public Api(Activity activity) {
        this.activity = activity;
    }

    public void get(String endpoint, Consumer<String> callback) {
        JSONObject jsonBody = new JSONObject();

        final String requestBody = jsonBody.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, this.activity.getString(R.string.endpoint) + endpoint,
                new Response.Listener<String>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.accept(response);
                        } catch (Error e) {
                            Log.i("api-service", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("api-service", error.toString());
                    }
                }
        ) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this.activity);
        requestQueue.add(stringRequest);
    }

    public void post(String login, String password) {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("login", login);
            jsonBody.put("password", password);
            final String requestBody = jsonBody.toString();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, this.activity.getString(R.string.endpoint) + "/login",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                            } catch (JSONException e) {
                                Log.i("api-service", e.toString());
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("api-service", error.toString());
                        }
                    }
            ) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    return requestBody == null ? null : requestBody.getBytes(StandardCharsets.UTF_8);
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this.activity);
            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            Log.i("api-service", e.toString());
        }
    }
}
