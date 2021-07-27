package View;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import View.Diagnostic.adaugaDiagnosticGUI;
import View.Diagnostic.afiseazaDiagnosticGUI;
import View.Diagnostic.cautaDiagnosticGUI;
import View.Diagnostic.stergeDiagnosticGUI;
import View.Masina.adaugaMasinaGUI;
import View.Masina.afiseazaMasiniGUI;
import View.Masina.cautaMasinaGUI;
import View.Masina.stergeMasinaGUI;
import View.Mecanic.adaugaMecanicGUI;
import View.Mecanic.afiseazaMecanicGUI;
import View.Mecanic.afiseazaOrarMecanicGUI;
import View.Mecanic.cautaMecanicGUI;
import View.Mecanic.stergeMecanicGUI;
import View.Piese.adaugaPieseGUI;
import View.Piese.afiseazaPieseGUI;
import View.Piese.cautaPieseGUI;
import View.Piese.stergePieseGUI;
import View.Programare.adaugaProgramareGUI;
import View.Programare.afiseazaProgramareGUI;
import View.Programare.cautaProgramareGUI;
import View.Programare.stergeProgramareGUI;

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

public class GUI {

	private JFrame frame;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GUI() throws IOException 
	{
		initialize();
	}


	private void initialize() throws IOException 
	{
	
		
		
		frame = new JFrame("Mr.Mecanic");
		frame.getContentPane().setBackground(Color.WHITE);
		
		BufferedImage img = null;
		
		try
		{
		
			img = ImageIO.read(new File("Fotografii//image1.png"));
		
		} 
		catch (IOException e)
		{
		
			e.printStackTrace();
		
		}
		
		Image dimg = img.getScaledInstance(1340, 720, Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		frame.setContentPane(new JLabel(imageIcon));
		
		frame.setBounds(100, 100, 1340, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		frame.setVisible(true);
		
		

		final JPopupMenu menuMasini = new JPopupMenu();
		final JPopupMenu menuMecanici = new JPopupMenu();
		final JPopupMenu menuProgramare = new JPopupMenu();
		final JPopupMenu menuDiagnostic = new JPopupMenu();
		final JPopupMenu menuPiese = new JPopupMenu();
		
		
		//---------Masina
		
		JMenuItem adaugaMasina = new JMenuItem("Adauga masina");
		adaugaMasina.setBackground(Color.WHITE);
		
		JMenuItem stergeMasina = new JMenuItem("Sterge masina");
		stergeMasina.setBackground(Color.WHITE);
		
		JMenuItem masinileCurente = new JMenuItem("Vezi masinile curente");
		masinileCurente.setBackground(Color.WHITE);
		
		JMenuItem cautaMasina = new JMenuItem("Cauta masina");
		cautaMasina.setBackground(Color.WHITE);
		
		
		//---------Mecanici
		
		JMenuItem adaugaMecanic = new JMenuItem("Adauga mecanic");
		adaugaMecanic.setBackground(Color.WHITE);
		
		JMenuItem stergeMecanic = new JMenuItem("Sterge mecanic");
		stergeMecanic.setBackground(Color.WHITE);
		
		
		JMenuItem mecaniciCurenti = new JMenuItem("Vezi mecanici curenti");
		mecaniciCurenti.setBackground(Color.WHITE);
		
		JMenuItem orarMecanici = new JMenuItem("Vezi orar mecanici");
		orarMecanici.setBackground(Color.WHITE);
		
		JMenuItem cautaMecanic = new JMenuItem("Cauta mecanic");
		cautaMecanic.setBackground(Color.WHITE);
		
		
		
		//----------Diagnostic
		JMenuItem adaugaDiagnostic = new JMenuItem("Adauga diagnostic");
		adaugaDiagnostic.setBackground(Color.WHITE);
		
		JMenuItem stergeDiagnostic = new JMenuItem("Sterge diagnostic");
		stergeDiagnostic.setBackground(Color.WHITE);
		
		
		JMenuItem diagnosticeleCurente = new JMenuItem("Vezi toate diagnosticurile");
		diagnosticeleCurente.setBackground(Color.WHITE);
		
		
		JMenuItem cautaDiagnostic = new JMenuItem("Cauta diagnostic");
		cautaDiagnostic.setBackground(Color.WHITE);
		
		//---------Piese
		
		JMenuItem adaugaPiese = new JMenuItem("Adauga piesa");
		adaugaPiese.setBackground(Color.WHITE);
		
		JMenuItem stergePiese = new JMenuItem("Sterge piesa");
		stergePiese.setBackground(Color.WHITE);
		
		
		JMenuItem pieseleCurente = new JMenuItem("Vezi toate piesele");
		pieseleCurente.setBackground(Color.WHITE);
		
		
		JMenuItem cautaPiese = new JMenuItem("Cauta piesa");
		cautaPiese.setBackground(Color.WHITE);
		
		
		//------Programare
		
		
		JMenuItem adaugaProgramare = new JMenuItem("Adauga programare");
		adaugaProgramare.setBackground(Color.WHITE);
		
		JMenuItem stergeProgramare = new JMenuItem("Sterge programare");
		stergeProgramare.setBackground(Color.WHITE);
		
		
		JMenuItem programarileCurente = new JMenuItem("Vezi toate programarile");
		programarileCurente.setBackground(Color.WHITE);
		
		
		JMenuItem cautaProgramare = new JMenuItem("Cauta programare");
		cautaProgramare.setBackground(Color.WHITE);
		
		
		
		
		menuMasini.add(adaugaMasina);
		menuMasini.add(stergeMasina);
		menuMasini.add(masinileCurente);
		menuMasini.add(cautaMasina);
		
		menuMecanici.add(adaugaMecanic);
		menuMecanici.add(stergeMecanic);
		menuMecanici.add(mecaniciCurenti);
		menuMecanici.add(orarMecanici);	
		menuMecanici.add(cautaMecanic);
		
		menuProgramare.add(adaugaProgramare);
		menuProgramare.add(stergeProgramare);
		menuProgramare.add(programarileCurente);
		menuProgramare.add(cautaProgramare);
		
		menuDiagnostic.add(adaugaDiagnostic);
		menuDiagnostic.add(stergeDiagnostic);
		menuDiagnostic.add(diagnosticeleCurente);
		menuDiagnostic.add(cautaDiagnostic);
		
		menuPiese.add(adaugaPiese);
		menuPiese.add(stergePiese);
		menuPiese.add(pieseleCurente);
		menuPiese.add(cautaPiese);
		
		
		
		
		JButton btnGestionezaMasini = new JButton("Masini");
		btnGestionezaMasini.setBackground(Color.WHITE);
		btnGestionezaMasini.setBounds(70, 70, 200, 25);
		
		btnGestionezaMasini.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				menuMasini.show(btnGestionezaMasini, btnGestionezaMasini.getWidth()/2, btnGestionezaMasini.getHeight());
				menuMasini.setBackground(Color.WHITE);
				
				adaugaMasina.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						try 
						{
							new adaugaMasinaGUI();
						} 
						catch (SQLException e1) 
						{
							
							e1.printStackTrace();
						}
					
					}
				});
				
				
				masinileCurente.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new afiseazaMasiniGUI();
					
					}
				});
				
				stergeMasina.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
						
						frame.dispose();
						new stergeMasinaGUI();
						
					}
					
					
				});
				
				
				cautaMasina.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
					    new cautaMasinaGUI();
					
					}
				});
				
				
			}
		});
		
		frame.getContentPane().add(btnGestionezaMasini);
		
		
		JButton btnGestionezaMecanici = new JButton("Mecanici");
		btnGestionezaMecanici.setBackground(Color.WHITE);
		btnGestionezaMecanici.setBounds(320, 70, 200, 25);
		
		btnGestionezaMecanici.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				menuMecanici.show(btnGestionezaMecanici, btnGestionezaMecanici.getWidth()/2, btnGestionezaMecanici.getHeight());
				menuMecanici.setBackground(Color.WHITE);
				
				adaugaMecanic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
					    new adaugaMecanicGUI();
					
					}
				
				});
				
				stergeMecanic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
					    new stergeMecanicGUI();
					
					}
				
				});
				
				mecaniciCurenti.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new afiseazaMecanicGUI();
					
					}
				
				});
				
				
				orarMecanici.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new afiseazaOrarMecanicGUI();
					
					}
				
				});
				
				
				cautaMecanic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
					    new cautaMecanicGUI();
					
					}
				
				});
				
				
			}
		});
		
		
		frame.getContentPane().add(btnGestionezaMecanici);
		
		
		JButton btnDiagnostic = new JButton("Diagnostic ");
		btnDiagnostic.setBackground(Color.WHITE);
		btnDiagnostic.setBounds(570, 70, 200, 25);
		
		btnDiagnostic.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				menuDiagnostic.show(btnDiagnostic, btnDiagnostic.getWidth()/2, btnDiagnostic.getHeight());
				menuDiagnostic.setBackground(Color.WHITE);
				
				adaugaDiagnostic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
				
						frame.dispose();
					    try 
					    {
							new adaugaDiagnosticGUI();
							
						}
					    catch (SQLException e1) 
					    {
		
							e1.printStackTrace();
						}
					
					}
				
				});
				
				stergeDiagnostic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new stergeDiagnosticGUI();
					
					}
				
				});
				
				diagnosticeleCurente.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new afiseazaDiagnosticGUI();
					
					}
				
				});
				
				
			
				
				cautaDiagnostic.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new cautaDiagnosticGUI();
					
					}
				
				});
				
				
			}
		});
		
		frame.getContentPane().add(btnDiagnostic);
		
		JButton btnProgramari = new JButton("Programari");
		menuProgramare.setBackground(Color.WHITE);
		btnProgramari.setBackground(Color.WHITE);
		btnProgramari.setBounds(820, 70, 200, 25);
		
		
		btnProgramari.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				
				menuProgramare.show(btnProgramari, btnProgramari.getWidth()/2, btnProgramari.getHeight());
				menuProgramare.setBackground(Color.WHITE);
				
				adaugaProgramare.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						try
						{
							new adaugaProgramareGUI();
						}
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
					
					}
				
				});
				
				stergeProgramare.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new stergeProgramareGUI();
					
					}
				
				});
				
				programarileCurente.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new afiseazaProgramareGUI();
					
					}
				
				});
				
				
			
				
				cautaProgramare.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new cautaProgramareGUI();
					
					}
				
				});
				
				
			}
		});
		
		
		frame.getContentPane().add(btnProgramari);
		
		JButton btnPiese = new JButton("Piese auto");
		btnPiese.setBounds(1070, 70, 200, 25);
		btnPiese.setBackground(Color.WHITE);
		
		btnPiese.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				menuPiese.show(btnPiese, btnPiese.getWidth()/2, btnPiese.getHeight());
				
				
				adaugaPiese.addActionListener(new ActionListener() 	
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
				
						frame.dispose();
					    new adaugaPieseGUI();
					
					}
				
				});
				
				stergePiese.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
					
						frame.dispose();
						new stergePieseGUI();
					
					}
				
				});
				
				pieseleCurente.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
					
						frame.dispose();
						new afiseazaPieseGUI();
					
					}
				
				});
				
				
			
				
				cautaPiese.addActionListener(new ActionListener() 
				{

					@Override
					public void actionPerformed(ActionEvent e)
					{
					
						frame.dispose();
						new cautaPieseGUI();
					
					}
				
				});
				
				
			}
		});
		
		
		frame.getContentPane().add(btnPiese);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1070, 600, 200, 25);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		frame.getContentPane().add(btnNewButton);
	}
}
