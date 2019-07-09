package it.cofidimpresa.facades;

import java.util.List;

import it.cofidimpresa.data.StateObjectData;

public interface StatoFinanziamentoFacade {
	
	public String getStatoFinanziamento(int idStatoFinanziamento);
	
	public List<StateObjectData> getAllStatoFinanziamenti();

}
