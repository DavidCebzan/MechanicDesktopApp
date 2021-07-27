package Model;

public class Piese {

	private String piesa,marca,model,pret,cod;
	private int anul;
	
	
	
	
	
	public Piese(String piesa, String marca, String model, String pret, int anul,String cod) 
	{
		
		this.piesa = piesa;
		this.marca = marca;
		this.model = model;
		this.pret = pret;
		this.anul = anul;
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
	
	public String getPiesa()
	{
		return piesa;
	}
	
	public void setPiesa(String piesa) 
	{
		this.piesa = piesa;
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
	
	public int getAnul() 
	{
		return anul;
	}
	
	public void setAnul(int anul) 
	{
		this.anul = anul;
	}
	
	
}
