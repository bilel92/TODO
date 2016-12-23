package com.first.sqlite.tekup.bilel.todo.Model;

import java.util.Date;

/**
 * Created by bilel on 23/12/2016.
 */

public class Tache {

    private long id;
    private  String title;
    private  String description;
    private  String image;
    private  String video;
    private  int position;
    private  int user;
    private  int etat;
    private Date date;


    public Tache() {}

    public Tache(String title, String description, String image, String video, int position, int user, int etat, Date date) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.video = video;
        this.position = position;
        this.user = user;
        this.etat = etat;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
