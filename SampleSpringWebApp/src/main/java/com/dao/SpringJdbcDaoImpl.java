package com.dao;


	 
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.beans.VngMem;
	 
	public class SpringJdbcDaoImpl implements SpringJdbcDao {
	 
		private JdbcTemplate jdbcTemplate;
	 
		public void setDataSource(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	 
		public void insertMemDts(VngMem contact) {
	 
			String query = "insert into vng_mem (NAME,DOB,EMAIL,PHONE,ADDRESS,PINCODE,COUNTRY)"
					+ " VALUES (?,?,?,?,?,?,?)";
	 
			jdbcTemplate.update(query,new Object[] { contact.getName(), contact.getDob(),contact.getEmail(), contact.getPhone(),contact.getAddress(), contact.getPincode(),contact.getCountry() });
	 
		}
	 
		// @Override
		public VngMem searchMemDts(VngMem vngmem) {
	 
			String queryinitial = "select * from vng_mem where NAME ='"
					+ vngmem.getName() + "'";
	 
			System.out.println("query formed with all the argument - "
					+ queryinitial);
	 
			@SuppressWarnings({ "rawtypes", "unused" })
			RowMapper rm = null;// = new RowMapper() ;
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List listcontacct = jdbcTemplate.query(queryinitial,
					new RowMapper() {
						public Object mapRow1(ResultSet resultSet, int rowNum)
								throws SQLException {
							return new VngMem(resultSet.getString("name"),
									resultSet.getString("dob"), resultSet
											.getString("email"), resultSet
											.getString("phone"), resultSet
											.getString("address"), resultSet
											.getLong("PINCODE"), resultSet
											.getString("country"));
						}

						public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
							// TODO Auto-generated method stub
							return null;
						}
					});
	 
			if (listcontacct.size() > 0)
				return (VngMem) listcontacct.get(0);
	 
			return new VngMem(queryinitial, queryinitial, queryinitial, queryinitial, queryinitial, 0, queryinitial);
		}
	 
	}


