package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.QualitaTitolareDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.QualitaTitolareModel;
import it.cofidimpresa.facades.QualitaTitolareFacade;

public class DefaultQualitaTitolareFacade implements QualitaTitolareFacade {

	@Resource(name="qualitaTitolareDAO")
	QualitaTitolareDAO qualitaTitolareDAO;
	
	public List<StateObjectData> getAllQualitaTitolare() {
		List<QualitaTitolareModel> allQualitaTitolare = qualitaTitolareDAO.getAllQualitaTitolare();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (QualitaTitolareModel qualitaTitolare : allQualitaTitolare) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(qualitaTitolare.getIdQualitaTitolare());
			stateObjectData.setDescrizione(qualitaTitolare.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

	public List<StateObjectData> getQualitaTitolare(Integer idQualitaTitolare) {
		List<QualitaTitolareModel> allQualitaTitolare = qualitaTitolareDAO.getAllQualitaTitolare();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (QualitaTitolareModel qualitaTitolare : allQualitaTitolare) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(qualitaTitolare.getIdQualitaTitolare());
			stateObjectData.setDescrizione(qualitaTitolare.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
