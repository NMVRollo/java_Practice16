package com.example.Practice16.service;

import com.example.Practice16.models.Dog;
import com.example.Practice16.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DogService {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public User getUserByDog(Long dogId) {
        return session.createQuery("from Dog where id =:id", Dog.class)
                .setParameter("id",dogId).getSingleResult().getUser();
    }

    public List<Dog> getAllDogs() {
        return session.createQuery("from Dog", Dog.class).list();
    }
}
