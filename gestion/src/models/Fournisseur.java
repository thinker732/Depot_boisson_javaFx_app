package models;

public class Fournisseur {

		private int idfournisseur;
		private String nomfournisseur;
		private String tproduit;
		private String Adresse;
		
		public int getIdfournisseur() {
			return idfournisseur;
		}

		public void setIdfournisseur(int idfournisseur) {
			this.idfournisseur = idfournisseur;
		}

		public String getNomfournisseur() {
			return nomfournisseur;
		}

		public void setNomfournisseur(String nomfournisseur) {
			this.nomfournisseur = nomfournisseur;
		}

		public String getTproduit() {
			return tproduit;
		}

		public void setTproduit(String tproduit) {
			this.tproduit = tproduit;
		}

		public String getAdresse() {
			return Adresse;
		}

		public void setAdresse(String adresse) {
			Adresse = adresse;
		}

		public Fournisseur(int idfournisseur, String nomfournisseur, String tproduit, String adresse) {
			super();
			this.idfournisseur = idfournisseur;
			this.nomfournisseur = nomfournisseur;
			this.tproduit = tproduit;
			Adresse = adresse;
		}
}
