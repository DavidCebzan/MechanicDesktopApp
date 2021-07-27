package View.Diagnostic;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.Controller;
import View.GUI;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class afiseazaDiagnosticGUI {

	private JFrame frame;
	private JTable table;
	private Controller c;

	
	public afiseazaDiagnosticGUI() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		
		c= new Controller();
		
		frame = new JFrame("Diagnosticele");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1209, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1167, 389);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setBackground(Color.BLACK);
		
		frame.getContentPane().add(scrollPane);
		
		
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setOpaque(false);
		table=c.afiseaza(table, "select * from diagnostic");
		
		scrollPane.setViewportView(table);
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(1082, 415, 97, 25);
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
		
		
		frame.getContentPane().add(btnInapoi);
		frame.setVisible(true);
	}
}
