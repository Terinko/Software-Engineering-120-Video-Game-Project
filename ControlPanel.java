//Tyler Rinko
//5/4/2024
//SER120 Final Project

//Importing necessary imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControlPanel extends JPanel{
	
	protected static int numEnemies = 1;

	//Control panel constructor
	public ControlPanel() {
		super();
		this.setSize(500, 450);
		
		this.setPreferredSize(new Dimension(500, 450));
		
		
		//where we create enemies/hero
		JLabel label = new JLabel("Character Selection");
		JRadioButton buttonForRed = new JRadioButton("Skeleton");
		JRadioButton buttonForGreen = new JRadioButton("Rogue Man");
		RadioListener redListener = new RadioListener(label, Color.RED);
		RadioListener greenListener = new RadioListener(label, Color.GREEN);
		String[] choices = { "-DEFAULT-", "EASY","MEDIUM", "IMPOSSIBLE"};

		// Create label and JFormattedTextField for number of enemies
        JLabel numEnemyLabel = new JLabel("Number of Enemies:");
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        JFormattedTextField numEnemyField = new JFormattedTextField(numberFormat);
        numEnemyField.setColumns(3); // Set the width of the text field

		// Add document listener to update numEnemies when text changes
        numEnemyField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateNumEnemies();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //updateNumEnemies();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //updateNumEnemies();
            }

            private void updateNumEnemies() {
				numEnemies = Integer.parseInt(numEnemyField.getText());
            }
        });

        // Add label and text field to the panel
        this.add(numEnemyLabel);
        this.add(numEnemyField);
		
		JButton upButton = new JButton("Up");
		JButton downButton = new JButton("Down");
		ButtonListener upListener = new ButtonListener("up");
		ButtonListener downListener = new ButtonListener("down");

		// NEW CHANGE start and quit buttons
		JButton startButton = new JButton("Start");
		startButton.setBackground(Color.green);
		startButton.setOpaque(true);
		startButton.setBorderPainted(false);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBackground(Color.red);
		quitButton.setOpaque(true);
		quitButton.setBorderPainted(false);

		ButtonListener startListener = new ButtonListener("start", startButton);
		ButtonListener quitListener = new ButtonListener("quit");
		
		startButton.addKeyListener(new ArrowKeyListener());
		// NEW CHANGE

		buttonForRed.addKeyListener(new ArrowKeyListener());
		buttonForGreen.addKeyListener(new ArrowKeyListener());
		upButton.addKeyListener(new ArrowKeyListener());
		downButton.addKeyListener(new ArrowKeyListener());

		//add listeners to their buttons
		buttonForRed.addMouseListener(redListener);
		buttonForGreen.addMouseListener(greenListener);
		upButton.addActionListener(upListener);
		downButton.addActionListener(downListener);
		startButton.addActionListener(startListener);
		quitButton.addActionListener(quitListener);

		//create button group and add buttons to it
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(buttonForRed);
		buttonGroup.add(buttonForGreen);
		buttonGroup.add(downButton);
		buttonGroup.add(upButton);
		buttonGroup.add(startButton);
		buttonGroup.add(quitButton);
		Dimension panelSize = new Dimension(100, 70); // CHANGE greater size to see buttons
		this.setPreferredSize(panelSize);
		
		JComboBox<String> cb = new JComboBox<String>(choices);
	    cb.setVisible(true);

	    //this adds the logic for the combo box which determines homw many enemies there will be during the game
	    cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
        		if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Get the selected item
                    String selectedItem = (String) cb.getSelectedItem();
                    if(selectedItem.equals("EASY")) {
                    	numEnemies = 4;
                    }else if(selectedItem.equals("MEDIUM")) {
                    	numEnemies = 10;
                    }else if(selectedItem.equals("IMPOSSIBLE")){
                    	numEnemies = 50;
                    }
					numEnemyField.setValue(numEnemies); // Uncomment to update automatically
                }
            }
	    });

		//add label and buttons to ControlPanel
		this.add(label);
		this.add(buttonForRed);
		this.add(buttonForGreen);
		this.add(cb);
		this.add(downButton);
		this.add(upButton);
		this.add(startButton);
		this.add(quitButton);
		
	}
}

