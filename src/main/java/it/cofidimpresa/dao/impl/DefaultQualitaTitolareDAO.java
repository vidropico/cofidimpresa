package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.QualitaTitolareDAO;
import it.cofidimpresa.datamodel.QualitaTitolareModel;

public class DefaultQualitaTitolareDAO implements QualitaTitolareDAO{
	private static final Logger logger = Logger.getLogger(DefaultStatoSocioDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<QualitaTitolareModel> getAllQualitaTitolare() {
		logger.debug("*** Start getAllQualitaTitolare ***");
		String sql = "SELECT  * FROM qualita_titolare";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			logger.debug("*** Query ***");
			logger.debug(sql);

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<QualitaTitolareModel> result = new ArrayList<QualitaTitolareModel>();

			while (rs.next()) {
				QualitaTitolareModel qualitaTitolare = new QualitaTitolareModel();
				qualitaTitolare.setIdQualitaTitolare(rs.getInt("ID_QUALITA_TITOLARE"));
				qualitaTitolare.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(qualitaTitolare);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllQualitaTitolare ***");
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
	

	public List<QualitaTitolareModel> getQualitaTitolareById(Integer idQualitaTitolare) {
		logger.debug("*** Start getQualitaTitolareById ***");
		String sql = "SELECT  * FROM qualita_titolare WHERE ID_QUALITA_TITOLARE = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idQualitaTitolare);
			ResultSet rs = ps.executeQuery();
			
			logger.debug("*** Query ***");
			logger.debug(ps);
			
			List<QualitaTitolareModel> result = new ArrayList<QualitaTitolareModel>();

			while (rs.next()) {
				QualitaTitolareModel qualitaTitolare = new QualitaTitolareModel();
				qualitaTitolare.setIdQualitaTitolare(rs.getInt("ID_QUALITA_TITOLARE"));
				qualitaTitolare.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(qualitaTitolare);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getQualitaTitolareById ***");
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
