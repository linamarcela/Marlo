package com.institution.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingteniera de sistemas
 * Conexion
 */

public class Conexion {
    private Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection cone = null;
    
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL+"?useTimezone=true&serverTimezone=UTC";
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		
	}
    
    
	public void conectar() throws SQLException {
		
		Connection conexion = null;
		String url;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 cone = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
            
	          System.out.println("conexion ok");
        } catch (ClassNotFoundException e) {
        		e.printStackTrace();        		
        	} catch (SQLException e) {
            e.printStackTrace();               
            
            }
    }
     
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public Connection getJdbcConnection() {
		System.out.println("Mostrar 1.6");
		return jdbcConnection;
	}  
	
	public  Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cone = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);         
            
            
            
        } catch(SQLException e)
        {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return cone;  
    }

}
