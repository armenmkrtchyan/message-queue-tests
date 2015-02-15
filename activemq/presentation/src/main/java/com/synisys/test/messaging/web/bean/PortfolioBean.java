package com.synisys.test.messaging.web.bean;

import com.synisys.test.messaging.web.data.PortfolioProject;
import com.synisys.test.messaging.web.data.Project;
import com.synisys.test.messaging.web.data.ProjectCost;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Armen.Mkrtchyan.
 */
public class PortfolioBean {

    private static final PortfolioProject[] PORTFOLIO_PROJECTS = new PortfolioProject[100];
    private static final ArrayList<Project> PROJECTS = new ArrayList<>(200);
    private static final int PAGE_SIZE = 10;

    static {
        for (int i = 0; i < 100; i++) {
            PORTFOLIO_PROJECTS[i] = new PortfolioProject((long) i, "Project Title" + i, "Project Description " + i, BigDecimal.TEN.add(BigDecimal.valueOf(i)));
            PROJECTS.add(new Project((long) i, "Project Title" + i, "Project Description " + i));
            for (int j = 0; j < 3; j++) {
                PROJECTS.get(i).getProjectCosts().add(new ProjectCost(BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(1000)).add(BigDecimal.valueOf(j))));
            }
        }
    }


    public Project findProject(Long id) {
        for (Project project : PROJECTS) {
            if (project.getProjectId().equals(id)) {
                return project;
            }
        }
        return new Project();
    }

    public void addProject(Project project) {
        PROJECTS.add(project);
    }

    public Integer getPageCount() {
        return PORTFOLIO_PROJECTS.length / PAGE_SIZE;
    }

    public List<PortfolioProject> getProjectsForPage(Integer page) {
        int start = (page - 1) * PAGE_SIZE;
        return Arrays.asList(Arrays.copyOfRange(PORTFOLIO_PROJECTS, start, start + PAGE_SIZE));
    }

}
