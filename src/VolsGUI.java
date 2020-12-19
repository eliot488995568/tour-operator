import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;


/* VolsGUI.java
 * 
 * Classe qui cr�e un JPanel permettant de cr�er des nouveaux vols. 
 * 
 */

public class VolsGUI extends JPanel {
	
	private JTextField departT, destinationT;
	private JLabel departL, destinationL, heureL, infoPane;
	private JButton creerVol;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private SpinnerDateModel model;
	private JSpinner date;
	private JSpinner.DateEditor heure;	
	private Vols vol;
	private GUI gui;
	
	//Constructeur
	VolsGUI(Vols v, GUI gui) {
		this.gui = gui;
		this.setLayout(new GridLayout(6, 1));
		this.vol = v;
		this.setSize(GUI.LARGEUR, 400);
		creerObjets();
		creerDates();
		placerObjets();
	}

	//On cr�� les diff�rents objets graphiques du JPanel.
	private void creerObjets() {
		departT = new JTextField(25);
		destinationT = new JTextField(25);
		
		infoPane = new JLabel("Cr�ation de vols");
		infoPane.setFont(new Font("Dialog",Font.PLAIN, 24));
		departL = new JLabel("D�part");
		destinationL = new JLabel("Destination");
		heureL= new JLabel("Date et heure de d�part");
		
		creerVol = new JButton("Cr�er le vol");
		creerVol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				creerVol();
			}
		});
				
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		panel3 = new JPanel(new FlowLayout());
		panel4 = new JPanel(new FlowLayout());
		panel5 = new JPanel(new FlowLayout());
	}
	
	//On place les objets dans le JPanel.
	private void placerObjets() {
		panel1.add(departL);
		panel1.add(departT);
		panel2.add(destinationL);
		panel2.add(destinationT);
		
		panel3.add(heureL);
		panel3.add(date);
		
		panel4.add(infoPane);
		panel5.add(creerVol);
		
		
		add(panel4);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel5);
	}
	
	//Cr�e un JSpinner sp�cifique pour la date et l'heure de d�part du vol.
	private void creerDates() {
		model = new SpinnerDateModel();
		date = new JSpinner(model);
		heure = new JSpinner.DateEditor(date, "yyyy:MM:dd:HH:mm");
		date.setEditor(heure);
		date.setValue(new Date());
	}
	
	//M�thode appell�e lorsque l'utilisateur clique sur le bouton pour cr�er un vol. V�rifie si toutes
	//les informations n�cessaires sont entr�es, sinon, on annule.
	private void creerVol() {
		String depart, destination;
		Date dateDepart = new Date();
		int rangees, cols;
		
		depart = departT.getText().trim();
		destination  = destinationT.getText().trim();		
		dateDepart = model.getDate();
		
		vol.addVol(depart, destination, dateDepart);
		
	}
	
}
