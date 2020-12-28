package com.example.newevent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context data;

    private ArrayList<EventNAme> eventdata;
private ArrayList<Imagelist> imagelists;

    public MainAdapter(Context data, ArrayList<EventNAme> mEventname) {
        this.data = data;
        this.eventdata = mEventname;
    }


    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.custom_recycler_iamges, parent, false);

        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        EventNAme newcollection = eventdata.get(position);
        String name = newcollection.getName();
        String about = newcollection.getAbout();
        holder.event_name.setText(name);
        holder.event_about.setText(about);
        setCatItemRecycler(holder.child_recycler, eventdata.get(position).getEventdata());
    }

    private void setCatItemRecycler(RecyclerView child_recycler, ArrayList<Imagelist> eventdata) {
        ImageListAdapter itemRecyclerAdapter = new ImageListAdapter(data,eventdata );
        child_recycler.setLayoutManager(new LinearLayoutManager(data, RecyclerView.HORIZONTAL, false));
        child_recycler.setAdapter(itemRecyclerAdapter);

    }

    @Override
    public int getItemCount() {
        return eventdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView event_name;
        TextView event_about;
        ImageView image_view, image_slide;
        RecyclerView child_recycler;

        public ViewHolder(View v) {
            super(v);
            event_name = v.findViewById(R.id.tv_South_name);

            event_about = v.findViewById(R.id.tv_South_about);
            child_recycler = v.findViewById(R.id.child_recycler);



        }
    }

}
