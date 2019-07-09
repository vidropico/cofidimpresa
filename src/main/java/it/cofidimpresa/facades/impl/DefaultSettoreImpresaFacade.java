package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.SettoreImpresaDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.SettoreImpresaModel;
import it.cofidimpresa.facades.SettoreImpresaFacade;

public class DefaultSettoreImpresaFacade implements SettoreImpresaFacade {
	
	@Resource(name="settoreImpresaDAO")
	SettoreImpresaDAO settoreImpresaDAO;
	
	public List<StateObjectData> getAllSettoreImpresa() {
		List<SettoreImpresaModel> allSettoreImpresa = settoreImpresaDAO.getAllSettoreImpresa();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (SettoreImpresaModel settoreImpresa : allSettoreImpresa) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(settoreImpresa.getIdSettoreImpresa());
			stateObjectData.setDescrizione(settoreImpresa.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
