package controllers;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import javafx.scene.layout.VBox;

import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.layout.Pane;

public class MainpageController implements Initializable{
	@FXML
	private AnchorPane mainroot;
	@FXML
	private VBox menubox;
	@FXML
	private Button fc;
	@FXML
	private Button in;
	@FXML
	private Button bo;
	@FXML
	private Button fo;
	@FXML
	private VBox contenubox;
	@FXML
	private Pane barrenotif;
	@FXML
	private FontAwesomeIconView help;
	@FXML
	private FontAwesomeIconView notifbutton;
	@FXML
	private FontAwesomeIconView config;
	@FXML
	private ImageView toff;
	@FXML
	private Label username;
	@FXML
	private Circle online;
	@FXML
	private Label notiflabel;
	@FXML
	private Pane menucontain;
	@FXML
	private Label msgcontain;
	@FXML
	private Label date_heure;
	

	//ajout des interfaces de menu

		
		Parent m1=null;
		Parent m2=null;
		Parent m3=null;
		Parent m4=null;
		
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//ajout des interfaces de menu

		try {
			
			Parent m1=FXMLLoader.load(getClass().getResource("/views/Projet_journalier.fxml"));
			Parent m2=FXMLLoader.load(getClass().getResource("/views/Iventaire.fxml"));
			Parent m3=FXMLLoader.load(getClass().getResource("/views/Boissons.fxml"));
			Parent m4=FXMLLoader.load(getClass().getResource("/views/Fournisseur.fxml"));
			
			ArrayList<Parent> menu=new ArrayList<>();
			
			menu.add(m1);
			menu.add(m2);
			menu.add(m3);
			menu.add(m4);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//modification du nom user
		username.setText(Login_pageController.nomuser);
		
		//modification de la Date
		date_heure.setText(date_du_jour());
		
		
		/*animation boutton rouge*/
			FadeTransition rouge=new FadeTransition();
			rouge.setDuration(Duration.millis(700));
			rouge.setNode(online);
			rouge.setFromValue(0);rouge.setToValue(1);;rouge.setCycleCount(Timeline.INDEFINITE);
			rouge.setAutoReverse(true);
			rouge.play();
		
	}
	
	private String date_du_jour() {
		Date auday=new Date();
		SimpleDateFormat simple=new SimpleDateFormat("'Le'  dd  MMMM  yyyy");
		
		return simple.format(auday);
		
	}
	
	
	// Event Listener on Button[#fc].onAction
		@FXML
		public void addfc(ActionEvent event) throws IOException {
			
			
			try {
				m1 = FXMLLoader.load(getClass().getResource("/views/Projet_journalier.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			focusation(fc,in,bo,fo);
			transition(m1,m2,m3,m4);
			
		}
		
		// Event Listener on Button[#in].onAction
		@FXML
		public void addin(ActionEvent event) throws IOException {
			try {
				m2 = FXMLLoader.load(getClass().getResource("/views/Iventaire.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			focusation(in,bo,fo,fc);
			transition(m2,m1,m4,m3);
			
		}
		
		// Event Listener on Button[#bo].onAction
		@FXML
		public void addbo(ActionEvent event) throws IOException {
			try {
				m3 = FXMLLoader.load(getClass().getResource("/views/Boissons.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			focusation(bo,fo,fc,in);
			transition(m3,m1,m2,m4);
			
		}
		
		// Event Listener on Button[#fo].onAction
		@FXML
		public void addfo(ActionEvent event) throws IOException {
			try {
				m4 = FXMLLoader.load(getClass().getResource("/views/Fournisseur.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			focusation(fo,fc,in,bo);
			transition(m4,m1,m2,m3);
			
		}
	
		public void transition(Parent a,Parent b,Parent c,Parent d) throws IOException {
			
			a.translateXProperty().set(menucontain.getWidth());
			menucontain.getChildren().add(a);
			
			
			Timeline timeline=new Timeline();
			KeyValue kv=new KeyValue(a.translateXProperty(),0,Interpolator.EASE_IN);
			KeyFrame kf=new KeyFrame(Duration.seconds(1.5),kv);
			timeline.getKeyFrames().add(kf);
			
			timeline.setOnFinished(event->{
				menucontain.getChildren().removeAll(b,c,d);
			});
			
			timeline.play();
			
		}
		
		public void focusation(Button a,Button b,Button c,Button d) {
			a.getStyleClass().add("buttf");
			b.getStyleClass().remove("buttf");
			c.getStyleClass().remove("buttf");
			d.getStyleClass().remove("buttf");
		}
		
		
		// Event Listener on Label[#notiflabel].onMouseClicked
		@FXML
		public void affichenotif(MouseEvent event) throws IOException {
			
			//System.out.println("essaie");
			
			
			Alert alert=new Alert(AlertType.WARNING);
			alert.setTitle("Stock D'alerte Atteint");
			alert.setHeaderText("le produit a atteint son stock d'alerte");
			alert.setContentText("pensez � renouveler son stock en commandant ce produit");
			alert.showAndWait();
			
			//Parent not= FXMLLoader.load(getClass().getResource("/views/Notif.fxml"));
			//mainroot.getChildren().add(not);
			//not.setLayoutX(201);not.setLayoutY(58);
			
			
			
		}
	
	
}
