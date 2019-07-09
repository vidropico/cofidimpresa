package it.cofidimpresa.facades;

import java.util.List;

import it.cofidimpresa.data.AntiriciclaggioData;
import it.cofidimpresa.data.AntiriciclaggioTmpData;

public interface AntiriciclaggioFacade {
	
	public int inserisciAntiriciclaggio(AntiriciclaggioData antTmpData);
	
	public int updateAntiriciclaggio(AntiriciclaggioData antTmpData);
	
	public List<AntiriciclaggioData> getAntiriciclaggioById(Integer idAnt);
	
	public List<AntiriciclaggioData> getAntiriciclaggioByIdFin(Integer idFin);
	
	public List<AntiriciclaggioData> elecoAntiriciclaggio();
}
