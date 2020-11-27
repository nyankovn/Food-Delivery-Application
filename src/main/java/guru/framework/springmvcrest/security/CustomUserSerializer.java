package guru.framework.springmvcrest.security;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import guru.framework.springmvcrest.model.users.Profile;
import guru.framework.springmvcrest.model.users.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomUserSerializer extends StdSerializer<List<Profile>> {


    public CustomUserSerializer(Class<List<Profile>> t) {
        super(t);
    }

    @Override
    public void serialize(
            List<Profile> profiles,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        List<Profile> studs = new ArrayList<>();
        for (Profile s : profiles) {

            studs.add(s);
        }
        generator.writeObject(studs);
    }
}