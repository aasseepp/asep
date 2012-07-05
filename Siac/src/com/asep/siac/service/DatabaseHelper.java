/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asep.siac.service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DatabaseHelper {
    private static Connection connection;
    private static MahasiswaService mahasiswaService;

    public static MahasiswaService getMahasiswaService() {
        if(mahasiswaService==null){
            mahasiswaService=new MahasiswaService();
        }
        return mahasiswaService;
    }

    public static Connection getConnection() {
        if(connection==null){
            try {
                Properties propertie=new Properties();
                propertie.load(DatabaseHelper.class.getResourceAsStream("/com/asep/siac/service/database.properties"));
                
                MysqlDataSource dataSource=new MysqlDataSource();
                dataSource.setUser(propertie.getProperty("username"));
                dataSource.setPassword(propertie.getProperty("password"));
                dataSource.setPort(Integer.valueOf(propertie.getProperty("port")));
                dataSource.setServerName("host");
                dataSource.setDatabaseName("database");
                connection=dataSource.getConnection();
            } catch (    SQLException | IOException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return connection;
    }
    
}
