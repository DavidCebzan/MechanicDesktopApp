package Model;

import java.sql.Date;

public class Diagnostic {

	
	
	private String diagnostic,mecanic,numeDetinator,nrInmatriculare,marca,model,pret;
	private java.sql.Date data;

	
	
	public Diagnostic(String diagnostic, String mecanic, String numeDetinator, String nrInmatriculare, String marca,
			String model, String pret, Date data) 
	{
		
		this.diagnostic = diagnostic;
		this.mecanic = mecanic;
		this.numeDetinator = numeDetinator;
		this.nrInmatriculare = nrInmatriculare;
		this.marca = marca;
		this.model = model;
		this.pret = pret;
		this.data = data;
	}

	public String getDiagnostic() 
	{
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) 
	{
		this.diagnostic = diagnostic;
	}

	public String getMecanic() 
	{
		return mecanic;
	}

	public void setMecanic(String mecanic) 
	{
		this.mecanic = mecanic;
	}

	public String getNumeDetinator()
	{
		return numeDetinator;
	}

	public void setNumeDetinator(String numeDetinator) 
	{
		this.numeDetinator = numeDetinator;
	}

	public String getNrInmatriculare() 
	{
		return nrInmatriculare;
	}

	public void setNrInmatriculare(String nrInmatriculare) 
	{
		this.nrInmatriculare = nrInmatriculare;
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

	public String getPret() 
	{
		return pret;
	}

	public void setPret(String pret) 
	{
		this.pret = pret;
	}

	public java.sql.Date getData() 
	{
		return data;
	}

	public void setData(java.sql.Date data)
	{
		this.data = data;
	}
	
	
	
	
	
	
}
