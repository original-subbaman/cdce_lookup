package com.cdce_gmc.db;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdce_gmc.model.*;
import java.sql.*; 
public class VoterDao {

	private String tableName;
	public static VoterDao voterDao; 
	private String query = "SELECT epic_no, name, name_of_relation, age, ward_no, polling_station_no FROM ";
	private PreparedStatement ps;
	List<Voter> voterList = new ArrayList<>();
	
	public VoterDao() {
	
	}
	
	public List<Voter> getVoter(HashMap<String, String> searchStrings, String ward) {
		String val = getValueForQuery(searchStrings); 
		String fullQuery = "";
		
		if(ward.equals("All wards")) {
			for(Ward wrd : WardDao.wardList) {
				tableName = new WardTableDao().getTableName(wrd.getWardName()); //returns the table name in db of that particular ward
				fullQuery = createQuery(searchStrings, tableName); 
				executeQuery(fullQuery, val); 
			}
		}else {
			tableName = new WardTableDao().getTableName(ward); //returns the table name in db of that particular ward
			fullQuery = createQuery(searchStrings, tableName);
			executeQuery(fullQuery, val); 
		}
		
		return voterList; 
	}
	
	public String getValueForQuery(HashMap<String, String> searchStrings) {
		String value = ""; 
		for(Map.Entry<String, String> set : searchStrings.entrySet()) {
			String temp = set.getValue(); 
			if(set.getKey().equals("ward")) continue; 
			if(temp.isBlank() || temp.isEmpty()) {
				continue; 
			}else {
				
				value = temp; 
				break; 
			}
		}
		
		return value; 
	}
	
	public String createQuery(HashMap<String, String> searchStrings, String tableName) {
		String fullQuery = query + tableName + " WHERE "; 
		String epic = searchStrings.get("epic"); 
		
		if(!epic.isBlank() || !epic.isEmpty()) {
			fullQuery += "epic_no LIKE ?";
		}
		
		String name = searchStrings.get("name"); 
		if(!name.isBlank() || !name.isEmpty()) {
			fullQuery += "name LIKE ?"; 
		}
		
		String relation = searchStrings.get("relation"); 
		if(!relation.isBlank() || !relation.isEmpty()) {
			fullQuery += "name_of_relation LIKE ?"; 
		}
		return fullQuery; 
		
	}
	
	public void executeQuery(String fullQuery, String val) {
		try { 	
			ps = Dao.getInstance().getConnection().prepareStatement(fullQuery);
			ps.setString(1, "%" + val + "%" );
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				voterList.add(new Voter(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6))); 
			}
			rs.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Dao.getInstance().closeConnection();
		}
	}
	
	
	
	public int getIndexOfFirstNonEmptyString(String[] strings) {
		int index = -1;  
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].isEmpty() == false) {
				index = i; 
				break; 
			}
		}
		return index; 
		
	}
	
	public static VoterDao getInstance() {
		if(voterDao == null) {
			return new VoterDao(); 
		}
		return voterDao; 
	}
	
}
