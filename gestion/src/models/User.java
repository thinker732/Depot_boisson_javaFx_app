package models;

public class User {

	private String login;
	private String mdp;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public User(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}
	
	public Boolean isadmin() {
		
		if(this.login.equals("admin") && this.mdp.equals("admin"))
			return true;
		else if(this.login.equals("BAED") && this.mdp.equals("savitar"))
			return true;
		else
			return false;
		
	}
	
	
}
