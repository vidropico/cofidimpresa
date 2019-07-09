package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.UserDAO;
import it.cofidimpresa.datamodel.UserModel;

public class DefaultUserDAO implements UserDAO {
	
	private static final Logger logger = Logger.getLogger(DefaultUserDAO.class);
    
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public void insert(UserModel customer) {
		
		logger.debug("*** Start insert user ***");
		
		String sql = "INSERT INTO utente " + 
				"(NOME," + 
				"COGNOME," + 
				"TELEFONO," + 
				"EMAIL," + 
				"ID_PROFILO," + 
				"USERID," + 
				"PASSWORD)" + 
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getNome());
			ps.setString(2, customer.getCognome());
			ps.setString(3, customer.getTelefono());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getId_profilo());
			ps.setString(6, customer.getUserid());
			ps.setString(7, customer.getPassword());
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			logger.debug("*** Parameter ***");
			logger.debug(customer.getNome()+","+customer.getCognome()+","
			+customer.getTelefono()+","+customer.getEmail()+","+customer.getId_profilo()+","+customer.getUserid());
			
			ps.executeUpdate();
			ps.close();
			logger.debug("*** End insert user ***");
		} catch (SQLException e) {
			logger.error("Exception: ",e);
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
	}

	public UserModel findByUsername(String username) {
		logger.debug("*** Start findUserByUserName ***");
		String sql = "SELECT * FROM utente WHERE USERID = ?";
		
		Connection conn = null;
		
		try {
			logger.debug("*** Query ***");
			logger.debug(sql);
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			logger.debug("*** Parameter ***");
			logger.debug(username);
			UserModel user = new UserModel();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setNome(rs.getString("NOME"));
				user.setCognome(rs.getString("COGNOME"));
				user.setTelefono(rs.getString("TELEFONO"));
				user.setEmail(rs.getString("EMAIL"));
				user.setId_profilo(rs.getInt("ID_PROFILO"));
				user.setUserid(rs.getString("USERID"));
				user.setPassword(rs.getString("PASSWORD"));
			}
				
			rs.close();
			ps.close();
			logger.debug("*** End findUserByUserName ***");
			return user;
		} catch (SQLException e) {
			logger.error("Exception: ",e);
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	

}
