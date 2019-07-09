package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.AtecoModel;
import it.cofidimpresa.datamodel.SociModel;

public interface SociDAO {

	public int getNumAllSoci();
	
	public List<SociModel> findAllSoci();
	
	public SociModel getSocioById(int idSocio);
	
	public List<AtecoModel> getCodiciAteco();

	public Integer addSocio(SociModel sociModel);
	
	public void addStoricoSocio(SociModel sociModel, Integer idSocio);
	
	public void addSocioAteco(int idAteco, int idSocio);
	
	public Integer updateSocio(SociModel sociModel);
	
	public Integer getIdSocioByPartitaIva(String pIva);
	
}
