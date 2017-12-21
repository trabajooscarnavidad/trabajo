/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import config.Configuration;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Miguel Angel Diaz
 */
public class DBConnection {

    private static DBConnection dbconection = null;
    
    private final DataSource hirakiDatasource;
    
    private DBConnection() {
        hirakiDatasource = getDataSourceHikari();
    }

    public static DBConnection getInstance(){
        if (dbconection == null)
            dbconection = new DBConnection();
       
        return dbconection;
    }
    
    public Connection getConnection() throws Exception {
        Class.forName(Configuration.getInstance().getDriverDB());
        Connection connection;

        connection = hirakiDatasource.getConnection();

        return connection;
    }


    private DataSource getDataSourceHikari() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl( Configuration.getInstance().getUrlDB());
        config.setUsername(Configuration.getInstance().getUserDB());
        config.setPassword( Configuration.getInstance().getPassDB());
        config.setDriverClassName(Configuration.getInstance().getDriverDB());
        config.setMaximumPoolSize(10);
        
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource datasource = new HikariDataSource(config);
        return datasource;
    }

    public DataSource getDataSource() {
        return hirakiDatasource;
    }

    public void cerrarConexion(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}