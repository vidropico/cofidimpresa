package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.TipoSocietaDAO;
import it.cofidimpresa.datamodel.StatoSocioModel;
import it.cofidimpresa.datamodel.TipoSocietaModel;

public class DefaultTipoSocietaDAO implements TipoSocietaDAO {

	private static final Logger logger = Logger.getLogger(DefaultStatoSocioDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<TipoSocietaModel> getAllTipoSocieta() {
		logger.debug("*** Start getAllTipoSocieta ***");
		String sql = "SELECT  * FROM tipo_societa";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<TipoSocietaModel> result = new ArrayList<TipoSocietaModel>();

			while (rs.next()) {
				TipoSocietaModel statoSocio = new TipoSocietaModel();
				statoSocio.setIdTipoSocieta(rs.getInt("ID_TIPO_SOCIETA"));
				statoSocio.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(statoSocio);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllTipoSocieta ***");
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
