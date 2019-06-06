package endpoints;

import models.RouteStartEndModel;
import models.google.GoogleRoute;
import models.google.Leg;
import models.google.Route;
import models.google.Step;
import services.GoogleDirectionsApiService;
import services.RouteSplitterService;

public class RouteSplitterMain {
    public static void main(String[] args) {
        GoogleDirectionsApiService directionsService = new GoogleDirectionsApiService();
        RouteSplitterService routeSplitterService = new RouteSplitterService();

        RouteStartEndModel input = new RouteStartEndModel("Enschotsestraat, Tilburg, The Netherlands",
                "Lambert de Wijsstraat, Tilburg, The Netherlands");
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());

        System.out.println("Logging the GoogleRoute that will be used for splitting. Input data: " + input);
        System.out.println(" == GOOGLEROUTE ==");
        System.out.println(result.toString());
        System.out.println(" ================ ");
        for (Route route : result.getRoutes()) {
            System.out.println(" == ROUTE ==");
            System.out.println(route.toString());
            System.out.println(" =========== ");
            for (Leg leg : route.getLegs()) {
                System.out.println(" == LEG ==");
                System.out.println(leg.toString());
                System.out.println(" ========= ");
                for (Step step : leg.getSteps()) {
                    System.out.println(" == STEP ==");
                    System.out.println(step.toString());
                    System.out.println(" ========== ");
                }
            }
        }

        routeSplitterService.SplitStepsIntoLocations(result.getRoutes().get(0).getLegs().get(0).getSteps(), 5);
    }
}