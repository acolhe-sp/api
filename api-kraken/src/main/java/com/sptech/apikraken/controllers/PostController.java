package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.post.PostDTO;
import com.sptech.apikraken.entity.Post;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.repository.IPostRepository;
import com.sptech.apikraken.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired private PostService postService;
    @Autowired private IPostRepository postRepository;
    @Autowired private INGORepository ngoRepository;

    @GetMapping
    public ResponseEntity listPosts() {

        if (postService.getAll().getTamanho() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(postService.getAll());
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity listPostsByPublisher(@PathVariable Integer id) {

        List<Post> posts = postService.getByPublisherId(id);

        if (posts.size() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(posts);
    }

    @GetMapping("/publisher/{id}/analytics")
    public ResponseEntity getAnalyticsPostsByPublisher(@PathVariable Integer id) {

        if (!ngoRepository.existsById(id)) return ResponseEntity.status(404).build();

        List<Post> posts = postService.getByPublisherId(id);

        if (posts.size() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(postService.getAnalyticsPostsPublisher(id, posts));
    }

    @PostMapping
    public ResponseEntity registerPost(@RequestBody @Valid PostDTO post){
        try {

            return ResponseEntity.status(201).body(postService.create(post));

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        try {

            return ResponseEntity.status(201).body(postService.delete(id));

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

}
