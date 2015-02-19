package com.synisys.test.messaging.dao;

import javax.sql.DataSource;
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
public class ProjectDao extends Dao {
    public ProjectDao(DataSource dataSource) {
        super(dataSource);
    }

    public ArrayList<Map<String, Object>> loadPortfolioProjectsInRange(Integer from, Integer to) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT Project.* " +
                    "FROM Project  " +
                    "LIMIT ? OFFSET ?");
            statement.setInt(1, to - from);
            statement.setInt(2, from);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Map<String, Object>> maps = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> projectData = new HashMap<>();
                projectData.put("ProjectID", resultSet.getLong("ProjectID"));
                projectData.put("ProjectTitle", resultSet.getString("ProjectTitle"));
                projectData.put("ProjectDescription", resultSet.getString("ProjectDescription"));
                maps.add(projectData);
            }
            return maps;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProjectsCount(){
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM Project");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return String.valueOf(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Something went wrong");
    }

    public Map<String, Object> loadProject(Long id) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Project WHERE ProjectID = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Map<String, Object> projectData = new HashMap<>();
                projectData.put("ProjectID", resultSet.getLong("ProjectID"));
                projectData.put("ProjectTitle", resultSet.getString("ProjectTitle"));
                projectData.put("ProjectDescription", resultSet.getString("ProjectDescription"));
                return projectData;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Something went wrong");
    }

    public void updateProject(Map<String, Object> project) {
        try(Connection connection = getConnection()) {
            PreparedStatement pst = connection.prepareStatement("UPDATE Project SET ProjectTitle = ?, ProjectDescription = ? WHERE ProjectId = ?");
            pst.setString(1, (String) project.get("ProjectTitle"));
            pst.setString(2, (String) project.get("ProjectDescription"));
            pst.setLong(3, (Long) project.get("ProjectId"));
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
