package models;

public class Boisson {

		private int codeboisson;
		private String nom;
		private int quantite;
		private int prix;
		private int stock_alerte;
		private int code_casier;
		private String typeboisson;
		
		public Boisson(int codeboisson, String nom, int quantite, int prix, int stock_alerte, int code_casier,
				String typeboisson) {
			super();
			this.codeboisson = codeboisson;
			this.nom = nom;
			this.quantite = quantite;
			this.prix = prix;
			this.stock_alerte = stock_alerte;
			this.code_casier = code_casier;
			this.typeboisson = typeboisson;
		}
		public int getCodeboisson() {
			return codeboisson;
		}
		public void setCodeboisson(int codeboisson) {
			this.codeboisson = codeboisson;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public int getPrix() {
			return prix;
		}
		public void setPrix(int prix) {
			this.prix = prix;
		}
		public int getStock_alerte() {
			return stock_alerte;
		}
		public void setStock_alerte(int stock_alerte) {
			this.stock_alerte = stock_alerte;
		}
		public int getCode_casier() {
			return code_casier;
		}
		public void setCode_casier(int code_casier) {
			this.code_casier = code_casier;
		}
		public String getTypeboisson() {
			return typeboisson;
		}
		public void setTypeboisson(String typeboisson) {
			this.typeboisson = typeboisson;
		}
}
