package com.practice.org.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.practice.org.model.Organization;

public class OrganizationDAOTest {
	private DriverManagerDataSource dataSource;
	private OrganizationDAO dao;
	private Boolean TRUE;
	
	@BeforeEach
	void SetupBeforeEach() {
		
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/org?verifyServerCertificate=false&useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao=new OrganizationDAOImpl(dataSource);
		
	}
	@Test
	void testSave() {		
		
		Organization org=new Organization("tech","tf","Academic",TRUE);
		int result =dao.save(org);
		
		assertTrue(result >0);
	}

}
