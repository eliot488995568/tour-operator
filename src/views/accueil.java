package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
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

public class accueil extends JFrame {
	
	
	public static void main(String[] args) {
		
		accueil fenetreA= new accueil();
		fenetreA.build();
		}
	
	public void fenetreAccueil() {
		build();
	}
	
	public void build() {
		
		setTitle("Acceuil_Tour_Operator"); //On donne un titre Ã  l'application
		setSize(700,400); //On donne une taille Ã  notre fenÃªtre
		setLocationRelativeTo(null); //On centre la fenÃªtre sur l'écran
		setResizable(true); //On permet le redimensionnement
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit Ã  l'application de se fermer lors du clic sur la croix
		setJMenuBar(buildMenu());
		setContentPane(buildContentPane());
		setVisible(true);
	}
	
private JMenuBar buildMenu() {
		
	JMenuBar myMenuBar=new JMenuBar();

	
	JMenu menuAcceuil = new JMenu("Acceuil");
	JMenu menuListVol = new JMenu("Liste des vols");
	
	myMenuBar.add(menuAcceuil);
	myMenuBar.add(menuListVol);
	
	return myMenuBar;
}
	
private JPanel buildContentPane() {
	
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		JPanel panelComposant = new JPanel();
			
		JLabel labelAcceuil=  new JLabel("Bienvenue dans notre application !!!");
		Font font = new Font("Arial",Font.BOLD,26);
		labelAcceuil.setFont(font);
		
		JTextArea description = new JTextArea("Cette application vous permettra de voir de nombreux vols , avec un certains nombeux de d'informations .\n  Vous pourrez également réservée les vols que vous désirez avec un grande simplicité :) !");
		description.setEditable(false);
		description.setOpaque(false);
		
		ImageIcon img = new ImageIcon("image1.jpg");	
		ImageIcon imageIcon = new ImageIcon("image1.jpg"); // load the image to a imageIcon
		Image imagee = imageIcon.getImage(); // transform it 
		Image newimg = imagee.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img = new ImageIcon(newimg);  // transform it back
		JLabel image1 = new JLabel(img, JLabel.CENTER);
		
		ImageIcon img2 = new ImageIcon("image2.jpeg");	
		ImageIcon imageIcon2 = new ImageIcon("image2.jpg"); // load the image to a imageIcon
		Image imagee2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = imagee2.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img2 = new ImageIcon(newimg2);  // transform it back
		JLabel image2 = new JLabel(img2, JLabel.CENTER);
		
		ImageIcon img3 = new ImageIcon("image3.jpg");	
		ImageIcon imageIcon3 = new ImageIcon("image3.jpg"); // load the image to a imageIcon
		Image imagee3 = imageIcon3.getImage(); // transform it 
		Image newimg3 = imagee3.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img3 = new ImageIcon(newimg3);  // transform it back
		JLabel image3 = new JLabel(img3, JLabel.CENTER);
		
		
		JButton accesVol = new JButton("Accéder à  la liste des vols"); 
				
		panelComposant.add(labelAcceuil);
		panelComposant.add(description);
		panelComposant.add(image1);
		panelComposant.add(image2);
		panelComposant.add(image3);
		panelComposant.add(accesVol);
		
		panel.add(panelComposant);
		
		return panel ;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource().equals(panelBouton)) {
			//System.out.println("ok");
			//FenetreSecondaire fenetreSecondaire = new FenetreSecondaire();
			//fenetreSecondaire.build();
			//fenetreSecondaire.setVisible(true);
			//panel.setVisible(false);
	}
}
