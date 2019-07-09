package it.cofidimpresa.facades.impl;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.cofidimpresa.dao.FinanziamentiDAO;
import it.cofidimpresa.data.FinanziamentiData;
import it.cofidimpresa.data.FinanziamentiTableData;
import it.cofidimpresa.datamodel.FinanziamentiModel;
import it.cofidimpresa.datamodel.SociModel;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.SociFacade;
import it.cofidimpresa.facades.StatoFinanziamentoFacade;
import it.cofidimpresa.utils.DefaultJavaUtils;

public class DefaultFinanziamentiFacade implements FinanziamentiFacade {

	private static final Logger logger = Logger.getLogger(DefaultFinanziamentiFacade.class);

	@Resource(name = "finanziamentiDAO")
	FinanziamentiDAO finanziamentiDAO;

	@Resource(name = "statoFinanziamentoFacade")
	StatoFinanziamentoFacade statoFinanziamentoFacade;

	@Resource(name = "sociFacade")
	SociFacade sociFacade;

	@Resource(name="defaultJavaUtils")
	DefaultJavaUtils defaultJavaUtils;
	
	public int getNumeroFinanziamenti() {
		return finanziamentiDAO.getNumAllFinanziamenti();
	}

	public int getNumFinanziamentiSocio(int idSocio) {
		return finanziamentiDAO.getNumFinanziamentiSocio(idSocio);
	}

	public List<FinanziamentiTableData> getAllFinanziamenti() {
		logger.debug("*** Start getAllFinanziamenti ");
		List<FinanziamentiTableData> finanziamentiTableDatas = new ArrayList<FinanziamentiTableData>();
		List<FinanziamentiModel> finaziamentiModels = finanziamentiDAO.getAllFinanziamenti();

		for (FinanziamentiModel finanziamentiModel : finaziamentiModels) {
			FinanziamentiTableData finanziamentiTableData = new FinanziamentiTableData();
			finanziamentiTableData.setIdFinanziamenti(finanziamentiModel.getIdFinanziamenti());
			finanziamentiTableData.setDataApprovazioneConsiglio(finanziamentiModel.getDataApprovazioneConsiglio());
			finanziamentiTableData.setDataErogazioneFinanziamento(finanziamentiModel.getDataErogazioneFinanziamento());
			finanziamentiTableData.setImportoDeliberato(Integer.toString(finanziamentiModel.getImportoDeliberato()));
			finanziamentiTableData.setImportoErogato(finanziamentiModel.getImporto());
			finanziamentiTableData.setImportoGaranzia(Double.toString(finanziamentiModel.getImportoGaranzia()));
			finanziamentiTableData.setPercentualeGaranzia(finanziamentiModel.getPercentualeGaranzia());
			finanziamentiTableData.setRate(finanziamentiModel.getRate());
			finanziamentiTableData.setIdSocio(finanziamentiModel.getIdSoci());
			
			SociModel socio = sociFacade.getSocioById(finanziamentiModel.getIdSoci());
			if (StringUtils.isNotEmpty(socio.getImpresa())) {
				finanziamentiTableData.setImpresa(socio.getImpresa());
			} else {
				finanziamentiTableData.setImpresa(socio.getCognome() + " " + socio.getNome());
			}
			finanziamentiTableData.setStato(
					statoFinanziamentoFacade.getStatoFinanziamento(finanziamentiModel.getIdStatoFinanziamenti()));

			finanziamentiTableDatas.add(finanziamentiTableData);

		}

		return finanziamentiTableDatas;
	}

	public List<FinanziamentiData> getFinanziamentiSocio(int idSocio) throws ParseException {
		List<FinanziamentiModel> finSocioList = finanziamentiDAO.getFinanziamentiBySocio(idSocio);
		List<FinanziamentiData> result = new ArrayList<FinanziamentiData>();
		for (FinanziamentiModel fin : finSocioList) {
			result.add(convertFinModelToData(fin));
		}
		return result;
	}

	public List<FinanziamentiTableData> getFinanziamentioListBySocio(Integer idSocio) {
		List<FinanziamentiTableData> finanziamentiTableDatas = new ArrayList<FinanziamentiTableData>();
		List<FinanziamentiModel> finaziamentiModels = finanziamentiDAO.getFinanziamentiBySocio(idSocio);
		for (FinanziamentiModel finanziamentiModel : finaziamentiModels) {
			FinanziamentiTableData finanziamentiTableData = new FinanziamentiTableData();
			finanziamentiTableData.setIdFinanziamenti(finanziamentiModel.getIdFinanziamenti());
			finanziamentiTableData.setDataApprovazioneConsiglio(finanziamentiModel.getDataApprovazioneConsiglio());
			finanziamentiTableData.setDataErogazioneFinanziamento(finanziamentiModel.getDataErogazioneFinanziamento());
			finanziamentiTableData.setImportoDeliberato(Integer.toString(finanziamentiModel.getImportoDeliberato()));
			finanziamentiTableData.setImportoErogato(finanziamentiModel.getImporto());
			finanziamentiTableData.setImportoGaranzia(Double.toString(finanziamentiModel.getImportoGaranzia()));
			finanziamentiTableData.setPercentualeGaranzia(finanziamentiModel.getPercentualeGaranzia());
			finanziamentiTableData.setRate(finanziamentiModel.getRate());
			SociModel socio = sociFacade.getSocioById(finanziamentiModel.getIdSoci());
			if (StringUtils.isNotEmpty(socio.getImpresa())) {
				finanziamentiTableData.setImpresa(socio.getImpresa());
			} else {
				finanziamentiTableData.setImpresa(socio.getCognome() + " " + socio.getNome());
			}
			finanziamentiTableData.setStato(
					statoFinanziamentoFacade.getStatoFinanziamento(finanziamentiModel.getIdStatoFinanziamenti()));

			finanziamentiTableDatas.add(finanziamentiTableData);

		}

		return finanziamentiTableDatas;
	}
	
	public Integer insertFinanziamento(FinanziamentiData fin) throws ParseException {
		FinanziamentiModel finModel = new FinanziamentiModel();
		finModel=convertFinDataToModel(fin);
		return finanziamentiDAO.insertFinanziamento(finModel);
	}
	
	public Integer updateFinanziamento(FinanziamentiData fin) throws ParseException {
		FinanziamentiModel finModel = new FinanziamentiModel();
		finModel=convertFinDataToModel(fin);
		return finanziamentiDAO.updateFinanziamento(finModel);
	}

	private FinanziamentiModel convertFinDataToModel(FinanziamentiData fin) throws ParseException {
		
		FinanziamentiModel result = new FinanziamentiModel();
		result.setAzioni(fin.getAzioni());
		result.setCosti(fin.getCosti());
		result.setCostoIstruttoria(fin.getCostoIstruttoria());
		if (StringUtils.isNotEmpty(fin.getDataApprovazioneConsiglio())) {
 			result.setDataApprovazioneConsiglio(defaultJavaUtils.convertDateFromString(fin.getDataApprovazioneConsiglio()));
		}
		if (StringUtils.isNotEmpty(fin.getDataErogazioneFinanziamento())) {
			result.setDataErogazioneFinanziamento(defaultJavaUtils.convertDateFromString(fin.getDataErogazioneFinanziamento()));
		}
		if (StringUtils.isNotEmpty(fin.getDataFineFinanziamento())) {
			result.setDataFineFinanziamento(defaultJavaUtils.convertDateFromString(fin.getDataFineFinanziamento()));
		}
		result.setIdBanche(fin.getIdBanche());
		result.setIdFinanziamenti(fin.getIdFinanziamenti());
		result.setIdGaranzia(fin.getIdGaranzia());
		result.setIdSoci(fin.getIdSoci());
		result.setIdStatoFinanziamenti(fin.getIdStatoFinanziamenti());
		result.setIdUtente(fin.getIdUtente());
		result.setImporto(fin.getImporto());
		result.setImportoDeliberato(fin.getImportoDeliberato());
		result.setImportoGaranzia(fin.getImportoGaranzia());
		result.setImportoRata(fin.getImportoRata());
		result.setImportoRichiesto(fin.getImportoRichiesto());
		result.setImportoScaduto(fin.getImportoScaduto());
		result.setNaturaFinanziamento(fin.getNaturaFinanziamento());
		result.setNomeAvvocato(fin.getNomeAvvocato());
		result.setNote(fin.getNote());
		result.setPagamento(fin.getPagamento());
		result.setPercentualeGaranzia(fin.getPercentualeGaranzia());
		result.setPianoRientro(fin.getPianoRientro());
		result.setProvinciaSedeLegale(fin.getProvinciaSedeLegale());
		result.setRate(fin.getRate());
		result.setRateScadute(fin.getRateScadute());
		result.setRisultato(fin.getRisultato());
		result.setTipologiaRientro(fin.getTipologiaRientro());
		result.setRateRichieste(fin.getRateRichieste());
		result.setIstruttoriaBanca(fin.getIstruttoriaBanca());
		result.setImpQuotaBanca(fin.getImpQuotaBanca());
		result.setAccredito(fin.getAccredito());
		result.setFlgUsura(fin.getFlgUsura());
		return result;
	}

	private FinanziamentiData convertFinModelToData(FinanziamentiModel fin) throws ParseException {
		FinanziamentiData result = new FinanziamentiData();
		result.setAzioni(fin.getAzioni());
		result.setCosti(fin.getCosti());
		result.setCostoIstruttoria(fin.getCostoIstruttoria());
		if (null != fin.getDataApprovazioneConsiglio()) {
			result.setDataApprovazioneConsiglio(defaultJavaUtils.convertStringFromDate((Date) fin.getDataApprovazioneConsiglio()));
		}
		if (null != fin.getDataErogazioneFinanziamento()) {
			result.setDataErogazioneFinanziamento(defaultJavaUtils.convertStringFromDate((Date) fin.getDataErogazioneFinanziamento()));
		}
		if (null != fin.getDataFineFinanziamento()) {
			result.setDataFineFinanziamento(defaultJavaUtils.convertStringFromDate((Date) fin.getDataFineFinanziamento()));
		}
		result.setIdBanche(fin.getIdBanche());
		result.setIdFinanziamenti(fin.getIdFinanziamenti());
		result.setIdGaranzia(fin.getIdGaranzia());
		result.setIdSoci(fin.getIdSoci());
		result.setIdStatoFinanziamenti(fin.getIdStatoFinanziamenti());
		result.setIdUtente(fin.getIdUtente());
		result.setImporto(fin.getImporto());
		result.setImportoDeliberato(fin.getImportoDeliberato());
		result.setImportoGaranzia(fin.getImportoGaranzia());
		result.setImportoRata(fin.getImportoRata());
		result.setImportoRichiesto(fin.getImportoRichiesto());
		result.setImportoScaduto(fin.getImportoScaduto());
		result.setNaturaFinanziamento(fin.getNaturaFinanziamento());
		result.setNomeAvvocato(fin.getNomeAvvocato());
		result.setNote(fin.getNote());
		result.setPagamento(fin.getPagamento());
		result.setPercentualeGaranzia(fin.getPercentualeGaranzia());
		result.setPianoRientro(fin.getPianoRientro());
		result.setProvinciaSedeLegale(fin.getProvinciaSedeLegale());
		result.setRate(fin.getRate());
		result.setRateScadute(fin.getRateScadute());
		result.setRisultato(fin.getRisultato());
		result.setTipologiaRientro(fin.getTipologiaRientro());
		result.setRateRichieste(fin.getRateRichieste());
		result.setAccredito(fin.getAccredito());
		result.setIstruttoriaBanca(fin.getIstruttoriaBanca());
		result.setImpQuotaBanca(fin.getImpQuotaBanca());
		result.setFlgUsura(fin.getFlgUsura());
		return result;
	}

	public FinanziamentiData getFinanziamentiById(int idFinanziamenti) throws ParseException {
		FinanziamentiModel fin = finanziamentiDAO.getFinanziamentoById(idFinanziamenti);
		return convertFinModelToData(fin);
	}

}
