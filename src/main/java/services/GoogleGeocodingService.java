
package services;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import models.google.GoogleGeocodedLocation;
import models.google.Location;

@Dependent
public class GoogleGeocodingService {
    private String API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    private String API_KEY = ConfigurationUtil.getInstance().get("config.google.directionsApi.key")
            .orElseThrow(() -> new RuntimeException("Could not find 'config.google.directionsApi.key'"));

    private Client client;
    private WebTarget target;

    public GoogleGeocodingService() {
        client = ClientBuilder.newClient();
    }

    public GoogleGeocodedLocation getLocation(Location location) {
        target = client.target(API_URL).queryParam("latlng", location.getLat() + "," + location.getLng())
                .queryParam("key", API_KEY);

        return target.request(MediaType.APPLICATION_JSON).get(GoogleGeocodedLocation.class);
    }

    public String getLocationUrl(Location location) {
        target = client.target(API_URL).queryParam("latlng", location.getLat() + "," + location.getLng())
                .queryParam("key", API_KEY);

        return target.getUri().toString();
    }
}