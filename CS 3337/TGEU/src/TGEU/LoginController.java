package TGEU;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class LoginController  implements Initializable{
	private static Stage stage;

	/*Buttons*/
	@FXML
	private Button loginButton;
	@FXML
	private ProgressIndicator indicator;
	@FXML
	private StackPane stackPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

    public static void setStage(Stage s) {
        stage = s;
    }
    
	public void login(){
		System.out.println("LOG ME IN BRO!");
		this.indicator.setVisible(true);
		this.indicator.setProgress(-1.0);
//		this.stackPane.getChildren().remove(loginButton);
		this.loginButton.setVisible(false);
		try {
			Thread.sleep(3000);
			Pane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
			HomeController.setStage(stage);
			stage.setScene(new Scene(pane, 350, 500));
		} catch (InterruptedException e) {
			System.out.println("Guess that didn't work");
		} catch (IOException e) {
			System.out.println("Nope.");
		}
		
		
	}
	
	

	
}
