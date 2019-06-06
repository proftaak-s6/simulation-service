package endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import models.RouteStartEndModel;
import models.TrackerServiceModel;
import models.google.GoogleRoute;
import models.google.Step;
import services.GoogleDirectionsApiService;
import services.RouteSplitterService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("route")
public class RouteEndpoint {

    @Inject
    GoogleDirectionsApiService directionsService;

    @Inject
    RouteSplitterService routeSplitterService;

    private static int updateInterval = 5;

    @GET
    public Response GetRouteUri(RouteStartEndModel input) {
        String route = directionsService.getDirectionsUrl(input.getOrigin(), input.getDestination());
        return Response.ok(route).build();
    }

    @POST
    public Response CreateRoute(RouteStartEndModel input) {
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());
        if (result.getStatus().equals("OK") 
                && result.getRoutes().size() > 0
                && result.getRoutes().get(0).getLegs().size() > 0
                && result.getRoutes().get(0).getLegs().get(0).getSteps().size() > 0) {
            List<Step> steps = result.getRoutes().get(0).getLegs().get(0).getSteps();
            List<TrackerServiceModel> entity = routeSplitterService.SplitStepsIntoLocations(steps, updateInterval);
            return Response.ok(entity).build();
        } else {
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(result).build();
        }
    }

    @POST
    @Path("json")
    public Response getRouteJson(RouteStartEndModel input) {
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());
        return Response.ok(result).build();
    }

}
