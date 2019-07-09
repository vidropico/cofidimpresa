package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.cofidimpresa.dao.StatoSocioDAO;
import it.cofidimpresa.datamodel.StatoSocioModel;

public class DefaultStatoSocioDAO implements StatoSocioDAO {

	private static final Logger logger = Logger.getLogger(DefaultStatoSocioDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getStatoSocio(int idStatoSocio) {
		logger.debug("*** Start getStatoSocio ***");
		String sql = "SELECT  * FROM stato_socio WHERE id_stato_socio = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idStatoSocio);
			ResultSet rs = ps.executeQuery();
			
			logger.debug("*** Parameter ***");
			logger.debug(idStatoSocio);
			
			String statoSocio = StringUtils.EMPTY;

			if (rs.next()) {
				statoSocio = rs.getString("DESCRIZIONE");
			}

			rs.close();
			ps.close();
			logger.debug("*** End getStatoSocio ***");
			return statoSocio;
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

	public List<StatoSocioModel> getAllStatoSocio() {
		logger.debug("*** Start getAllStatoSocio ***");
		String sql = "SELECT  * FROM stato_socio";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<StatoSocioModel> result = new ArrayList<StatoSocioModel>();

			while (rs.next()) {
				StatoSocioModel statoSocio = new StatoSocioModel();
				statoSocio.setIdStatoSocio(rs.getInt("ID_STATO_SOCIO"));
				statoSocio.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(statoSocio);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getStatoSocio ***");
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
