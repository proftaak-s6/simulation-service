
package models.google;

import java.util.List;

public class Leg {

    private TextValue distance;
    private TextValue duration;
    private Location end_location;
    private Location start_location;
    private List<Step> steps;

    public Leg() {
    }

    public Leg(TextValue distance, TextValue duration, Location end_location, Location start_location,
            List<Step> steps) {
        this.distance = distance;
        this.duration = duration;
        this.end_location = end_location;
        this.start_location = start_location;
        this.steps = steps;
    }

    public TextValue getDistance() {
        return this.distance;
    }

    public void setDistance(TextValue distance) {
        this.distance = distance;
    }

    public TextValue getDuration() {
        return this.duration;
    }

    public void setDuration(TextValue duration) {
        this.duration = duration;
    }

    public Location getEnd_location() {
        return this.end_location;
    }

    public void setEnd_location(Location end_location) {
        this.end_location = end_location;
    }

    public Location getStart_location() {
        return this.start_location;
    }

    public void setStart_location(Location start_location) {
        this.start_location = start_location;
    }

    public List<Step> getSteps() {
        return this.steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "{" + " distance='" + getDistance() + "'" + ", duration='" + getDuration() + "'" + ", end_location='"
                + getEnd_location() + "'" + ", start_location='" + getStart_location() + "'" + ", steps='" + getSteps()
                + "'" + "}";
    }

}
