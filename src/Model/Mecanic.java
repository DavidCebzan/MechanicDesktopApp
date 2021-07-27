package Model;

import java.sql.Date;

public class Mecanic {

	
	private String numeMecanic,expertiza,email,orarLuni,orarMarti,orarMiercuri,orarJoi,orarVineri,cod;
	private int telefon;
	private java.sql.Date dataAngajari;

	
	

	public Mecanic(String numeMecanic, String expertiza, String email, String orarLuni, String orarMarti,
			String orarMiercuri, String orarJoi, String orarVineri, int telefon, Date dataAngajari,String cod) 
	{
		this.numeMecanic = numeMecanic;
		this.expertiza = expertiza;
		this.email = email;
		this.orarLuni = orarLuni;
		this.orarMarti = orarMarti;
		this.orarMiercuri = orarMiercuri;
		this.orarJoi = orarJoi;
		this.orarVineri = orarVineri;
		this.telefon = telefon;
		this.dataAngajari = dataAngajari;
		this.cod=cod;
	}


	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public int getTelefon() 
	{
		return telefon;
	}


	public void setTelefon(int telefon) 
	{
		this.telefon = telefon;
	}


	public java.sql.Date getDataAngajari()
	{
		return dataAngajari;
	}


	public void setDataAngajari(java.sql.Date dataAngajari) 
	{
		this.dataAngajari = dataAngajari;
	}


	public String getNumeMecanic() 
	{
		return numeMecanic;
	}
	
	public void setNumeMecanic(String numeMecanic) 
	{
		this.numeMecanic = numeMecanic;
	}
	
	public String getExpertiza() 
	{
		return expertiza;
	}
	
	public void setexpertiza(String expertiza) 
	{
		this.expertiza = expertiza;
	}
	
	public String getOrarLuni() 
	{
		return orarLuni;
	}
	
	public void setOrarLuni(String orarLuni) 
	{
		this.orarLuni = orarLuni;
	}
	public String getOrarMarti() {
		return orarMarti;
	}
	
	public void setOrarMarti(String orarMarti)
	{
		this.orarMarti = orarMarti;
	}
	
	public String getOrarMiercuri()
	{
		return orarMiercuri;
	}
	
	public void setOrarMiercuri(String orarMiercuri) 
	{
		this.orarMiercuri = orarMiercuri;
	}
	
	public String getOrarJoi() 
	{
		return orarJoi;
	}
	
	public void setOrarJoi(String orarJoi) 
	{
		this.orarJoi = orarJoi;
	}
	
	public String getOrarVineri() 
	{
		return orarVineri;
	}
	
	public void setOrarVineri(String orarVineri) 
	{
		this.orarVineri = orarVineri;
	}
	

	public String getCod() 
	{
		return cod;
	}
	
	public void setCod(String cod) 
	{
		this.cod=cod;
	}
	
	

	
	
}
