package controllers;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
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
	private TextField mdp;
	

	@FXML
	private Button valider;

	

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
		
		String u1=user.getText();
		String u2=mdp.getText();
		
			//System.out.println(u1.getClass());
			//System.out.println(u2);
			
		User Admin=new User(u1,u2);
		
		if(Admin.isadmin()){
			//System.out.println("ok");
			transition();
		}

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
		
		/*timeline.setOnFinished(event->{
			logroot.getScene().getWindow().hide();
		});*/
		
		timeline.play();
		
	}
	
}

