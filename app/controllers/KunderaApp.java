package controllers;

import java.util.UUID;

import javax.persistence.EntityManager;

import models.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

/**
 *  Simple Controller for Kundera requests
 */
public class KunderaApp extends Controller {

    @Transactional
    public static Result createUser(String username) {
        EntityManager em = JPA.em();

        User user = new User();
        user.setUid(UUID.randomUUID().toString());
        user.setUsername(username);

        em.persist(user);

        return ok("Created user: " + user.getUid() + ": " + username);
    }

    @Transactional(readOnly = true)
    public static Result getUser(String uid) {
        User user = JPA.em().find(User.class, uid);
        return ok("Found user: " + uid + " - " + user.getUsername());
    }
}
