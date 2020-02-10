package com.practice.org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.practice.org.model.Organization;

public class OrganizationDAOImpl implements OrganizationDAO {

	private JdbcTemplate jdbcTemplate;

	public OrganizationDAOImpl(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Organization o) {
		String sql = "INSERT INTO org(name,alias,type,status) VALUES (?,?,?,?)";

		return jdbcTemplate.update(sql, o.getName(), o.getAlias(), o.getType(), o.getStatus());
	}

	@Override
	public int update(Organization o) {
		String sql = "UPDATE org SET name=?,alias=?,type=?,status=? WHERE id=?";

		return jdbcTemplate.update(sql, o.getName(), o.getAlias(), o.getType(), o.getStatus(), o.getId());
	}

	@Override
	public Organization get(Integer id) {
		String sql = "SELECT * FROM org WHERE id=" + id;
		ResultSetExtractor<Organization> extractor = new ResultSetExtractor<Organization>() {

			@Override
			public Organization extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String alias = rs.getString("alias");
					String type = rs.getString("type");
					Boolean status = rs.getBoolean("status");

					return new Organization(id, name, alias, type, status);

				}
				return null;
			}
		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM org WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Organization> list() {
		String sql = "SELECT * FROM contact";
		@SuppressWarnings("unchecked")
		List<Organization> orgList = new ArrayList<Organization>((Collection<? extends Organization>) jdbcTemplate.queryForList(sql));

		return orgList;

	}

}
