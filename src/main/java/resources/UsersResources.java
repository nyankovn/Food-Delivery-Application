package resources;

import model.User;
import repository.FakeDataStore;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UsersResources {
    private FakeDataStore dataStore=new FakeDataStore();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List <User> users=new ArrayList<>();
        users=dataStore.getUsers();
        GenericEntity<List<User>> entity=new GenericEntity<>(users){};
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:XXXX/students/3
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserPath(@PathParam("id") int id) {
        // StudentsRepository studentsRepository = RepositoryFactory.getStudentsRepository();
        User user = dataStore.getUser(id);//studentsRepository.get(stNr);
        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid student number.").build();
        } else {
            return Response.ok(user).build();
        }
    }
}
