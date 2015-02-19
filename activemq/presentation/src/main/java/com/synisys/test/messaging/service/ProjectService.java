package com.synisys.test.messaging.service;

import com.synisys.test.messaging.dao.ProjectCostDao;
import com.synisys.test.messaging.dao.ProjectDao;
import com.synisys.test.messaging.web.data.PortfolioProject;
import com.synisys.test.messaging.web.data.Project;
import com.synisys.test.messaging.web.data.ProjectCost;

import javax.jms.JMSException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public class ProjectService {

    private final ProjectCostDao projectCostDao;
    private final ProjectDao projectDao;

    public ProjectService(ProjectDao projectDao, ProjectCostDao projectCostDao) {
        this.projectCostDao = projectCostDao;
        this.projectDao = projectDao;
    }

    public List<PortfolioProject> findByPage(Integer from, Integer to) throws JMSException {
        ArrayList<Map<String, Object>> list = projectDao.loadPortfolioProjectsInRange(from, to);
        ArrayList<PortfolioProject> projects = new ArrayList<>();
        for (Map<String, Object> params : list) {
            projects.add(new PortfolioProject((Long)params.get("ProjectID"), (String)params.get("ProjectTitle"),
                    (String)params.get("ProjectDescription"), BigDecimal.ZERO));

        }
        return projects;
    }

    public List<ProjectCost> findCostsByProject(Long projectId) {
        ArrayList<Map<String, Object>> list = projectCostDao.loadCostsByProjectId(projectId);
        ArrayList<ProjectCost> projectsCosts = new ArrayList<>();
        for (Map<String, Object> params : list) {
            projectsCosts.add(new ProjectCost((BigDecimal) params.get("ProjectCostValue")));
        }
        return projectsCosts;
    }

    public Project findProjectById(Long id) {
        Map<String, Object> data = projectDao.loadProject(id);
        return new Project((Long)data.get("ProjectID"), (String)data.get("ProjectTitle"), (String)data.get("ProjectDescription"));
    }

    public void updateProject(Project project) {
        Map<String, Object> map = new HashMap<>();
        map.put("ProjectTitle", project.getTitle());
        map.put("ProjectDescription", project.getDescription());
        map.put("ProjectId", project.getProjectId());
        projectDao.updateProject(map);
    }

    public void insertProjectCost(List<ProjectCost> projectCosts, Long projectId) {
        ArrayList<Map<String, Object>> costsData = new ArrayList<>();
        for (ProjectCost projectCost : projectCosts) {
            Map<String, Object> costData = new HashMap<>();
            costData.put("ProjectCostId", projectCost.getId());
            costData.put("ProjectCostValue", projectCost.getAmount());
            costsData.add(costData);
        }
        projectCostDao.insert(costsData, projectId);
    }

    public Integer getProjectCount() {
        return Integer.valueOf(projectDao.getProjectsCount());
    }

    public BigDecimal getProjectTotalCost(Long projectId) {
        return projectCostDao.loadProjectTotalCost(projectId);
    }
}
