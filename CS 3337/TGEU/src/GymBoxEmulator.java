
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class GymBoxEmulator extends Application {
	private Calendar cal;
	private SimpleDateFormat sdf;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mysql3.gear.host:3306/gymbro?useSSL=false";
	
	//  Database credentials
	static final String USER = "gymbro";
	static final String PASS = "cs3337!";
	
	private void init(Stage primaryStage) throws ClassNotFoundException {
		GridPane root = new GridPane();
		primaryStage.setScene(new Scene(root));
		
		this.sdf = new SimpleDateFormat("HH:mm");
		
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		
		Label device1 = new Label("Device 1: ");
		ToggleButton on1 = new ToggleButton("ON");
		ToggleButton off1 = new ToggleButton("OFF");
		ToggleButton use1 = new ToggleButton("IN USE");
		
		ToggleGroup group1 = new ToggleGroup();
		on1.setToggleGroup(group1);
		off1.setToggleGroup(group1);
		use1.setToggleGroup(group1);
		
		Label device2 = new Label("Device 2: ");
		ToggleButton on2 = new ToggleButton("ON");
		ToggleButton off2 = new ToggleButton("OFF");
		ToggleButton use2 = new ToggleButton("IN USE");
		
		ToggleGroup group2 = new ToggleGroup();
		on2.setToggleGroup(group2);
		off2.setToggleGroup(group2);
		use2.setToggleGroup(group2);
	
		Label device3 = new Label("Device 3: ");
		ToggleButton on3 = new ToggleButton("ON");
		ToggleButton off3 = new ToggleButton("OFF");
		ToggleButton use3 = new ToggleButton("IN USE");
		
		ToggleGroup group3 = new ToggleGroup();
		on1.setToggleGroup(group3);
		off1.setToggleGroup(group3);
		use1.setToggleGroup(group3);
		
		Button reset = new Button("RESET");
		
		root.add(device1, 0, 0);
		root.add(device2, 0, 1);
		root.add(device3, 0, 2);
		
		root.add(on1, 1, 0);
		root.add(on2, 1, 1);
		root.add(on3, 1, 2);
		
		root.add(off1, 2, 0);
		root.add(off2, 2, 1);
		root.add(off3, 2, 2);
		
		root.add(use1, 3, 0);
		root.add(use2, 3, 1);
		root.add(use3, 3, 2);
		
		root.add(reset, 3, 3);
	
		on1.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (1, 'bike', 'on', '" + time + "')";
			insert(string);
		});
		
		off1.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (1, 'bike', 'off', '" + time + "')";
			insert(string);
		});
		use1.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (1, 'bike', 'use', '" + time + "')";
			insert(string);
		});
		
		on2.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (2, 'bike', 'on', '" + time + "')";
			insert(string);
		});
		
		off2.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (2, 'bike', 'off', '" + time + "')";
			insert(string);
		});
		use2.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (2, 'bike', 'use', '" + time + "')";
			insert(string);
		});
		
		on3.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (3, 'bike', 'on', '" + time + "')";
			insert(string);
		});
		
		off3.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (3, 'bike', 'off', '" + time + "')";
			insert(string);
		});
		use3.setOnAction((event) -> {
			this.cal = Calendar.getInstance();
			String time = this.sdf.format(this.cal.getTime());
			String string = "INSERT INTO Equipment " + "VALUES (3, 'bike', 'use', '" + time + "')";
			insert(string);
		});
		
		reset.setOnAction((event) -> {
			String string = "DELETE FROM Equipment";
			insert(string);
		});
		
	}
	
	public void insert(String sq){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sq);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
			}
	}

		
	@Override
		public void start(Stage primaryStage) throws Exception {
			init(primaryStage);
			primaryStage.show();
		}
		public static void main(String[] args) { 
			launch(args);
		}

}