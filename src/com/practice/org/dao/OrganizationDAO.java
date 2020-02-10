package com.practice.org.dao;

import java.util.List;


import com.practice.org.model.Organization;

public interface OrganizationDAO {
	public int save(Organization organization);
	
	public int update(Organization organization);
	
	public Organization get(Integer id);
	
	public int delete(Integer id);
	
	public List<Organization> list();

}
