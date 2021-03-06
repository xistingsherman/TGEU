package TGEU;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;

public class MyGymController  implements Initializable{
	private static Stage stage;
	private static Scene home;
	
	@FXML
	private Button homeButton;
	@FXML
	private PieChart chartOfPie;
	
	//images hard coded due to time constraints
	@FXML
	private ImageView bike1;
	@FXML
	private ImageView bike2;
	@FXML
	private ImageView bike3;
	@FXML
	private ImageView treadmill1;
	@FXML
	private ImageView treadmill2;
	@FXML
	private ImageView treadmill3;
	@FXML
	private ImageView stairmaster1;
	@FXML
	private ImageView stairmaster2;
	@FXML
	private ImageView stairmaster3;
	@FXML
	private ImageView elliptical1;
	@FXML
	private ImageView elliptical2;
	@FXML
	private ImageView elliptical3;
	
	//database:GED
	//table:machineusage
	public ArrayList<GymEquipment> gymEquip(){
		//reads from database and creates GymEquipment object's with the data
		ArrayList<GymEquipment> equipments = new ArrayList<GymEquipment>();
		Connection c = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.241.213.248/GED";
	        String username = "allen3just";
	        String password = "Justanswer30!";
	        
	        c = DriverManager.getConnection( url, username, password );
	        Statement stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from machineusage;" );
	        
	        while( rs.next() ){
            	
                GymEquipment equipment = new GymEquipment( rs.getInt( "id" ),
                    rs.getString( "type" ), rs.getString( "equipment" ), rs.getInt( "state" ));
                
                
                equipments.add( equipment );
            }
	        
	        ArrayList<ImageView> imageList = new ArrayList<ImageView>(Arrays.asList(bike1, bike2, bike3, treadmill1, treadmill2, treadmill3, stairmaster1, stairmaster2, stairmaster3,
	        		elliptical1, elliptical2, elliptical3));
	        
	        for(int i=0; i<equipments.size(); i++){
	        	equipments.get(i).setIcon(imageList.get(i));
	        }
	        
		}
		catch( Exception e ){
			e.printStackTrace();
	    }finally{
	    	try{
                if( c != null ) c.close();
            }
            catch( Exception e ){
            	e.printStackTrace();
            }
	    }
		
		return equipments;
	}
	
	public void displayChart(ArrayList<GymEquipment> equipments){
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		
		//gets list of different equipment and counts the number of equipment in use
		ArrayList<EquipmentType> equipmentTypes = new ArrayList<EquipmentType>();
		int j = 1;
		int total = 0;
		int inUse = 0;
		int available = 0;
		for(int i=0; i < equipments.size(); i++){
			total++;
			
			if(equipments.get(i).getState() == 1)
				inUse++;
			if(equipments.get(i).getState() == 2)
				available++;
			
			if(i == equipments.size() - 1 || equipments.get(i).getId() / 10 == j && equipments.get(i+1).getId() / 10 == j + 1){
				equipmentTypes.add(new EquipmentType(j, equipments.get(i).getType(), total, inUse, available));
				inUse = 0;
				available = 0;
				j++;
			}
				
		}
		
		int totalAvailable = 0;
		
		for(int i=0; i < equipmentTypes.size(); i++){
			pieChartData.add(new PieChart.Data(equipmentTypes.get(i).getType() + "(" + equipmentTypes.get(i).getInUse() + ")", equipmentTypes.get(i).getInUse()));
			
			totalAvailable += equipmentTypes.get(i).getAvailable();
		}
		
		pieChartData.add(new PieChart.Data("Available" + "(" + totalAvailable + ")", equipments.size()));
		
	    chartOfPie.setData(pieChartData);
	    chartOfPie.setLabelsVisible(false);
	    chartOfPie.setLegendVisible(true);

	}
	
	public void machineUsage(GymEquipment equipment){
		//gets the state of the machine and sets the background color of the image
		Paint paint = Color.GRAY;
		
		if(equipment.getState() == 1)
			paint = Color.RED;
		if(equipment.getState() == 2)
			paint = Color.GREEN;
		
	    Bounds bound = equipment.getIcon().getBoundsInLocal();
	    ColorInput color = new ColorInput();
	    color.setX(bound.getMinX());
	    color.setY(bound.getMinY());
	    color.setWidth(bound.getWidth());
	    color.setHeight(bound.getHeight());
	    color.setPaint(paint);
	    
	    ColorAdjust monochrome = new ColorAdjust();
	    monochrome.setSaturation(-1.0);
	    
	    Blend background = new Blend(BlendMode.MULTIPLY, monochrome, color);
	    
	    equipment.getIcon().setEffect(background);
	}
	
	
	@FXML
    private LineChart<String,Number> dailyHistory;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<GymEquipment> equipments = gymEquip();
		
		displayChart(equipments);
		
		for(GymEquipment equipment : equipments)
			machineUsage(equipment);
		
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        
	    series.getData().add(new Data<String, Number>(" Sun ", 40));
	    series.getData().add(new Data<String, Number>(" Mon ", 25));
	    series.getData().add(new Data<String, Number>(" Tue ", 20));
	    series.getData().add(new Data<String, Number>(" Wed ", 30));
	    series.getData().add(new Data<String, Number>(" Thu ", 40));
	    series.getData().add(new Data<String, Number>(" Fri ", 50));
	    series.getData().add(new Data<String, Number>(" Sat ", 65));
	    
	    dailyHistory.getData().add(series);
	}

    public static void setStage(Stage s) {
        stage = s;
    }
    public static void setHome(Scene h) {
        home = h;
    }
	public void toHome(){
		stage.setScene(home);
	}
	
	

	
}

