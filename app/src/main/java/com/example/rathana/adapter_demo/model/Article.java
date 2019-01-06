package com.example.rathana.adapter_demo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Article implements Parcelable {

    private String title;
    private String date;
    private String thumb;
    private String authorName;


    protected Article(Parcel in) {
        title = in.readString();
        date = in.readString();
        thumb = in.readString();
        authorName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(thumb);
        dest.writeString(authorName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Article() {}

    public Article(String title, String date,String author) {
        this.title = title;
        this.date = date;
        this.authorName=author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
