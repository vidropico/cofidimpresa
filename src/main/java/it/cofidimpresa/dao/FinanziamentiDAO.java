package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.FinanziamentiModel;

public interface FinanziamentiDAO {
	
	public int getNumAllFinanziamenti();
	
	public int getNumFinanziamentiSocio(int idSocio);
	
	public List<FinanziamentiModel> getAllFinanziamenti();
	
	public FinanziamentiModel getFinanziamentoById(int idFinanziamento);
	
	public List<FinanziamentiModel> getFinanziamentiBySocio(int idSocio);
	
	public int insertFinanziamento(FinanziamentiModel fin);
	
	public int updateFinanziamento(FinanziamentiModel fin);

}
