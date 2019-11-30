package si.fri.rso.escooterental.escooterorders.api.v1.resources;

import si.fri.rso.escooterental.escooterorders.models.entities.EscooterOrdersEntity;
import si.fri.rso.escooterental.escooterorders.lib.EscooterOrders;
import si.fri.rso.escooterental.escooterorders.services.beans.EscooterOrderBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;





@ApplicationScoped
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EscooterOrdersResource {

    @Inject
    private EscooterOrderBean escooterBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getEscooterOrder(){
//        List<EscooterOrders> orders = escooterBean.getEscooterOrders();
//        return Response.status(Response.Status.OK).entity(orders).build();
        return Response.status(Response.Status.OK).entity("{\n" +
                "    \"clani\": [\"jm1234\", \"mn3322\"],\n" +
                "    \"opis_projekta\": \"Nas projekt implementira aplikacijo za oddajo nepremicnin.\",\n" +
                "    \"mikrostoritve\": [\"http://35.189.96.118:8081/v1/orders\", \"http://35.197.209.159:8080/v1/customers/\"],\n" +
                "    \"github\": [\"https://github.com/jmezna/rso-customers\", \"https://github.com/jmezna/rso-orders\"],\n" +
                "    \"travis\": [\"https://travis-ci.org/jmezna/rso-customers\", \"https://travis-ci.org/jmezna/rso-orders\"],\n" +
                "    \"dockerhub\": [\"https://hub.docker.com/r/jmezna/rso-customers/\", \"https://hub.docker.com/r/jmezna/rso-orders/\"]\n" +
                "}").build();
    }
    @GET
    @Path("/{EscooterId}")
    public Response getEscooterOrder(@PathParam("EscooterId") Integer EscooterId){

        EscooterOrders escooter = escooterBean.getEscooter(EscooterId);
        if (escooter == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(escooter).build();
//        return Response.status(Response.Status.OK).entity().build();
    }

    @POST
    public Response createEscooterOrder(EscooterOrders escoot){
        if (escoot.getScooterId() == null || escoot.getPickupLocation() == null || escoot.getTimeFrom() == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            escoot = escooterBean.createEscooterOrder(escoot);
        }

        return Response.status(Response.Status.CONFLICT).entity(escoot).build();
    }

    @PUT
    @Path("{escooterId}")
    public Response changeEscooterCatalog(@PathParam("escooterId") Integer Id, EscooterOrders escooter){
        escooter = escooterBean.putEscooterOrder(Id,escooter);

        if (escooter == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @DELETE
    @Path("{escooterId}")
    public Response deleteEscooterCatalog(@PathParam("escooterId") Integer escooterId) {

        boolean deleted = escooterBean.deleteEscooterOrder(escooterId);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
