import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

/* Vol.java
 * 
 * Classe contenant les informations d'un Vol. On d�finit un vol par sa ville de d�part, sa destination et
 * son heure de d�part.
 * 
 */

public class Vol implements Comparable<Vol> {
	
	static int compteVol = 1; //Permet de cr�er une cl�e unique pour un vol.
	protected String depart, destination;
	protected Date dateDepart;
	private int volNb;
	protected int siegeRangees, siegeColonnes;
    static DateFormat fd = DateFormat.getDateInstance(DateFormat.MEDIUM,
                                     Locale.FRENCH);
	
    
	public Vol(String depart, String destination, Date dateDepart) {
		this.depart = depart;
		this.destination = destination;
		this.dateDepart = dateDepart;
	}
	
	public String toString() {
		return String.format("Vol %s, de %s � %s, date de d�part: %s %s,", creerCle(), depart, 
				destination, date(), heureDep());
	}
	
	@Override
	public int compareTo(Vol that) {
		if(this == that)
			return 0;
		int depComp = this.depart.compareTo(that.depart);
		depComp = depComp!=0?depComp:this.destination.compareTo(that.destination);
		return depComp!=0?depComp:this.dateDepart.compareTo(that.dateDepart);
	}
	
	public boolean equals(Object that) {
		if(this==that) {
			return true;
		}
		if(!(that instanceof Vol)) {
			return false;
		}
		Vol temp = (Vol)that;
		boolean b = depart.equals(temp.depart) && destination.equals(temp.destination) 
				&& dateDepart.equals(temp.dateDepart);
		return b;
	}
	
	public int hashCode() {
		return 31*depart.hashCode() + 37*destination.hashCode() + dateDepart.hashCode();
	}
	
	//Cr�e une cl� unique pour repr�senter le vol.
	protected String creerCle() {
		//On enl�ve les caract�res diff�rents des lettres, et on capitalise.
		StringBuilder sb = new StringBuilder();
		sb.append(depart.replaceAll("[^\\p{L}\\p{N}]", "").toUpperCase().substring(0,3));
		sb.append(destination.replaceAll("[^\\p{L}\\p{N}]", "").toUpperCase().substring(0,3));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		sb.append(formatter.format(dateDepart));
		sb.append(String.format("%03d",volNb));
		return ""+sb;	
	}
	
	//Retourne un string formatt� contenant la date de d�part du vol.
	protected String date() {
		return fd.format(dateDepart);
	}
	
	//Retourne un string formatt� contenant l'heure de d�part du vol.
	protected String heureDep() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(dateDepart);
	}
	
	//Retourne un string pour l'�criture d'un vol dans un fichier.
	protected String dateSave() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
		return formatter.format(dateDepart);
	}	
}
