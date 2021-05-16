package com.cdce_gmc.model;

public class Voter implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String si; 
	private String epic; 
	private String name; 
	private String relationship; 
	private String nameOfRelation; 
	private int age; 
	private String gender; 
	private String ac; 
	private String ward; 
	private String poll; 
	
	public Voter(String epic, String name, String relation, int age, String ward, String poll ) {
		super(); 
		this.epic = epic; 
		this.name = name; 
		this.nameOfRelation = relation; 
		this.age = age; 
		this.ward = ward; 
		this.poll = poll; 
	}

	

	public Voter(String si, String epic, String name, String relationship, String nameOfRelation, int age,
			String gender, String ac, String ward, String poll) {
		super();
		this.si = si;
		this.epic = epic;
		this.name = name;
		this.relationship = relationship;
		this.nameOfRelation = nameOfRelation;
		this.age = age;
		this.gender = gender;
		this.ac = ac;
		this.ward = ward;
		this.poll = poll;
	}



	public String getSi() {
		return si;
	}



	public void setSi(String si) {
		this.si = si;
	}



	public String getEpic() {
		return epic;
	}



	public void setEpic(String epic) {
		this.epic = epic;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRelationship() {
		return relationship;
	}



	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}



	public String getNameOfRelation() {
		return nameOfRelation;
	}



	public void setNameOfRelation(String nameOfRelation) {
		this.nameOfRelation = nameOfRelation;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAc() {
		return ac;
	}



	public void setAc(String ac) {
		this.ac = ac;
	}



	public String getWard() {
		return ward;
	}



	public void setWard(String ward) {
		this.ward = ward;
	}



	public String getPoll() {
		return poll;
	}



	public void setPoll(String poll) {
		this.poll = poll;
	}



	
}
