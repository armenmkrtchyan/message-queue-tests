package com.synisys.test.messaging.web.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Armen.Mkrtchyan.
 */
public class Project {

    private Long projectId;
    private String title;
    private String description;
    private final List<ProjectCost> projectCosts = new ArrayList<>();

    public Project() {
    }

    public Project(Long projectId, String title, String description) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProjectCost> getProjectCosts() {
        return projectCosts;
    }
}
