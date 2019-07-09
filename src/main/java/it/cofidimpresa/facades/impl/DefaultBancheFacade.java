package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.impl.DefaultBancheDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.BancheModel;
import it.cofidimpresa.facades.BancheFacade;

public class DefaultBancheFacade implements BancheFacade {
	
	@Resource(name="bancheDAO")
	DefaultBancheDAO bancheDAO;
	
	public List<StateObjectData> getAllBanche() {
		List<BancheModel> bancheModelList = bancheDAO.getAllBanche();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (BancheModel bancheList : bancheModelList) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(bancheList.getIdBanche());
			stateObjectData.setDescrizione(bancheList.getNomeBanche());
			result.add(stateObjectData);
		}
		return result;
	}

}
