package com.example.postsmanager.repo;

import com.example.postsmanager.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findAllByTitleContaining(String title);

    Iterable<Post> findAllByOrderByLikesAsc();

    @Query(nativeQuery = true, value = "select * from post order by id DESC limit 4")
    Iterable<Post> findAllTop4();
}
