package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
