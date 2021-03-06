package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	public static Boolean isSplashLoaded=false;
	
	public void start(Stage primaryStage) {
		try {
			
			//BorderPane root0 = new BorderPane();
			
			Parent root=FXMLLoader.load(getClass().getResource("/views/Mainpage.fxml"));
			primaryStage.setHeight(630);primaryStage.setWidth(800);
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.setTitle("APP name");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
