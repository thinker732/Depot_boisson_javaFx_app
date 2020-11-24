package models;

public class Iventaire {

	private int codeproduit;
	private int qteapp;
	private int qtlivre;
	
	public int getCodeproduit() {
		return codeproduit;
	}
	public void setCodeproduit(int codeproduit) {
		this.codeproduit = codeproduit;
	}
	public int getQteapp() {
		return qteapp;
	}
	public void setQteapp(int qteapp) {
		this.qteapp = qteapp;
	}
	public int getQtlivre() {
		return qtlivre;
	}
	public void setQtlivre(int qtlivre) {
		this.qtlivre = qtlivre;
	}
	public int getPerte() {
		return perte;
	}
	public void setPerte(int perte) {
		this.perte = perte;
	}
	public Iventaire(int codeproduit, int qteapp, int qtlivre, int perte) {
		super();
		this.codeproduit = codeproduit;
		this.qteapp = qteapp;
		this.qtlivre = qtlivre;
		this.perte = perte;
	}
	private int perte;
}
