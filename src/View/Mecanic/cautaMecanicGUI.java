package View.Mecanic;

import java.awt.Color;
import java.sql.SQLException;

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
import java.awt.event.ActionEvent;

public class cautaMecanicGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textCautaCod;
	private JTextField textCautaNume;
	private String cautaNume,cautaCod;
	
	private Controller c;


	public cautaMecanicGUI() 
	{
		initialize();
	}

	public void cautaDupaCod() 
	{
		
		cautaCod=textCautaCod.getText();
		
		if(cautaCod.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un cod");
			
		}
		else
		{
			try {
					table=c.cauta(cautaCod, table,"Select * from mecanic WHERE cod = ?");
					
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
				
						JOptionPane.showMessageDialog(null,"Mecanicul nu a fost gasit");
			
					}
					else
					{
			
						JOptionPane.showMessageDialog(null,"Mecanicul a fost gasit");
						sterge();
					
					}
				
				} 
			catch (SQLException e1) 
				{

					JOptionPane.showMessageDialog(null,"Mecanicul nu a fost gasit");
				
				}
			
		}
		
		
	}
	
	
	public void cautaDupaNume() 
	{
		
		cautaNume=textCautaNume.getText();
		
		if(cautaNume.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un nume");
			
		}
		else
		{
			try {
				
					table=c.cauta(cautaNume, table,"Select * from mecanic WHERE numeMecanic = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
				
						JOptionPane.showMessageDialog(null,"Mecanicul nu a fost gasit");
			
					}
					else
					{
			
					JOptionPane.showMessageDialog(null,"Mecanicul a fost gasit");
					sterge();
			
					}
			
				}
			
			catch (SQLException e1) 
				{
				
					JOptionPane.showMessageDialog(null,"Mecanicul nu a fost gasit");
				
				}
			
		}
		
		
	}
	

	public void sterge()
	{
		
		textCautaCod.setText("");
		textCautaNume.setText("");
		
	}
	

	private void initialize() 
	{
	
		frame = new JFrame("Cauta mecanici");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1300, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		c=new Controller();
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(loweredetched);
		panel_2.setLayout(null);
		panel_2.setBounds(869, 454, 401, 97);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnNewButton_2 = new JButton("Inapoi");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(292, 59, 97, 25);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 1258, 428);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);		
		table=c.afiseaza(table,"select * from mecanic");
		
		scrollPane.setViewportView(table);
		
		
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		panel.setBounds(12, 454, 386, 97);
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Cauta dupa nume");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 247, 16);
		
		panel.add(lblNewLabel);
		
		textCautaNume = new JTextField();
		textCautaNume.setBounds(12, 30, 200, 22);
		textCautaNume.setColumns(10);
		
		panel.add(textCautaNume);
		
		
		JButton btnNewButton = new JButton("Cauta");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 60, 97, 25);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaNume();
			}
		});
		
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(false);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		panel_1.setBounds(410, 454, 447, 97);
		
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cauta dupa cod");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 13, 224, 16);
		
		panel_1.add(lblNewLabel_1);
		
		textCautaCod = new JTextField();
		textCautaCod.setBounds(12, 30, 200, 22);
		textCautaCod.setColumns(10);
		
		panel_1.add(textCautaCod);
		
		
		JButton btnNewButton_1 = new JButton("Cauta");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(12, 60, 97, 25);
		
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaCod();
			}
		});
		
		panel_1.add(btnNewButton_1);
		
		frame.setVisible(true);
		frame.validate();
	}
}
