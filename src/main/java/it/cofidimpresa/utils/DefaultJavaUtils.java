package it.cofidimpresa.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DefaultJavaUtils {

	public Date convertDateFromString(String dataStringa) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		Date result = new Date(formatter.parse(dataStringa).getTime());
		//Date result = Date.valueOf(dataStringaCorretta);
		return result;
	}
	
	public String convertStringFromDate(Date data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataStringaCorretta = formatter.format(data);
		return dataStringaCorretta;
	}
	
	public String formatDateFromString(String dataStringa) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setLenient(false);
		String result = formatter.format(dataStringa);
		return result;
	}
	
}
