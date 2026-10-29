package sample2;  

import java.util.Scanner;  

import java.util.ArrayList;  

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class game1 {  
	public static Room currentRoom=World.buildWorld();  
	public static void main(String[] args) {  
		ScanText();
		currentRoom=World.buildWorld();
		gui=new interfaceGUI();
		String command="";
		runGameGUI(command);  
	}  
	
	public static void SaveGame() {
		try {
			File save=new File("SavedFile.sav");
			save.createNewFile();
			
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(save));
			
			out.writeObject(currentRoom);
			out.writeObject(invent);
			out.writeObject(World.rooms);
			out.close();
			
			print("saved successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void LoadGame() {
		try {
			File save=new File("SavedFile.sav");
			save.createNewFile();
			
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(save));
			
			currentRoom=(Room) in.readObject();
			invent=(ArrayList<Items>) in.readObject();
			World.rooms=(ArrayList<Room>) in.readObject();
			
			in.close();
			
			print("loaded successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static interfaceGUI gui;
	
	public static void updateRoomDisplay() {
		gui.setRooms(currentRoom.getName(), game.get(currentRoom.getName()));
	}
	
	public static HashMap<String,String> game=new HashMap<>();

	public static void print(Object obj) {  
		gui.print(obj.toString().trim());  
	}  
	
	public static void processCommand(String command) {
		if (command==null||command.trim().isEmpty()){
			return;
		}
		
		String[]str=command.split(" ");
		
		String[] directions=
			{
			"east",
			"west",
			"north",
			"south",
			"up",
			"down",
			};
		if (str[0].equals("move")) {
			if (currentRoom.isLocked()) {
				print("door is locked");
			}
			else if(str.length<2) {
				print("move?");
				print("\n");
			}else {
				move(str[1]);
				game1.print(currentRoom);
				updateRoomDisplay();
				for (int i=0; i<currentRoom.getRooms().length; i++) {
					if (currentRoom.getExit(i)!=null) {
						print("the only directions are "+directions[i]+"");
					}
				}
			}
		}else if (str[0].equals("take")){
			if (str.length<2) {
				print("take");
				print("\n");
			}else {
				takeItem(str[1]);
			}
			
		}else if(str[0].equals("i")) {
			showInventory();
		}else if(str[0].equals("exit")) {
			System.exit(0);
		}
		
		else if(str[0].equals("save")) {
			SaveGame();
		}else if (str[0].equals("load")) {
			LoadGame();
		}else if (str[0].equals("use")) {
			if (!invent.isEmpty()) {
				Items.use();
			}
		}
			
			
	}
	
	
	
	private static void showInventory() {
		if (invent.isEmpty()) {
			print("no items");
			print("\n");
		}else {
			print("Items:");
			for (Items i: invent) {
				print(i.toString());
			}
		}
		
	}

	public static void ScanText() {
		try {
			Scanner fileScan=new Scanner(new File("gameDesc.txt"));
			while (fileScan.hasNextLine()) {
				String line=fileScan.nextLine();
				String Name=line;
				String Desc="";
				line=fileScan.nextLine();
				while (!line.equals("#")) {
					Desc+=line+" ";
					line=fileScan.nextLine();
				}
				game.put(Name, Desc);
			}
			fileScan.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	private static ArrayList<Items> invent = new ArrayList<>();  

	public static void takeItem(String   itemNa) {
		if (currentRoom.getItems(itemNa)==null) {  
			print("nothing");  
			return;
		} if (currentRoom.getItems(itemNa).getItemName().equals(itemNa)) {
			Items it=currentRoom.getItems(itemNa);
			if (it.getItemName().equals("couch")) {
				if (it.isCarries()) {
					print("cannot carry "+it+".");
				}
			}
			invent.add(currentRoom.getItems(itemNa)); 
			currentRoom.removeItem(itemNa);
			print("you have taken "+itemNa+" and stored it");
		} else {
				print("you cannot take "+itemNa+".");
			}	
		
}
		
		  

	public static void move(String n) {  
		if (n.equals("east")) {  
			if (currentRoom.getExit(0)!=null) {
				currentRoom=currentRoom.getExit(0);  
			}
		
		else if (n.equals("west")) {  
			if (currentRoom.getExit(1)!=null) {  
				currentRoom=currentRoom.getExit(1);  
			}  	
		}  

		else if (n.equals("north")) {  
			if (currentRoom.getExit(2)!=null) {  
				currentRoom=currentRoom.getExit(2);  
			}  
		}  
		else if (n.equals("south")) {  
			if (currentRoom.getExit(3)!=null) {  
				currentRoom=currentRoom.getExit(3);  
			}  
		}else if (n.equals("up")) {  
			if (currentRoom.getExit(4)!=null) {  
				currentRoom=currentRoom.getExit(4);  
			}  
		}  
		else if (n.equals("down")) {  
			if (currentRoom.getExit(5)!=null) {  
				currentRoom=currentRoom.getExit(5);  
			}  
		}  
		else {  
			System.out.print("invalid");  
		}  
		}
	}  
	
 

	public static void runGameGUI(String command) {
		ScanText();
		updateRoomDisplay();
		String[] str1=command.split(" ");
		if (str1[0].equals("name")) {
			String player=str1[1];
			print("welcome "+player+".");
			print("\n");
			
			
		}
		processCommand(command);
	}

}
		

 

