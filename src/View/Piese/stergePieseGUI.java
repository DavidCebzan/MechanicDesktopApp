package View.Piese;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
import javax.swing.JPanel;

public class stergePieseGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textCod;
	private Controller c;
	private String cod;

	public stergePieseGUI() 
	{
		initialize();
	}
	
	
	public void stergePiesa() 
	{
		
		cod=textCod.getText();
		
		try {
			
				if(cod.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null,"Introduceti un Cod ");
				}
				else
				{
					boolean verifica;	
				
					verifica=c.sterge(cod,"DELETE FROM piese WHERE cod = ?");
			
		
			
					if(verifica)
					{
						JOptionPane.showMessageDialog(null,"Piesa a fost stersa ");
			
					}
					else
					{
				
						JOptionPane.showMessageDialog(null,"Piesa nu a fost stearsa");
			
					}
			
			
			sterge();
			
			frame.dispose();
			
			new stergePieseGUI();
			
			
			
				}
		} 
		catch (SQLException e1) 
		{
			
			JOptionPane.showMessageDialog(null,"Programare nu a fost stearsa, incearca din nou !!");
		}
	}
	
	public void sterge() 
	{
		textCod.setText("");
	}

	
	private void initialize() {
		
		frame = new JFrame("Sterge piese");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 965, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 923, 391);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);	
		table=c.afiseaza(table, "Select * from piese");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		panel.setBounds(12, 417, 600, 121);
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Itroduceti codul piesei care doriti sa o stergeti");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 262, 16);
		
		panel.add(lblNewLabel);
		
		textCod = new JTextField();
		textCod.setBounds(12, 42, 262, 22);
		textCod.setColumns(10);
		
		panel.add(textCod);
		
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.setBackground(Color.WHITE);
		btnSterge.setBounds(12, 83, 97, 25);
		
		panel.add(btnSterge);
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(Color.WHITE);
		panel_1.setOpaque(false);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		panel_1.setBounds(624, 417, 311, 121);
		
		frame.getContentPane().add(panel_1);
		
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(202, 83, 97, 25);
		
		panel_1.add(btnInapoi);
		
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
		
		btnSterge.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stergePiesa();
			}
		});
	}

}
