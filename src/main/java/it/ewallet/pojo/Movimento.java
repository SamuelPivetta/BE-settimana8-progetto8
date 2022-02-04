package it.ewallet.pojo;

public class Movimento {
	
	
	
	private String data;
	private String tipoMoviemnto;
	private int importo;
	private int iban;

	public Movimento() {
		
	}

	

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public String getTipoMoviemnto() {
		return tipoMoviemnto;
	}

	public void setTipoMoviemnto(String tipoMoviemnto) {
		this.tipoMoviemnto = tipoMoviemnto;
	}

	public int getIban() {
		return iban;
	}

	public void setIban(int iban) {
		this.iban = iban;
	}



	
}
