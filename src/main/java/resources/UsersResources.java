package resources;

import model.User;
import repository.FakeDataStore;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UsersResources {
    @Context
    private UriInfo uriInfo;
    private FakeDataStore dataStore=new FakeDataStore();

    @GET //GET at http://localhost:XXXX/students/hello
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        String msg = " Hello, your resources works!";
        return Response.ok(msg).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List <User> users=new ArrayList<>();
        users=dataStore.getUsers();
        GenericEntity<List<User>> entity=new GenericEntity<>(users){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserPath(@PathParam("id") int id) {
        User user=new User();
        user = dataStore.getUser(id);
        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid user number.").build();
        } else {
            return Response.ok(user).build();
        }
    }






}
