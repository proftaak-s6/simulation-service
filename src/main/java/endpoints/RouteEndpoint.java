package endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import models.OriginDestination;
import models.SplitRoute;
import models.google.GoogleRoute;
import models.google.GoogleStep;
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
    public Response GetRouteUri(OriginDestination input) {
        String route = directionsService.getDirectionsUrl(input.getOrigin(), input.getDestination());
        return Response.ok(route).build();
    }

    @POST
    public Response CreateRoute(OriginDestination input) {
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());
        if (result.getStatus().equals("OK") 
                && result.getRoutes().size() > 0
                && result.getRoutes().get(0).getLegs().size() > 0
                && result.getRoutes().get(0).getLegs().get(0).getSteps().size() > 0) {
            List<GoogleStep> steps = result.getRoutes().get(0).getLegs().get(0).getSteps();
            SplitRoute splitRoute = routeSplitterService.SplitStepsIntoLocations(steps, updateInterval);
            return Response.ok(splitRoute).build();
        } else {
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(result).build();
        }
    }

    @POST
    @Path("json")
    public Response getRouteJson(OriginDestination input) {
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());
        return Response.ok(result).build();
    }
}
