package ui.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private Image image; // attribut de type Image
	public MyPanel(){
		// on cree une icone de type image
		ImageIcon ii = new ImageIcon("C:\\Users\\Lucas\\Documents\\javaProject\\profils/lucdas1.jpg"); // chemin vers l’image
		this.image = ii.getImage(); // on recupere l’Image de l’icone
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Appel à la focntion paintCOmponent de la classe mère
		// Graphics est un objet fourni par le systeme qui est utilise pour dessiner les composant du conteneur
		Graphics2D g2d = (Graphics2D) g; // on cast en Graphics2D, objet permettant des manipulations plus evoluees

		g2d.drawImage(this.image, 10, 10, (int)(this.image.getWidth(null) * 0.1),
				(int) (this.image.getHeight(null) * 0.1
						), null); // on affiche l’image avec facteur d’echelle ( * 0.1)
	}
}