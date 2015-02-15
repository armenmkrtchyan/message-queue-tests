package com.synisys.test.messaging.web.servlet;

import com.synisys.test.messaging.web.bean.PortfolioBean;
import com.synisys.test.messaging.web.data.Project;
import com.synisys.test.messaging.web.data.ProjectCost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Armen.Mkrtchyan.
 * @version 1.0
 * @since <pre>Feb 14, 2015</pre>
 */
@WebServlet(name = "ProjectCostServlet", urlPatterns = "/projectCost/*")
public class ProjectCostServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        Long costId = Long.valueOf(req.getParameter("projectCostId"));
        PortfolioBean portfolioBean = (PortfolioBean) req.getSession().getAttribute("portfolioBean");
        Project project = portfolioBean.findProject(projectId);
        for (int i = 0; i < project.getProjectCosts().size(); i++) {
            if (project.getProjectCosts().get(i).getId().equals(costId)) {
                project.getProjectCosts().remove(i);
                break;
            }

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        BigDecimal value = new BigDecimal(req.getParameter("projectCost"));
        PortfolioBean portfolioBean = (PortfolioBean) req.getSession().getAttribute("portfolioBean");
        Project project = portfolioBean.findProject(projectId);
        project.getProjectCosts().add(new ProjectCost(value));
    }

}
