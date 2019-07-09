package it.cofidimpresa.datamodel;

import java.util.Date;

public class StoricoFinanziamentiModel {

	private int idStoricoFinanziamenti;
	private int idUtente;
	private int idFinanziamenti;
	private String oldValue;
	private String newValue;
	private Date date;

	public int getIdStoricoFinanziamenti() {
		return idStoricoFinanziamenti;
	}

	public void setIdStoricoFinanziamenti(int idStoricoFinanziamenti) {
		this.idStoricoFinanziamenti = idStoricoFinanziamenti;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdFinanziamenti() {
		return idFinanziamenti;
	}

	public void setIdFinanziamenti(int idFinanziamenti) {
		this.idFinanziamenti = idFinanziamenti;
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
