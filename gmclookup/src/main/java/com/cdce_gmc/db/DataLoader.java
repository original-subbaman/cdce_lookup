package com.cdce_gmc.db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*; 
import com.cdce_gmc.model.Ward;

/**
 * Servlet implementation class DataLoader
 */
public class DataLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao; 
    public DataLoader() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
    	dao = Dao.getInstance();
    	loadWardDetails(); 
    }
    
    @Override
    public void destroy() {
    	try {
    		if(dao.getConnection() != null) {
    			dao.getConnection().close();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace(); 
    	}
    }
	
	private void loadWardDetails(){
		String query = "SELECT * FROM ward_details";
		try {
			ResultSet result = dao.getConnection().prepareStatement(query).executeQuery();  
			String previousWard = ""; 
			int i = 0; 
			while(result.next()) {
				Ward ward; 
				if(previousWard.equals(result.getString("ward_no"))) {
					ward = WardDao.wardList.get(i - 1);
					ward.getPollingStation().add(result.getString("polling_station")); 
				}else {
					List<String> pollList = new ArrayList<>(); 
					pollList.add(result.getString("polling_station")); 
					WardDao.wardList.add(new Ward(result.getString("ward_no"),
							result.getString("ac_no"), 
							pollList));	
					i += 1; 
				}
				
				previousWard = result.getString("ward_no");
				
			}
			result.close();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			Dao.getInstance().closeConnection();
		}
		
	}
	
}
