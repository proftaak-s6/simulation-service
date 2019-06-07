package services;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import models.google.GoogleRoute;

@Dependent
public class GoogleDirectionsApiService {

    private String API_URL = "https://maps.googleapis.com/maps/api/directions/json?";
    private String API_KEY = ConfigurationUtil.getInstance()
        .get("config.google.directionsApi.key")
        .orElseThrow(() -> new RuntimeException("Could not find 'config.google.directionsApi.key'"));

    private Client client;
    private WebTarget target;


    @PostConstruct
    private void test() {
        Logger LOG = Logger.getLogger(getClass().getName());
        LOG.info("API_KEY: " + API_KEY);
    }

    public GoogleDirectionsApiService() {
        client = ClientBuilder.newClient();
    }

    public GoogleRoute getDirections(String origin, String destination) {
        target = client.target(API_URL).queryParam("origin", origin).queryParam("destination", destination)
                .queryParam("key", API_KEY);

        return target.request(MediaType.APPLICATION_JSON).get(GoogleRoute.class);
    }

    public String getDirectionsUrl(String origin, String destination) {
        target = client.target(API_URL).queryParam("origin", origin).queryParam("destination", destination)
                .queryParam("key", API_KEY);

        return target.getUri().toString();
    }
}