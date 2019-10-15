package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.cofidimpresa.dao.SociDAO;
import it.cofidimpresa.datamodel.AtecoModel;
import it.cofidimpresa.datamodel.SociModel;

public class DefaultSociDAO implements SociDAO {

	private static final Logger logger = Logger.getLogger(DefaultSociDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int getNumAllSoci() {
		logger.debug("*** Start getNumAllSoci ***");
		String sql = "SELECT  COUNT(id_soci) as numSoci FROM soci ";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int size = 0;

			if (rs.next()) {
				size = rs.getInt("numSoci");
			}

			logger.debug("*** Query ***");
			logger.debug(sql);

			rs.close();
			ps.close();
			logger.debug("*** End getNumAllSoci ***");
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

	public List<SociModel> findAllSoci() {
		logger.debug("*** Start findAllSoci ***");
		String sql = "SELECT  * FROM soci ";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<SociModel> result = new ArrayList<SociModel>();

			logger.debug("*** Query ***");
			logger.debug(sql);

			while (rs.next()) {
				SociModel soci = new SociModel();

				soci.setIdSoci(rs.getInt("ID_SOCI"));
				soci.setIdUtente(rs.getInt("ID_UTENTE"));
				soci.setIdQualitaTitolare(rs.getInt("ID_QUALITA_TITOLARE"));
				soci.setAntiriciclaggio(rs.getInt("ANTIRICICLAGGIO"));
				soci.setIdSettoreImpresa(rs.getInt("ID_SETTORE_IMPRESA"));
				soci.setIdStatoSocio(rs.getInt("ID_STATO_SOCIO"));
				soci.setIdTipoSocieta(rs.getInt("ID_TIPO_SOCIETA"));
				soci.setIdSettoreImpresa(rs.getInt("ID_SETTORE_IMPRESA"));
				soci.setDataAttivita(rs.getDate("DATA_ATTIVITA"));
				soci.setDataCessazione(rs.getDate("DATA_CESSAZIONE"));
				soci.setDataDiNascita(rs.getDate("DATA_DI_NASCITA"));
				soci.setDataInizio(rs.getDate("DATA_INIZIO"));
				soci.setDataCostituzione(rs.getDate("DATA_COSTITUZIONE"));
				soci.setNumeroLibroSoci(rs.getInt("NLIBRO_SOCI"));
				soci.setNumeroQuote(rs.getInt("NUMERO_QUOTE"));
				soci.setImportoQuote(rs.getDouble("IMPORTO_QUOTE"));
				soci.setNome(rs.getString("NOME"));
				soci.setCognome(rs.getString("COGNOME"));
				soci.setImpresa(rs.getString("IMPRESA"));
				soci.setCodiceFiscale(rs.getString("CODICE_FISCALE"));
				soci.setPartitaIva(rs.getString("PARTITA_IVA"));
				soci.setIndirizzoAzienda(rs.getString("INDIRIZZO_AZIENDA"));
				soci.setCittaAzienda(rs.getString("CITTA_AZIENDA"));
				soci.setCapAzienda(rs.getString("CAP_AZIENDA"));
				soci.setProvinciaAzienda(rs.getString("PROVINCIA_AZIENDA"));
				soci.setIndirizzoResidenza(rs.getString("INDIRIZZO_RESIDENZA"));
				soci.setCittaResidenza(rs.getString("CITTA_RESIDENZA"));
				soci.setCapResidenza(rs.getString("CAP_RESIDENZA"));
				soci.setProvinciaResidenza(rs.getString("PROVINCIA_RESIDENZA"));
				soci.setIndirizzoSedeOperativa(rs.getString("INDIRIZZO_SEDE_OPERATIVA"));
				soci.setCittaSedeOperativa(rs.getString("CITTA_SEDE_OPERATIVA"));
				soci.setCapSedeOperativa(rs.getString("CAP_SEDE_OPERATIVA"));
				soci.setProvinciaSedeOperativa(rs.getString("PROVINCIA_SEDE_OPERATIVA"));
				soci.setIndirizzoSedeLegale(rs.getString("INDIRIZZO_SEDE_LEGALE"));
				soci.setCittaSedeLegale(rs.getString("CITTA_SEDE_LEGALE"));
				soci.setCapSedeLegale(rs.getString("CAP_SEDE_LEGALE"));
				soci.setProvinciaSedeLegale(rs.getString("PROVINCIA_SEDE_LEGALE"));
				soci.setTelefono(rs.getString("TELEFONO"));
				soci.setFax(rs.getString("FAX"));
				soci.setMobile(rs.getString("MOBILE"));
				soci.setEmail(rs.getString("EMAIL"));
				soci.setTipologiaMerceologica(rs.getString("TIPOLOGIA_MERCEOLOGICA"));
				soci.setLuogoDiNascita(rs.getString("LUOGO_DI_NASCITA"));
				soci.setCciaa(rs.getString("CCIAA"));
				soci.setRea(rs.getString("REA"));
				soci.setNumeroDipendenti(rs.getString("NUMERO_DIPENDENTI"));
				soci.setCodiceFiscaleTitolare(rs.getString("CODICE_FISCALE_TITOLARE"));

				result.add(soci);

			}

			rs.close();
			ps.close();
			logger.debug("*** End findAllSoci ***");
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

	public SociModel getSocioById(int idSocio) {
		logger.debug("*** Start getSocioById ***");
		String sql = "SELECT  * FROM soci WHERE ID_SOCI=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ResultSet rs = ps.executeQuery();
			SociModel soci = new SociModel();

			logger.debug("*** Query ***");
			logger.debug(sql);

			logger.debug("*** Parameter ***");
			logger.debug(idSocio);

			while (rs.next()) {

				soci.setIdSoci(rs.getInt("ID_SOCI"));
				soci.setIdUtente(rs.getInt("ID_UTENTE"));
				soci.setIdQualitaTitolare(rs.getInt("ID_QUALITA_TITOLARE"));
				soci.setAntiriciclaggio(rs.getInt("ANTIRICICLAGGIO"));
				soci.setIdSettoreImpresa(rs.getInt("ID_SETTORE_IMPRESA"));
				soci.setIdStatoSocio(rs.getInt("ID_STATO_SOCIO"));
				soci.setIdTipoSocieta(rs.getInt("ID_TIPO_SOCIETA"));
				soci.setIdSettoreImpresa(rs.getInt("ID_SETTORE_IMPRESA"));
				soci.setDataAttivita(rs.getDate("DATA_ATTIVITA"));
				soci.setDataCessazione(rs.getDate("DATA_CESSAZIONE"));
				soci.setDataDiNascita(rs.getDate("DATA_DI_NASCITA"));
				soci.setDataInizio(rs.getDate("DATA_INIZIO"));
				soci.setDataCostituzione(rs.getDate("DATA_COSTITUZIONE"));
				soci.setNumeroLibroSoci(rs.getInt("NLIBRO_SOCI"));
				soci.setNumeroQuote(rs.getInt("NUMERO_QUOTE"));
				soci.setImportoQuote(rs.getDouble("IMPORTO_QUOTE"));
				soci.setNome(rs.getString("NOME"));
				soci.setCognome(rs.getString("COGNOME"));
				soci.setImpresa(rs.getString("IMPRESA"));
				soci.setCodiceFiscale(rs.getString("CODICE_FISCALE"));
				soci.setPartitaIva(rs.getString("PARTITA_IVA"));
				soci.setIndirizzoAzienda(rs.getString("INDIRIZZO_AZIENDA"));
				soci.setCittaAzienda(rs.getString("CITTA_AZIENDA"));
				soci.setCapAzienda(rs.getString("CAP_AZIENDA"));
				soci.setProvinciaAzienda(rs.getString("PROVINCIA_AZIENDA"));
				soci.setIndirizzoResidenza(rs.getString("INDIRIZZO_RESIDENZA"));
				soci.setCittaResidenza(rs.getString("CITTA_RESIDENZA"));
				soci.setCapResidenza(rs.getString("CAP_RESIDENZA"));
				soci.setProvinciaResidenza(rs.getString("PROVINCIA_RESIDENZA"));
				soci.setIndirizzoSedeOperativa(rs.getString("INDIRIZZO_SEDE_OPERATIVA"));
				soci.setCittaSedeOperativa(rs.getString("CITTA_SEDE_OPERATIVA"));
				soci.setCapSedeOperativa(rs.getString("CAP_SEDE_OPERATIVA"));
				soci.setProvinciaSedeOperativa(rs.getString("PROVINCIA_SEDE_OPERATIVA"));
				soci.setIndirizzoSedeLegale(rs.getString("INDIRIZZO_SEDE_LEGALE"));
				soci.setCittaSedeLegale(rs.getString("CITTA_SEDE_LEGALE"));
				soci.setCapSedeLegale(rs.getString("CAP_SEDE_LEGALE"));
				soci.setProvinciaSedeLegale(rs.getString("PROVINCIA_SEDE_LEGALE"));
				soci.setTelefono(rs.getString("TELEFONO"));
				soci.setFax(rs.getString("FAX"));
				soci.setMobile(rs.getString("MOBILE"));
				soci.setEmail(rs.getString("EMAIL"));
				soci.setTipologiaMerceologica(rs.getString("TIPOLOGIA_MERCEOLOGICA"));
				soci.setLuogoDiNascita(rs.getString("LUOGO_DI_NASCITA"));
				soci.setCciaa(rs.getString("CCIAA"));
				soci.setRea(rs.getString("REA"));
				soci.setNumeroDipendenti(rs.getString("NUMERO_DIPENDENTI"));
				soci.setCodiceFiscaleTitolare(rs.getString("CODICE_FISCALE_TITOLARE"));

			}

			rs.close();
			ps.close();
			logger.debug("*** End getSocioById ***");
			return soci;
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

	public List<AtecoModel> getCodiciAteco() {
		logger.debug("*** Start getCodiciAteco ***");
		String sql = "SELECT  * FROM ateco";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<AtecoModel> result = new ArrayList<AtecoModel>();

			logger.debug("*** Query ***");
			logger.debug(sql);

			while (rs.next()) {
				AtecoModel atecoModel = new AtecoModel();
				atecoModel.setIdAteco(rs.getInt("ID_ATECO"));
				atecoModel.setCodiceAteco(rs.getString("CODICE_ATECO"));
				atecoModel.setDescrizione(rs.getString("DESCRIZIONE"));

				result.add(atecoModel);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getCodiciAteco ***");
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

	public Integer addSocio(SociModel sociModel) {
		logger.debug("*** Start addSocio ***");
		String sql = "INSERT INTO soci(NOME, COGNOME, IMPRESA, CODICE_FISCALE, "
				+ "PARTITA_IVA, INDIRIZZO_AZIENDA, CITTA_AZIENDA, CAP_AZIENDA, PROVINCIA_AZIENDA,"
				+ "INDIRIZZO_RESIDENZA, CITTA_RESIDENZA, CAP_RESIDENZA,"
				+ "PROVINCIA_RESIDENZA, TELEFONO, FAX, MOBILE, EMAIL,"
				+ "ID_UTENTE, DATA_INIZIO, DATA_CESSAZIONE, INDIRIZZO_SEDE_OPERATIVA,"
				+ "CITTA_SEDE_OPERATIVA, CAP_SEDE_OPERATIVA, PROVINCIA_SEDE_OPERATIVA,"
				+ "INDIRIZZO_SEDE_LEGALE, CITTA_SEDE_LEGALE," + "CAP_SEDE_LEGALE, PROVINCIA_SEDE_LEGALE,"
				+ "TIPOLOGIA_MERCEOLOGICA, DATA_DI_NASCITA, LUOGO_DI_NASCITA,"
				+ "ID_TIPO_SOCIETA, ID_QUALITA_TITOLARE, CCIAA,"
				+ "REA, DATA_COSTITUZIONE, DATA_ATTIVITA, NUMERO_DIPENDENTI,"
				+ "CODICE_FISCALE_TITOLARE, ID_SETTORE_IMPRESA, ID_STATO_SOCIO,"
				+ "NLIBRO_SOCI,NUMERO_QUOTE,IMPORTO_QUOTE) VALUES ("
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + ")";

		Connection conn = null;

		try {
			logger.debug("*** Query ***");
			logger.debug(sql);

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, sociModel.getNome());
			ps.setString(2, sociModel.getCognome());
			ps.setString(3, sociModel.getImpresa());
			ps.setString(4, sociModel.getCodiceFiscale());
			ps.setString(5, sociModel.getPartitaIva());
			ps.setString(6, sociModel.getIndirizzoAzienda());
			ps.setString(7, sociModel.getCittaAzienda());
			ps.setString(8, sociModel.getCapAzienda());
			ps.setString(9, sociModel.getProvinciaAzienda());
			ps.setString(10, sociModel.getIndirizzoResidenza());
			ps.setString(11, sociModel.getCittaResidenza());
			ps.setString(12, sociModel.getCapResidenza());
			ps.setString(13, sociModel.getProvinciaResidenza());
			ps.setString(14, sociModel.getTelefono());
			ps.setString(15, sociModel.getFax());
			ps.setString(16, sociModel.getMobile());
			ps.setString(17, sociModel.getEmail());
			ps.setInt(18, sociModel.getIdUtente());
			if (sociModel.getDataInizio() != null) {
				ps.setDate(19, new Date(createDate(sociModel.getDataInizio())),Calendar.getInstance());
			} else {
				ps.setNull(19, java.sql.Types.DATE);
			}
			if (sociModel.getDataCessazione() != null) {
				ps.setDate(20, new Date(createDate(sociModel.getDataCessazione())),Calendar.getInstance());
			} else {
				ps.setNull(20, java.sql.Types.DATE);
			}
			ps.setString(21, sociModel.getIndirizzoSedeOperativa());
			ps.setString(22, sociModel.getCittaSedeOperativa());
			ps.setString(23, sociModel.getCapSedeOperativa());
			ps.setString(24, sociModel.getProvinciaSedeOperativa());
			ps.setString(25, sociModel.getIndirizzoSedeLegale());
			ps.setString(26, sociModel.getCittaSedeLegale());
			ps.setString(27, sociModel.getCapSedeLegale());
			ps.setString(28, sociModel.getProvinciaSedeLegale());
			ps.setString(29, sociModel.getTipologiaMerceologica());
			if (sociModel.getDataDiNascita() != null) {
				ps.setDate(30, new Date(createDate(sociModel.getDataDiNascita())),Calendar.getInstance());
			} else {
				ps.setNull(30, java.sql.Types.DATE);
			}
			ps.setString(31, sociModel.getLuogoDiNascita());
			ps.setInt(32, sociModel.getIdTipoSocieta());
			ps.setInt(33, sociModel.getIdQualitaTitolare());
			ps.setString(34, sociModel.getCciaa());
			ps.setString(35, sociModel.getRea());
			if (sociModel.getDataCostituzione() != null) {
				ps.setDate(36, new Date(createDate(sociModel.getDataCostituzione())),Calendar.getInstance());
			} else {
				ps.setNull(36, java.sql.Types.DATE);
			}
			if (sociModel.getDataAttivita() != null) {
				ps.setDate(37, new Date(createDate(sociModel.getDataAttivita())),Calendar.getInstance());
			} else {
				ps.setNull(37, java.sql.Types.DATE);
			}
			ps.setString(38, sociModel.getNumeroDipendenti());
			ps.setString(39, sociModel.getCodiceFiscaleTitolare());
			ps.setInt(40, sociModel.getIdSettoreImpresa());
			ps.setInt(41, sociModel.getIdStatoSocio());
			ps.setInt(42, sociModel.getNumeroLibroSoci());
			ps.setInt(43, sociModel.getNumeroQuote());
			ps.setDouble(44, sociModel.getImportoQuote());
			// ps.setInt(45, null);

			logger.debug("Parameter");
			logger.debug(sociModel.getNome() + "," + sociModel.getCognome() + "," + sociModel.getImpresa() + ","
					+ sociModel.getCodiceFiscale() + "," + sociModel.getPartitaIva() + ","
					+ sociModel.getIndirizzoAzienda() + "," + sociModel.getCittaAzienda() + ","
					+ sociModel.getCapAzienda() + "," + sociModel.getProvinciaAzienda() + ","
					+ sociModel.getIndirizzoResidenza() + "," + sociModel.getCittaResidenza() + ","
					+ sociModel.getCapResidenza() + "," + sociModel.getProvinciaResidenza() + ","
					+ sociModel.getTelefono() + "," + sociModel.getFax() + "," + sociModel.getMobile() + ","
					+ sociModel.getEmail() + "," + sociModel.getIdUtente() + "," + sociModel.getDataInizio() + ","
					+ sociModel.getDataCessazione() + "," + sociModel.getIndirizzoSedeOperativa() + ","
					+ sociModel.getCittaSedeOperativa() + "," + sociModel.getCapSedeOperativa() + ","
					+ sociModel.getProvinciaSedeOperativa() + "," + sociModel.getIndirizzoSedeLegale() + ","
					+ sociModel.getCittaSedeLegale() + "," + sociModel.getCapSedeLegale() + ","
					+ sociModel.getProvinciaSedeLegale() + "," + sociModel.getTipologiaMerceologica() + ","
					+ sociModel.getDataDiNascita() + "," + sociModel.getLuogoDiNascita() + ","
					+ sociModel.getIdTipoSocieta() + "," + sociModel.getIdQualitaTitolare() + "," + sociModel.getCciaa()
					+ "," + sociModel.getRea() + "," + sociModel.getDataCostituzione() + ","
					+ sociModel.getDataAttivita() + "," + sociModel.getNumeroDipendenti() + ","
					+ sociModel.getCodiceFiscaleTitolare() + "," + sociModel.getIdSettoreImpresa() + ","
					+ sociModel.getIdStatoSocio() + "," + sociModel.getNumeroLibroSoci() + ","
					+ sociModel.getNumeroQuote() + "," + sociModel.getImportoQuote());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			Integer idSocio = -1;
			if (rs.next()) {
				idSocio = rs.getInt("GENERATED_KEY");
			} else {
				throw new SQLException("Error to insert row");
			}

			rs.close();
			ps.close();
			logger.debug("*** End addSocio ***");
			return idSocio;
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

	public void addStoricoSocio(SociModel sociModel, Integer idSocio) {
		logger.debug("*** Start addStoricoSocio ***");
		String sql = "INSERT INTO storico_soci (ID_UTENTE, OLD_VALUE, NEW_VALUE, "
				+ "ID_SOCI, DATE) VALUES (?,?,?,?,CURDATE())";

		Connection conn = null;

		try {
			logger.debug("*** Query ***");
			logger.debug(sql);

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sociModel.getIdUtente());
			ps.setString(2, StringUtils.EMPTY);
			ps.setString(3, "Registrato nuovo socio");
			ps.setInt(4, idSocio);

			logger.debug("Parameter");
			logger.debug(ps.getParameterMetaData());
			ps.executeUpdate();

			ps.close();
			logger.debug("*** End addStoricoSocio ***");
			// return result;
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

	public void addSocioAteco(int idAteco, int idSocio) {
		logger.debug("*** Start addSocioAteco ***");
		String sql = "INSERT INTO socio_ateco (ID_SOCIO, ID_ATECO) VALUES (?,?)";

		Connection conn = null;

		try {
			logger.debug("*** Query ***");
			logger.debug(sql);

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idSocio);
			ps.setInt(2, idAteco);

			logger.debug("Parameter");
			logger.debug(ps.getParameterMetaData());

			ps.executeUpdate();

			ps.close();
			logger.debug("*** End addSocioAteco ***");
			// return result;
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

	public Integer updateSocio(SociModel sociModel) {
		logger.debug("*** Start updateSocio ***");
		String sql = "UPDATE soci SET " + "NOME = ?," + "COGNOME = ?," + "IMPRESA = ?," + "CODICE_FISCALE = ?,"
				+ "PARTITA_IVA = ?, " + "INDIRIZZO_AZIENDA = ?," + "CITTA_AZIENDA = ?," + "CAP_AZIENDA = ?,"
				+ "PROVINCIA_AZIENDA = ?," + "INDIRIZZO_RESIDENZA = ?," + "CITTA_RESIDENZA = ?," + "CAP_RESIDENZA = ?,"
				+ "PROVINCIA_RESIDENZA = ?," + "TELEFONO = ?," + "FAX = ?," + "MOBILE = ?," + "EMAIL = ?,"
				+ "ID_UTENTE= ?," + "DATA_INIZIO = ?," + "DATA_CESSAZIONE = ?," + "INDIRIZZO_SEDE_OPERATIVA = ?,"
				+ "CITTA_SEDE_OPERATIVA = ?," + "CAP_SEDE_OPERATIVA = ?," + "PROVINCIA_SEDE_OPERATIVA = ?,"
				+ "INDIRIZZO_SEDE_LEGALE = ?," + "CITTA_SEDE_LEGALE = ?," + "CAP_SEDE_LEGALE = ?,"
				+ "PROVINCIA_SEDE_LEGALE = ?," + "TIPOLOGIA_MERCEOLOGICA = ?," + "DATA_DI_NASCITA = ?,"
				+ "LUOGO_DI_NASCITA = ?," + "ID_TIPO_SOCIETA = ?," + "ID_QUALITA_TITOLARE = ?," + "CCIAA = ?,"
				+ "REA = ?," + "DATA_COSTITUZIONE = ?," + "DATA_ATTIVITA = ?," + "NUMERO_DIPENDENTI = ?,"
				+ "CODICE_FISCALE_TITOLARE = ?," + "ID_SETTORE_IMPRESA = ?," + "ID_STATO_SOCIO = ?,"
				+ "NLIBRO_SOCI = ?," + "NUMERO_QUOTE = ?," + "IMPORTO_QUOTE = ?," + "ANTIRICICLAGGIO = ?"
				+ " WHERE ID_SOCI =?";

		Connection conn = null;

		try {
			logger.debug("*** Query ***");
			logger.debug(sql);

			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, sociModel.getNome());
			ps.setString(2, sociModel.getCognome());
			ps.setString(3, sociModel.getImpresa());
			ps.setString(4, sociModel.getCodiceFiscale());
			ps.setString(5, sociModel.getPartitaIva());
			ps.setString(6, sociModel.getIndirizzoAzienda());
			ps.setString(7, sociModel.getCittaAzienda());
			ps.setString(8, sociModel.getCapAzienda());
			ps.setString(9, sociModel.getProvinciaAzienda());
			ps.setString(10, sociModel.getIndirizzoResidenza());
			ps.setString(11, sociModel.getCittaResidenza());
			ps.setString(12, sociModel.getCapResidenza());
			ps.setString(13, sociModel.getProvinciaResidenza());
			ps.setString(14, sociModel.getTelefono());
			ps.setString(15, sociModel.getFax());
			ps.setString(16, sociModel.getMobile());
			ps.setString(17, sociModel.getEmail());
			ps.setInt(18, sociModel.getIdUtente());
			if (sociModel.getDataInizio() != null) {
				ps.setDate(19, new Date(createDate(sociModel.getDataInizio())),Calendar.getInstance());
			} else {
				ps.setNull(19, java.sql.Types.DATE);
			}
			if (sociModel.getDataCessazione() != null) {
				ps.setDate(20, new Date(createDate(sociModel.getDataCessazione())),Calendar.getInstance());
			} else {
				ps.setNull(20, java.sql.Types.DATE);
			}
			ps.setString(21, sociModel.getIndirizzoSedeOperativa());
			ps.setString(22, sociModel.getCittaSedeOperativa());
			ps.setString(23, sociModel.getCapSedeOperativa());
			ps.setString(24, sociModel.getProvinciaSedeOperativa());
			ps.setString(25, sociModel.getIndirizzoSedeLegale());
			ps.setString(26, sociModel.getCittaSedeLegale());
			ps.setString(27, sociModel.getCapSedeLegale());
			ps.setString(28, sociModel.getProvinciaSedeLegale());
			ps.setString(29, sociModel.getTipologiaMerceologica());
			if (sociModel.getDataDiNascita() != null) {
				ps.setDate(30, new Date(createDate(sociModel.getDataDiNascita())),Calendar.getInstance());
			} else {
				ps.setNull(30, java.sql.Types.DATE);
			}
			ps.setString(31, sociModel.getLuogoDiNascita());
			ps.setInt(32, sociModel.getIdTipoSocieta());
			ps.setInt(33, sociModel.getIdQualitaTitolare());
			ps.setString(34, sociModel.getCciaa());
			ps.setString(35, sociModel.getRea());
			if (sociModel.getDataCostituzione() != null) {
				ps.setDate(36, new Date(createDate(sociModel.getDataCostituzione())),Calendar.getInstance());
			} else {
				ps.setNull(36, java.sql.Types.DATE);
			}
			if (sociModel.getDataAttivita() != null) {
				ps.setDate(37, new Date(createDate(sociModel.getDataAttivita())),Calendar.getInstance());
			} else {
				ps.setNull(37, java.sql.Types.DATE);
			}
			ps.setString(38, sociModel.getNumeroDipendenti());
			ps.setString(39, sociModel.getCodiceFiscaleTitolare());
			ps.setInt(40, sociModel.getIdSettoreImpresa());
			ps.setInt(41, sociModel.getIdStatoSocio());
			ps.setInt(42, sociModel.getNumeroLibroSoci());
			ps.setInt(43, sociModel.getNumeroQuote());
			ps.setDouble(44, sociModel.getImportoQuote());
			ps.setInt(45, sociModel.getAntiriciclaggio());
			ps.setInt(46, sociModel.getIdSoci());

			logger.debug("Parameter");
			logger.debug(sociModel.getNome() + "," + sociModel.getCognome() + "," + sociModel.getImpresa() + ","
					+ sociModel.getCodiceFiscale() + "," + sociModel.getPartitaIva() + ","
					+ sociModel.getIndirizzoAzienda() + "," + sociModel.getCittaAzienda() + ","
					+ sociModel.getCapAzienda() + "," + sociModel.getProvinciaAzienda() + ","
					+ sociModel.getIndirizzoResidenza() + "," + sociModel.getCittaResidenza() + ","
					+ sociModel.getCapResidenza() + "," + sociModel.getProvinciaResidenza() + ","
					+ sociModel.getTelefono() + "," + sociModel.getFax() + "," + sociModel.getMobile() + ","
					+ sociModel.getEmail() + "," + sociModel.getIdUtente() + "," + sociModel.getDataInizio() + ","
					+ sociModel.getDataCessazione() + "," + sociModel.getIndirizzoSedeOperativa() + ","
					+ sociModel.getCittaSedeOperativa() + "," + sociModel.getCapSedeOperativa() + ","
					+ sociModel.getProvinciaSedeOperativa() + "," + sociModel.getIndirizzoSedeLegale() + ","
					+ sociModel.getCittaSedeLegale() + "," + sociModel.getCapSedeLegale() + ","
					+ sociModel.getProvinciaSedeLegale() + "," + sociModel.getTipologiaMerceologica() + ","
					+ sociModel.getDataDiNascita() + "," + sociModel.getLuogoDiNascita() + ","
					+ sociModel.getIdTipoSocieta() + "," + sociModel.getIdQualitaTitolare() + "," + sociModel.getCciaa()
					+ "," + sociModel.getRea() + "," + sociModel.getDataCostituzione() + ","
					+ sociModel.getDataAttivita() + "," + sociModel.getNumeroDipendenti() + ","
					+ sociModel.getCodiceFiscaleTitolare() + "," + sociModel.getIdSettoreImpresa() + ","
					+ sociModel.getIdStatoSocio() + "," + sociModel.getNumeroLibroSoci() + ","
					+ sociModel.getNumeroQuote() + "," + sociModel.getImportoQuote() + ","
					+ sociModel.getAntiriciclaggio() + "," + sociModel.getIdSoci());

			logger.debug("*** Prepared Statement ***");
			logger.debug(ps);
			logger.debug(ps.toString());

			int result = ps.executeUpdate();

			ps.close();
			logger.debug("*** End addSocio ***");
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

	public Integer getIdSocioByPartitaIva(String pIva) {
		logger.debug("*** Start getIdSocioByPartitaIva ***");
		String sql = "SELECT  * FROM soci WHERE PARTITA_IVA=?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pIva);
			ResultSet rs = ps.executeQuery();

			logger.debug("*** Query ***");
			logger.debug(ps);

			Integer idSocio = new Integer(0);

			while (rs.next()) {

				idSocio = rs.getInt("ID_SOCI");
			}

			rs.close();
			ps.close();
			logger.debug("*** End getSocioById ***");
			return idSocio;
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
		if (date != null)
			return date.getTime();
		return null;
	}

}
