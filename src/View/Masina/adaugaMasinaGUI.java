package View.Masina;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Masina;
import View.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;


public class adaugaMasinaGUI{

	private JFrame frame;
	private JTextField textNumeDetinator;
	private JTextField textEmail;
	private JTextField textMarca;
	private JTextField textModel;
	private JTextField textData;
	private JTextField textAnul;
	private JTextField textNumarTelefon;
	private JTextField textNrInmatriculare;
	private JButton btnAdauga;
	private Controller c;
	
	private String numeDetinator,email,marca,model,nrInmatriculare;
	private int anulProdus,telefon;
	private java.sql.Date data;
	
	

	
	public adaugaMasinaGUI() throws SQLException 
	{
		initialize();
	}

	
	public void adaugaMasina() throws ParseException, SQLException
	{
		
		c= new Controller();
		
		
		numeDetinator=textNumeDetinator.getText();
		email=textEmail.getText();
		marca=textMarca.getText();
		model=textModel.getText();
		
		nrInmatriculare=textNrInmatriculare.getText();
		
	
		
		if(numeDetinator.isEmpty() || email.isEmpty() || marca.isEmpty() || model.isEmpty() || nrInmatriculare.isEmpty()) 
		{
		
			JOptionPane.showMessageDialog(null,"Completati toate campurile !!");
			
		}
		else 
		{
			 try 
			 {  
				 	anulProdus=Integer.parseInt(textAnul.getText());
					telefon=Integer.parseInt(textNumarTelefon.getText());
					
					 try 
					 {
						 	SimpleDateFormat tm = new SimpleDateFormat("dd/MM/yyyy");
							java.util.Date Date1 = tm.parse(textData.getText());
							data = new java.sql.Date(Date1.getTime());
							

							Masina m = new Masina(numeDetinator,email,marca,model,data,anulProdus,telefon,nrInmatriculare);
							
							if(c.adaugaMasina(m))
							{
								JOptionPane.showMessageDialog(null,"Masina a fost adaugata cu succes ");
								sterge();
								
							}
							else 
							{
								JOptionPane.showMessageDialog(null,"Masina nu a fost adaugata, numar de inmatriculare exista deja in baza de date");
							}
							
							
			 
			          } 
					 catch (ParseException e) 
					 {
			            	JOptionPane.showMessageDialog(null,"Introduceti o data valida ");
			            	
			         }
					
					
                 
			 }
			 catch(NumberFormatException ex)
			 {  
        	
				 	JOptionPane.showMessageDialog(null,"In casutele 'Telefon' si 'anul din care este masina' trebuie introduse numere ");
				 	
			 }
			 
			
			
			 
					
		}
		
	
		
		
		
	}
	
	public void sterge() 
	{
		  textNumeDetinator.setText("");
		  textEmail.setText("");
		  textMarca.setText("");
		  textModel.setText("");
		  textData.setText("");
		  textAnul.setText("");
		  textNumarTelefon.setText("");
		  textNrInmatriculare.setText("");
	}
	
	
	
	
	private void initialize() throws SQLException 
	{
		c= new Controller();
		
		frame = new JFrame("Adauga masina");
		
		BufferedImage img = null;
		
		try
		{
		
			img = ImageIO.read(new File("Fotografii//image1.png"));
		
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		
		}
		
		Image dimg = img.getScaledInstance(868, 599, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JLabel label = new JLabel(imageIcon);

		frame.setContentPane(label);
		
		
		
		frame.setBounds(100, 100, 868, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNume = new JLabel("Nume Detinator");
		lblNume.setForeground(Color.WHITE);
		lblNume.setBounds(12, 30, 220, 20);
		
		frame.getContentPane().add(lblNume);
		
		textNumeDetinator = new JTextField();
		textNumeDetinator.setBounds(12, 50, 220, 20);
		textNumeDetinator.setColumns(10);
		
		frame.getContentPane().add(textNumeDetinator);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(Color.BLACK);
		lblEmail.setBounds(12, 90, 217, 16);
		
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(12, 110, 220, 22);
		textEmail.setColumns(10);
		frame.getContentPane().add(textEmail);
		
		
		JLabel lblMarca = new JLabel("Marca Masini");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setBounds(12, 150, 220, 16);
		
		frame.getContentPane().add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 170, 220, 22);
		textMarca.setColumns(10);
		
		frame.getContentPane().add(textMarca);
		
		
		textModel = new JTextField();
		textModel.setBounds(12, 230, 217, 22);
		textModel.setColumns(10);
		
		frame.getContentPane().add(textModel);
		
		
		JLabel lblModelul = new JLabel("Modelul Masini");
		lblModelul.setForeground(Color.WHITE);
		lblModelul.setBounds(12, 210, 217, 16);
		
		frame.getContentPane().add(lblModelul);
		
		JLabel lblData = new JLabel("Data in care masina intra in garaj(dd/mm/yyyy)");
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(12, 270, 270, 16);
		
		frame.getContentPane().add(lblData);
		
		textData = new JTextField();
		textData.setBounds(12, 290, 217, 22);
		textData.setColumns(10);

		frame.getContentPane().add(textData);
		
		
		JLabel lblAnul = new JLabel("Anul din care este masina");
		lblAnul.setForeground(Color.WHITE);
		lblAnul.setBounds(12, 330, 186, 16);
		
		frame.getContentPane().add(lblAnul);
		
		textAnul = new JTextField();
		textAnul.setBounds(12, 350, 217, 22);
		textAnul.setColumns(10);

		frame.getContentPane().add(textAnul);
		
		
		JLabel lblTelefon = new JLabel("Numarul de Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setBounds(12, 390, 217, 16);
		
		frame.getContentPane().add(lblTelefon);
		
		textNumarTelefon = new JTextField();
		textNumarTelefon.setBounds(12, 410, 217, 22);
		textNumarTelefon.setColumns(10);

		frame.getContentPane().add(textNumarTelefon);
		
		JLabel lblNrInmatriculare = new JLabel("Numarul de inmatriculare a masini");
		lblNrInmatriculare.setForeground(Color.WHITE);
		lblNrInmatriculare.setBounds(12, 450, 217, 16);
		
		frame.getContentPane().add(lblNrInmatriculare);
		
		textNrInmatriculare = new JTextField();
		textNrInmatriculare.setBounds(12, 470, 217, 22);
		textNrInmatriculare.setColumns(10);
		
		frame.getContentPane().add(textNrInmatriculare);
		
		
		btnAdauga = new JButton("Adauga");
		btnAdauga.setBackground(Color.WHITE);
		btnAdauga.setBounds(12, 505, 100, 25);
		
		btnAdauga.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				try
				{
						adaugaMasina();
				} 
				catch (ParseException e1) 
				{
					e1.printStackTrace();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		
		frame.getContentPane().add(btnAdauga);
		
		JButton btnInapoi = new JButton("Inapoi ");
		btnInapoi.setBackground(Color.WHITE);
		
		btnInapoi.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
			
				frame.dispose();
			
				try 
				{
					new GUI();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		btnInapoi.setBounds(738, 505, 100, 25);
		frame.getContentPane().add(btnInapoi);
		
		
		
		
		
		
		 
	
		
		
		
		
		
		
	}
}
