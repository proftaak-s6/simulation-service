package models.rabbitmq;

import models.NamedDatedLocation;

public class StepMessage {
    private int distance;
    private NamedDatedLocation location;

    public StepMessage() {
    }

    public StepMessage(int distance, NamedDatedLocation location) {
        this.distance = distance;
        this.location = location;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public NamedDatedLocation getLocation() {
        return this.location;
    }

    public void setLocation(NamedDatedLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" + " distance='" + getDistance() + "'" + ", location='" + getLocation() + "'" + "}";
    }

}