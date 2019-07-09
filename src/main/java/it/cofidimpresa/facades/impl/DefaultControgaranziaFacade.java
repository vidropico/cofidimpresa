package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.impl.DefaultControgaranziaDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.BancheModel;
import it.cofidimpresa.datamodel.GaranziaModel;
import it.cofidimpresa.facades.ControgaranziaFacade;

public class DefaultControgaranziaFacade implements ControgaranziaFacade {

	@Resource(name="controgaranziaDAO")
	DefaultControgaranziaDAO controgaranziaDAO;
	
	public List<StateObjectData> getAllControgaranzia() {
		List<GaranziaModel> controGaranziaList = controgaranziaDAO.getAllGaranzia();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (GaranziaModel bancheList : controGaranziaList) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(bancheList.getIdGaranzia());
			stateObjectData.setDescrizione(bancheList.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
