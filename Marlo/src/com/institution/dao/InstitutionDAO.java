package com.institution.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.institution.model.Conexion;
import com.institution.model.Institucion;
import com.institution.model.InstitutionType;
import com.institution.model.LocElements;
import com.institution.model.Location;

/*
 * @autor: Lina Marcela Colorado Vivas
 * Ingteniera de sistemas
 * DAO
 */

public class InstitutionDAO {
	private Conexion con;
	private Connection connection;

	//get var conexion
	public InstitutionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public List<Institucion> listInstitucion() throws SQLException {		
		
		List<Institucion> listInstitucions = new ArrayList<Institucion>();
		PreparedStatement ps = null;
        ResultSet rs = null; 
		
		Connection cone  = con.getConexion();

        String sql = "SELECT ins.id as id, ins.acronym as acronym,ins.name as nam,ins.website_link as web,it.name as insti FROM prueba.institutions ins inner join prueba.institution_types it ON it.id = ins.id";
        
        try {
            ps = cone.prepareStatement(sql); 
            rs = ps.executeQuery();           
            while (rs.next()) 
            {              	
            	int id = rs.getInt("id");            	
    			String acronym = rs.getString("acronym");
    			String nam = rs.getString("nam");
    			String web = rs.getString("web");
    			String insti = rs.getString("insti");    			
    			Institucion institution = new Institucion(id, acronym, nam, web, insti);		
    			listInstitucions.add(institution);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
		return listInstitucions;
	}
	
	
	// get institution id
	public Institucion getInstitutionId(int id) throws SQLException {
		Institucion institution = null;
			
		PreparedStatement ps = null;
	    ResultSet rs = null;       
		Connection cone  = con.getConexion();

		String sql = "SELECT ins.id as id, ins.acronym as acronym,ins.name as nam,ins.website_link as web,ins.institution_type_id as insti FROM prueba.institutions ins WHERE ins.id = "+id;
	        
	        try {
	        	
	            ps = cone.prepareStatement(sql); 
	            rs = ps.executeQuery();
	            while (rs.next()) {
	    			institution = new Institucion(rs.getInt("id"), rs.getString("acronym"), rs.getString("nam"),
	    					rs.getString("web"),rs.getString("insti"));
	    		}            
	            
	            
	        } catch (SQLException e) {
	            System.err.println(e);
	            
	        } finally {
	            try {
	                cone.close();
	            } catch (SQLException e) {
	                System.err.println(e);
	            }
	        }
	        return institution;
	}
	
	public boolean update(Institucion institution) throws SQLException {		
		boolean rowActualizar = false;
		PreparedStatement ps = null;
        ResultSet rs = null;       
		Connection cone  = con.getConexion();				
		
        try {  
        	PreparedStatement stmt = cone.prepareStatement("UPDATE institutions SET acronym = ?, name = ?, website_link= ?, institution_type_id= ? WHERE id = ?");
        	stmt.setString(1, institution.getAcronym());
        	stmt.setString(2, institution.getNam());
        	stmt.setString(3, institution.getWeb());
        	stmt.setString(4, institution.getInsti()); 
        	stmt.setInt(5, institution.getId());
    		stmt.execute();        	
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return rowActualizar;		
	}
	
	public List<Location> listLocations(int id) throws SQLException {
		
		
		List<Location> listLocations = new ArrayList<Location>();
		PreparedStatement ps = null;
        ResultSet rs = null; 
		
		Connection cone  = con.getConexion();

        String sql = "select ilo.id, ilo.city, lem.name  from prueba.institutions_locations ilo   inner join prueba.institutions ins ON ilo.institution_id = ins.id  inner join prueba.loc_elements lem ON ilo.loc_element_id = lem.id  WHERE ins.id = "+id;
        
        try {
            ps = cone.prepareStatement(sql); 
            rs = ps.executeQuery();           
            while (rs.next()) 
            {  
            	
            	int idt = rs.getInt("id");            	
    			String city = rs.getString("city");  
    			String name = rs.getString("name");
    			Location locations = new Location(idt, city, name);		
    			listLocations.add(locations);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
		return listLocations;
	}
	
	public List<Location> listLocations() throws SQLException {		
		
		List<Location> listLocation = new ArrayList<Location>();
		PreparedStatement ps = null;
        ResultSet rs = null; 
		
		Connection cone  = con.getConexion();

        String sql = "select ilo.id, ilo.city from prueba.institutions_locations ilo";
        
        try {
            ps = cone.prepareStatement(sql); 
            rs = ps.executeQuery();           
            while (rs.next()) 
            {  
            	
            	int id = rs.getInt("id");            	
    			String city = rs.getString("city");    			    			
    			Location location = new Location(id, city,"");		
    			listLocation.add(location);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
		return listLocation;
	}
	
	
	public List<InstitutionType> listInstitutionType() throws SQLException {
		
		
		List<InstitutionType> listInstitutionType = new ArrayList<InstitutionType>();
		PreparedStatement ps = null;
        ResultSet rs = null; 
		
		Connection cone  = con.getConexion();

        String sql = "SELECT id, name FROM prueba.institution_types";
        
        try {
            ps = cone.prepareStatement(sql); 
            rs = ps.executeQuery();           
            while (rs.next()) 
            {  
            	
            	int id = rs.getInt("id");            	
    			String name = rs.getString("name");    			    			
    			InstitutionType institutionType = new InstitutionType(id, name);		
    			listInstitutionType.add(institutionType);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
		return listInstitutionType;
	}
	
	public List<LocElements> listElements() throws SQLException {
		
		
		List<LocElements> listElements = new ArrayList<LocElements>();
		PreparedStatement ps = null;
        ResultSet rs = null; 
		
		Connection cone  = con.getConexion();

        String sql = "select id, name from prueba.loc_elements";
        
        try {
            ps = cone.prepareStatement(sql); 
            rs = ps.executeQuery();           
            while (rs.next()) 
            {              	
            	int id = rs.getInt("id");            	
    			String name = rs.getString("name");    			    			
    			LocElements elements = new LocElements(id, name);		
    			listElements.add(elements);
            }
            
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
		return listElements;
	}
	
	
	public boolean insertLocation(int idInt, int idEle, String loca) throws SQLException {	
		
		boolean rowActualizar = false;
		PreparedStatement ps = null;
        ResultSet rs = null;       
		Connection cone  = con.getConexion();				
		
        try {  
        	PreparedStatement stmt = cone.prepareStatement("insert into prueba.institutions_locations (institution_id, loc_element_id, is_headquater, city) values (?,?,1,?);");
        	stmt.setInt(1, idInt);
        	stmt.setInt(2, idEle);
        	stmt.setString(3, loca);        	
    		stmt.execute();        	
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return rowActualizar;		
	}
	
	
	public boolean DeleteLocation(int idLoca) throws SQLException {		
		boolean rowActualizar = false;
		PreparedStatement ps = null;
        ResultSet rs = null;       
		Connection cone  = con.getConexion();			
		
        try {  
        	PreparedStatement stmt = cone.prepareStatement("delete from institutions_locations where id = ?");
        	stmt.setInt(1, idLoca);        	      	
    		stmt.execute();        	
            
        } catch (SQLException e) {
            System.err.println(e);
            
        } finally {
            try {
                cone.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return rowActualizar;		
	}


}
