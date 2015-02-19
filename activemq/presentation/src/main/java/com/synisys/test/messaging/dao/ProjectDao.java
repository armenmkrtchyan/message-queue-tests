package com.synisys.test.messaging.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public interface ProjectDao {

    public ArrayList<Map<String, Object>> loadPortfolioProjectsInRange(Integer from, Integer to);

    public String getProjectsCount();

    public Map<String, Object> loadProject(Long id);

    public void updateProject(Map<String, Object> project);

}
