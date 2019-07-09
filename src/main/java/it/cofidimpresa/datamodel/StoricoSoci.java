package it.cofidimpresa.datamodel;

import java.util.Date;

public class StoricoSoci {

	private int idStoricoSoci;
	private int idUtente;
	private int idSoci;
	private String oldValue;
	private String newValue;
	private Date date;

	public int getIdStoricoSoci() {
		return idStoricoSoci;
	}

	public void setIdStoricoSoci(int idStoricoSoci) {
		this.idStoricoSoci = idStoricoSoci;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdSoci() {
		return idSoci;
	}

	public void setIdSoci(int idSoci) {
		this.idSoci = idSoci;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
