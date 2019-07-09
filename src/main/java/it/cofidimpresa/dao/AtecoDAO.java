package it.cofidimpresa.dao;

import java.util.List;

import it.cofidimpresa.datamodel.AtecoModel;

public interface AtecoDAO {
	
	public void removeAteco(Integer idSocio, Integer idAteco);
	
	public List<Integer> getAtecoListFromSocio(Integer idSocio);
	
	public AtecoModel getAtecoById(Integer idAteco);
}
