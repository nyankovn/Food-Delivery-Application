package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.model.Tag;

import java.util.List;
import java.util.Map;

public interface TagService {
    List<Tag> getAllTags();

    Tag getTagById(Long id);

    Tag createTag(Tag tag);

    Tag updateTag(Long id, Tag tagDetails);

    Map<String, Boolean> deleteTag(Long id);
}
