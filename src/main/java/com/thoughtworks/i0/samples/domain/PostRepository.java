package com.thoughtworks.i0.samples.domain;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

class PostRepository {

    private EntityManager entityManager;

    @Inject
    public PostRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public long save(Post post) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(post);
        transaction.commit();
        return post.getId();
    }

    public List<Post> getAll() {
        return entityManager.createQuery("select p from Post p", Post.class).getResultList();
    }
}
