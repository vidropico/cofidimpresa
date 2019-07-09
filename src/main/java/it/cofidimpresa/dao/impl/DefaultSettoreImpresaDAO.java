package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.SettoreImpresaDAO;
import it.cofidimpresa.datamodel.QualitaTitolareModel;
import it.cofidimpresa.datamodel.SettoreImpresaModel;

public class DefaultSettoreImpresaDAO implements SettoreImpresaDAO {

	private static final Logger logger = Logger.getLogger(DefaultStatoSocioDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<SettoreImpresaModel> getAllSettoreImpresa() {
		logger.debug("*** Start getAllSettoreImpresa ***");
		String sql = "SELECT  * FROM settore_impresa";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<SettoreImpresaModel> result = new ArrayList<SettoreImpresaModel>();

			while (rs.next()) {
				SettoreImpresaModel settoreImpresa = new SettoreImpresaModel();
				settoreImpresa.setIdSettoreImpresa(rs.getInt("ID_SETTORE_IMPRESA"));
				settoreImpresa.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(settoreImpresa);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllSettoreImpresa ***");
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
