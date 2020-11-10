package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connexion {

	static Connection con;
	public String url;
	public String user;
	public String password;
	
	

	
	public Connexion(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}






	public static void connect(String url,String user,String password) throws SQLException{
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver O.K");
			Connection con=DriverManager.getConnection(url,user,password);
			System.out.println("connexion etablie");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
