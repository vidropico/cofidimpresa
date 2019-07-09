package it.cofidimpresa.datamodel;

import java.sql.Date;

public class FinanziamentiModel {

	private int idFinanziamenti;
	private String importo;
	private String rate;
	private String percentualeGaranzia;
	private String importoRata;
	private String costi;
	private String naturaFinanziamento;
	private String note;
	private String rateScadute;
	private String importoScaduto;
	private String tipologiaRientro;
	private String pianoRientro;
	private String nomeAvvocato;
	private String azioni;
	private String risultato;
	private String importoRichiesto;
	private int idSoci;
	private int idUtente;
	private int idStatoFinanziamenti;
	private int idBanche;
	private int provinciaSedeLegale;
	private int pagamento;
	private Double importoGaranzia;
	private int idGaranzia;
	private Double costoIstruttoria = new Double(0);
	private int importoDeliberato;
	private Date dataApprovazioneConsiglio;
	private Date dataErogazioneFinanziamento;
	private Date dataFineFinanziamento;
	private String rateRichieste;
	private String impQuotaBanca;
	private String istruttoriaBanca;
	private String accredito;
	private int flgUsura=0;
	
	public int getIdFinanziamenti() {
		return idFinanziamenti;
	}

	public void setIdFinanziamenti(int idFinanziamenti) {
		this.idFinanziamenti = idFinanziamenti;
	}

	public String getImporto() {
		return importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getPercentualeGaranzia() {
		return percentualeGaranzia;
	}

	public void setPercentualeGaranzia(String percentualeGaranzia) {
		this.percentualeGaranzia = percentualeGaranzia;
	}

	public String getImportoRata() {
		return importoRata;
	}

	public void setImportoRata(String importoRata) {
		this.importoRata = importoRata;
	}

	public String getCosti() {
		return costi;
	}

	public void setCosti(String costi) {
		this.costi = costi;
	}

	public String getNaturaFinanziamento() {
		return naturaFinanziamento;
	}

	public void setNaturaFinanziamento(String naturaFinanziamento) {
		this.naturaFinanziamento = naturaFinanziamento;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRateScadute() {
		return rateScadute;
	}

	public void setRateScadute(String rateScadute) {
		this.rateScadute = rateScadute;
	}

	public String getImportoScaduto() {
		return importoScaduto;
	}

	public void setImportoScaduto(String importoScaduto) {
		this.importoScaduto = importoScaduto;
	}

	public String getTipologiaRientro() {
		return tipologiaRientro;
	}

	public void setTipologiaRientro(String tipologiaRientro) {
		this.tipologiaRientro = tipologiaRientro;
	}

	public String getPianoRientro() {
		return pianoRientro;
	}

	public void setPianoRientro(String pianoRientro) {
		this.pianoRientro = pianoRientro;
	}

	public String getNomeAvvocato() {
		return nomeAvvocato;
	}

	public void setNomeAvvocato(String nomeAvvocato) {
		this.nomeAvvocato = nomeAvvocato;
	}

	public String getAzioni() {
		return azioni;
	}

	public void setAzioni(String azioni) {
		this.azioni = azioni;
	}

	public String getRisultato() {
		return risultato;
	}

	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}

	public String getImportoRichiesto() {
		return importoRichiesto;
	}

	public void setImportoRichiesto(String importoRichiesto) {
		this.importoRichiesto = importoRichiesto;
	}

	public int getIdSoci() {
		return idSoci;
	}

	public void setIdSoci(int idSoci) {
		this.idSoci = idSoci;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdStatoFinanziamenti() {
		return idStatoFinanziamenti;
	}

	public void setIdStatoFinanziamenti(int idStatoFinanziamenti) {
		this.idStatoFinanziamenti = idStatoFinanziamenti;
	}

	public int getIdBanche() {
		return idBanche;
	}

	public void setIdBanche(int idBanche) {
		this.idBanche = idBanche;
	}

	public int getProvinciaSedeLegale() {
		return provinciaSedeLegale;
	}

	public void setProvinciaSedeLegale(int provinciaSedeLegale) {
		this.provinciaSedeLegale = provinciaSedeLegale;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	public Double getImportoGaranzia() {
		return importoGaranzia;
	}

	public void setImportoGaranzia(Double importoGaranzia) {
		this.importoGaranzia = importoGaranzia;
	}

	public int getIdGaranzia() {
		return idGaranzia;
	}

	public void setIdGaranzia(int idGaranzia) {
		this.idGaranzia = idGaranzia;
	}

	public Double getCostoIstruttoria() {
		return costoIstruttoria;
	}

	public void setCostoIstruttoria(Double cotoIstruttoria) {
		this.costoIstruttoria = cotoIstruttoria;
	}

	public int getImportoDeliberato() {
		return importoDeliberato;
	}

	public void setImportoDeliberato(int importoDeliberato) {
		this.importoDeliberato = importoDeliberato;
	}

	public Date getDataApprovazioneConsiglio() {
		return dataApprovazioneConsiglio;
	}

	public void setDataApprovazioneConsiglio(Date dataApprovazioneConsiglio) {
		this.dataApprovazioneConsiglio = dataApprovazioneConsiglio;
	}

	public Date getDataErogazioneFinanziamento() {
		return dataErogazioneFinanziamento;
	}

	public void setDataErogazioneFinanziamento(Date dataErogazioneFinanziamento) {
		this.dataErogazioneFinanziamento = dataErogazioneFinanziamento;
	}

	public Date getDataFineFinanziamento() {
		return dataFineFinanziamento;
	}

	public void setDataFineFinanziamento(Date dataFineFinanziamento) {
		this.dataFineFinanziamento = dataFineFinanziamento;
	}

	public String getRateRichieste() {
		return rateRichieste;
	}

	public void setRateRichieste(String rateRichieste) {
		this.rateRichieste = rateRichieste;
	}

	public String getImpQuotaBanca() {
		return impQuotaBanca;
	}

	public void setImpQuotaBanca(String impQuotaBanca) {
		this.impQuotaBanca = impQuotaBanca;
	}

	public String getIstruttoriaBanca() {
		return istruttoriaBanca;
	}

	public void setIstruttoriaBanca(String istruttoriaBanca) {
		this.istruttoriaBanca = istruttoriaBanca;
	}

	public String getAccredito() {
		return accredito;
	}

	public void setAccredito(String accredito) {
		this.accredito = accredito;
	}

	public int getFlgUsura() {
		return flgUsura;
	}

	public void setFlgUsura(int flgUsura) {
		this.flgUsura = flgUsura;
	}

	
}
