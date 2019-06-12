package models;

import java.util.ArrayList;
import java.util.List;

public class SplitRoute {

    private int trackerId;
    private List<Step> steps = new ArrayList<>();

    public SplitRoute() {
    }

    public SplitRoute(int trackerId, List<Step> steps) {
        this.trackerId = trackerId;
        this.steps = steps;
    }

    public int getTrackerId() {
        return this.trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "{" + " trackerId='" + getTrackerId() + "'" + ", steps='" + getSteps() + "'" + "}";
    }

}