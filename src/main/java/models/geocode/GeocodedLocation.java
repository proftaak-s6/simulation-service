package models.geocode;

import java.util.List;

public class GeocodedLocation {
    public PlusCode plus_code;
    public List<Result> results;
    public String status;

    public GeocodedLocation() {
    }

    public GeocodedLocation(PlusCode plus_code, List<Result> results, String status) {
        this.plus_code = plus_code;
        this.results = results;
        this.status = status;
    }

    public PlusCode getPlus_code() {
        return this.plus_code;
    }

    public void setPlus_code(PlusCode plus_code) {
        this.plus_code = plus_code;
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
        return "{" + " plus_code='" + getPlus_code() + "'" + ", results='" + getResults() + "'" + ", status='"
                + getStatus() + "'" + "}";
    }

}