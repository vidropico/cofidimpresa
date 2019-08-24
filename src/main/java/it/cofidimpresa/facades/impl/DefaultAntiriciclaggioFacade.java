package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.AntiriciclaggioDAO;
import it.cofidimpresa.dao.FinanziamentiDAO;
import it.cofidimpresa.dao.SociDAO;
import it.cofidimpresa.data.AntiriciclaggioData;
import it.cofidimpresa.data.AntiriciclaggioTmpData;
import it.cofidimpresa.datamodel.AntiriciclaggioModel;
import it.cofidimpresa.datamodel.AntiriciclaggioTmpModel;
import it.cofidimpresa.datamodel.FinanziamentiModel;
import it.cofidimpresa.facades.AntiriciclaggioFacade;

public class DefaultAntiriciclaggioFacade implements AntiriciclaggioFacade{

	@Resource(name="antiriciclaggioDAO")
	AntiriciclaggioDAO antiriciclaggioDAO;
	
	@Resource(name="finanziamentiDAO")
	FinanziamentiDAO finanziamentiDAO;
	
	@Resource(name="sociDAO")
	SociDAO sociDAO;
	
	public int inserisciAntiriciclaggio(AntiriciclaggioData antData) {
		AntiriciclaggioModel antiriciclaggioModel = new AntiriciclaggioModel();
		FinanziamentiModel result = finanziamentiDAO.getFinanziamentoById(antData.getIdFinanziamento());
		Integer yearInt = result.getDataApprovazioneConsiglio().getYear();
		yearInt=yearInt+1900;
		Integer numProgressivo = antiriciclaggioDAO.maxNumeroProgressivo(Integer.toString(yearInt));
		antData.setAnnoProgressivo (yearInt);
		antData.setNumeroProgressivo(numProgressivo+1);
		antData.setDataInserimento(result.getDataApprovazioneConsiglio());
		convertDataToModel(antData,antiriciclaggioModel);
		int idAntiriciclaggio = antiriciclaggioDAO.inserisciAntiriciclaggio(antiriciclaggioModel);
		return idAntiriciclaggio;
	}
	
	public int updateAntiriciclaggio(AntiriciclaggioData antData) {
		AntiriciclaggioModel antiriciclaggioModel = new AntiriciclaggioModel();
		convertDataToModel(antData,antiriciclaggioModel);
		int idAntiriciclaggio = antiriciclaggioDAO.updateAntiriciclaggio(antiriciclaggioModel);
		return idAntiriciclaggio;
	}
	
	public List<AntiriciclaggioData> getAntiriciclaggioById(Integer idAnt) {
		List<AntiriciclaggioData> resultData = new ArrayList<AntiriciclaggioData>();
		List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();
		result = antiriciclaggioDAO.getAntiriciclaggioById(idAnt);
		for (AntiriciclaggioModel antTmpModel : result) {
			AntiriciclaggioData antData = new AntiriciclaggioData();
			convertModelToData(antTmpModel,antData);
			antData.setImpresa(sociDAO.getSocioById(antTmpModel.getIdSoci()).getImpresa());
			resultData.add(antData);
		}
			
		return resultData;
	}

	public List<AntiriciclaggioData> getAntiriciclaggioByIdFin(Integer idFin) {
		List<AntiriciclaggioData> resultData = new ArrayList<AntiriciclaggioData>();
		List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();
		result = antiriciclaggioDAO.getAntiriciclaggioByIdFin(idFin);
		for (AntiriciclaggioModel antTmpModel : result) {
			AntiriciclaggioData antData = new AntiriciclaggioData();
			convertModelToData(antTmpModel,antData);
			antData.setImpresa(sociDAO.getSocioById(antTmpModel.getIdSoci()).getImpresa());
			resultData.add(antData);
		}
			
		return resultData;
	}
	public List<AntiriciclaggioData> elecoAntiriciclaggio() {
		List<AntiriciclaggioData> resultData = new ArrayList<AntiriciclaggioData>();
		List<AntiriciclaggioModel> result = new ArrayList<AntiriciclaggioModel>();
		result = antiriciclaggioDAO.elencoAntiriciclaggio();
		for (AntiriciclaggioModel antTmpModel : result) {
			AntiriciclaggioData antData = new AntiriciclaggioData();
			convertModelToData(antTmpModel,antData);
			antData.setImpresa(sociDAO.getSocioById(antTmpModel.getIdSoci()).getImpresa());
			resultData.add(antData);
		}
			
		return resultData;
	}
	
	private void convertModelToData(AntiriciclaggioModel antModel, AntiriciclaggioData antData) {
		antData.setAnnoProgressivo(antModel.getAnnoProgressivo());
		antData.setAutoritaCompetente(antModel.getAutoritaCompetente());
		antData.setDataInserimento(antModel.getDataInserimento());
		antData.setDataRilascio(antModel.getDataRilascio());
		antData.setDataScadenza(antModel.getDataScadenza());
		antData.setFlagInsCompleto(antModel.getFlagInsCompleto());
		antData.setFlagStampa(antModel.getFlagStampa());
		antData.setIdAntiriciclaggio(antModel.getIdAntiriciclaggio());
		antData.setIdDocumento(antModel.getIdDocumento());
		antData.setIdFinanziamento(antModel.getIdFinanziamento());
		antData.setIdSoci(antModel.getIdSoci());
		antData.setLuogoRilascio(antModel.getLuogoRilascio());	
		antData.setNumeroDocumento(antModel.getNumeroDocumento());
		antData.setNumeroProgressivo(antModel.getNumeroProgressivo());
		antData.setNominativo(antModel.getNominativo());
		
	}

	private void convertDataToModel(AntiriciclaggioData antData,
			AntiriciclaggioModel antiriciclaggioModel) {
		antiriciclaggioModel.setAnnoProgressivo(antData.getAnnoProgressivo());
		antiriciclaggioModel.setAutoritaCompetente(antData.getAutoritaCompetente());
		antiriciclaggioModel.setDataInserimento(antData.getDataInserimento());
		antiriciclaggioModel.setDataRilascio(antData.getDataRilascio());
		antiriciclaggioModel.setDataScadenza(antData.getDataScadenza());
		antiriciclaggioModel.setFlagInsCompleto(antData.getFlagInsCompleto());
		antiriciclaggioModel.setFlagStampa(antData.getFlagStampa());
		antiriciclaggioModel.setIdAntiriciclaggio(antData.getIdAntiriciclaggio());
		antiriciclaggioModel.setIdDocumento(antData.getIdDocumento());
		antiriciclaggioModel.setIdFinanziamento(antData.getIdFinanziamento());
		antiriciclaggioModel.setIdSoci(antData.getIdSoci());
		antiriciclaggioModel.setLuogoRilascio(antData.getLuogoRilascio());	
		antiriciclaggioModel.setNumeroDocumento(antData.getNumeroDocumento());
		antiriciclaggioModel.setNumeroProgressivo(antData.getNumeroProgressivo());
		antiriciclaggioModel.setNominativo(antData.getNominativo());
		
	}
	
}
