package View.Programare;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Programare;
import View.GUI;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class adaugaProgramareGUI {

	private JFrame frame;
	private JTextField textNumeDetinator;
	private JTextField textEmail;
	private JTextField textMarca;
	private JTextField textModel;
	private JTextField textAnul;
	private JTextField textTelefon;
	private JTextField textOra;
	private JTextField textData;
	private JTextField textCod;
	@SuppressWarnings({ "rawtypes" })
	private JComboBox comboBox;
	
	private Controller c;
	
	private String numeDetinator,mecanic,email,marca,model,cod;
	private int anul,telefon;
	private java.sql.Date data;
	private java.sql.Time ora;
	private JTable table;
	


	public adaugaProgramareGUI() throws SQLException 
	{
		initialize();
	}

	
	public void adaugaProgramare() throws SQLException 
	{
		
		c=new Controller();
		
	   	 numeDetinator=textNumeDetinator.getText();
		 mecanic=(String) comboBox.getSelectedItem();
		 email=textEmail.getText();
		 marca=textMarca.getText();
		 model=textModel.getText();
		 cod=textCod.getText();
		 
		 
		 if(numeDetinator.isEmpty() || mecanic.isEmpty() || email.isEmpty() || marca.isEmpty() || model.isEmpty() || cod.isEmpty())
		 {
			 
			 JOptionPane.showMessageDialog(null,"Nu ati completat formularul cum trebuie !!");
			 
		 }
		 else 
		 {
			 try 
			 {
				 	anul=Integer.parseInt(textAnul.getText());
					telefon=Integer.parseInt(textTelefon.getText());
					 
					
					try 
					 {
						 	SimpleDateFormat tm = new SimpleDateFormat("dd/MM/yyyy");
							java.util.Date Date = tm.parse(textData.getText());
							data = new java.sql.Date(Date.getTime());
							
							
							SimpleDateFormat ttm = new SimpleDateFormat("HH:mm");
							java.util.Date Date1 = ttm.parse(textOra.getText());		
							 ora = new java.sql.Time(Date1.getTime());
							
							 
							 Programare p = new Programare(numeDetinator,mecanic,email,marca,model,telefon,anul,ora,data,cod);
							
							 if(c.adaugaProgramare(p)) 
							 {
								 JOptionPane.showMessageDialog(null,"Programarea a fost adaugata cu succes ");
								 sterge();
							 }
							 else
							 {
								 JOptionPane.showMessageDialog(null,"Programarea nu a fost adaugata");
							 }
							 
			 
			            } 
					 catch (ParseException e) 
					 {
			            	JOptionPane.showMessageDialog(null,"Introduceti data si ora valida ");
			            	
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
		textTelefon.setText("");
		textAnul.setText("");
		textOra.setText("");
		textData.setText("");
		textCod.setText("");
		
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws SQLException
	{
	
		
		frame = new JFrame("Adauga programare");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 883, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		
		JLabel lblNewLabel = new JLabel("Itroduceti numele detinatorului");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 10, 220, 16);
		
		frame.getContentPane().add(lblNewLabel);
		
		textNumeDetinator = new JTextField();
		textNumeDetinator.setBounds(12, 30, 220, 22);
		textNumeDetinator.setColumns(10);
		
		frame.getContentPane().add(textNumeDetinator);
		
		
		JLabel lblNewLabel_1 = new JLabel("Introduceti mecanicul");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 60, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		

		
		
		List<String> a = new ArrayList<String>();
		a=c.returneazaMecanici();
			
		String [] listaMecanici = new String[a.size()];
		
		for(int i = 0; i < listaMecanici.length; i++) 
		{
			listaMecanici[i] = a.get(i);
		}
		
		
	
		
		
		
		comboBox = new JComboBox(listaMecanici);
		comboBox.setBounds(12,80,220,22);
		
		
		
		
		
		frame.getContentPane().add(comboBox);
		
		
		textEmail = new JTextField();
		textEmail.setBounds(12, 130, 220, 22);
		textEmail.setColumns(10);

		frame.getContentPane().add(textEmail);
		
		JLabel lblNewLabel_3 = new JLabel("Marca");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 160, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_3);
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 180, 220, 22);
		textMarca.setColumns(10);

		frame.getContentPane().add(textMarca);
		
		
		JLabel lblNewLabel_4 = new JLabel("Model");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 210, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_4);
		
		textModel = new JTextField();
		textModel.setBounds(12, 230, 220, 22);
		textModel.setColumns(10);

		frame.getContentPane().add(textModel);
		
		JLabel lblNewLabel_5 = new JLabel("Anul din care este masina");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(12, 260, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_5);
		
		textAnul = new JTextField();
		textAnul.setBounds(12, 280, 220, 22);
		textAnul.setColumns(10);

		frame.getContentPane().add(textAnul);
		
		JLabel lblNewLabel_6 = new JLabel("Telefon");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(12, 310, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_6);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(12, 330, 220, 22);
		textTelefon.setColumns(10);

		frame.getContentPane().add(textTelefon);
		
		JLabel lblNewLabel_7 = new JLabel("Ora programari(hh:mm)");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(12, 360, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_7);
		
		textOra = new JTextField();
		textOra.setBounds(12, 380, 220, 22);
		textOra.setColumns(10);

		frame.getContentPane().add(textOra);
		
		JLabel lblNewLabel_8 = new JLabel("Data programari(dd/mm/yyyy)");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(12, 410, 220, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		textData = new JTextField();
		textData.setBounds(12, 430, 220, 22);
		textData.setColumns(10);

		frame.getContentPane().add(textData);
		
		JLabel lblNewLabel_9 = new JLabel("Cod-ul programari");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(12, 460, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_9);
		
		textCod = new JTextField();
		textCod.setBounds(12, 480, 220, 22);
		textCod.setColumns(10);
		
		frame.getContentPane().add(textCod);
		
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 515, 110, 25);
		
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			
						try 
						{
							
							adaugaProgramare();
						}
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
						
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(756, 515, 97, 25);
		
		btnNewButton_1.addActionListener(new ActionListener()
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
		
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Email-ul detinatorului");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(12, 110, 220, 16);
		
		frame.getContentPane().add(lblNewLabel_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(259, 10, 594, 491);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);	
		table=c.afiseaza(table,"select numeMecanic,Luni,Marti,Miercuri,Joi,Vineri from mecanic");
		
		scrollPane.setViewportView(table);
	}
}
