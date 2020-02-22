package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.AntiriciclaggioModel;
import it.cofidimpresa.datamodel.AntiriciclaggioTmpModel;

public interface AntiriciclaggioDAO {

	public int inserisciAntiriciclaggio(AntiriciclaggioModel antModel);
	
	public int updateAntiriciclaggio(AntiriciclaggioModel antModel);
	
	public int maxNumeroProgressivo(String year);
	
	public List<AntiriciclaggioModel> getAntiriciclaggioById(Integer idAnt);
	
	public List<AntiriciclaggioModel> getAntiriciclaggioByIdFin(Integer idFin);
	
	public List<AntiriciclaggioModel> elencoAntiriciclaggio();
	
	public List<AntiriciclaggioModel> elencoAntiriciclaggio(String anno);
}
