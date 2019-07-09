package it.cofidimpresa.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import it.cofidimpresa.dao.StatoFinanziamentoDAO;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.SettoreImpresaModel;
import it.cofidimpresa.datamodel.StatoFinanziamentiModel;
import it.cofidimpresa.facades.StatoFinanziamentoFacade;

public class DefaultStatoFinanziamentoFacade implements StatoFinanziamentoFacade{
	
	@Resource(name="statoFinanziamentoDAO")
	StatoFinanziamentoDAO statoFinanziamentoDAO;

	public String getStatoFinanziamento(int idStatoFinanziamento) {
		return statoFinanziamentoDAO.getStatoFinanziamento(idStatoFinanziamento);
	}

	public List<StateObjectData> getAllStatoFinanziamenti() {
		List<StatoFinanziamentiModel> statoFinList = statoFinanziamentoDAO.getAllStatoFinanziamenti();
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		for (StatoFinanziamentiModel statoFin : statoFinList) {
			StateObjectData stateObjectData = new StateObjectData();
			stateObjectData.setId(statoFin.getIdStatoFinanziamenti());
			stateObjectData.setDescrizione(statoFin.getDescrizione());
			result.add(stateObjectData);
		}
		return result;
	}

}
