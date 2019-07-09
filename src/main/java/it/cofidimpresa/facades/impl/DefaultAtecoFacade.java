package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.AtecoDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.AtecoModel;
import it.cofidimpresa.facades.AtecoFacade;

public class DefaultAtecoFacade implements AtecoFacade {

	@Resource(name="atecoDAO")
	public AtecoDAO atecoDAO;
	
	public void removeAteco(Integer idSocio, Integer idAteco) {
		atecoDAO.removeAteco(idSocio, idAteco);
	}
	public List<StateObjectData> getAtecoFromSocio(Integer idSocio) {
		List<Integer> idAtecoList = atecoDAO.getAtecoListFromSocio(idSocio);
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (Integer idAteco : idAtecoList) {
			result.add(convertStateObjectDataFromAteco(atecoDAO.getAtecoById(idAteco)));
		}
		return result;
	}
	private StateObjectData convertStateObjectDataFromAteco(AtecoModel atecoById) {
		StateObjectData result = new StateObjectData();
		result.setId(atecoById.getIdAteco());
		result.setDescrizione(atecoById.getCodiceAteco().concat(" - ").concat(atecoById.getDescrizione()));
		return result;
	}

}
