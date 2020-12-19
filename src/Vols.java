import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/* Vols.java
 * 
 * Classe permettant de faire la gestion d'objets Vol. Il est possible
 * d'ajouter ou d'enlever des vols. On peut aussi afficher les détails d'un vol ou les
 * informations de tous les vols. 
 *  
 */

public class Vols {

	protected Map<String, Vol> vols;
	private GUI gui;
		
	public Vols(GUI gui) {
		this.gui = gui;
		vols = new HashMap<String, Vol>();
	}
	
	//Véfifie si le vol existe déjà . Sinon, on crée le vol avec une clée unique.
	public boolean addVol(String depart, String destination, Date dateDepart, int rangees, int colonnes) {
		if(depart.equals("") || destination.equals("") || dateDepart == null) {
			gui.infos.append("Il manque une information pour créer le vol.\n");
			return false;
		}
		Vol temp = new Vol(depart, destination, dateDepart);
		/*
		for(Map.Entry<String, Vol> entry:vols.entrySet()) {
			if(entry.getValue().hashCode() == temp.hashCode()) {
				gui.infos.append("Le vol existe déjà .\n");
				return false;
			}
		}
		*/
		if(vols.containsValue(temp)) {
			gui.infos.append("Le vol existe déjà .\n");
			return false;
		}
		vols.put(temp.creerCle(), temp);
		gui.infos.append("Ajout du vol " + temp.creerCle() + "\n");
		return true;
	}
	
	//Cette méthode est utilisée lors de la lecture d'un fichier.
	public boolean addVol(String depart, String destination, Date dateDepart) {
		if(depart.equals("") || destination.equals("") || dateDepart == null) {
			gui.infos.append("Il manque une information pour créer le vol.\n");
			return false;
		}
		Vol temp = new Vol(depart, destination, dateDepart);
		/*
		for(Map.Entry<String, Vol> entry:vols.entrySet()) {
			if(entry.getValue().hashCode() == temp.hashCode()) {
				gui.infos.append("Le vol existe déjà.\n");
				return false;
			}
		}
		*/
		if(vols.containsValue(temp)) {
			gui.infos.append("Le vol existe déjà.\n");
			return false;
		}
		vols.put(temp.creerCle(), temp);
		gui.infos.append("Ajout du vol " + temp.creerCle() + "\n");
		return true;
	}
	
	//On affiche la liste des vols directement dans l'interface graphique.
	protected void afficherVols(JTextArea t) {
		t.setText("");
		int nb = 1;
		if(vols.isEmpty()) {
			t.append("Aucun vol créé pour le moment.\n");
		} else {
			for(String s:vols.keySet()) {
				t.append("Vol #" + nb+"\n");
				t.append("Clé: " + s +"\n");
				t.append("Ville de départ: " + vols.get(s).depart+"\n");
				t.append("Ville de destination: " + vols.get(s).destination+"\n");
				t.append("Date de départ: " + vols.get(s).date() + "\n");
				t.append("Heure de départ: " + vols.get(s).heureDep() + "\n");
				nb++;
				t.append("\n");
			}
		}	
	}

	//Retire le vol correspondant à  la clé de la liste des vols.
	protected boolean enleverVol(String cle) {
		if(!vols.containsKey(cle)) {
			gui.infos.append("Impossible de canceller le vol.\n");
			return false;
		} else {
			Vol temp = vols.get(cle);			
			vols.remove(cle);
			gui.infos.append("Le vol " + cle + " a été supprimé.\n");
			return true;
		}
	}
	
	//On affiche les détails du vol v dans le JTextArea textArea.
	protected void afficherVol(Vol v, JTextArea textArea) {	
		textArea.append("Vol: " + v.creerCle() + "\n");
		textArea.append("Ville de départ: " + v.depart + "\n");
		textArea.append("Ville d'arrivée: " + v.destination + "\n");
		textArea.append("Date de départ: " + v.date() + "\n");
		textArea.append("Heure de départ: " + v.heureDep() + "\n");
	}
}
