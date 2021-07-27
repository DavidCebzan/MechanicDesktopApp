package Model;
import java.sql.Date;

public class Masina {
	
	private String numeDetinator,email,marca,model,nrInmatriculare;
	private java.sql.Date dataProgramarii;
	int anulProdus,telefon;

	
	
	
	public Masina(String numeDetinator, String email, String marca, String model, Date dataProgramarii, int anulProdus,
			int telefon, String nrInmatriculare)
	{
	
		this.numeDetinator = numeDetinator;
		this.email = email;
		this.marca = marca;
		this.model = model;
		this.dataProgramarii = dataProgramarii;
		this.anulProdus = anulProdus;
		this.telefon = telefon;
		this.nrInmatriculare = nrInmatriculare;
	}

	
	public Masina(String numeDetinator,String marca,String model, String nrInmatriculare) 
	{
		this.numeDetinator = numeDetinator;
		this.marca = marca;
		this.model = model;
		this.nrInmatriculare = nrInmatriculare;

	}
	
	public String getNumeDetinator()
	{
		return numeDetinator;
	}

	
	public String getEmail()
	{
		return email;
	}

	public String getMarca()
	{
		return marca;
	}

	public String getModel() 
	{
		return model;
	}

	public java.sql.Date getDataProgramarii()
	{
		return dataProgramarii;
	}

	public int getAnulProdus()
	{
		return anulProdus;
	}

	public int getTelefon() 
	{
		return telefon;
	}

	public String getNrInmatriculare() 
	{
		return nrInmatriculare;
	}
	
	
	
	
	

}
