package models;

public class OriginDestination {
    private String origin;
    private String destination;

    public OriginDestination() {
    }

    public OriginDestination(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "{" + " origin='" + getOrigin() + "'" + ", destination='" + getDestination() + "'" + "}";
    }

}