package it.cofidimpresa.facades.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import it.cofidimpresa.dao.AtecoDAO;
import it.cofidimpresa.dao.SociDAO;
import it.cofidimpresa.data.SociData;
import it.cofidimpresa.data.SociTableData;
import it.cofidimpresa.data.StateObjectData;
import it.cofidimpresa.datamodel.AtecoModel;
import it.cofidimpresa.datamodel.SociModel;
import it.cofidimpresa.facades.FinanziamentiFacade;
import it.cofidimpresa.facades.SociFacade;
import it.cofidimpresa.facades.StatoSocioFacade;
import it.cofidimpresa.utils.DefaultJavaUtils;

public class DefaultSociFacade implements SociFacade {

	private static final Logger logger = Logger.getLogger(DefaultSociFacade.class);

	@Resource(name = "sociDAO")
	SociDAO sociDAO;

	@Resource(name = "finanziamentiFacade")
	FinanziamentiFacade finanziamentiFacade;

	@Resource(name = "statoSocioFacade")
	StatoSocioFacade statoSocioFacade;

	@Resource(name = "atecoDAO")
	AtecoDAO atecoDAO;

	@Resource(name = "defaultJavaUtils")
	DefaultJavaUtils defaultJavaUtils;

	public int getNumeroSoci() {
		logger.debug("*** Start getNumeroSoci ");
		return sociDAO.getNumAllSoci();
	}

	public List<SociTableData> getAllSoci() {
		logger.debug("*** Start getAllSoci ");
		List<SociTableData> sociTableDatas = new ArrayList<SociTableData>();
		List<SociModel> sociModels = sociDAO.findAllSoci();

		for (SociModel sociModel : sociModels) {
			SociTableData sociTableData = new SociTableData();
			sociTableData.setIdSocio(sociModel.getIdSoci());
			sociTableData.setCodFiscale(sociModel.getCodiceFiscale());
			sociTableData.setDataInizio(sociModel.getDataInizio());
			sociTableData.setEmail(sociModel.getEmail());
			if (StringUtils.isNotEmpty(sociModel.getImpresa())) {
				sociTableData.setImpresa(sociModel.getImpresa());
			} else {
				sociTableData.setImpresa(sociModel.getCognome() + " " + sociModel.getNome());
			}
			sociTableData.setIndirizzoAzienda(sociModel.getIndirizzoAzienda() + " " + sociModel.getCittaAzienda());
			sociTableData.setpIva(sociModel.getPartitaIva());
			sociTableData.setTipologiaMerceologica(sociModel.getTipologiaMerceologica());
			sociTableData.setCodiceUnivoco(sociModel.getCodiceUnivoco());
			sociTableData.setStato(statoSocioFacade.getStatoSocio(sociModel.getIdStatoSocio()));
			sociTableData.setFinanziamentiNum(
					Integer.toString(finanziamentiFacade.getNumFinanziamentiSocio(sociModel.getIdSoci())));

			sociTableDatas.add(sociTableData);
		}

		return sociTableDatas;
	}

	public SociModel getSocioById(int idSocio) {
		return sociDAO.getSocioById(idSocio);
	}

	public List<StateObjectData> getAtecoList() {
		logger.debug("*** Start getAtecoList ");
		List<StateObjectData> result = new ArrayList<StateObjectData>();
		List<AtecoModel> atecoList = sociDAO.getCodiciAteco();
		for (AtecoModel atecoModel : atecoList) {
			StateObjectData stData = new StateObjectData();
			stData.setId(atecoModel.getIdAteco());
			stData.setDescrizione(atecoModel.getCodiceAteco().concat(" - ").concat(atecoModel.getDescrizione()));

			result.add(stData);
		}
		return result;
	}

	public SociData addSocio(SociData socio) throws ParseException {
		logger.debug("*** Start addSocio ");
		SociModel sociModel = new SociModel();
		converterDataToModel(socio, sociModel);
		Integer idSocio = sociDAO.addSocio(sociModel);
		socio.setIdSoci(idSocio);
		sociDAO.addStoricoSocio(sociModel, idSocio);
		if (!CollectionUtils.isEmpty(socio.getIdAteco())) {
			if (idSocio.intValue() > 0) {
				for (Integer idAteco : socio.getIdAteco()) {
					if(idAteco != null) {
						sociDAO.addSocioAteco(idAteco.intValue(), idSocio.intValue());
					}
				}
			}else {
				logger.info("Id socio per inserimento Ateco non presente");
			}
		}
		return socio;
	}

	public SociData dettaglioSocio(Integer idSocio) throws ParseException {
		logger.debug("*** Start dettaglioSocio ");
		SociModel sociModel = new SociModel();
		sociModel = sociDAO.getSocioById(idSocio);
		SociData socio = new SociData();
		converterModelToData(sociModel, socio);

		return socio;
	}

	public SociData modificaSocio(SociData socio) throws ParseException, Exception {
		logger.debug("*** Start modificaSocio ");
		SociModel sociModel = new SociModel();
		converterDataToModel(socio, sociModel);
		Integer result = sociDAO.updateSocio(sociModel);
		if (result.intValue() <= 0) {
			throw new Exception("Si è verificato un errore nell'aggiornamento del socio");
		}
		Integer idSocio = socio.getIdSoci();
		if (!CollectionUtils.isEmpty(socio.getIdAteco())) {
			for (Integer idAteco : socio.getIdAteco()) {
				if (idAteco != null) {
					sociDAO.addSocioAteco(idAteco.intValue(), idSocio.intValue());
				}
			}
		}
		return socio;
	}

	public Integer getIdSocioByPIva(String pIva) throws ParseException {
		logger.debug("*** Start getIdSocioByPIva");
		Integer idSocio = 0;
		idSocio = sociDAO.getIdSocioByPartitaIva(pIva);
		return idSocio;
	}

	private void converterDataToModel(SociData socio, SociModel sociModel) throws ParseException {

		sociModel.setAntiriciclaggio(socio.getAntiriciclaggio());
		sociModel.setCapAzienda(socio.getCapAzienda());
		sociModel.setCapResidenza(socio.getCapResidenza());
		sociModel.setCapSedeLegale(socio.getCapSedeLegale());
		sociModel.setCapSedeOperativa(socio.getCapSedeOperativa());
		sociModel.setCciaa(socio.getCciaa());
		sociModel.setCittaAzienda(socio.getCittaAzienda());
		sociModel.setCittaResidenza(socio.getCittaResidenza());
		sociModel.setCittaSedeLegale(socio.getCittaSedeLegale());
		sociModel.setCittaSedeOperativa(socio.getCittaSedeOperativa());
		sociModel.setCodiceFiscale(socio.getCodiceFiscale());
		sociModel.setCodiceFiscaleTitolare(socio.getCodiceFiscaleTitolare());
		sociModel.setCognome(socio.getCognome());
		if (StringUtils.isNotEmpty(socio.getDataAttivita())) {
			sociModel.setDataAttivita(defaultJavaUtils.convertDateFromString(socio.getDataAttivita()));
		}
		if (StringUtils.isNotEmpty(socio.getDataCessazione())) {
			sociModel.setDataCessazione(defaultJavaUtils.convertDateFromString(socio.getDataCessazione()));
		}
		if (StringUtils.isNotEmpty(socio.getDataCostituzione())) {
			sociModel.setDataCostituzione(defaultJavaUtils.convertDateFromString(socio.getDataCostituzione()));
		}
		if (StringUtils.isNotEmpty(socio.getDataDiNascita())) {
			sociModel.setDataDiNascita(defaultJavaUtils.convertDateFromString(socio.getDataDiNascita()));
		}
		if (StringUtils.isNotEmpty(socio.getDataInizio())) {
			sociModel.setDataInizio(defaultJavaUtils.convertDateFromString(socio.getDataInizio()));
		}
		sociModel.setEmail(socio.getEmail());
		sociModel.setFax(socio.getFax());
		sociModel.setIdQualitaTitolare(socio.getIdQualitaTitolare());
		sociModel.setIdSettoreImpresa(socio.getIdSettoreImpresa());
		sociModel.setIdStatoSocio(socio.getIdStatoSocio());
		sociModel.setIdTipoSocieta(socio.getIdTipoSocieta());
		sociModel.setIdUtente(0);
		sociModel.setImportoQuote(socio.getImportoQuote());
		sociModel.setImpresa(socio.getImpresa());
		sociModel.setIndirizzoAzienda(socio.getIndirizzoAzienda());
		sociModel.setIndirizzoResidenza(socio.getIndirizzoResidenza());
		sociModel.setIndirizzoSedeLegale(socio.getIndirizzoSedeLegale());
		sociModel.setIndirizzoSedeOperativa(socio.getIndirizzoSedeOperativa());
		sociModel.setLuogoDiNascita(socio.getLuogoDiNascita());
		sociModel.setMobile(socio.getMobile());
		sociModel.setNome(socio.getNome());
		sociModel.setNumeroDipendenti(socio.getNumeroDipendenti());
		sociModel.setNumeroLibroSoci(socio.getNumeroLibroSoci());
		sociModel.setNumeroQuote(socio.getNumeroQuote());
		sociModel.setPartitaIva(socio.getPartitaIva());
		sociModel.setProvinciaAzienda(socio.getProvinciaAzienda());
		sociModel.setProvinciaResidenza(socio.getProvinciaResidenza());
		sociModel.setProvinciaSedeLegale(socio.getProvinciaSedeLegale());
		sociModel.setProvinciaSedeOperativa(socio.getProvinciaSedeOperativa());
		sociModel.setRea(socio.getRea());
		sociModel.setTelefono(socio.getTelefono());
		sociModel.setTipologiaMerceologica(socio.getTipologiaMerceologica());
		if (socio.getIdSoci() > 0) {
			sociModel.setIdSoci(socio.getIdSoci());
		}
		sociModel.setCodiceUnivoco(socio.getCodiceUnivoco());
	}

	private void converterModelToData(SociModel socioModel, SociData socio) throws ParseException {

		socio.setAntiriciclaggio(socioModel.getAntiriciclaggio());
		socio.setCapAzienda(socioModel.getCapAzienda());
		socio.setCapResidenza(socioModel.getCapResidenza());
		socio.setCapSedeLegale(socioModel.getCapSedeLegale());
		socio.setCapSedeOperativa(socioModel.getCapSedeOperativa());
		socio.setCciaa(socioModel.getCciaa());
		socio.setCittaAzienda(socioModel.getCittaAzienda());
		socio.setCittaResidenza(socioModel.getCittaResidenza());
		socio.setCittaSedeLegale(socioModel.getCittaSedeLegale());
		socio.setCittaSedeOperativa(socioModel.getCittaSedeOperativa());
		socio.setCodiceFiscale(socioModel.getCodiceFiscale());
		socio.setCodiceFiscaleTitolare(socioModel.getCodiceFiscaleTitolare());
		socio.setCognome(socioModel.getCognome());
		if (null != socioModel.getDataAttivita()) {
			socio.setDataAttivita(defaultJavaUtils.convertStringFromDate(socioModel.getDataAttivita()));
		}
		if (null != socioModel.getDataCessazione()) {
			socio.setDataCessazione(defaultJavaUtils.convertStringFromDate(socioModel.getDataCessazione()));
		}
		if (null != socioModel.getDataCostituzione()) {
			socio.setDataCostituzione(defaultJavaUtils.convertStringFromDate(socioModel.getDataCostituzione()));
		}
		if (null != socioModel.getDataDiNascita()) {
			socio.setDataDiNascita(defaultJavaUtils.convertStringFromDate(socioModel.getDataDiNascita()));
		}
		if (null != socioModel.getDataInizio()) {
			socio.setDataInizio(defaultJavaUtils.convertStringFromDate(socioModel.getDataInizio()));
		}
		socio.setEmail(socioModel.getEmail());
		socio.setFax(socioModel.getFax());
		socio.setIdQualitaTitolare(socioModel.getIdQualitaTitolare());
		socio.setIdSettoreImpresa(socioModel.getIdSettoreImpresa());
		socio.setIdStatoSocio(socioModel.getIdStatoSocio());
		socio.setIdTipoSocieta(socioModel.getIdTipoSocieta());
		socio.setIdUtente(0);
		socio.setImportoQuote(socioModel.getImportoQuote());
		socio.setImpresa(socioModel.getImpresa());
		socio.setIndirizzoAzienda(socioModel.getIndirizzoAzienda());
		socio.setIndirizzoResidenza(socioModel.getIndirizzoResidenza());
		socio.setIndirizzoSedeLegale(socioModel.getIndirizzoSedeLegale());
		socio.setIndirizzoSedeOperativa(socioModel.getIndirizzoSedeOperativa());
		socio.setLuogoDiNascita(socioModel.getLuogoDiNascita());
		socio.setMobile(socioModel.getMobile());
		socio.setNome(socioModel.getNome());
		socio.setNumeroDipendenti(socioModel.getNumeroDipendenti());
		socio.setNumeroLibroSoci(socioModel.getNumeroLibroSoci());
		socio.setNumeroQuote(socioModel.getNumeroQuote());
		socio.setPartitaIva(socioModel.getPartitaIva());
		socio.setProvinciaAzienda(socioModel.getProvinciaAzienda());
		socio.setProvinciaResidenza(socioModel.getProvinciaResidenza());
		socio.setProvinciaSedeLegale(socioModel.getProvinciaSedeLegale());
		socio.setProvinciaSedeOperativa(socioModel.getProvinciaSedeOperativa());
		socio.setRea(socioModel.getRea());
		socio.setTelefono(socioModel.getTelefono());
		socio.setTipologiaMerceologica(socioModel.getTipologiaMerceologica());
		if (socioModel.getIdSoci() > 0) {
			socio.setIdSoci(socioModel.getIdSoci());
		}
		socio.setCodiceUnivoco(socioModel.getCodiceUnivoco());

	}

}
