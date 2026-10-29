package sample2;

public class Tool extends Items{
	private boolean usedTool;
	
	public Tool() {
		super("tool");
		usedTool=false;
		
	}
	
	@Override
	public void use() {
		if (game1.currentRoom.getName().equals("Bedroom")) {
			if (usedTool) {
				game1.print("attic door already opened");
			}else {
				game1.currentRoom.getExit(4).setLocked(false);
				usedTool=true;
				game1.print("using tool, you are able to unlock other room doors");
			}
		}else {
			game1.print("no way of using tool to unlock other things");
		}
	}
}