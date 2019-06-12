package models;

import java.util.ArrayList;
import java.util.List;

public class SplitRoute {

    private int trackerId;
    private List<SplitStep> steps = new ArrayList<>();

    public SplitRoute() {
    }

    public SplitRoute(int trackerId, List<SplitStep> steps) {
        this.trackerId = trackerId;
        this.steps = steps;
    }

    public int getTrackerId() {
        return this.trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public List<SplitStep> getSteps() {
        return this.steps;
    }

    public void setSteps(List<SplitStep> steps) {
        this.steps = steps;
    }

}