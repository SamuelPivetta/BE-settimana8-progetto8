package it.ewallet.pojo;



public class ContoCorrente {
	
	
	private int iban;
	private String intestatario;
	private String data;
	private double saldo;
	
	public ContoCorrente() {
		
	}



	public int getIban() {
		return iban;
	}


	public void setIban(int iban) {
		this.iban = iban;
	}



	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

	
	

}
