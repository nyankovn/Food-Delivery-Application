package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.users.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
