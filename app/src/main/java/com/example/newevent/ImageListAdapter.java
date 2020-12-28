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


public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ListHolder> {
public Context context;
String [] data;
    private ArrayList<Imagelist> eventdata;
JSONArray images;
    public ImageListAdapter(Context data, ArrayList<Imagelist> mEventname) {
        this.context = data;
        this.eventdata = mEventname;
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
        Imagelist newcollection = eventdata.get(position);
        String name = newcollection.getTitle();
        String about = newcollection.getVenue_name();
        holder.list_text.setText(name);
        holder.venue_name.setText(about);
        Picasso.with(context).load(newcollection.getSmall_image()).into(holder.list_image);
    }

    @Override
    public int getItemCount() {
        return eventdata.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder{
        ImageView list_image;
        TextView list_text;
        TextView venue_name;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
            list_image=itemView.findViewById(R.id.image_view);
            list_text=itemView.findViewById(R.id.title);
            venue_name=itemView.findViewById(R.id.venue_name);
        }
    }
}
