package TGEU;

public class EquipmentType {
	private int typeId;
	private String type;
	private int total;
	private int inUse;
	private int available;
	private int off;
	
	public EquipmentType(int typeId, String type, int total, int inUse, int available) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.total = total;
		this.inUse = inUse;
		this.available = available;
		this.off = total - available;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getInUse() {
		return inUse;
	}

	public void setInUse(int inUse) {
		this.inUse = inUse;
	}
	
	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}
	
	
}
