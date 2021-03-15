package com.kumuluz.tutorial.resources;

import com.kumuluz.tutorial.entities.HintsEntity;
import com.kumuluz.tutorial.entities.PageEntity;
import com.kumuluz.tutorial.entities.TutorialEntity;
import com.kumuluz.tutorial.services.PageService;
import com.kumuluz.tutorial.services.TutorialService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("tutorial")
public class TutorialResource {

    @Inject
    private TutorialService tutorialService;

    @Inject
    private PageService pageService;

    @GET
    @Path("{tutorialId}")
    public Response getTutorial(@PathParam("tutorialId") Integer tutorialId) {
        TutorialEntity tutorialEntity = tutorialService.getTutorial(tutorialId);
        return tutorialEntity != null
                ? Response.ok(tutorialEntity).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{tutorialId}/page/{pageNumber}")
    public Response getTutorialPage(@PathParam("tutorialId") Integer tutorialId,
                                     @PathParam("pageNumber") Integer pageNumber) {
        PageEntity pageEntity = pageService.getPage(tutorialId, pageNumber);
        return pageEntity != null
                ? Response.ok(pageEntity).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
