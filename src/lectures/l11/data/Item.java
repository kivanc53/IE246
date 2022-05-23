package data;
public class Item {
	public int id;
	public int value;
	public int weight;
	public double valuePerWeight;
	public Item(int id, int value, int weight) {
		this.id = id;
		this.value = value;
		this.weight = weight;	
		this.valuePerWeight = (double) this.value/this.weight;
	}
	public Item(String sid, String svalue, String sweight) {
		this.id = Integer.parseInt(sid);
		this.value = Integer.parseInt(svalue);
		this.weight = Integer.parseInt(sweight);
		this.valuePerWeight = (double) this.value/this.weight;
	}
}
