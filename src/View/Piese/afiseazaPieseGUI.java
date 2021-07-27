package View.Piese;

import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.Controller;
import View.GUI;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class afiseazaPieseGUI {

	private JFrame frame;
	private JTable table;
	private Controller c;

	
	public afiseazaPieseGUI() 
	{
		initialize();
	}

	
	
	private void initialize() 
	{
		
		frame = new JFrame("Afiseaza piese");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 956, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 914, 395);
		
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table=c.afiseaza(table, "select * from piese");
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(829, 421, 97, 25);
		
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
