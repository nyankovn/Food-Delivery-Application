package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.users.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User userDetails);

    Map<String, Boolean> deleteUser(Long id);
}