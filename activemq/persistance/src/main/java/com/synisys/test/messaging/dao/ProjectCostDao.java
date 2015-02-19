package com.synisys.test.messaging.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public class ProjectCostDao extends Dao{

    public ProjectCostDao(DataSource dataSource) {
        super(dataSource);
    }

    public ArrayList<Map<String, Object>> loadCostsByProjectId(Long projectId) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT ProjectCostValue FROM ProjectCost WHERE ProjectID = ?");
            statement.setLong(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Map<String, Object>> costs = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> cost = new HashMap<>();
                cost.put("ProjectCostValue", resultSet.getBigDecimal("ProjectCostValue"));
                costs.add(cost);
            }
            return costs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal loadProjectTotalCost(Long projectId) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT SUM(ProjectCostValue) AS TOTAL FROM ProjectCost WHERE ProjectID = ? GROUP BY ProjectID");
            statement.setLong(1, projectId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBigDecimal("TOTAL");
            } else {
                return BigDecimal.ZERO;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void insert(List<Map<String, Object>> costs, Long projectId) {
        try (Connection connection = getConnection()) {
            PreparedStatement pst = connection.prepareStatement("DELETE FROM ProjectCost WHERE ProjectId = ?");
            pst.setLong(1, projectId);
            pst.executeUpdate();
            pst = connection.prepareStatement("INSERT INTO ProjectCost(ProjectCostId, ProjectId, ProjectCostValue) VALUES (?, ?, ?)");
            for (Map<String, Object> cost : costs) {
                pst.setLong(1, (Long) cost.get("ProjectCostId"));
                pst.setLong(2, projectId);
                pst.setBigDecimal(3, (BigDecimal) cost.get("ProjectCostValue"));
                pst.addBatch();
            }
            pst.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
