package it.cofidimpresa.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import it.cofidimpresa.dao.GeneraFileCrifDAO;
import it.cofidimpresa.data.CrifData;
import it.cofidimpresa.data.TableExcelData;

public class DefaultGeneraFileCrifDAO implements GeneraFileCrifDAO{

	private static final Logger logger = Logger.getLogger(DefaultGeneraFileCrifDAO.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<CrifData> getFinanzaimentiCrif(Date dataRiferimentoCrif) {
		logger.debug("*** Start getFinanziamentCrif ***");
		String sql = "SELECT SOCI.CODICE_FISCALE AS CODICE_FISCALE, SOCI.PARTITA_IVA AS PARTITA_IVA, "
				+ "SOCI.ID_TIPO_SOCIETA AS ID_TIPO_SOCIETA, FINANZIAMENTI.IMPORTO_GARANZIA AS IMPORTO_GARANTITO,	"
				+ "SOCI.ID_SOCI AS ID_SOCI, FINANZIAMENTI.ID_FINANZIAMENTI AS ID_FINANZIAMENTI, "
				+ "SOCI.PROVINCIA_SEDE_LEGALE AS PROVINCIA_SEDE_LEGALE, "
				+ "FINANZIAMENTI.DATA_APPROVAZIONE_CONSIGLIO AS DATA_INIZIO_FINANZIAMENTO, "
				+ "FINANZIAMENTI.DATA_FINE_FINANZIAMENTO AS DATA_FINE_FINANZIAMENTO, "
				+ "SOCI.DATA_DI_NASCITA AS DATA_DI_NASCITA "
				+ "FROM SOCI,FINANZIAMENTI,TIPO_SOCIETA "
				+ "WHERE SOCI.ID_SOCI = FINANZIAMENTI.ID_SOCI AND SOCI.ID_TIPO_SOCIETA = TIPO_SOCIETA.ID_TIPO_SOCIETA AND FINANZIAMENTI.ID_STATO_FINANZIAMENTI IN (2,3,4) AND FINANZIAMENTI.DATA_EROGAZIONE_FINANZIAMENTO > '2015-01-01' AND FINANZIAMENTI.DATA_EROGAZIONE_FINANZIAMENTO <= ?";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, (Date) dataRiferimentoCrif);
			
			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			List<CrifData> crifDataList = new ArrayList<CrifData>();

			while (rs.next()) {
				CrifData crifData = new CrifData(); 
				crifData.setCodiceFiscale(rs.getString("CODICE_FISCALE"));
				crifData.setPartitaIva(rs.getString("PARTITA_IVA"));
				crifData.setTipoSocieta(rs.getInt("ID_TIPO_SOCIETA"));
				crifData.setImportoGaranzia(rs.getInt("IMPORTO_GARANTITO"));
				crifData.setIdFinanziamenti(rs.getInt("ID_FINANZIAMENTI"));
				crifData.setIdSoci(rs.getInt("ID_SOCI"));
				crifData.setProvinciaSedeLegale(rs.getString("PROVINCIA_SEDE_LEGALE"));
				crifData.setDataInizioFinanziamento(rs.getDate("DATA_INIZIO_FINANZIAMENTO"));
				crifData.setDataFineFinanziamento(rs.getDate("DATA_FINE_FINANZIAMENTO"));
				crifData.setDataNascita(rs.getDate("DATA_DI_NASCITA"));
				
				crifDataList.add(crifData);
			}

			rs.close();
			ps.close();
			logger.debug("*** End getNumAllFinanziamenti ***");
			return crifDataList;
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
	
	public List<TableExcelData> getReportExcel(Date dateStart, Date dataEnd) {
		logger.debug("*** Start getReportExcel ***");
		String sql = "SELECT SOCI.NOME, SOCI.COGNOME, SOCI.IMPRESA, SOCI.CODICE_FISCALE," + 
				"SOCI.PARTITA_IVA, SOCI.TIPOLOGIA_MERCEOLOGICA," + 
				"FINANZIAMENTI.DATA_APPROVAZIONE_CONSIGLIO, FINANZIAMENTI.IMPORTO_DELIBERATO," + 
				"FINANZIAMENTI.DATA_EROGAZIONE_FINANZIAMENTO, FINANZIAMENTI.DATA_FINE_FINANZIAMENTO,"+
				"FINANZIAMENTI.IMPORTO," + "FINANZIAMENTI.FLG_USURA," + 
				"FINANZIAMENTI.ID_BANCHE, FINANZIAMENTI.IMPORTO_RATA, FINANZIAMENTI.RATE," + 
				"FINANZIAMENTI.ACCREDITO, FINANZIAMENTI.IMP_QUOTE_BANCA, " +
				"FINANZIAMENTI.ISTRUTTORIA_BANCA, BANCHE.NOME_BANCHE " + 
				"FROM SOCI,FINANZIAMENTI,BANCHE " + 
				"WHERE SOCI.ID_SOCI = FINANZIAMENTI.ID_SOCI " + 
				"AND FINANZIAMENTI.ID_BANCHE = BANCHE.ID_BANCHE " + 
				"AND FINANZIAMENTI.ID_STATO_FINANZIAMENTI = 4 " + 
				"AND finanziamenti.DATA_EROGAZIONE_FINANZIAMENTO >=? "+
				"AND finanziamenti.DATA_EROGAZIONE_FINANZIAMENTO <=? "+
				"ORDER BY (FINANZIAMENTI.DATA_EROGAZIONE_FINANZIAMENTO) ASC";
		
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, (Date) dateStart);
			ps.setDate(2, (Date) dataEnd);
			
			logger.debug("*** Query ***");
			logger.debug(ps);

			ResultSet rs = ps.executeQuery();

			List<TableExcelData> tableExcelDataList = new ArrayList<TableExcelData>();
			int i = 1;
			while (rs.next()) {
				TableExcelData tableExcelData = new TableExcelData(); 
				tableExcelData.setNumProgressivo(i);
				tableExcelData.setCodiceFiscale(rs.getString("CODICE_FISCALE"));
				tableExcelData.setPartitaIva(rs.getString("PARTITA_IVA"));
				tableExcelData.setNome(rs.getString("NOME"));
				tableExcelData.setCognome(rs.getString("COGNOME"));
				tableExcelData.setImpresa(rs.getString("IMPRESA"));
				tableExcelData.setImportoQuote(rs.getString("IMP_QUOTE_BANCA"));
				tableExcelData.setTipologiaMerceologica(rs.getString("TIPOLOGIA_MERCEOLOGICA"));
				tableExcelData.setDataApprovazioneConsiglio(rs.getString("DATA_APPROVAZIONE_CONSIGLIO"));
				tableExcelData.setImportoDeliberato(rs.getInt("IMPORTO_DELIBERATO"));
				tableExcelData.setDataErogazioneFinanziamento(rs.getString("DATA_EROGAZIONE_FINANZIAMENTO"));
				tableExcelData.setDataFineFinanziamento(rs.getString("DATA_FINE_FINANZIAMENTO"));
				tableExcelData.setImportoRata(rs.getString("IMPORTO_RATA"));
				tableExcelData.setRate(rs.getString("RATE"));
				tableExcelData.setCosti(rs.getString("ACCREDITO"));
				tableExcelData.setCostoIstruttoria(rs.getString("ISTRUTTORIA_BANCA"));
				tableExcelData.setNomeBanca(rs.getString("NOME_BANCHE"));
				tableExcelData.setImporto(rs.getString("IMPORTO"));
				if(rs.getInt("FLG_USURA")==0) {
					tableExcelData.setFlgUsura(StringUtils.EMPTY);
				}else {
					tableExcelData.setFlgUsura("PREV. USURA");
				}
				
				tableExcelDataList.add(tableExcelData);
			
				i++;
				
			}

			rs.close();
			ps.close();
			logger.debug("*** End getNumAllFinanziamenti ***");
			return tableExcelDataList;
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
