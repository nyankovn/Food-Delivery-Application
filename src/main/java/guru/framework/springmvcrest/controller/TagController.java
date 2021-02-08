package guru.framework.springmvcrest.controller;


import guru.framework.springmvcrest.model.Tag;
import guru.framework.springmvcrest.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        return new ResponseEntity(tagService.getTagById(id), HttpStatus.OK);
    }

    @PostMapping("/tags")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return new ResponseEntity(tagService.createTag(tag), HttpStatus.CREATED);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tagDetails) {
        return new ResponseEntity(tagService.updateTag(id, tagDetails), HttpStatus.OK);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTag(@PathVariable Long id) {
        return new ResponseEntity(tagService.deleteTag(id), HttpStatus.OK);
    }
}
