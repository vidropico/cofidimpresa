package it.cofidimpresa.facades;

import java.util.List;

import it.cofidimpresa.data.StateObjectData;

public interface AtecoFacade {

	public void removeAteco(Integer idSocio, Integer idAteco);
	
	public List<StateObjectData> getAtecoFromSocio(Integer idSocio);	
}
