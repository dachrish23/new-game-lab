package sample2;

import java.io.Serializable;

public class Items implements Serializable{
	private static final long serialVersionUTD=1L;
	private String itemName;
	private boolean carries;
	
	public static void use() {
		game1.print("cannot be used");
	}
	
	public Items(String in, boolean carry) {
		itemName=in;
		carries=carry;
		
	}


	public boolean isCarries() {
		return carries;
	}
	public void setCarries(boolean carries) {
		this.carries = carries;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String in) {
		this.itemName = in;
	}
	public String toString() {
		return itemName;
	}
	
}
