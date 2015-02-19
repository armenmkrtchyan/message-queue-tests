package com.synisys.test.messaging.web.bean;

import com.synisys.test.messaging.dao.ProjectDao;
import com.synisys.test.messaging.web.data.PortfolioProject;
import com.synisys.test.messaging.web.data.Project;
import com.synisys.test.messaging.service.ProjectService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.jms.JMSException;
import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Armen.Mkrtchyan.
 */
public class PortfolioBean {

    private static final int PAGE_SIZE = 10;

    private ProjectService projectService;
    private ProjectDao projectDao;

    private Project currentProject;

    public void setContext(ServletContext context) {
        this.projectService = (ProjectService) WebApplicationContextUtils.getRequiredWebApplicationContext(context).getBean("projectService");
    }



    public Project findProject(Long id) {
        Project project = projectService.findProjectById(id);
        project.getProjectCosts().addAll(projectService.findCostsByProject(id));
        this.currentProject = project;
        return project;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void addProject(Project project) {
        projectService.updateProject(project);
        projectService.insertProjectCost(project.getProjectCosts(), project.getProjectId());
    }

    public void updateProject(Project project) {
        projectService.updateProject(project);
        projectService.insertProjectCost(project.getProjectCosts(), project.getProjectId());
    }

    public Integer getPageCount() {
        return (int)Math.ceil(projectService.getProjectCount() / (double)PAGE_SIZE );
    }

    public BigDecimal getProjectTotalCost(Long projectId) {
        return projectService.getProjectTotalCost(projectId);
    }

    public List<PortfolioProject> getProjectsForPage(Integer page) {
        int projectsCount = projectService.getProjectCount();
        int start = (page - 1) * PAGE_SIZE;
        int end = Math.min(projectsCount, start + PAGE_SIZE);

        try {
            return projectService.findByPage(start, end);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }



}
