package sample2;

import java.util.ArrayList;

public class World {
	public static ArrayList<Room>rooms=new ArrayList<>();
	public static Room buildWorld() {
//		Items officekey=new Items("officekey", true);
//		Items tool=new Tool();
//		Items couch=new Items("couch", false);
//		Items musicbox=new Items("musicbox", false);
//		Items knife=new Items("knife", true);
//		Items flashlight=new Items("flashlight", true);
//		Items orb=new Items("orb", true);
//		Items bed=new Items("bed", false);
		
		Items officekey=new Tool();
		Items tool=new Tool();
		Items couch=new Tool();
		Items musicbox=new Tool();
		Items knife=new Tool();
		Items flashlight=new Tool();
		Items orb=new Tool();
		Items bed=new Tool();
		
		Room livingRoom=new Room("Living Room", "This is a small living room with a couch and coffee table and a TV.", false);
		Room Kitchen=new Room("The Kitchen", "where you make food", true);
		Room Office=new Room("The Office", "to get stuff done", false);
		Room Bedroom=new Room("The Bedroom", "to rest in", true);
		Room Attic=new Room("Attic", "lots of old stuff", false);
		Room Garage=new Room("Garage", "somethings", true);
		
		Office.addItem(officekey);
		livingRoom.addItem(tool);
		livingRoom.addItem(musicbox);
		Kitchen.addItem(knife);
		Kitchen.addItem(flashlight);
		Kitchen.addItem(orb);
		Bedroom.addItem(bed);
		
		livingRoom.addItem(couch);
		livingRoom.addExit(Bedroom, 2);
		livingRoom.addExit(Office, 1);
		livingRoom.addExit(Kitchen, 0);
		Kitchen.addExit(Garage, 3);
		Kitchen.addExit(livingRoom, 1);
		Garage.addExit(Kitchen, 2);
		Office.addExit(livingRoom, 0);
		Bedroom.addExit(livingRoom, 3);
		Bedroom.addExit(Attic, 4);
		Attic.addExit(Bedroom, 5);
		
		return livingRoom;
	}
}