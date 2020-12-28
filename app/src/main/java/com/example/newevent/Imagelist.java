package com.example.newevent;

public class Imagelist {
    private String title;
    private String venue_name;
    private String small_image;


    public Imagelist(String title, String venue_name, String small_image) {
        this.title = title;
        this.venue_name = venue_name;
        this.small_image = small_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getSmall_image() {
        return small_image;
    }

    public void setSmall_image(String small_image) {
        this.small_image = small_image;
    }
}
