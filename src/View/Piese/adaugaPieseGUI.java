package View.Piese;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.Controller;
import Model.Piese;
import View.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class adaugaPieseGUI {

	private JFrame frame;
	private JTextField textPiesa;
	private JTextField textMarca;
	private JTextField textModel;
	private JTextField textPret;
	private JTextField textAnul;
	private JTextField textCod;
	
	private Controller c;
	private String piesa,marca,model,pret,cod;
	private int anul;

	
	public adaugaPieseGUI() 
	{
		initialize();
	}
	
	public void adaugaPiese() throws SQLException 
	{
		
		c=new Controller();
		
		piesa=textPiesa.getText();
		marca=textMarca.getText();
		model=textModel.getText();
		pret=textPret.getText();
		cod=textCod.getText();
		
		
		
		if(piesa.isEmpty() || marca.isEmpty() || model.isEmpty() || pret.isEmpty() || cod.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Nu ati completat formularul cum trebuie !!");
			
		}
		else
		{
			
			try 
			{
				
				anul=Integer.parseInt(textAnul.getText());
				
				Piese p = new Piese(piesa,marca,model,pret,anul,cod);
				
				if(c.adaugaPiesa(p))
				{
					sterge();
					JOptionPane.showMessageDialog(null,"Piesa a fost adaugata cu succes ");
				
				}else 
				
				{
					JOptionPane.showMessageDialog(null,"Piesa nu a fost adaugata");
				}
				
				
			}
			catch(NumberFormatException ex) 
			{
				JOptionPane.showMessageDialog(null,"In casuta 'Telefon' trebuie introduse numere ");
			 	
				
			}
			
			
		}	
		
	}

	
	public void sterge()
	{
		textPiesa.setText("");
		textMarca.setText("");
		textModel.setText("");
		textPret.setText("");
		textCod.setText("");
		textAnul.setText("");
	}
	
	private void initialize()
	{
	
		frame = new JFrame("Adauga piesa");
		
		BufferedImage img = null;
		
		try
		{
		
			img = ImageIO.read(new File("Fotografii//image1.png"));
		
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		
		}
		
		Image dimg = img.getScaledInstance(938, 466, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JLabel label = new JLabel(imageIcon);

		frame.setContentPane(label);
		
		
		frame.setBounds(100, 100, 938, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		
		
		
		JLabel lblNewLabel = new JLabel("Piesa");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 10, 56, 16);
		
		frame.getContentPane().add(lblNewLabel);
		
		textPiesa = new JTextField();
		textPiesa.setBounds(12, 30, 180, 22);
		textPiesa.setColumns(10);
		frame.getContentPane().add(textPiesa);
		
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 70, 56, 16);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 90, 180, 22);
		textMarca.setColumns(10);
		
		frame.getContentPane().add(textMarca);
		
		
		JLabel lblNewLabel_2 = new JLabel("Model");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 130, 56, 16);
		
		frame.getContentPane().add(lblNewLabel_2);
		
		textModel = new JTextField();
		textModel.setBounds(12, 150, 180, 22);
		textModel.setColumns(10);
		
		frame.getContentPane().add(textModel);
		
		
		JLabel lblNewLabel_3 = new JLabel("Pret(pret-valuta)");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 190, 180, 16);
		
		frame.getContentPane().add(lblNewLabel_3);
		
		textPret = new JTextField();
		textPret.setBounds(12, 210, 180, 22);
		textPret.setColumns(10);
		
		frame.getContentPane().add(textPret);
		
		
		JLabel lblNewLabel_4 = new JLabel("Anul");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 250, 56, 16);
		
		frame.getContentPane().add(lblNewLabel_4);
		
		textAnul = new JTextField();
		textAnul.setBounds(12, 270, 180, 22);
		textAnul.setColumns(10);
		
		frame.getContentPane().add(textAnul);
		
		
		JLabel lblNewLabel_5 = new JLabel("Cod");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(12, 310, 56, 16);
		
		frame.getContentPane().add(lblNewLabel_5);
		
		textCod = new JTextField();
		textCod.setBounds(12, 330, 180, 22);
		textCod.setColumns(10);
		
		frame.getContentPane().add(textCod);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(12, 381, 97, 25);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					adaugaPiese();
				}
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
			}
		});
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(811, 381, 97, 25);
		
		btnNewButton_1.addActionListener(new ActionListener()
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
		
		frame.getContentPane().add(btnNewButton_1);
	}
}
