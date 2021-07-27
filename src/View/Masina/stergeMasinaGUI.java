package View.Masina;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
import java.awt.Color;

public class stergeMasinaGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textNrInmatriculare;
	private Controller c;
	private String nrInamtriculare;

	
	public stergeMasinaGUI()
	{
		initialize();
	}

	public void stergeMasina()
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
				
					verifica=c.sterge(nrInamtriculare,"DELETE FROM masini WHERE nrInmatriculare = ?");
			
			
					if(verifica)
					{
						JOptionPane.showMessageDialog(null,"Masina a fost stearsa ");
			
					}
					else
					{
				
						JOptionPane.showMessageDialog(null,"Masina nu a fost stearsa, introduceti un numar de inmatriculare valid ");
			
					}
			
					sterge();
			
					frame.dispose();
			
					new stergeMasinaGUI();
			
			
				}
			} 
		catch (SQLException e1) 
		{
			
			JOptionPane.showMessageDialog(null,"Masina nu a fost stearsa, incearca din nou !!");
		}
	}
	
	
	
	
	public void sterge() 
	{
		textNrInmatriculare.setText("");	
	}
	
	
	
	private void initialize() 
	{
	
		frame = new JFrame("Sterge Masina");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1005, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c=new Controller();
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 963, 366);
		
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		table.setDefaultEditor(Object.class, null);
		table.setOpaque(false);
		table=c.afiseaza(table,"Select * from masini");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(loweredetched);
		panel.setBounds(12, 392, 628, 98);
		
		frame.getContentPane().add(panel);
		
		
		JButton btnSterge = new JButton("Sterge");
		btnSterge.setBackground(Color.WHITE);
		btnSterge.setBounds(12, 65, 97, 25);
		
		panel.add(btnSterge);
		
		textNrInmatriculare = new JTextField();
		textNrInmatriculare.setBounds(12, 35, 278, 22);
		textNrInmatriculare.setColumns(10);
		
		panel.add(textNrInmatriculare);
		
		
		JLabel lblIntroducetiNumarulDe = new JLabel("Introduceti Numarul de Inmatriculare a masini care doriti sa o stergeti");
		lblIntroducetiNumarulDe.setForeground(Color.WHITE);
		lblIntroducetiNumarulDe.setBounds(12, 13, 558, 16);
		
		panel.add(lblIntroducetiNumarulDe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(649, 392, 326, 98);
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(loweredetched);

		frame.getContentPane().add(panel_1);
		
		
		JButton btnNewButton = new JButton("Inapoi la meniu");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(167, 60, 147, 25);
		
		panel_1.add(btnNewButton);
		
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
		
		btnSterge.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				stergeMasina();				
			}
		});
	}
}
