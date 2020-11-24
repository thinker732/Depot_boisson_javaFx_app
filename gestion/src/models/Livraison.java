package models;

public class Livraison {

	private int idlivraison;
	private int codelivraison;
	private String jour;
	private String heure;
	private int qteliv;
	private int perte;
	public int getIdlivraison() {
		return idlivraison;
	}
	public void setIdlivraison(int idlivraison) {
		this.idlivraison = idlivraison;
	}
	public int getCodelivraison() {
		return codelivraison;
	}
	public void setCodelivraison(int codelivraison) {
		this.codelivraison = codelivraison;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public int getQteliv() {
		return qteliv;
	}
	public void setQteliv(int qteliv) {
		this.qteliv = qteliv;
	}
	public int getPerte() {
		return perte;
	}
	public void setPerte(int perte) {
		this.perte = perte;
	}
	
	public Livraison(int idlivraison, int codelivraison, String jour, String heure, int qteliv, int perte) {
		super();
		this.idlivraison = idlivraison;
		this.codelivraison = codelivraison;
		this.jour = jour;
		this.heure = heure;
		this.qteliv = qteliv;
		this.perte = perte;
	}
	
}
