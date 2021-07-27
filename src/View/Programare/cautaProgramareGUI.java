package View.Programare;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Controller.Controller;
import View.GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class cautaProgramareGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textCod;
	private JTextField textNume;
	private Controller c;
	private String cod,nume;

	public cautaProgramareGUI() 
	{
		initialize();
	}
	
	
	public void cautaDupaCod() 
	{
		
		cod=textCod.getText();

		if(cod.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un cod");
			
		}
		else
		{
			try {
					
					table=c.cauta(cod, table,"Select * from programare WHERE cod = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
				
						JOptionPane.showMessageDialog(null,"Programarea nu a fost gasita");
			
					}
					else
					{
			
						JOptionPane.showMessageDialog(null,"Programarea a fost gasita");
						sterge();
					}
				} 
			catch (SQLException e1) 
			{
				JOptionPane.showMessageDialog(null,"Programarea nu a fost gasita");
			}
			
		}
		
		
	}
	
	
	
	public void cautaDupaNume()
	{
		
		nume=textNume.getText();

			if(nume.isEmpty()) 
			{
			
				JOptionPane.showMessageDialog(null,"Introduceti numele mecanicului");
			
			}
			else
			{
				
				try {
					
						table=c.cauta(nume, table,"Select * from programare WHERE mecanic = ?");
					
						int rows = table.getRowCount();
					
					
						if(rows<1) 
						{
					
							JOptionPane.showMessageDialog(null,"Programarea nu a fost gasita");
				
						}
						else
						{
				
							JOptionPane.showMessageDialog(null,"Programarea a fost gasita");
							sterge();
						}
					} 
				catch (SQLException e1) 	
				{
					JOptionPane.showMessageDialog(null,"Programarea nu a fost gasita");
				
				}
			
		}
		
		
	}

	
	public void sterge()
	{
		textNume.setText("");
		textCod.setText("");
		
	}
	
	public void initialize()
	{
		frame = new JFrame("Cauta programare");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 999, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		c=new Controller();
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 957, 408);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);	
		table=c.afiseaza(table, "select * from programare");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		panel.setBounds(12, 434, 302, 106);
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Cauta dupa cod");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 166, 16);
		
		panel.add(lblNewLabel);
		
		textCod = new JTextField();
		textCod.setBounds(12, 33, 116, 22);
		textCod.setColumns(10);
		
		panel.add(textCod);
	
		
		JButton btnNewButton = new JButton("Cauta");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 61, 97, 25);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaCod();
			}
		});
		
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(false);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		panel_1.setBounds(326, 434, 336, 106);
		
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Cauta dupa nume mecanic");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 13, 166, 16);
		
		panel_1.add(lblNewLabel_1);
		
		textNume = new JTextField();
		textNume.setBounds(12, 33, 116, 22);
		textNume.setColumns(10);
		panel_1.add(textNume);
		
		
		JButton btnNewButton_1 = new JButton("Cauta");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(12, 61, 97, 25);
		
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cautaDupaNume();
			}
		});
		
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(loweredetched);
		panel_2.setLayout(null);
		panel_2.setBounds(674, 434, 295, 106);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnNewButton_2 = new JButton("Inapoi");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(186, 68, 97, 25);
		
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
