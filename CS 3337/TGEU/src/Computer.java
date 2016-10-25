
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Justin's Code
public class Computer extends JFrame {
	static final long serialVersionUID = 1;

	static private Connection connection;
	static private PreparedStatement insertRecordsQuery;
	static private PreparedStatement getRecordsQuery;
	static private PreparedStatement deleteRecordQuery;

	private JLabel nameLabel = new JLabel("Player Name:");
	private JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
	private JLabel locationLabel = new JLabel("Team:");
	private JLabel deleteLabel = new JLabel("ID To Delete: ");
	private JTextArea outputArea = new JTextArea();
	private JScrollPane outputScrollPane = new JScrollPane(outputArea); 
	private JTextField nameTextField = new JTextField();
	private JTextField dateTextField = new JTextField();
	private JTextField locationTextField = new JTextField();
	private JTextField delTextField = new JTextField();
	private JButton updateButton = new JButton("Insert Record");
	private JButton cancelUpdateButton = new JButton("Cancel Insert");
	private JButton deleteButton = new JButton("Delete Record");
	private JButton cancelDeleteButton = new JButton("Cancel Delete");
	Computer() {
		showRecords();
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					runInsertRecordsQuery();
					showRecords();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
										
					deleteRecordQuery.setInt(1, Integer.parseInt(delTextField.getText()));
					deleteRecordQuery.execute();
					insertRecordsQuery.clearBatch();
					showRecords();
					delTextField.setText("");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		cancelUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				dateTextField.setText("");
				locationTextField.setText("");
					}
		});

		cancelDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delTextField.setText("");
			}
		});

		
		setUpGUI();
	}

	private void runInsertRecordsQuery() throws Exception{
		insertRecordsQuery.setString(1, nameTextField.getText());
		String[] dateFields = dateTextField.getText().split("-");
		insertRecordsQuery.setString(2,  Integer.parseInt(dateFields[0]) + "-" + Integer.parseInt(dateFields[1]) + "-" + Integer.parseInt(dateFields[2]) );
		insertRecordsQuery.setString(3, locationTextField.getText());
		insertRecordsQuery.executeUpdate();
		insertRecordsQuery.clearBatch();
		nameTextField.setText("");
		dateTextField.setText("");
		locationTextField.setText("");
	}
	
	private void showRecords(){
		try {
			getRecordsQuery.executeQuery();	
			StringBuilder output = new StringBuilder();
			ResultSet rs = getRecordsQuery.getResultSet();
			while(rs.next()) {
				output.append(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getString(4) + System.lineSeparator());
			}
			
			outputArea.setText(output.toString());
			getRecordsQuery.clearBatch();

		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	private void setUpGUI(){
		JPanel insertRecordPanel = new JPanel();
		insertRecordPanel.setLayout(new GridLayout(4,2));
		
		insertRecordPanel.add(nameLabel);
		insertRecordPanel.add(nameTextField);
		insertRecordPanel.add(dateLabel);
		insertRecordPanel.add(dateTextField);
		insertRecordPanel.add(locationLabel);
		insertRecordPanel.add(locationTextField);
		insertRecordPanel.add(updateButton);
		insertRecordPanel.add(cancelUpdateButton);
		
		JPanel outputPanel = new JPanel();
		
		outputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		outputPanel.add(outputScrollPane);
		outputScrollPane.setPreferredSize(new Dimension(400, 300));
		
		JPanel deleteRecordPanel = new JPanel();	
		deleteRecordPanel.setLayout(new GridLayout(2,2));
		
		deleteRecordPanel.add(deleteLabel);
		deleteRecordPanel.add(delTextField);
		deleteRecordPanel.add(deleteButton);
		deleteRecordPanel.add(cancelDeleteButton);
	
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(400,500));
		mainPanel.add(insertRecordPanel);
		mainPanel.add(outputPanel);
		mainPanel.add(deleteRecordPanel);
		
		
		
		getContentPane().add(mainPanel);
	}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.jdbc.Driver");	
		Connection conn = DriverManager.getConnection("jdbc:mysql:gymbro.gear.host;user=gymbro;password=cs3337!;database=gymbro");
		System.out.println("test");
		
		Statement sta = conn.createStatement();
		String Sql = "select * from testing_table";
		ResultSet rs = sta.executeQuery(Sql);
		while (rs.next()) {
			System.out.println(rs.getString("txt_title"));
		}
	}
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://159.203.220.229/sports";
//			connection = DriverManager.getConnection(url, "allen", "simple");
//			insertRecordsQuery = connection
//					.prepareStatement("INSERT INTO basketball (player_name, some_date, team) VALUES (?, ?, ?)");
//			deleteRecordQuery = connection
//					.prepareStatement("DELETE FROM basketball WHERE id = ?");
//
//			getRecordsQuery = connection
//					.prepareStatement("SELECT * FROM sports.basketball");
//	
//			Computer psp = new Computer();
//			psp.setDefaultCloseOperation(EXIT_ON_CLOSE);
//			psp.setVisible(true);
//			psp.pack();
//		} catch (Exception e) {e.printStackTrace();
//		}

}