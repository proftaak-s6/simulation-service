package models;

import java.util.Date;

import models.google.Location;

public class DatedLocation extends Location {
    private Date date;

    public DatedLocation() {
    }

    public DatedLocation(double lat, double lng, Date date) {
        this.lat = lat;
        this.lng = lng;
        this.date = date;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + " lat='" + getLat() + "'" + ", lng='" + getLng() + "'" + ", date='" + getDate() + "'" + "}";
    }

}