package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
				Parent root = FXMLLoader.load(getClass().getResource("SceneOne.fxml"));
				Scene scene = new Scene(root);
				stage.setTitle("IW_HACKATHON");
				stage.setResizable(false);
				stage.setScene(scene);
				stage.show();
			
		}catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
}
















	
	
	
