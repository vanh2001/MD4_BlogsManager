package com.example.postsmanager.controller;

import com.example.postsmanager.model.Post;
import com.example.postsmanager.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping("")
    public ResponseEntity<Iterable<Post>> findAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findAllByTitle")
    public ResponseEntity<Iterable<Post>> findAllByTitle(@RequestParam String title){
        return new ResponseEntity<>(postService.findAllByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("/findAllByLikesAsc")
    public ResponseEntity<Iterable<Post>> findAllByLikesAsc(){
        return new ResponseEntity<>(postService.findAllByOrderByLikesAsc(), HttpStatus.OK);
    }

    @GetMapping("/findAllTop4")
    public ResponseEntity<Iterable<Post>> findAllTop4(){
        return new ResponseEntity<>(postService.findAllTop4(), HttpStatus.OK);
    }
}
