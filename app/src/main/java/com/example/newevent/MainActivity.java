package com.example.newevent;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView event_data_recyclerview, South_recycler;
    String Url = "http://thepartymantra.com/api/home";
    MainAdapter msoutheventadapter;
    RequestQueue requestQueue;
    private ArrayList<ModelEventName> mEventname;
    private ArrayList<ModelImageName> imagelists;
    private ArrayList<ModelBannerName> bannerImages;
    private MainAdapter mainAdapter;

    private ImageDataAdapter imageListAdapter;
    JSONArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        event_data_recyclerview = findViewById(R.id.event_data_recyclerview);
        event_data_recyclerview.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        event_data_recyclerview.setLayoutManager(manager);
        event_data_recyclerview.setHasFixedSize(true);
        requestQueue = Volley.newRequestQueue(this);
        bannerImages = new ArrayList<>();
        mEventname = new ArrayList<>();
        imagelists = new ArrayList<>();
        getdatafromserver();

    }

    private void getdatafromserver() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // JSONObject objMsain=new JSONObject(response);
                try {

                    JSONArray otherArray = response.getJSONArray("others");


                    showDataForSouth(otherArray);


                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                error.printStackTrace();
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void showDataForSouth(JSONArray otherArray) {
        for (int i = 0; i < otherArray.length(); i++) {
            {

                try {
                    JSONObject obj = otherArray.getJSONObject(i);
                    String name = obj.getString("name");
                    String about = obj.getString("about");
                    mEventname.add(new ModelEventName(name, about, imagelists, bannerImages));
                    mainAdapter = new MainAdapter(getApplicationContext(), mEventname);
                    event_data_recyclerview.setAdapter(mainAdapter);
                    JSONArray eventArray = obj.getJSONArray("event");
                    JSONObject object = eventArray.getJSONObject(i);
                    String title = object.getString("title");
                    String venue_name = object.getString("venue_name");
                    String small_images = object.getString("small_image");
                    imagelists.add(new ModelImageName(title, venue_name, small_images));
                    JSONObject object1 = otherArray.getJSONObject(i);
                    JSONArray bannerarray = object1.getJSONArray("banners");
                        for (int j=0; j < bannerarray.length(); j++){
                            JSONObject baner = bannerarray.getJSONObject(j);
                            String image = baner.getString("image");
                            bannerImages.add(new ModelBannerName(image,bannerarray.length()));



                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }

    }
}

