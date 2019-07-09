package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.BancheDAO;
import it.cofidimpresa.datamodel.BancheModel;
import it.cofidimpresa.datamodel.SettoreImpresaModel;

public class DefaultBancheDAO implements BancheDAO {

	private static final Logger logger = Logger.getLogger(DefaultBancheDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public List<BancheModel> getAllBanche() {
		logger.debug("*** Start getAllBanche ***");
		String sql = "SELECT  * FROM banche";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<BancheModel> result = new ArrayList<BancheModel>();

			while (rs.next()) {
				BancheModel banca = new BancheModel();
				banca.setIdBanche(rs.getInt("ID_BANCHE"));
				banca.setNomeBanche(rs.getString("NOME_BANCHE"));
				banca.setIndirizzoBanche(rs.getString("INDIRIZZO_BANCHE"));
				banca.setFilialeBanche(rs.getString("FILIALE_BANCHE"));
				result.add(banca);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllBanche ***");
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
