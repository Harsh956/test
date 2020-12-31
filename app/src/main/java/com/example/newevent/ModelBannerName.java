package com.example.newevent;

import java.util.ArrayList;

public class ModelBannerName {
    private String image;
    private int getBannerImages;
    public ModelBannerName(String image,int getBannerImages) {
        this.image = image;
        this.getBannerImages=getBannerImages;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
