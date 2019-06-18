package services;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.kumuluz.ee.configuration.utils.ConfigurationUtil;

import models.google.GoogleRoute;

@Dependent
public class GoogleDirectionsApiService {
    private GoogleApiKeyService keyService = new GoogleApiKeyService();

    private String API_URL = "https://maps.googleapis.com/maps/api/directions/json?";
    private String API_KEY = keyService.getKey();

    private Gson gson = new Gson();
    private Client client = ClientBuilder.newClient();
    private WebTarget target;

    public GoogleRoute getDirections(String origin, String destination) {
        WebTarget target = client.target(API_URL)
                .queryParam("origin", origin)
                .queryParam("destination", destination)
                .queryParam("key", API_KEY);

        Logger.getLogger(getClass().getName()).info(target.getUri().toString());

        String googleRouteString = target.request().get(String.class);

        GoogleRoute googleRoute = gson.fromJson(googleRouteString, GoogleRoute.class);

        return googleRoute;
    }

    public String getDirectionsUrl(String origin, String destination) {
        target = client.target(API_URL).queryParam("origin", origin).queryParam("destination", destination)
                .queryParam("key", API_KEY);

        return target.getUri().toString();
    }

}