package View.Diagnostic;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import Model.Diagnostic;
import Model.Masina;
import View.GUI;
import Controller.Controller;
import java.awt.Color;
import javax.swing.JComboBox;

public class adaugaDiagnosticGUI {

	
	private JFrame frame_1;
	private JTextField textDiagnostic;
	private JTextField textNrInmatriculare;
	private JTextField textMarca;
	private JTextField textModel;
	private JTextField textData;
	private JTextField textPret;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private List<Masina> listaMasini;
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxDetinator;
	private String diagnostic,mecanic,numeDetinator,nrInmatriculare,marca,model,pret;
	java.sql.Date dataDiagnosticari;
	
	private Controller c;

	
	public adaugaDiagnosticGUI() throws SQLException 
	{
		initialize();
	}
	
	
	public void adaugaDiagnostic() throws SQLException 
	{
		
		
		c=new Controller();
		
		diagnostic=textDiagnostic.getText();
		mecanic=(String) comboBox.getSelectedItem();
		numeDetinator=(String) comboBoxDetinator.getSelectedItem();
		nrInmatriculare=textNrInmatriculare.getText();
		marca=textMarca.getText();
		model=textModel.getText();
		pret=textPret.getText();
		
		if(diagnostic.isEmpty() || mecanic.isEmpty() || numeDetinator.isEmpty() || nrInmatriculare.isEmpty() || marca.isEmpty() || model.isEmpty() || pret.isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Nu ati completat formularul cum trebuie !!");
			
		}
		else
		{
			 try 
			 {
				 	SimpleDateFormat tm = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date Date1 = tm.parse(textData.getText());
					dataDiagnosticari = new java.sql.Date(Date1.getTime());
	 
					
					Diagnostic d = new Diagnostic(diagnostic,mecanic,numeDetinator,nrInmatriculare,marca,model,pret,dataDiagnosticari);
					
					 
					 if(c.adaugaDiagnostic(d))
					 {
						 JOptionPane.showMessageDialog(null,"Diagnosticul a fost adaugata cu succes ");
							sterge();
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"Diagnosticul nu a fost adaugata ");
					 }
					 
					
	          } 
			 catch (ParseException e) 
			  {
	            	JOptionPane.showMessageDialog(null,"Introduceti o data valida ");
	            	
			  }
			
			 
			 
			 
		
		}
		
		
	}
	
	public void sterge() 
	{
		
		  textDiagnostic.setText("");  
		  textNrInmatriculare.setText("");
		  textMarca.setText("");
		  textModel.setText("");
		  textData.setText("");
		  textPret.setText("");
			
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() throws SQLException 
	{
		c=new Controller();
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		frame_1 = new JFrame("Mr.Mecanic");
		frame_1.getContentPane().setBackground(Color.BLACK);
		
		
		
		BufferedImage img = null;
		
		try
		{
		
			img = ImageIO.read(new File("Fotografii//image1.png"));
		
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		
		}
		
		Image dimg = img.getScaledInstance(439, 550, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JLabel label = new JLabel(imageIcon);

		frame_1.setContentPane(label);
		frame_1.setBounds(100, 100, 953, 620);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		frame_1.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 353, 551);
		panel.setBackground(Color.BLACK);
		panel.setBorder(loweredetched);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		frame_1.getContentPane().add(panel);
		
		
		textDiagnostic = new JTextField();
		textDiagnostic.setBounds(12, 35, 320, 80);
		textDiagnostic.setColumns(10);
		
		panel.add(textDiagnostic);
		
		
		JLabel lblNewLabel = new JLabel("Diagnosticul");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 10, 70, 20);
		
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mecanic");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 125, 320, 16);
		
		panel.add(lblNewLabel_1);

		
		List<String> a = new ArrayList<String>();
		a=c.returneazaMecanici();
			
		String [] listaMecanici = new String[a.size()];
		
		for(int i = 0; i < listaMecanici.length; i++) 
		{
			listaMecanici[i] = a.get(i);
		}
		
		comboBox = new JComboBox(listaMecanici);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(12, 145, 320, 25);
		
		panel.add(comboBox);
		
		
		
		
	listaMasini = new ArrayList<Masina>();
		listaMasini=c.returneazaDetinatori();
		
		
		String[] detinator = new String[listaMasini.size()];
		
		for(int i=0;i<detinator.length;i++) {
			detinator[i]=listaMasini.get(i).getNumeDetinator();
		}
		
		
		comboBoxDetinator = new JComboBox(detinator);
		comboBoxDetinator.setBounds(12, 200, 320, 25);
		comboBoxDetinator.setBackground(Color.WHITE);
		comboBoxDetinator.addItemListener(new ItemListener() 
		{

			@Override
			public void itemStateChanged(ItemEvent e)
			{
				
				
				String getSelected =(String) comboBoxDetinator.getSelectedItem();
				
				for(int i =0;i<detinator.length;i++) 
				{
					if(getSelected.equals(listaMasini.get(i).getNumeDetinator())) 
					{
						textMarca.setText(listaMasini.get(i).getMarca());
						textModel.setText(listaMasini.get(i).getModel());
						textNrInmatriculare.setText(listaMasini.get(i).getNrInmatriculare());
					}
				}
				 
			}
			
			
			
			
		});
		
		panel.add(comboBoxDetinator);
		
	
		JLabel lblNewLabel_2 = new JLabel("Nume Detinador");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 180, 320, 16);
		
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numarul de inmatriculare");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 235, 320, 16);
		
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(12, 290, 320, 16);
		
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Model");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(12, 345, 320, 16);
		
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pretul care trebui platit(pret-valuta)");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(12, 400, 320, 16);
		
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Data in care a fost diagnoticata masina(dd/mm/yyyy)");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(12, 455, 320, 16);
		
		panel.add(lblNewLabel_7);
		
		textNrInmatriculare = new JTextField();
		textNrInmatriculare.setBounds(12, 255, 320, 22);
		textNrInmatriculare.setColumns(10);
		
		panel.add(textNrInmatriculare);
	
		
		textMarca = new JTextField();
		textMarca.setBounds(12, 310, 320, 22);
		textMarca.setColumns(10);
		
		panel.add(textMarca);
	
		
		textModel = new JTextField();
		textModel.setBounds(12, 365, 320, 22);
		textModel.setColumns(10);
		
		panel.add(textModel);
		
		
		textData = new JTextField();
		textData.setBounds(12, 475, 320, 22);
		textData.setColumns(10);
		
		panel.add(textData);
		
		
		textPret = new JTextField();
		textPret.setBounds(12, 420, 320, 22);
		textPret.setColumns(10);
		
		panel.add(textPret);
		
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.setBackground(Color.WHITE);
		btnAdauga.setForeground(Color.BLACK);
		btnAdauga.setBounds(12, 510, 97, 25);
		btnAdauga.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				try 
				{
					adaugaDiagnostic();
				}
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		
		
		
		panel.add(btnAdauga);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(798, 464, 125, 96);
		panel_1.setLayout(null);
		
		frame_1.getContentPane().add(panel_1);
		
		
		JButton btnInapoi = new JButton("Inapoi");
		btnInapoi.setBackground(Color.WHITE);
		btnInapoi.setBounds(12, 58, 97, 25);
		
		btnInapoi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame_1.dispose();
				
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
		
		
		panel_1.add(btnInapoi);
		
		
		
		frame_1.setVisible(true);
		
		
		
		
	}
}
