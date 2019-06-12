package endpoints;

import com.google.gson.Gson;

import models.OriginDestination;
import models.SplitRoute;
import models.google.GoogleRoute;
import services.GoogleDirectionsApiService;
import services.RouteSplitterService;

public class RouteSplitterMain {
    public static void main(String[] args) {
        GoogleDirectionsApiService directionsService = new GoogleDirectionsApiService();
        RouteSplitterService routeSplitterService = new RouteSplitterService();

        // Alternate route, over the A50
        // OriginDestination input = new OriginDestination("McDonald's Heesch",
        // "Carpoolplaats Ravenstein A50");

        OriginDestination input = new OriginDestination("Enschotsestraat, Tilburg, The Netherlands",
                "Lambert de Wijsstraat, Tilburg, The Netherlands");
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());

        SplitRoute splitRoute = routeSplitterService
                .SplitStepsIntoLocations(result.getRoutes().get(0).getLegs().get(0).getSteps(), 5);
        System.out.println(new Gson().toJson(splitRoute));
    }
}