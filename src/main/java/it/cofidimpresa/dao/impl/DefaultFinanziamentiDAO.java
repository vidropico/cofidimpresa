package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cofidimpresa.dao.FinanziamentiDAO;
import it.cofidimpresa.datamodel.FinanziamentiModel;

public class DefaultFinanziamentiDAO implements FinanziamentiDAO {

	private static final Logger logger = Logger.getLogger(DefaultFinanziamentiDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int getNumAllFinanziamenti() {
		logger.debug("*** Start getNumAllFinanziamenti ***");
		String sql = "SELECT  COUNT(id_finanziamenti) as numFin FROM finanziamenti ";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int size = 0;

			if (rs.next()) {
				size = rs.getInt("numFin");
			}

			logger.debug("*** Query ***");
			logger.debug(sql);

			rs.close();
			ps.close();
			logger.debug("*** End getNumAllFinanziamenti ***");
			return size;
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

	public int getNumFinanziamentiSocio(int idSocio) {
		logger.debug("*** Start getNumFinanziamentiSocio ***");
		String sql = "SELECT  COUNT(id_finanziamenti) as numFin FROM finanziamenti WHERE id_soci = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			logger.debug("*** Query ***");
			logger.debug(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ResultSet rs = ps.executeQuery();
			logger.debug("*** Parameter ***");
			logger.debug(idSocio);
			int numFinanziamentiSocio = 0;

			if (rs.next()) {
				numFinanziamentiSocio = rs.getInt("numFin");
			}

			rs.close();
			ps.close();
			logger.debug("*** End getNumAllFinanziamenti ***");
			return numFinanziamentiSocio;
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

	public List<FinanziamentiModel> getAllFinanziamenti() {
		logger.debug("*** Start getAllFinanziamenti ***");
		String sql = "SELECT  * FROM finanziamenti ";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<FinanziamentiModel> result = new ArrayList<FinanziamentiModel>();

			logger.debug("*** Query ***");
			logger.debug(sql);

			while (rs.next()) {
				FinanziamentiModel fin = new FinanziamentiModel();

				fin.setIdFinanziamenti(rs.getInt("ID_FINANZIAMENTI"));
				fin.setIdSoci(rs.getInt("ID_SOCI"));
				fin.setIdUtente(rs.getInt("ID_UTENTE"));
				fin.setIdStatoFinanziamenti(rs.getInt("ID_STATO_FINANZIAMENTI"));
				fin.setIdBanche(rs.getInt("ID_BANCHE"));
				fin.setPagamento(rs.getInt("PAGAMENTO"));
				fin.setImportoGaranzia(rs.getDouble("IMPORTO_GARANZIA"));
				fin.setIdGaranzia(rs.getInt("ID_GARANZIA"));
				fin.setImportoDeliberato(rs.getInt("IMPORTO_DELIBERATO"));
				fin.setCostoIstruttoria(rs.getDouble("COSTO_ISTRUTTORIA"));
				fin.setDataApprovazioneConsiglio(rs.getDate("DATA_APPROVAZIONE_CONSIGLIO"));
				fin.setDataErogazioneFinanziamento(rs.getDate("DATA_EROGAZIONE_FINANZIAMENTO"));
				fin.setDataFineFinanziamento(rs.getDate("DATA_FINE_FINANZIAMENTO"));
				fin.setImporto(rs.getString("IMPORTO"));
				fin.setRate(rs.getString("RATE"));
				fin.setPercentualeGaranzia(rs.getString("PERCENTUALE_GARANZIA"));
				fin.setImportoRata(rs.getString("IMPORTO_RATA"));
				fin.setCosti(rs.getString("COSTI"));
				fin.setNaturaFinanziamento(rs.getString("NATURA_FINANZIAMENTO"));
				fin.setNote(rs.getString("NOTE"));
				fin.setRateScadute(rs.getString("RATE_SCADUTE"));
				fin.setImportoScaduto(rs.getString("IMPORTO_SCADUTO"));
				fin.setTipologiaRientro(rs.getString("TIPOLOGIA_RIENTRO"));
				fin.setPianoRientro(rs.getString("PIANO_RIENTRO"));
				fin.setNomeAvvocato(rs.getString("NOME_AVVOCATO"));
				fin.setAzioni(rs.getString("AZIONI"));
				fin.setRisultato(rs.getString("RISULTATO"));
				fin.setImportoRichiesto(rs.getString("IMPORTO_RICHIESTO"));
				fin.setAccredito(rs.getString("ACCREDITO"));
				fin.setIstruttoriaBanca(rs.getString("ISTRUTTORIA_BANCA"));
				fin.setImpQuotaBanca(rs.getString("IMP_QUOTE_BANCA"));
				fin.setFlgUsura(rs.getInt("FLG_USURA"));
				result.add(fin);

			}

			rs.close();
			ps.close();
			logger.debug("*** End getAllFinanziamenti ***");
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

	public FinanziamentiModel getFinanziamentoById(int idFinanziamento) {
		logger.debug("*** Start getFinanziamentoById ***");
		String sql = "SELECT  * FROM finanziamenti WHERE ID_FINANZIAMENTI = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idFinanziamento);
			ResultSet rs = ps.executeQuery();
			FinanziamentiModel fin = new FinanziamentiModel();

			logger.debug("*** Query ***");
			logger.debug(ps);

			while (rs.next()) {
				fin.setIdFinanziamenti(rs.getInt("ID_FINANZIAMENTI"));
				fin.setIdSoci(rs.getInt("ID_SOCI"));
				fin.setIdUtente(rs.getInt("ID_UTENTE"));
				fin.setIdStatoFinanziamenti(rs.getInt("ID_STATO_FINANZIAMENTI"));
				fin.setIdBanche(rs.getInt("ID_BANCHE"));
				fin.setPagamento(rs.getInt("PAGAMENTO"));
				fin.setImportoGaranzia(rs.getDouble("IMPORTO_GARANZIA"));
				fin.setIdGaranzia(rs.getInt("ID_GARANZIA"));
				fin.setImportoDeliberato(rs.getInt("IMPORTO_DELIBERATO"));
				fin.setCostoIstruttoria(rs.getDouble("COSTO_ISTRUTTORIA"));
				fin.setDataApprovazioneConsiglio(rs.getDate("DATA_APPROVAZIONE_CONSIGLIO"));
				fin.setDataErogazioneFinanziamento(rs.getDate("DATA_EROGAZIONE_FINANZIAMENTO"));
				fin.setDataFineFinanziamento(rs.getDate("DATA_FINE_FINANZIAMENTO"));
				fin.setImporto(rs.getString("IMPORTO"));
				fin.setRate(rs.getString("RATE"));
				fin.setPercentualeGaranzia(rs.getString("PERCENTUALE_GARANZIA"));
				fin.setImportoRata(rs.getString("IMPORTO_RATA"));
				fin.setCosti(rs.getString("COSTI"));
				fin.setNaturaFinanziamento(rs.getString("NATURA_FINANZIAMENTO"));
				fin.setNote(rs.getString("NOTE"));
				fin.setRateScadute(rs.getString("RATE_SCADUTE"));
				fin.setImportoScaduto(rs.getString("IMPORTO_SCADUTO"));
				fin.setTipologiaRientro(rs.getString("TIPOLOGIA_RIENTRO"));
				fin.setPianoRientro(rs.getString("PIANO_RIENTRO"));
				fin.setNomeAvvocato(rs.getString("NOME_AVVOCATO"));
				fin.setAzioni(rs.getString("AZIONI"));
				fin.setRisultato(rs.getString("RISULTATO"));
				fin.setImportoRichiesto(rs.getString("IMPORTO_RICHIESTO"));
				fin.setRateRichieste(rs.getString("RATE_RICHIESTE"));
				fin.setAccredito(rs.getString("ACCREDITO"));
				fin.setIstruttoriaBanca(rs.getString("ISTRUTTORIA_BANCA"));
				fin.setImpQuotaBanca(rs.getString("IMP_QUOTE_BANCA"));
				fin.setFlgUsura(rs.getInt("FLG_USURA"));

			}

			rs.close();
			ps.close();
			logger.debug("*** End getFinanziamentoById ***");
			return fin;
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

	public List<FinanziamentiModel> getFinanziamentiBySocio(int idSocio) {
		logger.debug("*** Start getFinanziamentoById ***");
		String sql = "SELECT  * FROM finanziamenti WHERE ID_SOCI = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ResultSet rs = ps.executeQuery();
			List<FinanziamentiModel> result = new ArrayList<FinanziamentiModel>();

			logger.debug("*** Query ***");
			logger.debug(sql);

			while (rs.next()) {
				FinanziamentiModel fin = new FinanziamentiModel();
				fin.setIdFinanziamenti(rs.getInt("ID_FINANZIAMENTI"));
				fin.setIdSoci(rs.getInt("ID_SOCI"));
				fin.setIdUtente(rs.getInt("ID_UTENTE"));
				fin.setIdStatoFinanziamenti(rs.getInt("ID_STATO_FINANZIAMENTI"));
				fin.setIdBanche(rs.getInt("ID_BANCHE"));
				fin.setPagamento(rs.getInt("PAGAMENTO"));
				fin.setImportoGaranzia(rs.getDouble("IMPORTO_GARANZIA"));
				fin.setIdGaranzia(rs.getInt("ID_GARANZIA"));
				fin.setImportoDeliberato(rs.getInt("IMPORTO_DELIBERATO"));
				fin.setCostoIstruttoria(rs.getDouble("COSTO_ISTRUTTORIA"));
				fin.setDataApprovazioneConsiglio(rs.getDate("DATA_APPROVAZIONE_CONSIGLIO"));
				fin.setDataErogazioneFinanziamento(rs.getDate("DATA_EROGAZIONE_FINANZIAMENTO"));
				fin.setDataFineFinanziamento(rs.getDate("DATA_FINE_FINANZIAMENTO"));
				fin.setImporto(rs.getString("IMPORTO"));
				fin.setRate(rs.getString("RATE"));
				fin.setPercentualeGaranzia(rs.getString("PERCENTUALE_GARANZIA"));
				fin.setImportoRata(rs.getString("IMPORTO_RATA"));
				fin.setCosti(rs.getString("COSTI"));
				fin.setNaturaFinanziamento(rs.getString("NATURA_FINANZIAMENTO"));
				fin.setNote(rs.getString("NOTE"));
				fin.setRateScadute(rs.getString("RATE_SCADUTE"));
				fin.setImportoScaduto(rs.getString("IMPORTO_SCADUTO"));
				fin.setTipologiaRientro(rs.getString("TIPOLOGIA_RIENTRO"));
				fin.setPianoRientro(rs.getString("PIANO_RIENTRO"));
				fin.setNomeAvvocato(rs.getString("NOME_AVVOCATO"));
				fin.setAzioni(rs.getString("AZIONI"));
				fin.setRisultato(rs.getString("RISULTATO"));
				fin.setImportoRichiesto(rs.getString("IMPORTO_RICHIESTO"));
				fin.setRateRichieste(rs.getString("RATE_RICHIESTE"));
				fin.setAccredito(rs.getString("ACCREDITO"));
				fin.setIstruttoriaBanca(rs.getString("ISTRUTTORIA_BANCA"));
				fin.setImpQuotaBanca(rs.getString("IMP_QUOTE_BANCA"));
				fin.setFlgUsura(rs.getInt("FLG_USURA"));
				result.add(fin);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getFinanziamentoById ***");
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

	public int insertFinanziamento(FinanziamentiModel fin) {
		logger.debug("*** Start insertFinanziamento ***");
		String sql = "INSERT INTO finanziamenti(IMPORTO, RATE, DATA_APPROVAZIONE_CONSIGLIO,"
				+ "DATA_EROGAZIONE_FINANZIAMENTO, ID_SOCI, ID_UTENTE, PERCENTUALE_GARANZIA, "
				+ "IMPORTO_RATA, COSTI, NATURA_FINANZIAMENTO, NOTE,ID_STATO_FINANZIAMENTI,"
				+ "ID_BANCHE,RATE_SCADUTE, IMPORTO_SCADUTO, PAGAMENTO, TIPOLOGIA_RIENTRO, "
				+ "PIANO_RIENTRO,NOME_AVVOCATO, AZIONI,RISULTATO,DATA_FINE_FINANZIAMENTO,"
				+ "IMPORTO_RICHIESTO,ID_GARANZIA,COSTO_ISTRUTTORIA,IMPORTO_DELIBERATO,"
				+ "IMPORTO_GARANZIA,RATE_RICHIESTE,ACCREDITO,IMP_QUOTE_BANCA,ISTRUTTORIA_BANCA,FLG_USURA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fin.getImporto());
			ps.setString(2, fin.getRate());
			ps.setDate(3, (Date) fin.getDataApprovazioneConsiglio());
			ps.setDate(4, (Date) fin.getDataErogazioneFinanziamento());
			ps.setInt(5, fin.getIdSoci());
			ps.setInt(6,fin.getIdUtente());
			ps.setString(7, fin.getPercentualeGaranzia());
			ps.setString(8, fin.getImportoRata());
			ps.setString(9, fin.getCosti());
			ps.setString(10, fin.getNaturaFinanziamento());
			ps.setString(11, fin.getNote());
			ps.setInt(12, fin.getIdStatoFinanziamenti());
			ps.setInt(13, fin.getIdBanche());
			ps.setString(14, fin.getRateScadute());
			ps.setString(15, fin.getImportoScaduto());
			ps.setInt(16, fin.getPagamento());
			ps.setString(17, fin.getTipologiaRientro());
			ps.setString(18, fin.getPianoRientro());
			ps.setString(19, fin.getNomeAvvocato());
			ps.setString(20, fin.getAzioni());
			ps.setString(21, fin.getRisultato());
			ps.setDate(22, (Date) fin.getDataFineFinanziamento());
			ps.setString(23, fin.getImportoRichiesto());
			ps.setInt(24, fin.getIdGaranzia());
			ps.setDouble(25, fin.getCostoIstruttoria());
			ps.setInt(26, fin.getImportoDeliberato());
			ps.setDouble(27, fin.getImportoGaranzia());
			ps.setString(28, fin.getRateRichieste());
			ps.setString(29, fin.getAccredito());
			ps.setString(30, fin.getImpQuotaBanca());
			ps.setString(31, fin.getIstruttoriaBanca());
			ps.setInt(32, fin.getFlgUsura());
			
			logger.debug("*** Query ***");
			logger.debug(ps);
			
			int result = ps.executeUpdate();
			
			ps.close();
			logger.debug("*** End insertFinanziamento ***");
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

	public int updateFinanziamento(FinanziamentiModel fin) {
		logger.debug("*** Start updateFinanziamento ***");
		String sql = "UPDATE finanziamenti SET "
				+ "IMPORTO=?, "
				+ "RATE=?, "
				+ "DATA_APPROVAZIONE_CONSIGLIO=?,"
				+ "DATA_EROGAZIONE_FINANZIAMENTO=?,"
				+ "ID_SOCI=?,"
				+ "ID_UTENTE=?,"
				+ "PERCENTUALE_GARANZIA=?,"
				+ "IMPORTO_RATA=?,"
				+ "COSTI=?,"
				+ "NATURA_FINANZIAMENTO=?,"
				+ "NOTE=?,"
				+ "ID_STATO_FINANZIAMENTI=?,"
				+ "ID_BANCHE=?,"
				+ "RATE_SCADUTE=?,"
				+ "IMPORTO_SCADUTO=?,"
				+ "PAGAMENTO=?,"
				+ "TIPOLOGIA_RIENTRO=?,"
				+ "PIANO_RIENTRO=?,"
				+ "NOME_AVVOCATO=?,"
				+ "AZIONI=?,"
				+ "RISULTATO=?,"
				+ "DATA_FINE_FINANZIAMENTO=?,"
				+ "IMPORTO_RICHIESTO=?,"
				+ "ID_GARANZIA=?,"
				+ "COSTO_ISTRUTTORIA=?,"
				+ "IMPORTO_DELIBERATO=?,"
				+ "IMPORTO_GARANZIA=?,"
				+ "RATE_RICHIESTE=?,"
				+" ACCREDITO=?,"
				+ "IMP_QUOTE_BANCA=?,"
				+ "ISTRUTTORIA_BANCA=?,"
				+ "FLG_USURA=? "
				+ "WHERE ID_FINANZIAMENTI=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fin.getImporto());
			ps.setString(2, fin.getRate());
			ps.setDate(3, (Date) fin.getDataApprovazioneConsiglio());
			ps.setDate(4, (Date) fin.getDataErogazioneFinanziamento());
			ps.setInt(5, fin.getIdSoci());
			ps.setInt(6,fin.getIdUtente());
			ps.setString(7, fin.getPercentualeGaranzia());
			ps.setString(8, fin.getImportoRata());
			ps.setString(9, fin.getCosti());
			ps.setString(10, fin.getNaturaFinanziamento());
			ps.setString(11, fin.getNote());
			ps.setInt(12, fin.getIdStatoFinanziamenti());
			ps.setInt(13, fin.getIdBanche());
			ps.setString(14, fin.getRateScadute());
			ps.setString(15, fin.getImportoScaduto());
			ps.setInt(16, fin.getPagamento());
			ps.setString(17, fin.getTipologiaRientro());
			ps.setString(18, fin.getPianoRientro());
			ps.setString(19, fin.getNomeAvvocato());
			ps.setString(20, fin.getAzioni());
			ps.setString(21, fin.getRisultato());
			ps.setDate(22, (Date) fin.getDataFineFinanziamento());
			ps.setString(23, fin.getImportoRichiesto());
			ps.setInt(24, fin.getIdGaranzia());
			ps.setDouble(25, fin.getCostoIstruttoria());
			ps.setInt(26, fin.getImportoDeliberato());
			ps.setDouble(27, fin.getImportoGaranzia());
			ps.setString(28, fin.getRateRichieste());			
			ps.setString(29, fin.getAccredito());
			ps.setString(30, fin.getImpQuotaBanca());
			ps.setString(31, fin.getIstruttoriaBanca());
			ps.setInt(32, fin.getFlgUsura());
			ps.setInt(33, fin.getIdFinanziamenti());
			
			logger.debug("*** Query ***");
			logger.debug(ps);
			
			int result = ps.executeUpdate();
			
			ps.close();
			logger.debug("*** End updateFinanziamento ***");
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
