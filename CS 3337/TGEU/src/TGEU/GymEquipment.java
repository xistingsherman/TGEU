package TGEU;

import javafx.scene.image.ImageView;

public class GymEquipment {
	private int id;
	private String type;
	private String equipment;
	private int state;
	private ImageView icon;

	public GymEquipment(int id, String type, String equipment, int state, ImageView icon) {
		super();
		this.id = id;
		this.type = type;
		this.equipment = equipment;
		this.state = state;
		this.icon = icon;
	}

	GymEquipment(int id, String type, String equipment, int state) {
		super();
		this.id = id;
		this.type = type;
		this.equipment = equipment;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public ImageView getIcon() {
		return icon;
	}

	public void setIcon(ImageView icon) {
		this.icon = icon;
	}

}
