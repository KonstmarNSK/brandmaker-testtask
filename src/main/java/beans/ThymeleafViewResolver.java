package beans;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Singleton
public class ThymeleafViewResolver {

    @Inject
    private ServletContext servletContext;
    private TemplateEngine thymeleafEngine;

    @PostConstruct
    public void initThymeleafEngine() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/WEB-INF/frontend/");
        templateResolver.setSuffix(".html");

        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCacheable(true);
        thymeleafEngine = new TemplateEngine();
        thymeleafEngine.setTemplateResolver(templateResolver);
    }

    public String processView(String view, HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model) {
        WebContext ctx = new WebContext(req, resp, servletContext, req.getLocale());
        ctx.setVariables(model);

        return thymeleafEngine.process(view, ctx);
    }
}
