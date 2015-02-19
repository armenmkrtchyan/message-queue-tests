package com.synisys.test.messaging.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public interface ProjectCostDao {

    public ArrayList<Map<String, Object>> loadCostsByProjectId(Long projectId);

    public void insert(List<Map<String, Object>> costs, Long projectId);

    public BigDecimal loadProjectTotalCost(Long projectId);

}
