package com.first.sqlite.tekup.bilel.todo.Model;

/**
 * Created by bilel on 23/12/2016.
 */

public class Position {

    private long id;
    private Double longitude;
    private Double latitude;


    public Position() {}

    public Position(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
