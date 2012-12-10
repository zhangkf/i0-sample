package com.thoughtworks.i0.samples.domain;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 12/10/12
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class RepositoryTest {

    protected EntityManager entityManager;

    public RepositoryTest() {
        entityManager = Persistence.createEntityManagerFactory("domain").createEntityManager();
    }
}
