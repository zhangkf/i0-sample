package com.thoughtworks.i0.samples.domain;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class PostRepositoryTest extends RepositoryTest {

    private PostRepository repository;

    public PostRepositoryTest() {
        repository = new PostRepository(entityManager);
    }

    @Test
    public void should_save_post_to_db(){
        Post post = new Post("title", "content");
        long postId = repository.save(post);
        List<Post> resultList = entityManager.createQuery("select p from Post p", Post.class).getResultList();
        assertThat(postId, not(0l));
        assertThat(resultList.get(0).getTitle(), is("title"));

    }

    @Test
    public void should_get_all_posts_from_db(){
        List<Post> posts = repository.getAll();
        assertThat(posts.size(), is(0));

        repository.save(new Post("t1", "c1"));
        repository.save(new Post("t2", "c2"));
        assertThat(repository.getAll().size(), is(2));

    }

}
