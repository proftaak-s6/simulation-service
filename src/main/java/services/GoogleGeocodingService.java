
package services;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import models.google.GoogleGeocodedLocation;
import models.google.Location;

@Dependent
public class GoogleGeocodingService {
    // latlng=40.714224,-73.961452&key=YOUR_API_KEY

    private String API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    // De eerste die hier de api key plaatst en dat op git zet krijgt slaag van Eva
    private String API_KEY = "<enter the key here>";

    private Client client;
    private WebTarget target;

    public GoogleGeocodingService() {
        client = ClientBuilder.newClient();
    }

    public GoogleGeocodedLocation getDirections(Location location) {
        target = client.target(API_URL).queryParam("latlng", location.getLat() + "," + location.getLng())
                .queryParam("key", API_KEY);

        return target.request(MediaType.APPLICATION_JSON).get(GoogleGeocodedLocation.class);
    }

    public String getDirectionsUrl(String origin, String destination) {
        target = client.target(API_URL).queryParam("origin", origin).queryParam("destination", destination)
                .queryParam("key", API_KEY);

        return target.getUri().toString();
    }
}