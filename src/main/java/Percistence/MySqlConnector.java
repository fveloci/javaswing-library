/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author matluna
 */
public class MySqlConnector {
    
    private static Connection instance;
    
    private MySqlConnector () throws Exception{
    
    }
    
    public static Connection getInstance() throws Exception {
        try {
            if(instance == null) {
                instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/final", "root", "rootroot") ;
            }
            return instance;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
