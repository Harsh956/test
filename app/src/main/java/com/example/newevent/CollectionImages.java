package com.example.newevent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CollectionImages extends RecyclerView.Adapter<CollectionImages.ViewHolder> {
    private Context mdata;
    JSONArray eventdata;
    private ArrayList<CollectionItem> mcollectionItems;

    public CollectionImages(Context data, ArrayList<CollectionItem> collectionItems) {
        this.mdata = data;
        this.mcollectionItems = collectionItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.event_data_ui, parent, false);

        return new CollectionImages.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       CollectionItem newcollection = mcollectionItems.get(position);
       String image =newcollection.getMsmall_image();
       Picasso.with(mdata).load(image).fit().centerInside().into(holder.image_view);

    }

    @Override
    public int getItemCount() {
        return mcollectionItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;


        public ViewHolder(View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.collection_image_view);
        }
    }
}
