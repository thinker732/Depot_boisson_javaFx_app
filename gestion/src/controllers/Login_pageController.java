package controllers;

import connectivity.dbConnection;
import java.io.IOException;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import models.User;


public class Login_pageController implements Initializable{
	@FXML
	private AnchorPane logroot;
	@FXML
	private TextField user;
	@FXML
	private PasswordField mdp;
	
	@FXML
	private Button valider;

	public static  String nomuser="";

	
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(!application.Main.isSplashLoaded) {
			loadwelcome();
		}
		
	}
	
	
	private void loadwelcome() {
		try {
			
			application.Main.isSplashLoaded=true;
			
			StackPane pane=FXMLLoader.load(getClass().getResource("/views/Welcome.fxml"));
			pane.setLayoutX(0);pane.setLayoutY(0);
			logroot.getChildren().setAll(pane);
			
			FadeTransition fadein=new FadeTransition(Duration.seconds(5),pane);
			fadein.setFromValue(0);
			fadein.setToValue(1);
			fadein.setCycleCount(1); 
			
			FadeTransition fadeout=new FadeTransition(Duration.seconds(3),pane);
			fadeout.setFromValue(1);
			fadeout.setToValue(0);
			fadeout.setCycleCount(1); 
			
			fadein.play();
			
			fadein.setOnFinished((e)->{
				fadeout.play();
			});
			
			fadeout.setOnFinished((e)->{
				try {
					AnchorPane parentcontent=FXMLLoader.load(getClass().getResource("/views/Login_page.fxml"));
				logroot.getChildren().setAll(parentcontent);
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
			
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Event Listener on Button[#valider].onAction
	@FXML
	public void validation(ActionEvent event) throws IOException{
		
		String u1=user.getText().toString();
		String u2=mdp.getText().toString();
		
		nomuser=u1;
			//System.out.println(u1.getClass());
			//System.out.println(u2);
			
		User Admin=new User(u1,u2);
		
		//verification dans la BD
		
		java.sql.Connection con;
		try {
			int st=0;
			con = dbConnection.connect();
			PreparedStatement stat = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM user WHERE nom = ? AND mdp= ?";
		    
		    	stat = (PreparedStatement) con.prepareStatement(sql);
		    	stat.setString(1,Admin.getLogin());
		    	stat.setString(2, Admin.getMdp());
		    	
		    	rs = stat.executeQuery();
		    			if(rs.next()) {
		    				
		    				transition();
		    			
		    				
		    			/*
		    			 * insertion
		    			 * 
		    			 * 	String sql1= "INSERT INTO user(nom,mdp) VALUE(?,?)";
		    				PreparedStatement stat1;
		    				stat1 = (PreparedStatement) con.prepareStatement(sql1);
		    		    	stat1.setString(1, "thinker");
		    		    	stat1.setString(2, "savitar");
		    		    	st=stat1.executeUpdate();
		    		    	
		    		    	if(st>0) {
		    		    		Alert alert=new Alert(AlertType.INFORMATION);
		    		    		alert.setTitle("connexion");
		    		    	}
		    		    	*/
		    			}else {
		    				Alert alert= new Alert(AlertType.ERROR);
		    				alert.setTitle("Connexion non etablie");
		    				alert.setHeaderText("Erreur");
		    				alert.setContentText("nom ou mot de passe incorrecte");
		    				alert.showAndWait();
		    			}	
		    			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	/*
		
		if(Admin.isadmin()){
			//System.out.println("ok");
			transition();
		}
		else {
			Alert alert= new Alert(AlertType.ERROR);
			alert.setTitle("Connexion non etablie");
			alert.setHeaderText("Erreur");
			alert.setContentText("nom ou mot de passe incorrecte");
			alert.showAndWait();
		}
*/
	}


	public void transition() throws IOException {

		Parent rootp=FXMLLoader.load(getClass().getResource("/views/mainpage.fxml"));
		rootp.setLayoutX(0);rootp.setLayoutY(0);
		Scene scene=valider.getScene();
		
		rootp.translateYProperty().set(scene.getHeight());
		logroot.getChildren().add(rootp);
		
		Timeline timeline=new Timeline();
		KeyValue kv=new KeyValue(rootp.translateYProperty(),0,Interpolator.EASE_IN);
		KeyFrame kf=new KeyFrame(Duration.seconds(2),kv);
		timeline.getKeyFrames().add(kf);
		
		
		
		timeline.play();
		
	}
	
}

