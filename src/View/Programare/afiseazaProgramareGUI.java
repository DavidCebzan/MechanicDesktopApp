package View.Programare;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;

import Controller.Controller;
import View.GUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class afiseazaProgramareGUI {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private Controller c;
	
	public afiseazaProgramareGUI() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		
		frame = new JFrame("Programari");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 946, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 904, 378);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);	
		table=c.afiseaza(table, "select * from programare");
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(819, 400, 97, 25);
		
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
