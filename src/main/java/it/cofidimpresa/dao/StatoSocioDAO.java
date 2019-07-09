package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.StatoSocioModel;

public interface StatoSocioDAO {
	
	public String getStatoSocio(int idStatoSocio);
	
	public List<StatoSocioModel> getAllStatoSocio();

}
