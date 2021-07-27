package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.Masina;
import Model.Mecanic;
import Model.Piese;
import Model.Programare;
import Model.Diagnostic;
import net.proteanit.sql.DbUtils;

public class Controller {

	private	Connection con;
	private static String uname="root";
	private static String url="jdbc:mysql://localhost:3306/licenta";
	private static String password="";

	
	
	
	
	public boolean adaugaMasina(Masina masina) throws SQLException 
	{
		
			boolean adaugat=false;
			
			 con = DriverManager.getConnection(url,uname,password);
			
		
			String insert ="INSERT INTO `masini`(`numeDetinator`, `email`, `marca`, `model`, `dataProgramarii`, `anulProdus`, `telefon`, `nrInmatriculare`) VALUES (?,?,?,?,?,?,?,?)";
			String verificaNrinmatriculare="SELECT `nrInmatriculare` FROM `masini` WHERE `nrInmatriculare`=?";
			
			
			
			PreparedStatement inserareMasini = con.prepareStatement(insert);
			PreparedStatement verificareNrinmatrucularemasini = con.prepareStatement(verificaNrinmatriculare);
						
			
			verificareNrinmatrucularemasini.setString(1, masina.getNrInmatriculare());
			ResultSet myRs = verificareNrinmatrucularemasini.executeQuery();
			
			if(myRs.next())
			{
			
				adaugat=false;
				myRs.close();
				
			}
			else
			{
				
				inserareMasini.setString(1, masina.getNumeDetinator());
				inserareMasini.setString(2, masina.getEmail());
				inserareMasini.setString(3, masina.getMarca());
				inserareMasini.setString(4, masina.getModel());
				inserareMasini.setDate(5, masina.getDataProgramarii());
				inserareMasini.setInt(6, masina.getAnulProdus());
				inserareMasini.setInt(7, masina.getTelefon());
				inserareMasini.setString(8, masina.getNrInmatriculare());
			
				inserareMasini.executeUpdate();
			
				con.close();
			
				adaugat=true;
			}

		
		return adaugat;
	}
	

	

	public boolean adaugaMecanic(Mecanic mecanic) throws SQLException 
	{
		
		boolean adaugat=false;
		
		 con = DriverManager.getConnection(url,uname,password);
		
	
		String insert ="INSERT INTO `mecanic`(`numeMecanic`, `expertiza`, `email`, `cod`, `telefon`, `dataAngajari`,`Luni`, `Marti`,`Miercuri`,`Joi`,`Vineri`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		String verificaCod="SELECT `cod` FROM `mecanic` WHERE `cod`=?";
		
		
		
		PreparedStatement inserareMecanic = con.prepareStatement(insert);
		
		PreparedStatement verificareCod = con.prepareStatement(verificaCod);
					
		
		verificareCod.setString(1, mecanic.getCod());
		ResultSet myRs = verificareCod.executeQuery();
		
		if(myRs.next()) 
		{
			adaugat=false;
			myRs.close();
			
		}
		else
		{
			inserareMecanic.setString(1, mecanic.getNumeMecanic());
			inserareMecanic.setString(2, mecanic.getExpertiza());
			inserareMecanic.setString(3, mecanic.getEmail());
			inserareMecanic.setString(4, mecanic.getCod());
			inserareMecanic.setInt(5, mecanic.getTelefon());
			inserareMecanic.setDate(6, mecanic.getDataAngajari());
			inserareMecanic.setString(7, mecanic.getOrarLuni());
			inserareMecanic.setString(8, mecanic.getOrarMarti());
			inserareMecanic.setString(9, mecanic.getOrarMiercuri());
			inserareMecanic.setString(10, mecanic.getOrarJoi());
			inserareMecanic.setString(11, mecanic.getOrarVineri());
			
			inserareMecanic.executeUpdate();
			
		
			con.close();
		
			adaugat=true;
		
		}

		
		
	
	
		return adaugat;
	
	}
	

	
	
	public boolean adaugaDiagnostic(Diagnostic d) throws SQLException 
	{
		
		boolean adaugat=false;
		
		 con = DriverManager.getConnection(url,uname,password);
		
	
		String insert ="INSERT INTO `diagnostic`(`diagnostic`, `mecanic`, `numeDetinator`, `nrInmatriculare`, `marca`, `model`, `pret`, `dataDiagnosticari`) VALUES (?,?,?,?,?,?,?,?)";
		String verificaNrinmatriculare="SELECT `nrInmatriculare` FROM `diagnostic` WHERE `nrInmatriculare`=?";
		
		
		
		PreparedStatement inserareDiagnostic = con.prepareStatement(insert);
		PreparedStatement verificareNrinmatrucularemasini = con.prepareStatement(verificaNrinmatriculare);
					
		
		verificareNrinmatrucularemasini.setString(1, d.getNrInmatriculare());
		ResultSet myRs = verificareNrinmatrucularemasini.executeQuery();
		
		if(myRs.next())
		{
		
			adaugat=false;
			myRs.close();
			
		}
		else 
		{
		
			inserareDiagnostic.setString(1, d.getDiagnostic());
			inserareDiagnostic.setString(2, d.getMecanic());
			inserareDiagnostic.setString(3, d.getNumeDetinator());
			inserareDiagnostic.setString(4, d.getNrInmatriculare());
			inserareDiagnostic.setString(5, d.getMarca());
			inserareDiagnostic.setString(6, d.getModel());
			inserareDiagnostic.setString(7, d.getPret());
			inserareDiagnostic.setDate(8, d.getData());
		
			inserareDiagnostic.executeUpdate();
		
			con.close();
		
			adaugat=true;
		}

		
		
	
	
		return adaugat;
		
	}
	
	
	public boolean adaugaProgramare(Programare p) throws SQLException 
	{
		
		boolean adaugat=false;
		
		 con = DriverManager.getConnection(url,uname,password);
		
	
		String insert ="INSERT INTO `programare`(`numeDetinator`, `mecanic`, `email`, `marca`, `model`, `telefon`, `anulProduceri`, `oraProgramari`,`dataProgramari`,`cod`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		String verificare="SELECT `cod` FROM `programare` WHERE `cod`=?";
		
		
		
		PreparedStatement inserareProgramare = con.prepareStatement(insert);
		PreparedStatement verificareCod = con.prepareStatement(verificare);
					
		
		verificareCod.setString(1, p.getCod());
		ResultSet myRs = verificareCod.executeQuery();
		
		if(myRs.next()) 
		{
		
			adaugat=false;
			myRs.close();
			
		}
		else 
		{
		
			inserareProgramare.setString(1, p.getNumeDetinator());
			inserareProgramare.setString(2, p.getMecanic());
			inserareProgramare.setString(3, p.getEmail());
			inserareProgramare.setString(4, p.getMarca());
			inserareProgramare.setString(5, p.getModel());
			inserareProgramare.setInt(6, p.getTelefon());
			inserareProgramare.setInt(7, p.getAnulProduceti());
			inserareProgramare.setTime(8, p.getOra());
			inserareProgramare.setDate(9, p.getDataProgramare());
			inserareProgramare.setString(10, p.getCod());

		
			inserareProgramare.executeUpdate();
		
			con.close();
		
			adaugat=true;
		
		}

		
		
	
	
		return adaugat;
		
	}

	
	
	public boolean adaugaPiesa(Piese p) throws SQLException 
	{
	
		boolean adaugat=false;
	
		con = DriverManager.getConnection(url,uname,password);
	

		String insert ="INSERT INTO `piese`(`piesa`, `marca`, `model`, `pret`, `cod`,`anul`) VALUES (?,?,?,?,?,?)";
		String verificare="SELECT `cod` FROM `piese` WHERE `cod`=?";
	
	
	
		PreparedStatement inserarePiese = con.prepareStatement(insert);
		PreparedStatement verificareCod = con.prepareStatement(verificare);
				
	
		verificareCod.setString(1, p.getCod());
		ResultSet myRs = verificareCod.executeQuery();
	
	if(myRs.next())
	{
		adaugat=false;
		myRs.close();
		
	}
	else
	{
	
		inserarePiese.setString(1, p.getPiesa());
		inserarePiese.setString(2, p.getMarca());
		inserarePiese.setString(3, p.getModel());
		inserarePiese.setString(4,p.getPret());
		inserarePiese.setString(5, p.getCod());
		inserarePiese.setInt(6, p.getAnul());
		

	
		inserarePiese.executeUpdate();
	
		con.close();
	
		adaugat=true;
	
	}

	
	


		return adaugat;
	
	
	}

	
	
	
	public JTable afiseaza(JTable table,String querry) 
	{
		
		try{
				con = DriverManager.getConnection(url,uname,password);
			    
			    PreparedStatement st =con.prepareStatement(querry);
			    
			    
			    ResultSet rs = st.executeQuery();
			    
			    table.setModel(DbUtils.resultSetToTableModel(rs));
			   
			    con.close();
			    
			}
		catch(Exception ex)    
			{
			
			JOptionPane.showMessageDialog(null, ex.toString());
			
			}

		
			return table;
		}
		
	
	
	
	
	
		
		
	public JTable cauta(String orice,JTable table, String querry) throws SQLException 
	{
			
		try{
			
				
			
				con = DriverManager.getConnection(url,uname,password);
		    
				PreparedStatement st =con.prepareStatement(querry);
		    
				st.setString(1,orice);
				
				ResultSet rs = st.executeQuery();
		    
				table.setModel(DbUtils.resultSetToTableModel(rs));
		    
				
				con.close();
		    
		    }
		catch(Exception ex)
		    {
		    
		    	JOptionPane.showMessageDialog(null, ex.toString());
		    
		    }
			
			return table;
			
		}
		
	
	
	
	
	
	public boolean sterge(String orice,String querry) throws SQLException 
	{
			
			con = DriverManager.getConnection(url,uname,password);
			
			boolean sters=false;
			
		try {	
			
			int verifica=0;
			
			
			PreparedStatement sterge = con.prepareStatement(querry);
			
			sterge.setString(1, orice);
			
			verifica=sterge.executeUpdate();
			
				if(verifica<1)
				{
			
					sters=false;
				
				}
				else
				{
			
					sters=true;
			
				}
			
			
			con.close();
				
			}
			catch(Exception err)
			{
			 
				System.out.println("A aparut o eroare");
				System.out.println("Vedeti detaliile complete mai jos.");
				err.printStackTrace();
			 
				sters=false;
			
			}
			

		
			return sters;
		}
		
	
	
	
	public List<String> returneazaMecanici() throws SQLException{
		
		con = DriverManager.getConnection(url,uname,password);
		
		List<String> lista = new ArrayList<String>();
		
		String get ="Select numeMecanic from mecanic";
		
	
	
	
		
		PreparedStatement verificare = con.prepareStatement(get);
				
	
		
		ResultSet myRs = verificare.executeQuery();
	
	while(myRs.next())
	{
		lista.add(myRs.getString("numeMecanic"));
		
	}
		
		
		con.close();
		return lista;
		
	}
	
	
	
	
	public List<Masina> returneazaDetinatori() throws SQLException{
		
		con = DriverManager.getConnection(url,uname,password);
		
		List<Masina> lista = new ArrayList<Masina>();
		
		String get ="Select * from masini";
		
	
	
	
		
		PreparedStatement verificare = con.prepareStatement(get);
				
	
		
		ResultSet myRs = verificare.executeQuery();
	
	while(myRs.next())
	{
		Masina m = new Masina(myRs.getString("numeDetinator"),myRs.getString("marca"),myRs.getString("model"),myRs.getString("nrInmatriculare"));
		lista.add(m);
		
	}
		
		
		con.close();
		return lista;
		
	}
	
	
	



	
	

	
}
