package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.TipoSocietaDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.TipoSocietaModel;
import it.cofidimpresa.facades.TipoSocietaFacade;

public class DefaultTipoSocietaFacade  implements TipoSocietaFacade{
	
	@Resource(name="tipoSocietaDAO")
	TipoSocietaDAO tipoSocietaDAO;
	
	public List<StateObjectData> getAllTipoSocieta() {
		List<TipoSocietaModel> allTipoSocieta = tipoSocietaDAO.getAllTipoSocieta();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (TipoSocietaModel tipoSocieta : allTipoSocieta) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(tipoSocieta.getIdTipoSocieta());
			stateObjectData.setDescrizione(tipoSocieta.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
