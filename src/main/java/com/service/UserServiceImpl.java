package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DB.DB;
import com.model.User;

public class UserServiceImpl implements UserService {

	/*
	 * @Override public void userSignup(User user) {
	 * 
	 * //write sql, createStatement, execute sql String sql =
	 * "insert into user(fname, lname, username, password) values('"+user.getFname()
	 * +"', '"+user.getLname()+"', '"+user.getUsername()+"', '"+user.getPassword()+
	 * "')";
	 * 
	 * try { Statement stm = DB.getConnection().createStatement();
	 * 
	 * stm.execute(sql);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } }
	 */

	// yesari garda ni hunxa[best]
	@Override
	public void userSignup(User user) {

		// write sql, PreparedStatement, execute sql
		String sql = "insert into user(fname, lname, username, password) values(?, ?, ?, ?)";

		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);

			pstm.setString(1, user.getFname());
			pstm.setString(2, user.getLname());
			pstm.setString(3, user.getUsername());
			pstm.setString(4, user.getPassword());

			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public boolean userLogin(String un, String psw) {

		// write sql, createStatement, execute sql
		String sql = "select * from user where username ='" + un + "' and password ='" + psw + "'";

		try {

			Statement stm = DB.getConnection().createStatement();

			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {

				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<User> getAllUser() {
		
		List<User> ulist = new ArrayList<User>();

		// write sql, createStatement, execute sql
		String sql = "select * from user";

		try {

			Statement stm = DB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				//row mapping to object
				User u = new User();
				
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				ulist.add(u);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ulist;
	}

}
