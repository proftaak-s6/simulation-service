package models;

import java.util.ArrayList;
import java.util.List;

public class SplitStep {
    private int distance;
    private NamedLocation start;
    private List<DatedLocation> locations = new ArrayList<DatedLocation>();

    public SplitStep() {
    }

    public SplitStep(int distance, NamedLocation start, List<DatedLocation> locations) {
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
}