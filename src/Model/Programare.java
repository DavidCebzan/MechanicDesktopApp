package Model;
import java.sql.Date;
import java.sql.Time;

public class Programare {

	private String numeDetinator,mecanic,email,marca ,model,cod;
	private int telefon,anulProduceti;
	private java.sql.Time ora;
	private java.sql.Date dataProgramare;

	
	
	public Programare(String numeDetinator, String mecanic, String email, String marca, String model, int telefon,
			int anulProduceti, Time ora, Date dataProgramare,String cod) 
	{
		
		this.numeDetinator = numeDetinator;
		this.mecanic = mecanic;
		this.email = email;
		this.marca = marca;
		this.model = model;
		this.telefon = telefon;
		this.anulProduceti = anulProduceti;
		this.ora = ora;
		this.dataProgramare = dataProgramare;
		this.cod=cod;
	}
	
	
	public String getCod() 
	{
		return cod;
	}
	
	public void setCod(String cod) 
	{
		this.cod=cod;
	}
	
	public String getNumeDetinator() 
	{
		return numeDetinator;
	}
	
	public void setNumeDetinator(String numeDetinator) 
	{
		this.numeDetinator = numeDetinator;
	}
	
	public String getMecanic()
	{
		return mecanic;
	}
	
	public void setMecanic(String mecanic) 
	{
		this.mecanic = mecanic;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public String getModel() 
	{
		return model;
	}
	
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public int getTelefon()
	{
		return telefon;
	}
	
	public void setTelefon(int telefon) 
	{
		this.telefon = telefon;
	}
	
	public int getAnulProduceti()
	{
		return anulProduceti;
	}
	
	public void setAnulProduceti(int anulProduceti) 
	{
		this.anulProduceti = anulProduceti;
	}
	
	public java.sql.Time getOra()
	{
		return ora;
	}
	
	public void setOra(java.sql.Time ora) 
	{
		this.ora = ora;
	}
	
	public java.sql.Date getDataProgramare()
	{
		return dataProgramare;
	}
	
	public void setDataProgramare(java.sql.Date dataProgramare)
	{
		this.dataProgramare = dataProgramare;
	}
	
	
	
	

	
}
