package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.AtecoDAO;
import it.cofidimpresa.datamodel.AtecoModel;

public class DefaultAtecoDAO implements AtecoDAO {
	

	private static final Logger logger = Logger.getLogger(DefaultFinanziamentiDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void removeAteco(Integer idSocio, Integer idAteco) {
		logger.debug("*** Start removeAteco ***");
		String sql = "DELETE FROM socio_ateco WHERE id_socio = ? AND id_ateco = ? ";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ps.setInt(2,idAteco);
			ps.executeUpdate();
			
			logger.debug("*** Query ***");
			logger.debug(sql);

			ps.close();
			logger.debug("*** End removeAteco ***");
		} catch (SQLException e) {
			logger.error("Exception: ", e);
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

	public List<Integer> getAtecoListFromSocio(Integer idSocio) {
		logger.debug("*** Start getAtecoListFromSocio ***");
		String sql = "SELECT * FROM socio_ateco WHERE id_socio = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ResultSet rs = ps.executeQuery();
			List<Integer> result = new ArrayList<Integer>();
			logger.debug("*** Query ***");
			logger.debug(sql);

			logger.debug("*** Parameter ***");
			logger.debug(idSocio);
			while (rs.next()) {
				result.add(rs.getInt("ID_ATECO"));
			}
			rs.close();
			ps.close();
			
			logger.debug("*** End getAtecoListFromSocio ***");
			return result;
		} catch (SQLException e) {
			logger.error("Exception: ", e);
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

	public AtecoModel getAtecoById(Integer idAteco) {
		logger.debug("*** Start getAtecoById ***");
		String sql = "SELECT * FROM ateco WHERE id_ateco = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idAteco);
			ResultSet rs = ps.executeQuery();
			AtecoModel result = new AtecoModel();
			logger.debug("*** Query ***");
			logger.debug(sql);

			logger.debug("*** Parameter ***");
			logger.debug(idAteco);
			if (rs.next()) {
				result.setIdAteco(rs.getInt("ID_ATECO"));
				result.setCodiceAteco(rs.getString("CODICE_ATECO"));
				result.setDescrizione(rs.getString("DESCRIZIONE"));
			}
			rs.close();
			ps.close();
			
			logger.debug("*** End getAtecoById ***");
			return result;
		} catch (SQLException e) {
			logger.error("Exception: ", e);
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

}
