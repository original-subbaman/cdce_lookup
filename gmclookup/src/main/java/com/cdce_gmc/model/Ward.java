package com.cdce_gmc.model;
 
import java.util.*; 

public class Ward {
	
	private String wardName; 
	private String acName; 
	private List<String> pollingStation; 
	
	public Ward(String wardName, String acName, List<String> pollStation) {
		this.wardName = wardName; 
		this.acName = acName; 
		this.pollingStation = pollStation; 
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public List<String> getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(List<String> pollingStation) {
		this.pollingStation = pollingStation;
	}
	
	

}
