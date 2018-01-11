import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Class MainWindow: 
 * 
 * This class represents the main window of program 2
 * 
 * @author Daniel Jordan
 * @version 1.0
 * @date 3/20/17
 */
public class MainWindow {

	/*
	 * Instance Data Section
	 */
	private SubWindow subWindow;

	//Components for the window
	private JFrame mainFrame;
	private JPanel mainPanel;
	private JButton showButton, addButton, removeButton, exitButton;
	private Checkbox birdCheckbox, cloudCheckbox, ufoCheckbox;

	//Constants for the size of the main window
	private final int WIDTH;
	private final int HEIGHT;

	/**
	 * Constructor for class MainWindow
	 */
	public MainWindow(){

		//Instantiating the JFrame
		mainFrame = new JFrame("Main Window of Program 2");

		//Instantiating the JPanel
		mainPanel = new JPanel();

		//Instantiating the JButtons
		showButton = new JButton("SHOW");
		addButton = new JButton("ADD");
		removeButton = new JButton("REMOVE");
		exitButton = new JButton("EXIT PROGRAM");

		//Instantiating the Checkboxes
		birdCheckbox = new Checkbox("Bird");
		cloudCheckbox = new Checkbox("Cloud");
		ufoCheckbox = new Checkbox("UFO");

		//Instantiating the constants
		WIDTH = 550;
		HEIGHT = 100;

		//Instantiating the sub window and setting the button actions
		subWindow = new SubWindow();
		subWindow.setButtonActions();
		subWindow.setVisibilityFalse();
	}

	/**
	 * Method start, calls prepareGUI() and setButtonActions() 
	 * which creates the components for the main window.
	 */
	public void start(){

		prepareGUI();
		setButtonActions();
	}

	/**
	 * Method prepareGUI, adds all the components to mainFrame
	 */
	public void prepareGUI(){

		//Setting up components for mainJFrame
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(mainPanel);

		//Setting up components for mainPanel
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(showButton);
		mainPanel.add(addButton);
		mainPanel.add(removeButton);
		mainPanel.add(exitButton);
		mainPanel.add(birdCheckbox);
		mainPanel.add(cloudCheckbox);
		mainPanel.add(ufoCheckbox);

		mainFrame.setVisible(true);
	}

	/**Method setButtonActions, sets the actionsListeners for all the buttons 
	 * that will be added to mainFrame
	 */
	public void setButtonActions(){

		//Setting up the ActionListener for showButton
		showButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(subWindow.getStatus() == 0){

					subWindow.setFrameVisibilityTrue();
				}

				//Checking if is created but already hidden 
				if((subWindow.getStatus() > 0) && (!subWindow.getVisibility())){

					subWindow.setFrameVisibilityTrue();
				}
			}
		});

		//Setting up the ActionListener for addButton
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{

				//Checking for the first time for the subWindow to be made and if bird is checked
				if((birdCheckbox.getState())){

					subWindow.setFrameVisibilityTrue();
					subWindow.makeBird();
					subWindow.startTimer();
				}

				//Checking for the first time for the subWindow to be made and if cloud is checked
				if((cloudCheckbox.getState())){

					subWindow.setFrameVisibilityTrue();
					subWindow.makeCloud();
					subWindow.startTimer();
				}

				//Checking for the first time for the subWindow to be made and if ufo is checked
				if((ufoCheckbox.getState())){

					subWindow.setFrameVisibilityTrue();
					subWindow.makeUFO();
					subWindow.startTimer();
				}

			}
		});

		//Setting up the ActionListener for removeButton
		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{				
				subWindow.removeShape();
			}
		});

		//Setting up the ActionListener for exitButton
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//when clicked ALL windows should close and the program terminates
				System.exit(0);
			}
		});
	}

}
