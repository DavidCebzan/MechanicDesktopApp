package View.Piese;

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

public class cautaPieseGUI {

	private JFrame frame;
	private JTable table;
	private JTextField textCod;
	private JTextField textMarca;
	private Controller c;
	private String cautaCod,cautaNume;

	
	public cautaPieseGUI() 
	{
		initialize();
	}
	
	public void cautaDupaCod()
	{
		
		cautaCod=textCod.getText();
		
		if(cautaCod.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un cod");
			
		}
		else
		{
			try {
					
					table=c.cauta(cautaCod, table,"Select * from piese WHERE cod = ?");
				
					int rows = table.getRowCount();
				
				
					if(rows<1) 
					{
				
						JOptionPane.showMessageDialog(null,"Piesa nu a fost gasita");
			
					}
					else
					{
			
						JOptionPane.showMessageDialog(null,"Piesa a fost gasita");
						sterge();
					}
				
				}
			catch (SQLException e1)
				{
	
					JOptionPane.showMessageDialog(null,"Piesa nu a fost gasita");
				}
			
		}
		
		
	}
	
	public void cautaDupaMarca() 
	{
		
		cautaNume=textMarca.getText();
		
		if(cautaNume.isEmpty()) 
		{
			JOptionPane.showMessageDialog(null,"Introduceti un nume");
			
		}
		else
		{
			try 
			{
				table=c.cauta(cautaNume, table,"Select * from piese WHERE marca = ?");
				
				int rows = table.getRowCount();
				
				
				if(rows<1) 
				{
			
					JOptionPane.showMessageDialog(null,"Piesa nu a fost gasita");
					 sterge();
				}
				else
				{
		
					JOptionPane.showMessageDialog(null,"Piesa a fost gasita");
				
				}
			
			}
			catch (SQLException e1) 
			{
				
				JOptionPane.showMessageDialog(null,"Piesa nu a fost gasit");
			}
			
		}
		
		
	}
	
	public void sterge()
	{
		
		textMarca.setText("");
		textCod.setText("");
	}
	
	
	private void initialize() 
	{
		
		frame = new JFrame("Cauta piese");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 961, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		c= new Controller();
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.setBounds(12, 13, 919, 358);
		
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table=c.afiseaza(table, "select * from piese");
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		panel.setBounds(12, 384, 320, 109);
		
		frame.getContentPane().add(panel);
		
		
		JLabel lblNewLabel = new JLabel("Cauta piesa dupa cod");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 13, 220, 16);
		
		panel.add(lblNewLabel);
		
		textCod = new JTextField();
		textCod.setBounds(12, 30, 116, 22);
		textCod.setColumns(10);
		
		panel.add(textCod);
		
		
		JButton btnNewButton = new JButton("Cauta");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 65, 97, 25);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				cautaDupaCod();
			}
		});
		
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(loweredetched);
		panel_1.setLayout(null);
		panel_1.setBounds(344, 384, 349, 109);
		
		frame.getContentPane().add(panel_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Cauta piesa dupa marca masini");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 13, 220, 16);
		
		panel_1.add(lblNewLabel_1);
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 30, 116, 22);
		textMarca.setColumns(10);
		
		panel_1.add(textMarca);
		
		
		JButton btnNewButton_1 = new JButton("Cauta");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(12, 65, 97, 25);
		
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cautaDupaMarca();
			}
		});
		
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(loweredetched);
		panel_2.setLayout(null);
		panel_2.setBounds(705, 384, 226, 109);
		
		frame.getContentPane().add(panel_2);
		
		
		JButton btnNewButton_2 = new JButton("Inapoi");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(117, 71, 97, 25);
		
		btnNewButton_2.addActionListener(new ActionListener() 
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
		
		panel_2.add(btnNewButton_2);
	}
}
