package it.cofidimpresa.facades;

import java.util.List;

import it.cofidimpresa.data.StateObjectData;

public interface StatoSocioFacade {

	public String getStatoSocio(int idStatoSocio);
	
	public List<StateObjectData> getAllStatoSocio();
}
