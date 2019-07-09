package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.expression.spel.ast.PropertyOrFieldReference;

import it.cofidimpresa.dao.ProfiloDAO;
import it.cofidimpresa.datamodel.ProfiloModel;
import it.cofidimpresa.datamodel.UserModel;

public class DefaultProfiloDAO implements ProfiloDAO{
	
	private static final Logger logger = Logger.getLogger(DefaultProfiloDAO.class);

    private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public ProfiloModel findById(int id) {
		String sql = "SELECT * FROM profilo WHERE ID_PROFILO = ?";
		
		logger.debug("*** Query ***");
		logger.debug(sql);
		logger.debug("*** Parameter ***");
		logger.debug(id);
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ProfiloModel profilo = new ProfiloModel();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				profilo.setId(rs.getString("ID_PROFILO"));
				profilo.setDescrizione(rs.getString("DESCRIZIONE"));
				profilo.setRole(rs.getString("ROLE"));
			}
			rs.close();
			ps.close();
			return profilo;
		} catch (SQLException e) {
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
