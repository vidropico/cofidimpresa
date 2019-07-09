package it.cofidimpresa.data;

import java.util.Date;

public class FinanziamentiTableData {

	private int idFinanziamenti;
	private String impresa;
	private String importoDeliberato;
	private String importoErogato;
	private String importoGaranzia;
	private String rate;
	private String percentualeGaranzia;
	private Date dataApprovazioneConsiglio;
	private Date dataErogazioneFinanziamento;
	private String stato;
	private int idSocio;
	
	public int getIdFinanziamenti() {
		return idFinanziamenti;
	}

	public void setIdFinanziamenti(int idFinanziamenti) {
		this.idFinanziamenti = idFinanziamenti;
	}

	public String getImpresa() {
		return impresa;
	}

	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}

	public String getImportoDeliberato() {
		return importoDeliberato;
	}

	public void setImportoDeliberato(String importoDeliberato) {
		this.importoDeliberato = importoDeliberato;
	}

	public String getImportoErogato() {
		return importoErogato;
	}

	public void setImportoErogato(String importoErogato) {
		this.importoErogato = importoErogato;
	}

	public String getImportoGaranzia() {
		return importoGaranzia;
	}

	public void setImportoGaranzia(String importoGaranzia) {
		this.importoGaranzia = importoGaranzia;
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

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

}
