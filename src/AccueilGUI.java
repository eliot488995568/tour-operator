import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/* AccueilGUI.java
 * 
 * Cette classe affiche la page d'accueil de l'application.
 * Il n'est pas possible d'interagir avec ce panel, il affiche seulement les informations.
 * 
 * 
 */

public class AccueilGUI extends JPanel {
	
	private JLabel labelAcceuil, image1, image2, image3;
	private JPanel panel1, panel2, panelglobal;
	private JTextArea textarea;
	private ImageIcon img, img2, img3, imageIcon, imageIcon2, imageIcon3;
	private Image imagee ,newimg, imagee2 ,newimg2 ,imagee3 ,newimg3;
	private Vols vol;
	GUI gui;
	
	//Constructeur
	AccueilGUI(Vols v, GUI gui) {
		this.gui = gui;
		this.setLayout(new GridLayout(5, 1));
		this.vol = v;
		this.setSize(GUI.LARGEUR, 400);
		this.setLayout(new BorderLayout());
		buildContentPane();
		placeContent();
	}

	//On créé les objets
	private void buildContentPane() {
		
		labelAcceuil = new JLabel("Bienvenue dans notre application !!!");
		labelAcceuil.setFont(new Font("Arial",Font.BOLD,26));
		
		textarea = new JTextArea("Cette application vous permettra de voir de nombreux vols , avec un certains nombeux de d'informations .\n  Vous pourrez également réservée les vols que vous désirez avec un grande simplicité :) !");
		textarea.setEditable(false);
		textarea.setOpaque(false);
		
		img = new ImageIcon("image1.jpg");	
		imageIcon = new ImageIcon("image1.jpg"); // load the image to a imageIcon
		imagee = imageIcon.getImage(); // transform it 
		newimg = imagee.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img = new ImageIcon(newimg);  // transform it back
		image1 = new JLabel(img, JLabel.CENTER);
		
		img2 = new ImageIcon("image2.jpg");
		imageIcon2 = new ImageIcon("image2.jpg"); // load the image to a imageIcon
		imagee2 = imageIcon2.getImage(); // transform it 
		newimg2 = imagee2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img2 = new ImageIcon(newimg2);  // transform it back
		image2 = new JLabel(img2, JLabel.CENTER);
		
		img3 = new ImageIcon("image3.jpg");	
		imageIcon3 = new ImageIcon("image3.jpg"); // load the image to a imageIcon
		imagee3 = imageIcon3.getImage(); // transform it 
		newimg3 = imagee3.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img3 = new ImageIcon(newimg3);  // transform it back
		image3 = new JLabel(img3, JLabel.CENTER);

				
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
		panelglobal = new JPanel();
	}
	
	private void placeContent() {
		panel1.add(labelAcceuil);
		panel1.add(textarea);
		panel2.add(image1);
		panel2.add(image2);
		panel2.add(image3);
		
		panelglobal.add(panel1);
		panelglobal.add(panel2);
		
		add(panelglobal);
	}
}

