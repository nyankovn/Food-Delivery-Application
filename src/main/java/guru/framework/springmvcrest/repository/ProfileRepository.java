package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.users.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

//    @Query("SELECT p FROM Profile p WHERE p.username = :username")
//    Profile getProfileByUsername(@Param("username") String username);
    Profile findByUsername(String s);
}

