package models.geocode;

import java.util.List;

public class GeocodedLocation {
    private PlusCode plusCode;
    private List<Result> results;
    private String status;

    public GeocodedLocation() {
    }

    public GeocodedLocation(PlusCode plusCode, List<Result> results, String status) {
        this.plusCode = plusCode;
        this.results = results;
        this.status = status;
    }

    public PlusCode getPlusCode() {
        return this.plusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" + " plusCode='" + getPlusCode() + "'" + ", results='" + getResults() + "'" + ", status='"
                + getStatus() + "'" + "}";
    }

}