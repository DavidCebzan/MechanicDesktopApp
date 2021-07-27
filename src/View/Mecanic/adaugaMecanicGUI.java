package View.Mecanic;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Controller.Controller;
import Model.Mecanic;
import View.GUI;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class adaugaMecanicGUI {

	private JFrame frame;
	private JTextField textNumeMecanic;
	private JTextField textExpertiza;
	private JTextField textEmail;
	private JTextField textCod;
	private JTextField textTelefon;
	private JTextField textDataAngajari;
	private JPanel panel;
	private JLabel lblOrarLuni;
	private JTextField textOrarLuni;
	private JLabel lblNewLabel_3;
	private JTextField textOrarMiercuri;
	private JLabel lblNewLabel_4;
	private JTextField textOrarVineri;
	private JLabel lblOrarMarti;
	private JTextField textOrarMarti;
	private JLabel lblOrarJoi;
	private JTextField textOrarJoi;
	private Controller c;
	
	
	private String numeMecanic,expertiza,email,orarLuni,orarMarti,orarMiercuri,orarJoi,orarVineri,cod;
	private int telefon;
	private java.sql.Date dataAngajari;
	private JButton btnNewButton;
	
	
	public adaugaMecanicGUI() 
	{
		initialize();
	}
	
	public void adaugaMecanic() throws SQLException 
	{
	
		c= new Controller();
		
		numeMecanic=textNumeMecanic.getText();
		expertiza=textExpertiza.getText();
		email=textEmail.getText();
		orarLuni=textOrarLuni.getText();
		orarMarti=textOrarMarti.getText();
		orarMiercuri=textOrarMiercuri.getText();
		orarJoi=textOrarJoi.getText();
		orarVineri=textOrarVineri.getText();
		cod=textCod.getText();
		
		
		
		if(numeMecanic.isEmpty() || expertiza.isEmpty() || email.isEmpty() || orarLuni.isEmpty() || orarMarti.isEmpty() || orarMiercuri.isEmpty() || orarJoi.isEmpty() || orarVineri.isEmpty() || cod.isEmpty())
		{
			
			JOptionPane.showMessageDialog(null,"Nu ati completat formularul cum trebuie !!");
			
		}
		else
		{
			
			try 
			{
				
				telefon=Integer.parseInt(textTelefon.getText());
				
				try 
				 {
					SimpleDateFormat tm = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date Date1 = tm.parse(textDataAngajari.getText());
					dataAngajari = new java.sql.Date(Date1.getTime());
					
					
					
					Mecanic m = new Mecanic( numeMecanic,  expertiza,  email,  orarLuni,  orarMarti,
							 orarMiercuri,  orarJoi,  orarVineri,  telefon,  dataAngajari, cod);
					if(c.adaugaMecanic(m))
					{
						JOptionPane.showMessageDialog(null,"Mecanic a fost adaugat cu succes ");
						sterge();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Mecanic nu a fost adaugat ");
					}
					
		 
		          } 
				 catch (ParseException e) 
				 {
		            	JOptionPane.showMessageDialog(null,"Introduceti o data valida ");
		            	
		         }
				
				
				
			}
			catch(NumberFormatException ex) 
			{
				JOptionPane.showMessageDialog(null,"In casuta 'Telefon' trebuie introduse numere ");
			 
				
			}
			
			
			
			

			
			
			
		}	
		
		
		
	}
	
	public void sterge() 
	{
		
		  textNumeMecanic.setText("");;
		  textExpertiza.setText("");;
		  textEmail.setText("");;
		  textCod.setText("");;
		  textTelefon.setText("");;
		  textDataAngajari.setText("");;
		  textOrarLuni.setText("");
		  textOrarMarti.setText("");
		  textOrarMiercuri.setText("");
		  textOrarJoi.setText("");
		  textOrarVineri.setText("");
		
	}


	private void initialize() 
	{
		
		frame = new JFrame("Adauga Mecanic");
		
		BufferedImage img = null;
		
		try
		{
		
			img = ImageIO.read(new File("Fotografii//image1.png"));
		
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		
		}
		
		Image dimg = img.getScaledInstance(955, 579, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JLabel label = new JLabel(imageIcon);

		frame.setContentPane(label);
		
		
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 955, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title1 = BorderFactory.createTitledBorder(loweredetched, "Orar Mecanic(xx-xx_xx-xx)");
		title1.setTitleColor(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Numele Mecanicului");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 10, 130, 16);
		
		frame.getContentPane().add(lblNewLabel);
		
		textNumeMecanic = new JTextField();
		textNumeMecanic.setBounds(10, 30, 220, 22);
		textNumeMecanic.setColumns(10);

		frame.getContentPane().add(textNumeMecanic);
		
		
		JLabel lblNewLabel_1 = new JLabel("Expertiza");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 60, 130, 16);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		textExpertiza = new JTextField();
		textExpertiza.setBounds(10, 80, 220, 22);
		textExpertiza.setColumns(10);

		frame.getContentPane().add(textExpertiza);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(12, 110, 56, 16);
		
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(10, 130, 220, 22);
		textEmail.setColumns(10);
	
		frame.getContentPane().add(textEmail);
	
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setForeground(Color.WHITE);
		lblCod.setBounds(12, 160, 56, 16);
		
		frame.getContentPane().add(lblCod);
		
		textCod = new JTextField();
		textCod.setBounds(10, 180, 220, 22);
		textCod.setColumns(10);

		frame.getContentPane().add(textCod);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setBounds(12, 210, 56, 16);
		
		frame.getContentPane().add(lblTelefon);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(10, 230, 220, 22);
		textTelefon.setColumns(10);

		frame.getContentPane().add(textTelefon);
		
		
		JLabel lblNewLabel_2 = new JLabel("Data angajari(dd/mm/yyyy)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 260, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_2);
		
		textDataAngajari = new JTextField();
		textDataAngajari.setBounds(10, 280, 220, 22);
		textDataAngajari.setColumns(10);
	
		frame.getContentPane().add(textDataAngajari);
	
		
		
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
        panel.setBorder(title1);
        panel.setLayout(null);
		panel.setBounds(12, 327, 336, 192);
		
		frame.getContentPane().add(panel);
		
		
		lblOrarLuni = new JLabel("Orar Luni");
		lblOrarLuni.setForeground(Color.WHITE);
		lblOrarLuni.setBounds(12, 35, 115, 16);
		
		panel.add(lblOrarLuni);
		
		textOrarLuni = new JTextField();
		textOrarLuni.setBounds(12, 50, 115, 22);
		textOrarLuni.setColumns(10);
		
		panel.add(textOrarLuni);
		
		
		lblNewLabel_3 = new JLabel("Orar Miercuri");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 85, 115, 16);
		
		panel.add(lblNewLabel_3);
		
		textOrarMiercuri = new JTextField();
		textOrarMiercuri.setBounds(12, 100, 115, 22);
		textOrarMiercuri.setColumns(10);
		
		panel.add(textOrarMiercuri);
		
		
		
		lblNewLabel_4 = new JLabel("Orar Vineri");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 135, 115, 16);
		
		panel.add(lblNewLabel_4);
		
		textOrarVineri = new JTextField();
		textOrarVineri.setBounds(12, 150, 115, 22);
		textOrarVineri.setColumns(10);
		
		panel.add(textOrarVineri);
		
		
		lblOrarMarti = new JLabel("Orar Marti");
		lblOrarMarti.setForeground(Color.WHITE);
		lblOrarMarti.setBounds(200, 35, 70, 16);
		
		panel.add(lblOrarMarti);
		
		textOrarMarti = new JTextField();
		textOrarMarti.setBounds(200, 50, 116, 22);
		textOrarMarti.setColumns(10);

		panel.add(textOrarMarti);
		
		
		lblOrarJoi = new JLabel("Orar Joi");
		lblOrarJoi.setForeground(Color.WHITE);
		lblOrarJoi.setBounds(200, 85, 56, 16);
		
		panel.add(lblOrarJoi);
		
		textOrarJoi = new JTextField();
		textOrarJoi.setBounds(200, 100, 116, 22);
		textOrarJoi.setColumns(10);

		panel.add(textOrarJoi);
	
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.setForeground(Color.BLACK);
		btnAdauga.setBackground(Color.WHITE);
		btnAdauga.setBounds(200, 150, 116, 25);
		
		btnAdauga.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				try 
				{
					adaugaMecanic();
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
					
				
				
			}
		});
		
		
		panel.add(btnAdauga);
		
		btnNewButton = new JButton("Inapoi");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(825, 492, 100, 25);
		btnNewButton.addActionListener(new ActionListener() 
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
		
		frame.getContentPane().add(btnNewButton);
	}
}
