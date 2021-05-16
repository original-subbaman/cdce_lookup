package com.cdce_gmc.db;

import java.sql.*; 
public class WardTableDao {
	private Dao dao; 
	private PreparedStatement ps; 
	private String query = "SELECT db_table FROM ward_db_table WHERE ward=?"; 
	public WardTableDao() {
		dao = Dao.getInstance(); 
	}
	
	public String getTableName(String ward) {
		String tableName = ""; 
		try {
			ps = dao.getConnection().prepareStatement(query);
			ps.setString(1, ward);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
				tableName = rs.getString(1); 
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.closeConnection();
		}
		
		return tableName; 
	}
}
