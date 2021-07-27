package View.Masina;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Controller.Controller;
import View.GUI;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class cautaMasinaGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textNrInmatriculare;
	private Controller c;
	private String nrInamtriculare,numeDetinator;
	private JTextField textNumeDetinator;

	
	public cautaMasinaGUI() 
	{
		initialize();
	}

	
	public void cautaDupaNumeDetinator() 
	{
		
		numeDetinator=textNumeDetinator.getText();
		
		if(numeDetinator.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti Numele detinatorului ");
		
		}
		else
		{
			try {
					table=c.cauta(numeDetinator, table,"Select * from masini WHERE numeDetinator = ?");
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
						JOptionPane.showMessageDialog(null,"Masina nu a fost gasita");
					
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Masina a fost gasita");
						sterge();
					
					}
				
				
			
				} 
			catch (SQLException e1) 
				{
				
					JOptionPane.showMessageDialog(null,"Masina nu a fost gasita ");
				
				}
			
		}
		
		
		
	}
	
	public void cautaDupaNrInmatriculare() 
	{
		
		nrInamtriculare=textNrInmatriculare.getText();
		
		if(nrInamtriculare.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un Numar de Inmatriculare ");
			
		}
		else
		{
			try {
				
					table=c.cauta(nrInamtriculare, table,"Select * from masini WHERE nrInmatriculare = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
						JOptionPane.showMessageDialog(null,"Masina nu a fost gasita");
					
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Masina a fost gasita");
						sterge();
					}
				
				} 
			catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(null,"Masina nu a fost gasita ");
				}
			
		}
		
		
	}
	
	public void sterge()
	{
		
		textNrInmatriculare.setText("");
		textNumeDetinator.setText("");
		
	}
	
	
	private void initialize() 
	{
		
		frame = new JFrame("Cauta masina");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1004, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 962, 340);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);
		table=c.afiseaza(table,"Select * from masini");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 366, 295, 102);
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);		
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		
		
		
		JLabel lblScrietiNumarulDe = new JLabel("Cauta masina duna Numarul de inmatriculare ");
		lblScrietiNumarulDe.setForeground(Color.WHITE);
		lblScrietiNumarulDe.setBounds(12, 13, 271, 16);
		
		panel.add(lblScrietiNumarulDe);
		
		textNrInmatriculare = new JTextField();
		textNrInmatriculare.setBounds(12, 34, 271, 22);
		textNrInmatriculare.setColumns(10);
		panel.add(textNrInmatriculare);
		
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.setBackground(Color.WHITE);
		btnCauta.setBounds(12, 64, 97, 25);
		
		panel.add(btnCauta);
		
		btnCauta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				cautaDupaNrInmatriculare();
				
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(loweredetched);
		panel_1.setBounds(319, 366, 408, 102);
		
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel = new JLabel("Cauta masina dupa numele detinatorului");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 271, 16);
		
		panel_1.add(lblNewLabel);
		
		textNumeDetinator = new JTextField();
		textNumeDetinator.setBounds(12, 33, 271, 22);
		textNumeDetinator.setColumns(10);
		panel_1.add(textNumeDetinator);
		
		
		JButton btnCautaDupaNume = new JButton("Cauta");
		btnCautaDupaNume.setBackground(Color.WHITE);
		btnCautaDupaNume.setBounds(12, 64, 97, 25);
		
		panel_1.add(btnCautaDupaNume);
		
		btnCautaDupaNume.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaNumeDetinator();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(loweredetched);
		panel_2.setBounds(739, 366, 235, 102);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(91, 64, 132, 25);
		
		panel_2.add(btnInapoi);
		
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
	}
}
