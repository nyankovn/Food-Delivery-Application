package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.users.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    //    @Query("SELECT p FROM Profile p WHERE p.username = :username")
//    Profile getProfileByUsername(@Param("username") String username);
    @Transactional
    Profile findByUsername(String s);
}

