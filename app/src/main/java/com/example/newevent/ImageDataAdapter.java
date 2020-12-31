package com.example.newevent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;


public class ImageDataAdapter extends RecyclerView.Adapter<ImageDataAdapter.ListHolder> {
public Context context;
String [] data;
    private ArrayList<ModelImageName> neventdata ;
JSONArray images;
    public ImageDataAdapter(Context data, ArrayList<ModelImageName> mEventname) {
        this.context = data;
        this.neventdata = mEventname;
    }



    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.gridlayout,parent,false);

        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        ModelImageName newcollection = neventdata.get(position);
        String name = newcollection.getTitle();
        String about = newcollection.getVenue_name();
        holder.list_text.setText(name);
        holder.venue_name.setText(about);
        Picasso.with(context).load(newcollection.getSmall_image()).into(holder.list_image);
       // Picasso.with(context).load(newcollection.getSmall_image()).into(holder.img_rating);
    }

    @Override
    public int getItemCount() {
        return neventdata.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        ImageView list_image,img_rating;
        TextView list_text;
        TextView venue_name;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
            list_image=itemView.findViewById(R.id.image_view);
           // img_rating=itemView.findViewById(R.id.img_rating);
            list_text=itemView.findViewById(R.id.title);
            venue_name=itemView.findViewById(R.id.venue_name);
        }
    }
}
