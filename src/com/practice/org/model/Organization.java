package com.practice.org.model;

public class Organization {
	private Integer id;
	private String name;
	private String alias;
	private String type;
	private Boolean status;
	
	

	
	public Organization( String name, String alias, String type, Boolean status) {		
		
		this.name = name;
		this.alias = alias;
		this.type = type;
		this.status = status;
	}

	public Organization(Integer id,String name, String alias, String type, Boolean status) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", alias=" + alias + ", type=" + type + ", status="
				+ status + "]";
	}

	

}
