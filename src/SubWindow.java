import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Class SubWindow: 
 * 
 * This class represents the sub window of program 2
 * 
 * @author Daniel Jordan
 * @version 1.0
 * @date 3/20/17
 */
public class SubWindow{

	/*
	 * Instance Data Section
	 */
	private MoveableShape shape;
	private ShapeIcon icon;

	//Components for Sub Window
	private JFrame subFrame;
	private JPanel subIconPanel;
	private JPanel subButtonPanel;
	private JLabel subLabel;
	private JLabel label;
	private JButton hideButton, subExitButton;

	//Constants for the size of the sub window
	private final int WIDTH;
	private final int HEIGTH;

	//Constants for the size of the ShapeIcon
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 400;
	private static final int SHAPE_WIDTH = 100;

	//Status variables for the sub window
	private int status;
	private boolean visibility;

	//Timer for Sub Window
	private Timer t;

	/**
	 * Constructor for class SubWindow
	 */
	public SubWindow(){

		//Instantiating ShapeIcon
		icon = new ShapeIcon(1000, 1000);

		//Instantiating the JFrame
		subFrame = new JFrame("Sub Window of Program 2");

		//Instantiating the JPanels
		subIconPanel = new JPanel();
		subButtonPanel = new JPanel();

		//Instantiating the JLabel
		subLabel = new JLabel();
		label = new JLabel(icon);

		//Instantiating the JButtons
		hideButton = new JButton("HIDE");
		subExitButton = new JButton("EXIT THIS WINDOW");

		//Instantiating the constants 
		WIDTH = 1000;
		HEIGTH = 1000;

		//Instantiating the status's 
		status = 0;
		visibility = false;

		//Instantiating the moveable label
		subIconPanel.add(label);
		subIconPanel.setPreferredSize(new Dimension(400,400));

		//Setting up the components for subFrame
		subFrame.setSize(WIDTH, HEIGTH);
		subFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		subFrame.setLocationRelativeTo(null);

		//Setting up the layout for subFrame
		subFrame.setLayout(new BorderLayout());
		subIconPanel.setBackground(Color.BLUE);
		subButtonPanel.setBackground(Color.GREEN);
		subFrame.add(subIconPanel, BorderLayout.CENTER);
		subFrame.add(subButtonPanel, BorderLayout.SOUTH);

		//Setting up the components for subIconPanel
		subIconPanel.add(subLabel);

		//Setting up the components for subButtonPanel
		subButtonPanel.add(hideButton);
		subButtonPanel.add(subExitButton);

		subFrame.setVisible(false);

		//Instantiating the Timer
		t = new Timer(10, new TimerListener());

	}

	/**
	 * Method startTimer, simply starts the timer.
	 */
	public void startTimer(){

		t.start();
	}

	/**
	 * Method removeShape, removes the shape from the arraylist
	 */
	public void removeShape(){
		icon.removeFromArrayList();
	}

	/**
	 * Method makeBird, constructs an object of a BirdShape
	 */
	public void makeBird(){

		Random rand = new Random();
		int x = rand.nextInt(800) + 1;
		int y = rand.nextInt(800) + 1;

		shape = new BirdShape(x, y, SHAPE_WIDTH);

		icon.addToArrayList(shape);

		label.repaint();
	}

	/**
	 * Method makeCloud, constructs an object of a CloudShape
	 */
	public void makeCloud(){

		Random rand = new Random();
		int x = rand.nextInt(500) + 1;
		int y = rand.nextInt(500) + 1;

		shape = new CloudShape(x, y, SHAPE_WIDTH);

		icon.addToArrayList(shape);	

		label.repaint();
	}

	/**
	 * Method makeUFO, constructs and object of a UFOShape
	 */
	public void makeUFO(){

		Random rand = new Random();
		int x = rand.nextInt(200) + 1;
		int y = rand.nextInt(200) + 1;

		shape = new UFOShape(x, y, SHAPE_WIDTH);

		icon.addToArrayList(shape);

		label.repaint();
	}

	/**
	 * Method setButtonActions, sets the actionListeners for all the buttons
	 * that will be added to the subFrame
	 */
	public void setButtonActions(){

		//Setting up the ActionListener for hideButton 
		hideButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				subFrame.setVisible(false);
				setVisibilityFalse();
			}
		});

		//Setting up the ActionListener for subExitButton
		subExitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				incrementStatus();//Increment the count when the subWindow is closed
				
				icon.removeAllFromArrayList();
				subFrame.dispose();
			}
		});
	}

	/**
	 * Method setFrameVisibilityTrue, sets the visibility for the Sub Window to true
	 */
	public void setFrameVisibilityTrue(){

		this.subFrame.setVisible(true);
	}

	/**
	 * Method setFrameVisibilityFalse, sets the visibility for the Sub Window to false
	 */
	public void setFrameVisibilityFalse(){

		this.subFrame.setVisible(false);
	}

	/**
	 * Method getVisibility, returns the visibility of Sub Window
	 */
	public boolean getVisibility(){

		return this.visibility;
	}

	/**
	 * Method setVisibilityTrue, sets visibility to true
	 */
	public void setVisibilityTrue(){
		this.visibility = true;
	}

	/**
	 * Method setVisibilityFalse, sets visibility to false
	 */
	public void setVisibilityFalse(){
		this.visibility = false;
	}

	/**
	 * Method getStatus, returns the value of status 
	 */
	public int getStatus(){

		return this.status;
	}

	/**
	 * Method incrementStatus, increments the status count
	 */
	public void incrementStatus(){

		this.status++;
	}

	/**
	 * Method getWindowState, returns true or false depending on the state of the window 
	 */
	public boolean getWindowState(){

		boolean makeWindow = false;

		//If this is true, make the sub window
		if(getStatus() % 2 == 0){

			makeWindow = true;
		}
		incrementStatus();
		return makeWindow;
	}

	/**
	 * Private helper class for the timer
	 * @author Daniel Jordan
	 *
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			icon.translate(1, 1);
			label.repaint();
		}
	}
}