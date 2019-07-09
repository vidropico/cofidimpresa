package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.ControgaranziaDAO;
import it.cofidimpresa.datamodel.GaranziaModel;
import it.cofidimpresa.datamodel.StatoFinanziamentiModel;

public class DefaultControgaranziaDAO implements ControgaranziaDAO {

private static final Logger logger = Logger.getLogger(DefaultStatoFinanziamentoDAO.class);
	
	@Resource(name="dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<GaranziaModel> getAllGaranzia() {
		logger.debug("*** Start getAllGaranzia ***");
		String sql = "SELECT  * FROM garanzia ORDER BY (ID_GARANZIA)";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			List<GaranziaModel> result = new ArrayList<GaranziaModel>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				GaranziaModel garanzia = new GaranziaModel();
				garanzia.setIdGaranzia(rs.getInt("ID_GARANZIA"));
				garanzia.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(garanzia);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllGaranzia ***");
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
