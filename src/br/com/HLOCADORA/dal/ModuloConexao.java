/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.HLOCADORA.dal;
import java.sql.*;

/**
 *
 * @author Gustavo
 */
public class ModuloConexao {
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/HLocadora?autoReconnect=true&useSSL=false";
        String user = "root";
        String password =  "admin";
        
        try {
            
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            
        } catch (Exception e){
            return null;
            
        }
    }
    
}
