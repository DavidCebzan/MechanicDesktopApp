package View.Mecanic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.Controller;
import View.GUI;

public class afiseazaOrarMecanicGUI {

	private JFrame frame;
	private JTable table;
	private Controller c;
	
	public afiseazaOrarMecanicGUI() 
	{
		initialize();
	}

	
	private void initialize() 
	{
	
		frame = new JFrame("Mecanici");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 893, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 12, 851, 355);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table=c.afiseaza(table,"Select numeMecanic,Luni,Marti,Miercuri,Joi,Vineri from mecanic;");
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(763, 380, 100, 25);

		
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


