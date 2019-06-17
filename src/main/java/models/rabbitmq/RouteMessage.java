package models.rabbitmq;

import java.util.ArrayList;
import java.util.List;

public class RouteMessage {

    private int trackerId;
    private List<StepMessage> steps = new ArrayList<>();

    public RouteMessage() {
    }

    public RouteMessage(int trackerId, List<StepMessage> steps) {
        this.trackerId = trackerId;
        this.steps = steps;
    }

    public int getTrackerId() {
        return this.trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public List<StepMessage> getSteps() {
        return this.steps;
    }

    public void setSteps(List<StepMessage> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "{" + " trackerId='" + getTrackerId() + "'" + ", steps='" + getSteps() + "'" + "}";
    }

}