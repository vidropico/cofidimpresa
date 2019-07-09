package it.cofidimpresa.facades;

import java.sql.Date;
import java.util.List;

import it.cofidimpresa.data.TableExcelData;

public interface GeneraFileCrifFacade {

	public boolean generaFileCrif(Date dataCrif, String dateFile);
	
	public List<TableExcelData> generaFileExcel(Date dataStart, Date dateEnd);
}
