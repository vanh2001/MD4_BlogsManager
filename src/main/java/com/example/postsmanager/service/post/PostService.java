package com.example.postsmanager.service.post;

import com.example.postsmanager.model.Post;
import com.example.postsmanager.repo.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService{
    @Autowired
    private IPostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllByTitleContaining(String title) {
        return postRepository.findAllByTitleContaining(title);
    }

    @Override
    public Iterable<Post> findAllByOrderByLikesAsc() {
        return postRepository.findAllByOrderByLikesAsc();
    }

    @Override
    public Iterable<Post> findAllTop4() {
        return postRepository.findAllTop4();
    }
}
