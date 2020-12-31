package com.example.newevent;

import java.util.ArrayList;

public class EventNAme {


    private String  name;
    private String about;
    private ArrayList<Imagelist> eventdata;
    private ArrayList<BannerImages> bannerImages;
    public EventNAme(String name, String about,ArrayList<Imagelist> eventdata,ArrayList<BannerImages> bannerImages) {
        this.name = name;
        this.about = about;
        this.eventdata=eventdata;
        this.bannerImages=bannerImages;

    }

    public ArrayList<Imagelist> getEventdata() {
        return eventdata;
    }
    public ArrayList<BannerImages> getBannerImages() {
        return bannerImages;
    }

    public void setEventdata(ArrayList<Imagelist> eventdata) {
        this.eventdata = eventdata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
