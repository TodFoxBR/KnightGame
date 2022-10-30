package com.knightgame.br.network;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:postgresql://motty.db.elephantsql.com/ryxynete"); // jdbc:postgresql://localhost:5432/postgres
        config.setUsername("ryxynete");
        config.setPassword("tMsfVTRjYf3Zue2SqGGG8RCjyX9e6h3c");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void handleCloseConnection(Connection connection) {
        try { connection.close(); } catch (Exception ignored) { }
    }

    public static void handleCloseConnection(PreparedStatement statement) {
        try { statement.close(); } catch (Exception ignored) { }
    }

    public static void handleCloseConnection(Statement statement) {
        try { statement.close(); } catch (Exception ignored) { }
    }

}
