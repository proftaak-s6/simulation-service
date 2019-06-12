package endpoints;

import models.geocode.GeocodedLocation;
import models.google.Location;
import services.GoogleGeocodingService;

public class Main {

    public static void main(String[] args) {
        GoogleGeocodingService service = new GoogleGeocodingService();
        Location location = new Location(40.714224, -73.961452);
        // String googleLocation = service.getLocationUrl(location);
        GeocodedLocation googleLocation = service.getLocation(location);
        System.out.println(googleLocation);
    }
}