import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* MenuBar.java
 * 
 * Cette classe gère la barre de menu de l'interface graphique de Vols. La barre permet surtout
 * de changer de panel pour faire différentes opérations.
 * 
 */

public class MenuBar extends JMenuBar {

	private JMenu  vols;
	private JMenuItem creerVol, supVol, listeVol, listeVols;
	private Vols v;
	private GUI gui;

	//Constructeur
	public MenuBar (Vols v, GUI gui) {
		this.v = v;
		this.gui = gui;
		creerMenu();
	}
	
	//Initialise les menus.
	private void creerMenu() {
		
		vols = new JMenu("Vols");
		
		creerVol = new JMenuItem("Créer un vol");
		creerVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.switchPanelCreer();
			}
		});
		supVol = new JMenuItem("Supprimer un vol");
		supVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.switchPanelEfface();
			}
		});
		listeVol = new JMenuItem("Afficher les détails d'un vol");
		listeVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.switchPanelListe();
			}
		});
		
		listeVols = new JMenuItem("Afficher tous les vols");
		listeVols.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.switchPanelListeVols();
			}
		});
				
		vols.add(creerVol);
		vols.add(supVol);
		vols.add(listeVol);
		vols.add(listeVols);
		
		add(vols);
		
	} //Fin créerMenu

} //Fin MenuBar
