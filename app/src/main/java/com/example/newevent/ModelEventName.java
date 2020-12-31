package com.example.newevent;

import java.util.ArrayList;

public class ModelEventName {


    private String  name;
    private String about;
    private ArrayList<ModelImageName> eventdata;
    private ArrayList<ModelBannerName> bannerImages;
    public ModelEventName(String name, String about, ArrayList<ModelImageName> eventdata, ArrayList<ModelBannerName> bannerImages) {
        this.name = name;
        this.about = about;
        this.eventdata=eventdata;
        this.bannerImages=bannerImages;

    }

    public ArrayList<ModelImageName> getEventdata() {
        return eventdata;
    }
    public ArrayList<ModelBannerName> getBannerImages() {
        return bannerImages;
    }

    public void setEventdata(ArrayList<ModelImageName> eventdata) {
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
