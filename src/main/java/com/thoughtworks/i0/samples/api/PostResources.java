package com.thoughtworks.i0.samples.api;

import com.thoughtworks.i0.samples.domain.Post;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostResources {

    private EntityManager entityManager;

    @Inject
    public PostResources(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GET
    public List<Post> all() {
        return entityManager.createQuery("select p from Post p", Post.class).getResultList();
    }
}
