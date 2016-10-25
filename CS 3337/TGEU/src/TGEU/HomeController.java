package TGEU;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomeController implements Initializable{
	private static Stage stage;
//	private static Stage prevStage;
	/*Buttons*/
	@FXML
	private Button gymButton;
	@FXML
	private Button fitnessButton;
	@FXML
	private Button foodButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public static void setStage(Stage s) {
        stage = s;
    }
	
	public void toGym(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("SelectLocation.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	
	public void toFitnessLog(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("Fitness.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	
	public void toFoodDiary(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("FoodDiary.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}


	
}
