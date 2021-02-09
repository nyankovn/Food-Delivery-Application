package guru.framework.springmvcrest.services;

import guru.framework.springmvcrest.exception.ResourceNotFoundException;
import guru.framework.springmvcrest.model.Tag;
import guru.framework.springmvcrest.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private String tagWithId = "Tag with id ";
    private String doesNotExist = " does not exists";

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(tagWithId + id + doesNotExist));
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag tagDetails) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(tagWithId + id + doesNotExist));

        tag.setName(tagDetails.getName());
        return tagRepository.save(tag);
    }

    public Map<String, Boolean> deleteTag(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(tagWithId + id + doesNotExist));

        tagRepository.delete(tag);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
