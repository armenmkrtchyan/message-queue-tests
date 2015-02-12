package com.synisys.test.messaging.web.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Armen.Mkrtchyan.
 */
public class Project {

    private String title;
    private String description;
    private final List<ProjectCost> projectCosts = new ArrayList<>();

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
