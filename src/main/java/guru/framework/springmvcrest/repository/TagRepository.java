package guru.framework.springmvcrest.repository;

import guru.framework.springmvcrest.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository  extends JpaRepository<Tag,Long> {
}
