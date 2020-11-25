package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.Tag;
import guru.framework.springmvcrest.model.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
