/*package connectivity;




import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Boisson;
import models.Fournisseur;
import models.Livraison;

public class Request {
	
	private static final String url ="jdbc:mysql://localhost:3306/gest_stock";
	private static final String user = "root";
	private static final String password = "";
	
public static Connection connect() throws SQLException{
		try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,user,password);
	return con;
	
} catch(ClassNotFoundException | SQLException e) {
	Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, e);
}
return null;

}


 // Fonction d'insertion des differentes classes en BD

/*
public static int Save(Boisson  ct) {
	int st= 0;
	try {
		String sql= "INSERT INTO boissons(nom,quantité,prix,stock_alerte,code_casier,type) VALUE(?,?,?,?,?)";
		Connection con = dbConnection.connect();
		PreparedStatement stat;
		stat = con.prepareStatement(sql);
    	stat.setString(1, ct.getNom());
    	stat.setInt(2, ct.getQuantite());
    	stat.setInt(3, ct.getPrix());
    	stat.setInt(4, ct.getStock_alerte());
    	stat.setString(5, ct.getCode_casier());
    	stat.setString(6, ct.getTypeboisson());
    	st = stat.executeUpdate();
    	con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return st;
	}
	*/

	/*
public static int Save(Fournisseur ct) {
	int st1= 0;
	try {
		String sql= "INSERT INTO fournisseurn(nom,typeproduit,adresse) VALUE(?,?,?)";
		Connection con = dbConnection.connect();
		PreparedStatement stat1;
		stat1 = con.prepareStatement(sql);
    	stat1.setString(1,ct.getNomfournisseur());
    	stat1.setString(2, ct.getTproduit());
    	stat1.setString(3, ct.getAdresse());
    	st1 = stat1.executeUpdate();
    	con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return st1;
	}
*/	

/*
public static int save(Livraison ct){
	int st2= 0;
	try {
		String sql= "INSERT INTO Livraison(codetransaction,jour,heure,quantite,codeboisson,nomclient) VALUE(?,?,?,?,?,?))";
		Connection con = dbConnection.connect();
		PreparedStatement stat2;
		stat2 = con.prepareStatement(sql);
    	stat2.setInt(1, ct.getCodelivraison());
    	stat2.setInt(2, ct.getJour());
    	stat2.setString(3, ct.getHeure());
    	stat2.setString(4, ct.getQteliv());
    	stat2.setString(5, ct.get);
    	st2 = stat2.executeUpdate();
    	con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return st2;
	}
	


}

*/
