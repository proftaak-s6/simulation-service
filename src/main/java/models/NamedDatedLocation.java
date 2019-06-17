package models;

import models.google.Location;

public class NamedDatedLocation extends Location {

    private String name;
    private String date;

    public NamedDatedLocation() {
    }

    public NamedDatedLocation(String name, String date, double lat, double lng) {
        this.name = name;
        this.date = date;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
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

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", date='" + getDate() + "'" + ", lat='" + getLat() + "'" + ", lng='"
                + getLng() + "'" + "}";
    }

}