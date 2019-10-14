package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.AntiriciclaggioDAO;
import it.cofidimpresa.datamodel.AntiriciclaggioModel;
import it.cofidimpresa.datamodel.AntiriciclaggioTmpModel;

public class DefaultAntiriciclaggioDAO implements AntiriciclaggioDAO {

	private static final Logger logger = Logger.getLogger(DefaultFinanziamentiDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int inserisciAntiriciclaggio(AntiriciclaggioModel antModel) {
		logger.debug("*** Start inserisciAntiriciclaggio ***");

		String sql = "INSERT INTO antiriciclaggio(ID_SOCI, ID_DOCUMENTO, "
				+ "NUMERO_DOCUMENTO, DATA_RILASCIO, DATA_SCADENZA, LUOGO_RILASCIO, AUTORITA_COMPETENTE,"
				+ "DATA_INSERIMENTO, FLAG_STAMPA, FLAG_INSCOMPLETO,"
				+ "ID_FINANZIAMENTO, NOMINATIVO, NUMERO_PROGRESSIVO, ANNO_PROGRESSIVO) VALUES ("
				+ "?,?,?,?,?,?,?,?,0,0,?,?,?,?" + ")";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, antModel.getIdSoci());
			ps.setString(2, antModel.getIdDocumento());
			ps.setString(3, antModel.getNumeroDocumento());
			ps.setString(4, antModel.getDataRilascio());
			ps.setString(5, antModel.getDataScadenza());
			ps.setString(6, antModel.getLuogoRilascio());
			ps.setString(7, antModel.getAutoritaCompetente());
			if(antModel.getDataInserimento()!=null) {
				ps.setDate(8, new Date(createDate(antModel.getDataInserimento())));
			}else {
				ps.setNull(8, java.sql.Types.DATE);
			}
			ps.setInt(9, antModel.getIdFinanziamento());
			ps.setString(10, antModel.getNominativo());
			ps.setInt(11, antModel.getNumeroProgressivo());
			ps.setInt(12, antModel.getAnnoProgressivo());

			logger.debug("*** Query ***");
			logger.debug(ps);

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			Integer idAntiriciclaggio = -1;
			if (rs.next()) {
				idAntiriciclaggio = rs.getInt("GENERATED_KEY");
			} else {
				throw new SQLException("Error to insert row");
			}

			rs.close();
			ps.close();
			logger.debug("*** End inserisciAntiriciclaggio ***");
			return idAntiriciclaggio;
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

	public int updateAntiriciclaggio(AntiriciclaggioModel antModel) {
		logger.debug("*** Start updateAntiriciclaggio ***");

		String sql = "UPDATE antiriciclaggio SET ID_DOCUMENTO =?, "
				+ "NUMERO_DOCUMENTO=?, DATA_RILASCIO=?, DATA_SCADENZA=?, LUOGO_RILASCIO=?, AUTORITA_COMPETENTE=?,"
				+ " NOMINATIVO = ? WHERE ID_ANTIRICICLAGGIO=?";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, antModel.getIdDocumento());
			ps.setString(2, antModel.getNumeroDocumento());
			ps.setString(3, antModel.getDataRilascio());
			ps.setString(4, antModel.getDataScadenza());
			ps.setString(5, antModel.getLuogoRilascio());
			ps.setString(6, antModel.getAutoritaCompetente());
			ps.setString(7, antModel.getNominativo());
			ps.setInt(8, antModel.getIdAntiriciclaggio());

			logger.debug("*** Query ***");
			logger.debug(ps);

			int result = ps.executeUpdate();

			ps.close();
			logger.debug("*** End updateAntiriciclaggio ***");
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

	public int maxNumeroProgressivo(String year) {
		logger.debug("*** Start maxNumeroProgressivo ***");

		String sql = "SELECT * FROM antiriciclaggio WHERE anno_progressivo=? order by numero_progressivo desc ";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setObject(1, Integer.valueOf(year));

			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			Integer numeroProgressivo = -1;
			if (rs.next()) {
				numeroProgressivo = rs.getInt("NUMERO_PROGRESSIVO");
			}else {
				numeroProgressivo = 0;
			}
			rs.close();
			ps.close();
			logger.debug("*** End maxNumeroProgressivo ***");
			return numeroProgressivo;
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

	public List<AntiriciclaggioModel> getAntiriciclaggioById(Integer idAnt) {
		logger.debug("*** Start getAntiriciclaggioById ***");

		String sql = "SELECT * FROM antiriciclaggio WHERE id_antiriciclaggio=? ";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, idAnt);

			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();

			while (rs.next()) {
				AntiriciclaggioModel ant = new AntiriciclaggioModel();
				ant.setAnnoProgressivo(rs.getInt("ANNO_PROGRESSIVO"));
				ant.setAutoritaCompetente(rs.getString("AUTORITA_COMPETENTE"));
				ant.setDataInserimento(rs.getDate("DATA_INSERIMENTO"));
				ant.setDataRilascio(rs.getString("DATA_RILASCIO"));
				ant.setDataScadenza(rs.getString("DATA_SCADENZA"));
				ant.setFlagInsCompleto(rs.getInt("FLAG_INSCOMPLETO"));
				ant.setFlagStampa(rs.getInt("FLAG_STAMPA"));
				ant.setIdAntiriciclaggio(rs.getInt("ID_ANTIRICICLAGGIO"));
				ant.setIdDocumento(rs.getString("ID_DOCUMENTO"));
				ant.setIdFinanziamento(rs.getInt("ID_FINANZIAMENTO"));
				ant.setIdSoci(rs.getInt("ID_SOCI"));
				ant.setLuogoRilascio(rs.getString("LUOGO_RILASCIO"));
				ant.setNominativo(rs.getString("NOMINATIVO"));
				ant.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
				ant.setNumeroProgressivo(rs.getInt("NUMERO_PROGRESSIVO"));
				result.add(ant);
			}
			rs.close();
			ps.close();
			logger.debug("*** End getAntiriciclaggioById ***");
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

	public List<AntiriciclaggioModel> getAntiriciclaggioByIdFin(Integer idFin) {
		logger.debug("*** Start getAntiriciclaggioById ***");

		String sql = "SELECT * FROM antiriciclaggio WHERE id_finanziamento=? ";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, idFin);

			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();

			while (rs.next()) {
				AntiriciclaggioModel ant = new AntiriciclaggioModel();
				ant.setAnnoProgressivo(rs.getInt("ANNO_PROGRESSIVO"));
				ant.setAutoritaCompetente(rs.getString("AUTORITA_COMPETENTE"));
				ant.setDataInserimento(rs.getDate("DATA_INSERIMENTO"));
				ant.setDataRilascio(rs.getString("DATA_RILASCIO"));
				ant.setDataScadenza(rs.getString("DATA_SCADENZA"));
				ant.setFlagInsCompleto(rs.getInt("FLAG_INSCOMPLETO"));
				ant.setFlagStampa(rs.getInt("FLAG_STAMPA"));
				ant.setIdAntiriciclaggio(rs.getInt("ID_ANTIRICICLAGGIO"));
				ant.setIdDocumento(rs.getString("ID_DOCUMENTO"));
				ant.setIdFinanziamento(rs.getInt("ID_FINANZIAMENTO"));
				ant.setIdSoci(rs.getInt("ID_SOCI"));
				ant.setLuogoRilascio(rs.getString("LUOGO_RILASCIO"));
				ant.setNominativo(rs.getString("NOMINATIVO"));
				ant.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
				ant.setNumeroProgressivo(rs.getInt("NUMERO_PROGRESSIVO"));
				result.add(ant);
			}
			rs.close();
			ps.close();
			logger.debug("*** End getAntiriciclaggioById ***");
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

	public List<AntiriciclaggioModel> elencoAntiriciclaggio() {
		logger.debug("*** Start elencoAntiriciclaggio ***");

		String sql = "SELECT * FROM antiriciclaggio";

		Connection conn = null;

		try {

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();

			while (rs.next()) {
				AntiriciclaggioModel ant = new AntiriciclaggioModel();
				ant.setAnnoProgressivo(rs.getInt("ANNO_PROGRESSIVO"));
				ant.setAutoritaCompetente(rs.getString("AUTORITA_COMPETENTE"));
				ant.setDataInserimento(rs.getDate("DATA_INSERIMENTO"));
				ant.setDataRilascio(rs.getString("DATA_RILASCIO"));
				ant.setDataScadenza(rs.getString("DATA_SCADENZA"));
				ant.setFlagInsCompleto(rs.getInt("FLAG_INSCOMPLETO"));
				ant.setFlagStampa(rs.getInt("FLAG_STAMPA"));
				ant.setIdAntiriciclaggio(rs.getInt("ID_ANTIRICICLAGGIO"));
				ant.setIdDocumento(rs.getString("ID_DOCUMENTO"));
				ant.setIdFinanziamento(rs.getInt("ID_FINANZIAMENTO"));
				ant.setIdSoci(rs.getInt("ID_SOCI"));
				ant.setLuogoRilascio(rs.getString("LUOGO_RILASCIO"));
				ant.setNominativo(rs.getString("NOMINATIVO"));
				ant.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
				ant.setNumeroProgressivo(rs.getInt("NUMERO_PROGRESSIVO"));
				result.add(ant);
			}
			rs.close();
			ps.close();
			logger.debug("*** End elencoAntiriciclaggio ***");
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
	
	private Long createDate(java.util.Date date) {
		if (date!=null)
			return date.getTime();
		return null;
	}

}
