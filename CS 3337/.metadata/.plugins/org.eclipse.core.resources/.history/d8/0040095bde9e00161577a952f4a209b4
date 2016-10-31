package TGEU;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyGymController  implements Initializable{
	private static Stage stage;
	private static Scene home;
	
	@FXML
	private Button homeButton;
	@FXML
	private PieChart chartOfPie;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<PieChart.Data> pieChartData =
	            FXCollections.observableArrayList(
	            new PieChart.Data("Cycling Machine (3)", 3),
	            new PieChart.Data("Tread Mill (3)", 2),
	            new PieChart.Data("Stair Master (2)", 2),
	            new PieChart.Data("Eliptical Machine(3)", 3),
				new PieChart.Data("Free (2)", 2));
	    chartOfPie.setData(pieChartData);
	    chartOfPie.setLabelsVisible(false);
	    chartOfPie.setLegendVisible(true);
	}

    public static void setStage(Stage s) {
        stage = s;
    }
    public static void setHome(Scene h) {
        home = h;
    }
    
	public void login(){
		System.out.println("LOG ME IN BRO!");
		
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	
	public void toHome(){
		stage.setScene(home);
	}
	
	

	
}

