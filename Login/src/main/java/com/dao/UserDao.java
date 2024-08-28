package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public class UserDao {
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbcTemplateVar;

	public UserDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplateVar = jdbcTemplate;
	}

	public UserDao() {
		super();
	}

	public int insertUser(User user) {
		try {
			return jdbcTemplateVar.update("insert into user values(?,?,?)", user.getEmailid(), user.getPassword(),
					user.getUsertyp());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public int deleteUser(String emailid) {
		try {
			return jdbcTemplateVar.update("delete from user where emailid=?", emailid);
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public int updateUser(User user) {
		try {
			return jdbcTemplateVar.update("update user set usertyp=? where emailid=?", user.getUsertyp(),
					user.getEmailid());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public User getUserWithPassword(User user) {
		try {

			return jdbcTemplateVar.queryForObject(
					"select * from user where emailid= '" + user.getEmailid() + "' and password='" + user.getPassword()+"'",
					new MyRowMapper());

		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	/*
	 * class MyResultSetExtracter implements ResultSetExtractor<User>{ public User
	 * extractData(ResultSet rs) throws SQLException, DataAccessException { // TODO
	 * Auto-generated method stub return null; } }
	 */
	class MyRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setEmailid(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setUsertyp(rs.getString(3));
			return user;
		}

	}
}