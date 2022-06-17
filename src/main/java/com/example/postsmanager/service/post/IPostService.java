package com.example.postsmanager.service.post;

import com.example.postsmanager.model.Post;
import com.example.postsmanager.service.IGeneralService;

public interface IPostService extends IGeneralService<Post> {
    Iterable<Post> findAllByTitleContaining(String title);

    Iterable<Post> findAllByOrderByLikesAsc();

    Iterable<Post> findAllTop4();
}
