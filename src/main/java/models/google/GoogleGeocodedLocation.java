
package models.google;

import java.util.ArrayList;
import java.util.List;

public class GoogleGeocodedLocation {

    private List<Result> results = new ArrayList<>();
    private String status;

    public GoogleGeocodedLocation() {
    }

    public GoogleGeocodedLocation(List<Result> results, String status) {
        this.results = results;
        this.status = status;
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
}
