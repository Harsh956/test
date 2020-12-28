package com.example.newevent;

import java.util.ArrayList;

public class EventNAme {


    private String  name;
    private String about;
    private ArrayList<Imagelist> eventdata;

    public EventNAme(String name, String about,ArrayList<Imagelist> eventdata) {
        this.name = name;
        this.about = about;

    }

    public ArrayList<Imagelist> getEventdata() {
        return eventdata;
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
