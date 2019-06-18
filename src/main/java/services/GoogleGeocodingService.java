
package services;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import models.geocode.AddressComponent;
import models.geocode.GeocodedLocation;
import models.geocode.Result;
import models.google.Location;

@Dependent
public class GoogleGeocodingService {
    private GoogleApiKeyService keyService = new GoogleApiKeyService();
    private String API_URL = "https://maps.googleapis.com/maps/api/geocode/json?";
    private String API_KEY = keyService.getKey();

    private Gson gson = new Gson();
    private Client client = ClientBuilder.newClient();
    private WebTarget target;

    public String getStreetname(Location location) {
        String geocodedLocationString = client
            .target(API_URL)
            .queryParam("latlng", location.getLat() + "," + location.getLng())
            .queryParam("key", API_KEY)
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        GeocodedLocation geocodedLocation = gson.fromJson(geocodedLocationString, GeocodedLocation.class);

        for (Result result : geocodedLocation.getResults()) {
            for (AddressComponent addressComponent : result.getAddress_components()) {
                for (String type : addressComponent.getTypes()) {
                    if (type.equals("route")) {
                        return addressComponent.getLong_name();
                    }
                }
            }
        }

        // TODO: Throw an error?
        return "Augoirkestraat";
    }

    public String getLocationUrl(Location location) {
        target = client
            .target(API_URL)
            .queryParam("latlng", location.getLat() + "," + location.getLng())
            .queryParam("key", API_KEY);

        return target.getUri().toString();
    }
}