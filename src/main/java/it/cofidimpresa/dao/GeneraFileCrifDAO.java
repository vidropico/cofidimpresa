package it.cofidimpresa.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import it.cofidimpresa.data.CrifData;
import it.cofidimpresa.data.TableExcelData;

public interface GeneraFileCrifDAO {

	public List<CrifData> getFinanzaimentiCrif(Date dataRiferimentoCrif);
	
	public List<TableExcelData> getReportExcel(Date dateStart, Date dataEnd) throws ParseException;
}
