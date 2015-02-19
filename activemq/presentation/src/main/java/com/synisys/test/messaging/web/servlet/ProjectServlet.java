package com.synisys.test.messaging.web.servlet;

import com.synisys.test.messaging.web.bean.PortfolioBean;
import com.synisys.test.messaging.web.data.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Armen.Mkrtchyan.
 * @version 1.0
 * @since <pre>Feb 14, 2015</pre>
 */
@WebServlet(name = "ProjectServlet", urlPatterns = "/project/*")
public class ProjectServlet extends HttpServlet {

    private static final AtomicLong ATOMIC_LONG = new AtomicLong(200);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        String projectTitle = req.getParameter("projectTitle");
        String projectDescription = req.getParameter("projectDescription");
        PortfolioBean portfolioBean = (PortfolioBean) req.getSession().getAttribute("portfolioBean");
        Project project = portfolioBean.getCurrentProject();
        if (project == null) {
            project = new Project(ATOMIC_LONG.incrementAndGet(), projectTitle, projectDescription);
            portfolioBean.addProject(project);
        } else {
            project.setDescription(projectDescription);
            project.setTitle(projectTitle);
            portfolioBean.updateProject(project);
        }
    }
}
