package controllers;

import beans.ThymeleafViewResolver;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Objects;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;


@Stateless
@Path("/")
public class HomeController {
    @EJB
    private ThymeleafViewResolver thymeleafViewResolver;

    @Inject
    ServletContext context;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHomepage(@Context HttpServletRequest req, @Context HttpServletResponse response) {
        return thymeleafViewResolver.processView("index", req, response, Collections.emptyMap());
    }

    @GET
    @Path("{path: ^frontend\\/.*}")
    public Response staticResources(@PathParam("path") final String path) {

        InputStream resource = context.getResourceAsStream(String.format("/WEB-INF/%s", path));
        String contentType = URLConnection.guessContentTypeFromName(path);

        return Objects.isNull(resource)
                ? Response.status(NOT_FOUND).build()
                : Response.ok().entity(resource).type(contentType).build();
    }
}

