package it.cofidimpresa.facades;

import java.text.ParseException;
import java.util.List;

import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.SociTableData;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.SociModel;

public interface SociFacade {
	
	public int getNumeroSoci();
	
	public List<SociTableData> getAllSoci();
	
	public SociModel getSocioById(int idSocio);
	
	public List<StateObjectData> getAtecoList();

	public SociData addSocio(SociData socio) throws ParseException;
	
	public SociData dettaglioSocio(Integer idSocio) throws ParseException;
	
	public SociData modificaSocio(SociData socio) throws ParseException, Exception;

	public Integer getIdSocioByPIva(String pIva) throws ParseException;
}
