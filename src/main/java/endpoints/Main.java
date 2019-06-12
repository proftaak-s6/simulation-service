package endpoints;

import models.geocode.AddressComponent;
import models.google.Location;
import services.GoogleGeocodingService;

public class Main {

    public static void main(String[] args) {
        GoogleGeocodingService service = new GoogleGeocodingService();
        Location location = new Location(40.714224, -73.961452);
        String streetname = service.getStreetname(location);
        System.out.println(streetname);
    }
}