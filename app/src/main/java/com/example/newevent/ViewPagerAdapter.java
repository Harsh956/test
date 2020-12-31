package com.example.newevent;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    JSONArray banner;
    private JSONArray images ;
    private ArrayList<ModelBannerName> imagelists;
    public ViewPagerAdapter(Context context, ArrayList<ModelBannerName> imagelists ) {
        this.context = context;
        this.imagelists=imagelists;
    }

    @Override
    public int getCount() {
        return imagelists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.banner_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.banner_scroll_images);
        ModelBannerName newcollection = imagelists.get(position);
        Picasso.with(context).load(newcollection.getImage()).into(imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
