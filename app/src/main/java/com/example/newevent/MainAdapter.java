package com.example.newevent;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.widget.GridLayout.HORIZONTAL;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {



    private Context data;

    private ArrayList<EventNAme> eventdata;
    private ArrayList<BannerImages> imagelists;

    public MainAdapter(Context data, ArrayList<EventNAme> mEventname) {
        this.data = data;
        this.eventdata = mEventname;

    }

    public MainAdapter(ArrayList<BannerImages> imagelists) {


        this.imagelists = imagelists;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.custom_recycler_iamges, parent, false);

        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventNAme newcollection = eventdata.get(position);
        String name = newcollection.getName();
        String about = newcollection.getAbout();
        holder.event_name.setText(name);
        holder.event_about.setText(about);
        setIventItemRecycler(holder.child_recycler, eventdata.get(position).getEventdata());
       setViewPager(holder.view_pager, eventdata.get(position).getBannerImages());

        //setBannerItemPager(holder.view_pager, eventdata.get(position.getpagerData()));
    }

   private void setViewPager(ViewPager view_pager, ArrayList<BannerImages> eventdata) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(data, eventdata);
        view_pager.setAdapter(viewPagerAdapter);
        view_pager.setVisibility(View.VISIBLE);
       Timer timer = new Timer();
      // timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 4000);

    }

    private void setIventItemRecycler(RecyclerView child_recycler, ArrayList<Imagelist> eventdata) {
        ImageListAdapter itemRecyclerAdapter = new ImageListAdapter(data, eventdata);

        child_recycler.setLayoutManager(new GridLayoutManager(data, 3));
        child_recycler.setAdapter(itemRecyclerAdapter);



    }


    @Override
    public int getItemCount() {
        return eventdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView event_name;
        TextView event_about;
        ViewPager view_pager;
        RecyclerView child_recycler;

        public ViewHolder(View v) {
            super(v);
            event_name = v.findViewById(R.id.tv_South_name);

            event_about = v.findViewById(R.id.tv_South_about);
            child_recycler = v.findViewById(R.id.child_recycler);
            view_pager = v.findViewById(R.id.viewPager);


        }
    }




}
