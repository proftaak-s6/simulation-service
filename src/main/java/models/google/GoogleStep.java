
package models.google;

public class GoogleStep {

    private TextValue distance;
    private TextValue duration;
    private Location start_location;
    private Location end_location;

    public GoogleStep() {
    }

    public GoogleStep(TextValue distance, TextValue duration, Location start_location, Location end_location) {
        this.distance = distance;
        this.duration = duration;
        this.start_location = start_location;
        this.end_location = end_location;
    }

    public int getSpeed() {
        int distance = this.getDistance().getValue();
        int duration = this.getDuration().getValue();
        return (int) Math.rint((double) distance / (double) duration);
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

    public Location getStart_location() {
        return this.start_location;
    }

    public void setStart_location(Location start_location) {
        this.start_location = start_location;
    }

    public Location getEnd_location() {
        return this.end_location;
    }

    public void setEnd_location(Location end_location) {
        this.end_location = end_location;
    }

    @Override
    public String toString() {
        return "{" + " distance='" + getDistance() + "'" + ", duration='" + getDuration() + "'" + ", start_location='"
                + getStart_location() + "'" + ", end_location='" + getEnd_location() + "'" + "}";
    }

}
