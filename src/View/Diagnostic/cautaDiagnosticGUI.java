package View.Diagnostic;

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

public class cautaDiagnosticGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textDupaNumeMecanic;
	private JTextField textDupaNrInmatriculare;
	private Controller c;
	private String numeMecanic,nrInmatriculare;


	public cautaDiagnosticGUI() 
	{
		initialize();
	}

	
	public void cautaDupaNrInmatriculare() 
	{
		
		c=new Controller();
		
		nrInmatriculare=textDupaNrInmatriculare.getText();
		
		if(nrInmatriculare.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Introduceti numele");
		}	
		else
		{
			try {
				
					table=c.cauta(nrInmatriculare, table,"Select * from diagnostic WHERE nrInmatriculare = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
						
						JOptionPane.showMessageDialog(null,"Diagnosticul nu a fost gasit");
					
					}
					else
					{
					
						JOptionPane.showMessageDialog(null,"Diagnosticul a fost gasit");
						sterge();
						
					}
				
				
				
				}
			catch (SQLException e1) 
				{
				
				JOptionPane.showMessageDialog(null,"Mecanicul nu a fost gasit");
				
				}
			
		}	
		
		
	}
	
	
	public void cautaNumeMecanic() 
	{
		
		c=new Controller();
		
		numeMecanic=textDupaNumeMecanic.getText();
		
		if(numeMecanic.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Introduceti numele");
		}	
		else
		{
			try {
				
					table=c.cauta(numeMecanic, table,"Select * from diagnostic WHERE mecanic = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
					
						JOptionPane.showMessageDialog(null,"Diagnosticul nu a fost gasit");
				
					}
					else
					{
				
						JOptionPane.showMessageDialog(null,"Diagnosticul a fost gasit");
						sterge();
				
					}
			
				} 
			catch (SQLException e1) 	
				{
				
					JOptionPane.showMessageDialog(null,"Diagnosticul nu a fost gasit");
				}
			
		}	
		
		
	}
	
	
	private void sterge()
	{
		textDupaNumeMecanic.setText("");;
		textDupaNrInmatriculare.setText("");;
	
	}
	
	
	

	private void initialize() 
	{
		
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		
		c=new Controller();
		
		frame = new JFrame("Cauta diagnostic");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 920, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.BLACK);
		frame.setVisible(true);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 880, 428);
		scrollPane.getViewport().setBackground(Color.BLACK);
		
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
		panel.setBorder(loweredetched);
		panel.setBounds(12, 454, 356, 128);
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Cauta diagnostic dupa numele meccanicului");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 330, 16);
		
		panel.add(lblNewLabel);
		
		textDupaNumeMecanic = new JTextField();
		textDupaNumeMecanic.setBounds(12, 37, 330, 22);
		textDupaNumeMecanic.setColumns(10);
		
		panel.add(textDupaNumeMecanic);
		
		
		JButton btnCautaNume = new JButton("Cauta");
		btnCautaNume.setBackground(Color.WHITE);
		btnCautaNume.setBounds(12, 72, 100, 25);
		btnCautaNume.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				cautaNumeMecanic();
				
			}
		
		});
		

		panel.add(btnCautaNume);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(loweredetched);
		panel_1.setBounds(380, 454, 373, 128);
		panel_1.setLayout(null);
		
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cauta diagnostic dupa numarul de inmatriculare");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 13, 350, 16);
		
		panel_1.add(lblNewLabel_1);
		
		textDupaNrInmatriculare = new JTextField();
		textDupaNrInmatriculare.setBounds(12, 37, 350, 22);
		textDupaNrInmatriculare.setColumns(10);
		
		panel_1.add(textDupaNrInmatriculare);
		
		JButton btnCautaNrInm = new JButton("Cauta");
		btnCautaNrInm.setBackground(Color.WHITE);
		btnCautaNrInm.setBounds(12, 72, 100, 25);
		btnCautaNrInm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaNrInmatriculare();
			}
		
		});
		
		panel_1.add(btnCautaNrInm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(loweredetched);
		panel_2.setBounds(765, 454, 125, 128);
		panel_2.setLayout(null);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(26, 90, 73, 25);
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
		
		panel_2.add(btnInapoi);
	}
}
