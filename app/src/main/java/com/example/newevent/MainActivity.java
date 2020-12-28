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
    private ArrayList<EventNAme> mEventname;
    private ArrayList<Imagelist> imagelists;
    private MainAdapter mainAdapter;

    private ImageListAdapter imageListAdapter;
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
        imagelists=new ArrayList<>();
        /*South_recycler=findViewById(R.id.South_recycler);
        listAdapter=new ListAdapter(this,images);
        //South_recycler.setNestedScrollingEnabled(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        South_recycler.setLayoutManager(gridLayoutManager);
        South_recycler.setHasFixedSize(true);
*/


        mEventname = new ArrayList<>();
        imagelists = new ArrayList<>();
        getdatafromserver();

    }

    private void getdatafromserver() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // JSONObject objMsain=new JSONObject(response);
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
            try {

                JSONObject obj = otherArray.getJSONObject(i);
                obj = otherArray.getJSONObject(i);
                JSONArray jsonArray = obj.getJSONArray("event");
                imageListAdapter = new ImageListAdapter(getApplicationContext(), imagelists);
                String name = obj.getString("name");
                String about = obj.getString("about");
                mEventname.add(new EventNAme(name, about,imagelists));
               // imageListAdapter = new ImageListAdapter(getApplicationContext(), jsonArray);
//listAdapter=new ListAdapter(getApplicationContext(),jsonArray);
                // South_recycler.setAdapter(listAdapter);
                mainAdapter = new MainAdapter(getApplicationContext(), mEventname);

                event_data_recyclerview.setAdapter(mainAdapter);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }

}

