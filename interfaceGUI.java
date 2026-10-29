package sample2;
import javax.swing.*;
import java.awt.*;

public class interfaceGUI extends JFrame {

    private JLabel roomName;
    private JLabel roomDescription;
    private JTextArea output;
    private JTextField commandInput;
    private JButton enterButton;
    private JTextField inputField;

    public interfaceGUI() {
        setTitle("Text Adventure");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        enterButton=new JButton("enter");
        inputField=new JTextField();

        // TOP: Room name and description
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        roomName = new JLabel("Dark Cave", SwingConstants.CENTER);
        roomName.setFont(new Font("Arial", Font.BOLD, 22));

        roomDescription = new JLabel(
            "You are in a dark cave. There is a door to the north.",
            SwingConstants.CENTER
        );
        
        String room="";
        String desc="";
        
        if (game1.currentRoom!=null) {
        	room=game1.currentRoom.getName();
        	desc=game1.game.get(room);

        }
        
        roomName=new JLabel(room,SwingConstants.CENTER);
        roomName.setFont(new Font("Arial", Font.BOLD, 22));
        
        roomDescription=new JLabel(room,SwingConstants.CENTER);
        roomDescription.setFont(new Font("Arial", Font.BOLD, 14));
        
        topPanel.add(roomName);
        topPanel.add(roomDescription);
        add(topPanel, BorderLayout.NORTH); topPanel.add(roomName);
        add(topPanel, BorderLayout.NORTH); topPanel.add(roomDescription);

        // MIDDLE: Game output
        output = new JTextArea();
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        output.setText("Welcome"+"\n"+"enter command"+"\n"+"\n");

        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBorder(
            BorderFactory.createTitledBorder("Game Output")
        );
        add(scrollPane, BorderLayout.CENTER);

        // BOTTOM: Command input
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        add(bottomPanel,BorderLayout.SOUTH);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        commandInput = new JTextField();
        JButton enterButton = new JButton("Enter");
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(enterButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // Submit commands with Enter or button click
        enterButton.addActionListener(e-> 
        {
        	String command=inputField.getText().trim();
        	
        	if (!command.isEmpty()) {
        		game1.processCommand(command);
        	}
        	inputField.setText("");
        });

        inputField.addActionListener(e->
        {
        	String command=inputField.getText().trim();
        	
        	if (!command.isEmpty()) {
        		game1.processCommand(command);
        	}
        	inputField.setText("");
        }
        		);
        	
        setVisible(true);
    }

    
    
    public void setRooms(String n, String d) {
    	roomName.setText(n);
    	roomDescription.setText(d);
    }
    
    public void Message(String mes) {
    	output.append(mes+"\n");
    	output.setCaretPosition(output.getDocument().getLength());
    }
    
    public void print(String s) {
    	output.append(s+"\n");
    	output.setCaretPosition(output.getDocument().getLength());
    }

}
