package it.cofidimpresa.facades.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import it.cofidimpresa.dao.GeneraFileCrifDAO;
import it.cofidimpresa.data.CrifData;
import it.cofidimpresa.data.TableExcelData;
import it.cofidimpresa.facades.GeneraFileCrifFacade;
import it.cofidimpresa.utils.DefaultJavaUtils;

public class DefaultGeneraFileCrifFacade implements GeneraFileCrifFacade {

	private static final Logger logger = Logger.getLogger(DefaultGeneraFileCrifFacade.class);

	@Resource(name = "generaFileCrifDAO")
	GeneraFileCrifDAO generaFileCrifDAO;

	@Value("${document.path.crif}")
	private String pathDocumentCrif;

	@Resource(name = "defaultJavaUtils")
	DefaultJavaUtils defaultJavaUtils;

	public boolean generaFileCrif(Date dataCrif, String dateFile) {
		try {
			List<CrifData> crifDataList = generaFileCrifDAO.getFinanzaimentiCrif(dataCrif);
			String fileName = pathDocumentCrif.concat("P7JCONF");
			File fileCrif = new File(fileName);
			FileWriter fw = new FileWriter(fileCrif);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Y076501444060618     30008" + dateFile.replace("/", ""));
			for (int i = 35; i < 300; i++)
				bw.write(" ");
			bw.write("\r\n");
			int numRecord = 0;
			int sommaImporto = 0;
			for (CrifData crifData : crifDataList) {

				if (crifData.getTipoSocieta() == 1) {
					bw.write(crifData.getCodiceFiscale());
				} else {
					bw.write(crifData.getPartitaIva());
					bw.write("     ");
				}

				bw.write(crifData.getPartitaIva());

				if (crifData.getTipoSocieta() == 1) {
					if (crifData.getDataNascita() != null)
						bw.write(defaultJavaUtils.convertStringFromDate(crifData.getDataNascita()).replace("/", ""));
					else
						throw new Exception("La data nascita è null del socio: " + crifData.getIdSoci());

					bw.write("2");
				} else {
					bw.write("000000003");
				}

				sommaImporto += crifData.getImportoGaranzia();

				for (int i = 0; i < (9 - Integer.toString(crifData.getImportoGaranzia()).length()); i++)
					bw.write("0");

				bw.write(crifData.getImportoGaranzia());

				bw.write(crifData.getIdSoci());

				for (int i = 0; i < (16 - Integer.toString(crifData.getIdSoci()).length()); i++)
					bw.write(" ");

				bw.write(crifData.getIdFinanziamenti());

				for (int i = 0; i < (16 - Integer.toString(crifData.getIdFinanziamenti()).length()); i++)
					bw.write(" ");

				bw.write("              0000");

				bw.write(crifData.getProvinciaSedeLegale());

				bw.write("    ");

				bw.write("08987");
				if (crifData.getDataInizioFinanziamento() != null)
					bw.write(defaultJavaUtils.convertStringFromDate(crifData.getDataInizioFinanziamento()).replace("/",
							""));
				else
					throw new Exception(
							"La data inizio Finanziamento è null del finanziamento: " + crifData.getIdFinanziamenti());

				if (crifData.getDataFineFinanziamento() != null)
					bw.write(defaultJavaUtils.convertStringFromDate(crifData.getDataFineFinanziamento()).replace("/",
							""));
				else
					throw new Exception(
							"La data fine Finanziamento è null del finanziamento: " + crifData.getIdFinanziamenti());

				bw.write("P ");
				bw.write("P ");

				bw.write("000000000");

				bw.write("  ");

				bw.write("000000000");

				bw.write("000000000");

				for (int i = 156; i < 300; i++)
					bw.write(" ");

				bw.write("\r\n");
			}

			for (int i = 0; i < (9 - Integer.toString(numRecord).length()); i++)
				bw.write("0");

			bw.write(numRecord);

			for (int i = 0; i < (12 - Integer.toString(sommaImporto).length()); i++)
				bw.write("0");

			bw.write(sommaImporto);

			for (int i = 22; i < 300; i++)
				bw.write(" ");

			bw.flush();
			bw.close();
			return true;
		} catch (Exception e) {
			logger.error("Error Generate Crif File", e);
			return false;
		}
	}

	public List<TableExcelData> generaFileExcel(Date dateStart, Date dateEnd) {
		List<TableExcelData> tableExcelDataList = new ArrayList<TableExcelData>();
		try {
			tableExcelDataList = generaFileCrifDAO.getReportExcel(dateStart, dateEnd);

		} catch (Exception e) {
			logger.error("Error Generate Report Excel", e);
		}
		return tableExcelDataList;
		
	}

}
