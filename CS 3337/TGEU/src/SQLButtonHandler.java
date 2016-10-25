import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SQLButtonHandler implements EventHandler<ActionEvent> {
	private final String string;
	
	SQLButtonHandler(String string) {
	    this.string = string ;
	}
	@Override
	public void handle(ActionEvent event) {
	    string.set(string.get());
	}
}
