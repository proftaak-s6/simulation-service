package endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import messaging.MessageProducer;
import models.OriginDestination;
import models.SplitRoute;
import models.google.GoogleRoute;
import models.google.GoogleStep;
import models.rabbitmq.RouteMessage;
import services.GoogleDirectionsApiService;
import services.RouteSplitterService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("route")
public class RouteEndpoint {

    @Inject
    private GoogleDirectionsApiService directionsService;

    @Inject
    private MessageProducer messageProducer;

    @Inject
    private RouteSplitterService routeSplitterService;

    private static int updateInterval = 5;

    private Gson gson = new Gson();

    @POST
    @Path("/{trackerId}")
    public Response CreateRoute(@PathParam("trackerId") int trackerId, OriginDestination input) {
        GoogleRoute result = directionsService.getDirections(input.getOrigin(), input.getDestination());

        if (result.getStatus().equals("OK") && result.getRoutes().size() > 0
                && result.getRoutes().get(0).getLegs().size() > 0
                && result.getRoutes().get(0).getLegs().get(0).getSteps().size() > 0) {

            List<GoogleStep> steps = result.getRoutes().get(0).getLegs().get(0).getSteps();

            SplitRoute splitRoute = routeSplitterService.SplitStepsIntoLocations(steps, updateInterval);
            splitRoute.setTrackerId(trackerId);

            RouteMessage routeMessage = splitRoute.toRouteMessage();

            messageProducer.sendJSONMessage(gson.toJson(routeMessage));

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

    @GET
    @Path("test")
    public Response getTest() {
        return Response.ok(directionsService.getDirections("Dongen", "Tilburg")).build();
    }
}
