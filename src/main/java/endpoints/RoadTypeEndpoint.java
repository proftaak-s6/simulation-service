package endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.RoadType;
import services.RoadTypeService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("road-types")
public class RoadTypeEndpoint {

    @Inject
    private RoadTypeService service;

    @GET
    public Response getAll() {
        List<RoadType> roadTypes = service.getAll();

        if (roadTypes == null || roadTypes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT.getStatusCode()).build();
        }

        return Response.ok().entity(roadTypes).build();
    }

    @GET
    @Path("/speed/{speed}")
    public Response getBySpeed(@PathParam("speed") int speed) {
        RoadType type = service.getBySpeed(speed);

        if (type == null) {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "No Road type found with speed: " + speed).build();
        }
        
        return Response.ok().entity(type).build();
    }

    @PUT
    @Path("/{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updatePrice(@PathParam("name") String name, double price) {
        RoadType type = service.getByName(name);

        if (type == null) {
            return Response.status(Response.Status.NOT_FOUND.getStatusCode(), "No Road type found with name: " + name).build();
        }

        type.setPrice(price);

        try {
            service.update(type);
            return Response.status(Response.Status.NO_CONTENT.getStatusCode()).build(); 
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}