import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JLabel roleLabel;

  JTextArea storyText;

  JButton choiceButtons[];
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // change background color of mainPanel 
    mainPanel.setBackground(Color.BLACK);
    // turn on manual layouts 
    mainPanel.setLayout(null);
    // add the main panel to the JFrame 
    frame.add(mainPanel);


    // initialize the label 
    roleLabel = new JLabel("");
    
    // set the size and location of the label 
    roleLabel.setBounds(300, 10, 200, 20);

    // add the label to the main panel 
    mainPanel.add(roleLabel);


    // initialize the JTextArea 
    storyText = new JTextArea("");

    // set the size and location of the JTextArea 
    storyText.setBounds(30, 60, 740, 240);

    // disable the text area so the user can't type inside it 
    storyText.setEnabled(false);

    // change the text color in storyText
    Font font = new Font ("Times New Roman", Font.BOLD, 24);
    storyText.setFont(font);
    storyText.setForeground(Color.red);

    // put text inside the text area 
    storyText.setText("It is a time of perile in the kingdom of ");

    // change font size 
    storyText.setFont (storyText.getFont ().deriveFont(24.0f));

    // change the storyText background 
    storyText.setBackground(Color.BLACK);

    // add the text area to the mainPanel 
    mainPanel.add(storyText);

    
    // create an array for the choice buttons 
    choiceButtons = new JButton[5];

    // use a for loop to go through and create each button and set the getActionCommand
    for(int i = 1; i < choiceButtons.length; i++){
      // initialize the buttons 
      JButton button = new JButton ("" + i);
      // set the action command 
      button.setActionCommand("" + i);
      // put the button in the array 
      choiceButtons[i] = button;
    }

    // set the size and location of the buttons 
    choiceButtons[1].setBounds(30, 320, 360, 100);
    choiceButtons[2].setBounds(410, 320, 360, 100);
    choiceButtons[3].setBounds(30, 440, 360, 100);
    choiceButtons[4].setBounds(410, 440, 360, 100);

    // add action listener to the buttons 
    choiceButtons[1].addActionListener(this);
    choiceButtons[2].addActionListener(this);
    choiceButtons[3].addActionListener(this);
    choiceButtons[4].addActionListener(this);

    // insert set text for each button 
    choiceButtons[1].setText("Warrior");
    choiceButtons[2].setText("Wizard");
    choiceButtons[3].setText("Spy");

    // change font size of the buttons 
    choiceButtons[1].setFont (choiceButtons[1].getFont ().deriveFont(20.0f));
    choiceButtons[2].setFont (choiceButtons[2].getFont ().deriveFont(20.0f));
    choiceButtons[3].setFont (choiceButtons[3].getFont ().deriveFont(20.0f));
    choiceButtons[4].setFont (choiceButtons[4].getFont ().deriveFont(20.0f));

    // make the JButton not visible 
    choiceButtons[4].setVisible(false);

    // add the choiceButtons to the mainPanel 
    mainPanel.add(choiceButtons[1]);
    mainPanel.add(choiceButtons[2]);
    mainPanel.add(choiceButtons[3]);
    mainPanel.add(choiceButtons[4]);

    }

  

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
