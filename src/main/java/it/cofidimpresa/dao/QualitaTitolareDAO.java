package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.QualitaTitolareModel;

public interface QualitaTitolareDAO {
	
	public List<QualitaTitolareModel> getAllQualitaTitolare();
	
	public List<QualitaTitolareModel> getQualitaTitolareById(Integer idQualitaTitolare);

}
