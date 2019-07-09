package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.StatoSocioDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.StatoSocioModel;
import it.cofidimpresa.facades.StatoSocioFacade;

public class DefaultStatoSocioFacade implements StatoSocioFacade{

	@Resource(name="statoSocioDAO")
	StatoSocioDAO statoSocioDAO;
	
	public String getStatoSocio(int idStatoSocio) {
		return statoSocioDAO.getStatoSocio(idStatoSocio);
	}

	public List<StateObjectData> getAllStatoSocio() {
		List<StatoSocioModel> allStatoSocio = statoSocioDAO.getAllStatoSocio();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (StatoSocioModel statoSocioModel : allStatoSocio) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(statoSocioModel.getIdStatoSocio());
			stateObjectData.setDescrizione(statoSocioModel.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
