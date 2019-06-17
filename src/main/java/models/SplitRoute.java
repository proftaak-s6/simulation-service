package models;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.google.Location;
import models.rabbitmq.RouteMessage;
import models.rabbitmq.StepMessage;

public class SplitRoute {

    private int trackerId;
    private List<Step> steps = new ArrayList<>();

    public RouteMessage toRouteMessage() {
        List<StepMessage> stepMessages = new ArrayList<>();

        for (Step step : steps) {
            String name = step.getStart().getName();
            Date date = step.getLocations().get(0).getDate();

            String dateString = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();

            Location location = step.getLocations().get(0);

            NamedDatedLocation stepLocation = new NamedDatedLocation(name, dateString, location.getLat(),
                    location.getLng());
            stepMessages.add(new StepMessage(step.getDistance(), stepLocation));
        }

        return new RouteMessage(trackerId, stepMessages);
    }

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