package it.cofidimpresa.facades;

import java.text.ParseException;
import java.util.List;

import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.FinanziamentiTableData;

public interface FinanziamentiFacade {
	
	public int getNumeroFinanziamenti();
	
	public int getNumFinanziamentiSocio(int idSocio);
	
	public List<FinanziamentiTableData> getAllFinanziamenti();
	
	public List<FinanziamentiData> getFinanziamentiSocio(int idSocio) throws ParseException;
	
	public List<FinanziamentiTableData> getFinanziamentioListBySocio(Integer idSocio);
	
	public FinanziamentiData getFinanziamentiById(int idFinanziamenti) throws ParseException;
	
	public Integer insertFinanziamento(FinanziamentiData fin) throws ParseException;
	
	public Integer updateFinanziamento(FinanziamentiData fin) throws ParseException;

}
