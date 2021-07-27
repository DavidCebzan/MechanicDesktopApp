package View.Mecanic;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Controller.Controller;
import View.GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class stergeMecanicGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textSterge;
	private String cod;
	
	private Controller c;

	
	public stergeMecanicGUI() 
	{
		initialize();
	}
	
	
	public void stergeMecanic()
	{
		cod=textSterge.getText();
	
		try {
				if(cod.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduceti un Cod ");
				}
				else
				{
		
					boolean verifica;	
				
					verifica=c.sterge(cod,"DELETE FROM mecanic WHERE cod = ?");
			
		
			
						if(verifica)
						{
							JOptionPane.showMessageDialog(null,"Mecanicu a fost sters ");
			
						}
						else
						{
				
							JOptionPane.showMessageDialog(null,"Mecanicul nu a fost stears");
			
						}
			
			
					sterge();
			
					frame.dispose();
			
					new stergeMecanicGUI();
			
			
			
				}
		} 
		catch (SQLException e1) 
		{
			JOptionPane.showMessageDialog(null,"Masina nu a fost stearsa, incearca din nou !!");
		}
	}
	
	
	private void sterge() 
	{
		textSterge.setText("");
		
	}


	
	private void initialize() 
	{
	
		frame = new JFrame("Sterge mecanici");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 953, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 911, 306);
		scrollPane.getViewport().setBackground(Color.BLACK);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);	
		table=c.afiseaza(table,"Select numeMecanic,cod,dataAngajari,telefon,email from mecanic");
		
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(false);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		panel_1.setBounds(12, 332, 750, 108);
		
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel = new JLabel("Introduceti codul mecanicului care doriti sa-l stergeti");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 473, 16);
		panel_1.add(lblNewLabel);
		
		textSterge = new JTextField();
		textSterge.setBounds(12, 33, 150, 22);
		textSterge.setColumns(10);
		
		panel_1.add(textSterge);
		
		
		JButton btnNewButton = new JButton("Sterge");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 68, 97, 25);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stergeMecanic();
			}
		});
		
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(true);
		panel_2.setBackground(Color.WHITE);
		panel_2.setOpaque(false);
		panel_2.setBorder(loweredetched);
		panel_2.setLayout(null);
		panel_2.setBounds(774, 332, 149, 108);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnNewButton_2 = new JButton("Inapoi");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(25, 70, 97, 25);
		
		btnNewButton_2.addActionListener(new ActionListener() 
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
		
		panel_2.add(btnNewButton_2);
	}
}
