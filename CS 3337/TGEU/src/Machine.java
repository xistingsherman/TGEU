import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Machine{
	private int id;
	private String type;
	private String state;
	private String time;
	
	private Calendar cal;
	private SimpleDateFormat sdf;
	
	//unique ID number? extend machine to include machine type. add a static parameter: number of bikes. 
	public Machine(){
		//from StackOverflow http://stackoverflow.com/questions/833768/java-code-for-getting-current-time
		this.sdf = new SimpleDateFormat("HH:mm:ss");
		setID(0);
		setType("treadmill");
		setState("on");
		setTime();
		
	}
	public Machine(int id, String type, String state){
		this.sdf = new SimpleDateFormat("HH:mm:ss");
		setID(id);
		setType(type);
		setState(state);
		setTime();
	}
	
	public void setID(int id){
		this.id = id;
	}
	public int getID(){
		return this.id;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}
	//calls the time function to set time
	public void setTime(){
		this.cal = Calendar.getInstance();
		this.time = this.sdf.format(this.cal.getTime());
	}
	//method overload for time distribution customization.
	public void setTime(String time){
		this.time = time;
	}
	public String getTime(){
		return this.time;
	}
}
