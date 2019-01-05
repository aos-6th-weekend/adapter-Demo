package com.example.rathana.adapter_demo.model;

public class Song {

    int thumb;
    String title;
    String channelName;
    String views;

    public Song() {}

    public Song(int thumb, String title, String channelName, String views) {
        this.thumb = thumb;
        this.title = title;
        this.channelName = channelName;
        this.views = views;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Song{" +
                "thumb=" + thumb +
                ", title='" + title + '\'' +
                ", channelName='" + channelName + '\'' +
                ", views='" + views + '\'' +
                '}';
    }
}
