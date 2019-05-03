package ui.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class InterfaceGraphique extends JFrame{
	// on fait heriter notre classe de JFrame (fenetre graphique)
	// pour pouvoir eventuellement personnaliser son comportement (surcharge)
	private JPanel container = new JPanel();
	private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
	private JLabel label1 = new JLabel("Grimpe");
	private JLabel label2 = new JLabel("Liste d'amis");

	public InterfaceGraphique(){
		this.init(); // on separe le constructeur du code d’initialisation des parametres graphiques (bonne pratique)
	}

	private void init(){
		this.setTitle("Test fenetre"); // titre de la fenetre
		this.setSize(400, 400); // taille de la fenetre. On utilise plutot setPreferredSize si le composant parent
		// utilise un LayoutManager.
		this.setLocationRelativeTo(null); // positionnement centre par rapport a l’ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // comportement lors d’un clic sur la croix rouge
		this.setVisible(true); // on la rend visible
		combo1.setPreferredSize(new Dimension(150,20));
		combo1.addItem("Rechercher secteur");
		combo1.addItem("Rechercher voie");
		combo1.addItem("Rechercher profil");
		combo1.addItem("Rechercher annonces");
		combo1.addItem("Rechercher évènements");
		combo2.setPreferredSize(new Dimension(100,20));

		// Lecture du fichier liste amis
		String filePath = "C:\\Users\\Lucas\\Documents\\javaProject/liste amis.txt";

		try { 
			InputStream ips = new FileInputStream(filePath);
			InputStreamReader ipsr= new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);

			String ligne;
			while((ligne= br.readLine()) !=null){
				String str[] =ligne.split(" ");
				for(int i = 1; i < str.length; i++) {
					combo2.addItem(str[i]);
				}
			}
		}catch (FileNotFoundException f) {
			f.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

		JPanel top = new JPanel();
		top.add(label1);
		top.add(combo1);
		container.add(top, SpringLayout.EAST);
		this.setContentPane(container);
		this.setVisible(true);    

		JPanel bottom = new JPanel();
		bottom.add(label2);
		bottom.add(combo2);
		container.add(bottom, SpringLayout.EAST);
		this.setContentPane(container);
		this.setVisible(true);
		
		MyPanel imgProfil = new MyPanel();
		container.add(imgProfil, SpringLayout.WEST);
		this.setContentPane(imgProfil);
		this.setVisible(true);
	}

	public static void main(String args[]){
		InterfaceGraphique myGUI = new InterfaceGraphique();
	}	
}