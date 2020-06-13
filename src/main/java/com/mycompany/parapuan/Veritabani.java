/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parapuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author eray
 */
public class Veritabani {
    public static Connection connection;
    public static void baglan() {
        
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "sameteray.2";
            
                    try {
                         connection = DriverManager.getConnection(url, user, password);
                         
            PreparedStatement prepareStatement = connection.prepareStatement("select birim from birims");
            ResultSet executeQuery = prepareStatement.executeQuery();
            if(executeQuery.next()) {
                Constants.birim=executeQuery.getFloat("birim");
                System.out.println(Constants.birim);
                
            }
            prepareStatement.close();
            executeQuery.close();
                    }
                    catch ( Exception ex) {
                            System.exit(1);
                    }
                    
    }

    public static Connection getConnection() {
        return connection;
    }
        
        
    }

