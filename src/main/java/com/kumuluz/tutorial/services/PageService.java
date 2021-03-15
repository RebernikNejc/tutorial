package com.kumuluz.tutorial.services;

import com.kumuluz.tutorial.entities.PageEntity;
import com.kumuluz.tutorial.entities.TutorialEntity;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.Optional;

@RequestScoped
@Transactional
public class PageService {

    @PersistenceContext(unitName = "tutorial-jpa")
    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    public PageEntity getPage(Integer tutorialId, Integer pageNumber) {
        TutorialEntity tutorialEntity = em.find(TutorialEntity.class, tutorialId);
        if (tutorialEntity != null) {
            List<PageEntity> pages = (List<PageEntity>) tutorialEntity.getPagesById();
            Optional<PageEntity> optionalPageEntity = pages.stream().filter(
                    pageEntity -> pageNumber.equals(pageEntity.getPosition())).findFirst();
            if (optionalPageEntity.isPresent()) {
                PageEntity page = optionalPageEntity.get();
                if (pageNumber - 1 > 0) {
                    page.setPrev(uriInfo.getAbsolutePathBuilder().replacePath(
                            String.format("v1/tutorial/%d/page/%d", tutorialId, pageNumber - 1)
                    ).toString());
                }
                if (pageNumber + 1 <= pages.size()) {
                    page.setNext(uriInfo.getAbsolutePathBuilder().replacePath(
                            String.format("v1/tutorial/%d/page/%d", tutorialId, pageNumber + 1)
                    ).toString());
                }
                return optionalPageEntity.get();
            }
        }
        return null;
    }
}
