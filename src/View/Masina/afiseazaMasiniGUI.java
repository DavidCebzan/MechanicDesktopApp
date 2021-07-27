package View.Masina;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controller;
import View.GUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class afiseazaMasiniGUI {

	private JFrame frame;
	private JTable table;
	private Controller c;


	public afiseazaMasiniGUI() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		
		frame = new JFrame("Afiseaza masina");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1000, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 958, 345);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);
		table=c.afiseaza(table,"Select * from masini");
		
		scrollPane.setViewportView(table);
		
		JButton btnInapoi = new JButton(" Inapoi ");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(870, 365, 100, 25);
		btnInapoi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				try {
				
						new GUI();
				
					} 
				catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				
			}
		});
		
		frame.getContentPane().add(btnInapoi);
	}
}
