package it.cofidimpresa.data;

import java.util.Date;

public class SociTableData {

	private int idSocio;
	private String impresa;
	private String codFiscale;
	private String pIva;
	private String indirizzoAzienda;
	private String tipologiaMerceologica;
	private String codiceUnivoco;
	private String stato;
	private String email;
	private Date dataInizio;
	private String finanziamentiNum;

	public String getImpresa() {
		return impresa;
	}

	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getIndirizzoAzienda() {
		return indirizzoAzienda;
	}

	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getFinanziamentiNum() {
		return finanziamentiNum;
	}

	public void setFinanziamentiNum(String finanziamentiNum) {
		this.finanziamentiNum = finanziamentiNum;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getTipologiaMerceologica() {
		return tipologiaMerceologica;
	}

	public void setTipologiaMerceologica(String tipologiaMerceologica) {
		this.tipologiaMerceologica = tipologiaMerceologica;
	}

	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}

	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}

}
