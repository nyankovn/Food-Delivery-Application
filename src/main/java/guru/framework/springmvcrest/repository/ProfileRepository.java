package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.users.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Transactional
    Profile findByUsername(String s);
}

