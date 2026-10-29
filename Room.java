package sample2;  

import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Room implements Serializable{
	private static final long serialVersionUTD=1L;
	private HashMap<String, Items> objects;
	private String roomName;
	private boolean isLocked;
	
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}


	private Room[] rooms;
	
	
	public Room(String n, String d, boolean lock) {
		roomName=n;
		rooms=new Room[6];
		objects=new HashMap<>();
		isLocked=lock;
		}

	public Room[] getRooms() {
		return rooms;
	}

	
	public Items getItems(String a) {
		return objects.get(a);
	}
	
	public void addItem(Items i) {
		objects.put(i.toString(), i);
	}
	
	public void removeItem(String b) {
		objects.remove(b);		
	}
	

	public void addExit(Room r, int n) {
		rooms[n]=r;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public void setRoomDesc(String roomDesc) {
		game1.game.put(roomName, roomDesc);
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
	public Room getExit(int m) {
		return rooms[m];
	}

	public String getName() {
		return roomName;
	}
	
	public String getDesc() {
		return game1.game.get(getName());
	}
	

	public String toString() {
		return roomName+"\n"+game1.game.get(getName());
	}


}
