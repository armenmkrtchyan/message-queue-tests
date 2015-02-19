package com.synisys.test.messaging.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author armen mkrtchyan
 * @version 1.0
 */
public abstract class Dao {

    private final DataSource dataSource;

    protected Dao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("could not open connection");
        }
    }
}
