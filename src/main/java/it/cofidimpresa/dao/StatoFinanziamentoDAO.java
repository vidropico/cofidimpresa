package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.StatoFinanziamentiModel;

public interface StatoFinanziamentoDAO {
	
	public String getStatoFinanziamento(int idStatoFinanziamento);
	
	public List<StatoFinanziamentiModel> getAllStatoFinanziamenti();
 	
}
