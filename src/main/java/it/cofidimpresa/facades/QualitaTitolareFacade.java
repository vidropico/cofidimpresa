package it.cofidimpresa.facades;

import java.util.List;

import it.cofidimpresa.data.StateObjectData;

public interface QualitaTitolareFacade {
	
	public List<StateObjectData> getAllQualitaTitolare();
	
	public List<StateObjectData> getQualitaTitolare(Integer idQualitaTitolare);

}
