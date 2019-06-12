package models;

import java.util.ArrayList;
import java.util.List;

public class Step {
    private int distance;
    private NamedLocation start;
    private List<DatedLocation> locations = new ArrayList<DatedLocation>();

    public Step() {
    }

    public Step(int distance, NamedLocation start, List<DatedLocation> locations) {
        this.distance = distance;
        this.start = start;
        this.locations = locations;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public NamedLocation getStart() {
        return this.start;
    }

    public void setStart(NamedLocation start) {
        this.start = start;
    }

    public List<DatedLocation> getLocations() {
        return this.locations;
    }

    public void setLocations(List<DatedLocation> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "{" + " distance='" + getDistance() + "'" + ", start='" + getStart() + "'" + ", locations='"
                + getLocations() + "'" + "}";
    }

}