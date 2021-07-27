package View.Diagnostic;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Controller;
import View.GUI;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class stergeDiagnosticGUI {

	private JFrame frame;
	private Controller c;
	private String nrInamtriculare;
	private JTable table;
	private JTextField textNrInmatriculare;


	
	public stergeDiagnosticGUI() 
	{
	
		initialize();
	
	}
	
	public void sterge()
	{
	
		textNrInmatriculare.setText("");
	
	}
	
	public void stergeDiagnostic() 
	{
		
		nrInamtriculare=textNrInmatriculare.getText();
		
		try {
			
				if(nrInamtriculare.isEmpty()) 
				{
			
					JOptionPane.showMessageDialog(null,"Introduceti un Numar de inmatriculare");
			
				}
				else
				{
				
					boolean verifica;	
				
					verifica=c.sterge(nrInamtriculare,"DELETE FROM diagnostic WHERE nrInmatriculare = ?");
			
			
					if(verifica)
					{
					
						JOptionPane.showMessageDialog(null,"Diagnosticul a fost sters ");
			
					}
					else
					{
				
						JOptionPane.showMessageDialog(null,"Diagnosticul nu a fost sters ");
			
					}
			
					sterge();
			
					frame.dispose();
			
					new stergeDiagnosticGUI();
			
				}
			}	 
		catch (SQLException e1) 
			{
			
			JOptionPane.showMessageDialog(null,"Masina nu a fost stearsa, incearca din nou !!");
			
			}
	
	}


	private void initialize()
	{
		
		
		c=new Controller();
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 919, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 877, 389);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);
		table=c.afiseaza(table, "select * from diagnostic");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBorder(loweredetched);
		panel.setBounds(12, 415, 608, 119);
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Introduceti nr da inmatriculare a diagnosticului care doriti sa il stergeti");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 458, 16);
		
		panel.add(lblNewLabel);
		
		textNrInmatriculare = new JTextField();
		textNrInmatriculare.setBounds(12, 42, 403, 22);
		textNrInmatriculare.setColumns(10);
		
		panel.add(textNrInmatriculare);
		
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.setBackground(Color.WHITE);
		btnSterge.setBounds(12, 78, 97, 25);
		
		panel.add(btnSterge);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(632, 415, 257, 119);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		
		frame.getContentPane().add(panel_1);
		
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(148, 81, 97, 25);
		
		panel_1.add(btnInapoi);
		
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
		
		btnSterge.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stergeDiagnostic();
			}
		});
	}

}
