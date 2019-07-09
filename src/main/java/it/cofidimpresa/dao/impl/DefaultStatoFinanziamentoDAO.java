package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.cofidimpresa.dao.StatoFinanziamentoDAO;
import it.cofidimpresa.datamodel.SettoreImpresaModel;
import it.cofidimpresa.datamodel.StatoFinanziamentiModel;

public class DefaultStatoFinanziamentoDAO implements StatoFinanziamentoDAO{
	
	private static final Logger logger = Logger.getLogger(DefaultStatoFinanziamentoDAO.class);
	
	@Resource(name="dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getStatoFinanziamento(int idStatoFinanziamento) {
		logger.debug("*** Start getStatoFinanziamento ***");
		String sql = "SELECT  * FROM stato_finanziamenti WHERE id_stato_finanziamenti = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idStatoFinanziamento);
			ResultSet rs = ps.executeQuery();
			
			logger.debug("*** Parameter ***");
			logger.debug(idStatoFinanziamento);
			
			String statoFin = StringUtils.EMPTY;

			if (rs.next()) {
				statoFin = rs.getString("DESCRIZIONE");
			}

			rs.close();
			ps.close();
			logger.debug("*** End getStatoFinanziamento ***");
			return statoFin;
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

	public List<StatoFinanziamentiModel> getAllStatoFinanziamenti() {
		logger.debug("*** Start getAllStatoFinanziamenti ***");
		String sql = "SELECT  * FROM stato_finanziamenti";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			
			logger.debug("*** Query ***");
			logger.debug(sql);
			
			List<StatoFinanziamentiModel> result = new ArrayList<StatoFinanziamentiModel>();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				StatoFinanziamentiModel staoFin = new StatoFinanziamentiModel();
				staoFin.setIdStatoFinanziamenti(rs.getInt("ID_STATO_FINANZIAMENTI"));
				staoFin.setDescrizione(rs.getString("DESCRIZIONE"));
				result.add(staoFin);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllStatoFinanziamenti ***");
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
