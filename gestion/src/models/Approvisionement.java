package models;

public class Approvisionement {

	private int idapp;
	private int codeapp;
	private String nomf;
	private int codeb;
	private int quantitelivre;
	private String nomcl;
	
	public Approvisionement(int idapp, int codeapp, String nomf, int codeb, int quantitelivre, String nomcl) {
		super();
		this.idapp = idapp;
		this.codeapp = codeapp;
		this.nomf = nomf;
		this.codeb = codeb;
		this.quantitelivre = quantitelivre;
		this.nomcl = nomcl;
	}

	public int getIdapp() {
		return idapp;
	}

	public void setIdapp(int idapp) {
		this.idapp = idapp;
	}

	public int getCodeapp() {
		return codeapp;
	}

	public void setCodeapp(int codeapp) {
		this.codeapp = codeapp;
	}

	public String getNomf() {
		return nomf;
	}

	public void setNomf(String nomf) {
		this.nomf = nomf;
	}

	public int getCodeb() {
		return codeb;
	}

	public void setCodeb(int codeb) {
		this.codeb = codeb;
	}

	public int getQuantitelivre() {
		return quantitelivre;
	}

	public void setQuantitelivre(int quantitelivre) {
		this.quantitelivre = quantitelivre;
	}

	public String getNomcl() {
		return nomcl;
	}

	public void setNomcl(String nomcl) {
		this.nomcl = nomcl;
	}
	
	
	
}
