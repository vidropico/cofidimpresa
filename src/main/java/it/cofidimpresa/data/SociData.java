package it.cofidimpresa.data;

import java.util.Date;
import java.util.List;

public class SociData {
	
	private int idSoci;
	private String nome;
	private String impresa;
	private String codiceFiscale;
	private String partitaIva;
	private String indirizzoAzienda;
	private String cittaAzienda;
	private String capAzienda;
	private String provinciaAzienda;
	private String indirizzoResidenza;
	private String cittaResidenza;
	private String capResidenza;
	private String provinciaResidenza;
	private String indirizzoSedeOperativa;
	private String cittaSedeOperativa;
	private String capSedeOperativa;
	private String provinciaSedeOperativa;
	private String indirizzoSedeLegale;
	private String cittaSedeLegale;
	private String capSedeLegale;
	private String provinciaSedeLegale;
	private String telefono;
	private String fax;
	private String mobile;
	private String email;
	private String tipologiaMerceologica;
	private String dataInizio;
	private String dataCessazione;
	private String dataDiNascita;
	private String dataCostituzione;
	private String dataAttivita;
	private String luogoDiNascita;
	private String cciaa;
	private String rea;
	private String numeroDipendenti;
	private String codiceFiscaleTitolare;
	private Integer numeroLibroSoci=0;
	private Integer numeroQuote=0;
	private Double importoQuote=new Double(0);
	private int idUtente;
	private int idTipoSocieta;
	private int idQualitaTitolare;
	private int idSettoreImpresa;
	private int idStatoSocio;
	private int antiriciclaggio;
	private String cognome;
	private String codiceUnivoco;
	private List<Integer> idAteco;
	
	public int getIdSoci() {
		return idSoci;
	}
	public void setIdSoci(int idSoci) {
		this.idSoci = idSoci;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImpresa() {
		return impresa;
	}
	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getIndirizzoAzienda() {
		return indirizzoAzienda;
	}
	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}
	public String getCittaAzienda() {
		return cittaAzienda;
	}
	public void setCittaAzienda(String cittaAzienda) {
		this.cittaAzienda = cittaAzienda;
	}
	public String getCapAzienda() {
		return capAzienda;
	}
	public void setCapAzienda(String capAzienda) {
		this.capAzienda = capAzienda;
	}
	public String getProvinciaAzienda() {
		return provinciaAzienda;
	}
	public void setProvinciaAzienda(String provinciaAzienda) {
		this.provinciaAzienda = provinciaAzienda;
	}
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	public String getCittaResidenza() {
		return cittaResidenza;
	}
	public void setCittaResidenza(String cittaResidenza) {
		this.cittaResidenza = cittaResidenza;
	}
	public String getCapResidenza() {
		return capResidenza;
	}
	public void setCapResidenza(String capResidenza) {
		this.capResidenza = capResidenza;
	}
	public String getProvinciaResidenza() {
		return provinciaResidenza;
	}
	public void setProvinciaResidenza(String provinciaResidenza) {
		this.provinciaResidenza = provinciaResidenza;
	}
	public String getIndirizzoSedeOperativa() {
		return indirizzoSedeOperativa;
	}
	public void setIndirizzoSedeOperativa(String indirizzoSedeOperativa) {
		this.indirizzoSedeOperativa = indirizzoSedeOperativa;
	}
	public String getCittaSedeOperativa() {
		return cittaSedeOperativa;
	}
	public void setCittaSedeOperativa(String cittaSedeOperativa) {
		this.cittaSedeOperativa = cittaSedeOperativa;
	}
	public String getCapSedeOperativa() {
		return capSedeOperativa;
	}
	public void setCapSedeOperativa(String capSedeOperativa) {
		this.capSedeOperativa = capSedeOperativa;
	}
	public String getProvinciaSedeOperativa() {
		return provinciaSedeOperativa;
	}
	public void setProvinciaSedeOperativa(String provinciaSedeOperativa) {
		this.provinciaSedeOperativa = provinciaSedeOperativa;
	}
	public String getIndirizzoSedeLegale() {
		return indirizzoSedeLegale;
	}
	public void setIndirizzoSedeLegale(String indirizzoSedeLegale) {
		this.indirizzoSedeLegale = indirizzoSedeLegale;
	}
	public String getCittaSedeLegale() {
		return cittaSedeLegale;
	}
	public void setCittaSedeLegale(String cittaSedeLegale) {
		this.cittaSedeLegale = cittaSedeLegale;
	}
	public String getCapSedeLegale() {
		return capSedeLegale;
	}
	public void setCapSedeLegale(String capSedeLegale) {
		this.capSedeLegale = capSedeLegale;
	}
	public String getProvinciaSedeLegale() {
		return provinciaSedeLegale;
	}
	public void setProvinciaSedeLegale(String provinciaSedeLegale) {
		this.provinciaSedeLegale = provinciaSedeLegale;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipologiaMerceologica() {
		return tipologiaMerceologica;
	}
	public void setTipologiaMerceologica(String tipologiaMerceologica) {
		this.tipologiaMerceologica = tipologiaMerceologica;
	}
	public String getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}
	public String getDataCessazione() {
		return dataCessazione;
	}
	public void setDataCessazione(String dataCessazione) {
		this.dataCessazione = dataCessazione;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getDataCostituzione() {
		return dataCostituzione;
	}
	public void setDataCostituzione(String dataCostituzione) {
		this.dataCostituzione = dataCostituzione;
	}
	public String getDataAttivita() {
		return dataAttivita;
	}
	public void setDataAttivita(String dataAttivita) {
		this.dataAttivita = dataAttivita;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public String getCciaa() {
		return cciaa;
	}
	public void setCciaa(String cciaa) {
		this.cciaa = cciaa;
	}
	public String getRea() {
		return rea;
	}
	public void setRea(String rea) {
		this.rea = rea;
	}
	public String getNumeroDipendenti() {
		return numeroDipendenti;
	}
	public void setNumeroDipendenti(String numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}
	public String getCodiceFiscaleTitolare() {
		return codiceFiscaleTitolare;
	}
	public void setCodiceFiscaleTitolare(String codiceFiscaleTitolare) {
		this.codiceFiscaleTitolare = codiceFiscaleTitolare;
	}
	public Integer getNumeroLibroSoci() {
		return numeroLibroSoci;
	}
	public void setNumeroLibroSoci(Integer numeroLibroSoci) {
		this.numeroLibroSoci = numeroLibroSoci;
	}
	public Integer getNumeroQuote() {
		return numeroQuote;
	}
	public void setNumeroQuote(Integer numeroQuote) {
		this.numeroQuote = numeroQuote;
	}
	public Double getImportoQuote() {
		return importoQuote;
	}
	public void setImportoQuote(Double importoQuote) {
		this.importoQuote = importoQuote;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public int getIdTipoSocieta() {
		return idTipoSocieta;
	}
	public void setIdTipoSocieta(int idTipoSocieta) {
		this.idTipoSocieta = idTipoSocieta;
	}
	public int getIdQualitaTitolare() {
		return idQualitaTitolare;
	}
	public void setIdQualitaTitolare(int idQualitaTitolare) {
		this.idQualitaTitolare = idQualitaTitolare;
	}
	public int getIdSettoreImpresa() {
		return idSettoreImpresa;
	}
	public void setIdSettoreImpresa(int idSettoreImpresa) {
		this.idSettoreImpresa = idSettoreImpresa;
	}
	public int getIdStatoSocio() {
		return idStatoSocio;
	}
	public void setIdStatoSocio(int idStatoSocio) {
		this.idStatoSocio = idStatoSocio;
	}
	public int getAntiriciclaggio() {
		return antiriciclaggio;
	}
	public void setAntiriciclaggio(int antiriciclaggio) {
		this.antiriciclaggio = antiriciclaggio;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<Integer> getIdAteco() {
		return idAteco;
	}
	public void setIdAteco(List<Integer> idAteco) {
		this.idAteco = idAteco;
	}
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}
	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

}
