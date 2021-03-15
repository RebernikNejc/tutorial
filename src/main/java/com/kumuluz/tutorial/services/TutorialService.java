package com.kumuluz.tutorial.services;

import com.kumuluz.tutorial.entities.TutorialEntity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public class TutorialService {

    @PersistenceContext(unitName = "tutorial-jpa")
    private EntityManager em;

    public TutorialEntity getTutorial(Integer tutorialId) {
        return em.find(TutorialEntity.class, tutorialId);
    }

    public TutorialEntity createTutorial(TutorialEntity tutorialEntity) {
        em.persist(tutorialEntity);
        return tutorialEntity;
    }
}
