import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel gameScreen;
  JPanel titleScreen;
  JPanel mainPanel;
  
  JLabel roleLabel;
  JLabel titleLabel;

  JTextArea storyText;

  JButton choiceButtons[];
  JButton startButton;

  CardLayout screens;

  String marker;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Valor City 2077");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    gameScreen = new JPanel();
    // change background color of gameScreen 
    gameScreen.setBackground(Color.BLACK);
    // turn on manual layouts 
    gameScreen.setLayout(null); 
    


    // initialize the label 
    roleLabel = new JLabel("A Street Thug's Story");
    
    // set the size and location of the label 
    roleLabel.setBounds(300, 10, 200, 20);

    // add the label to the main panel 
    gameScreen.add(roleLabel);


    // initialize the JTextArea 
    storyText = new JTextArea("");

    // set the size and location of the JTextArea 
    storyText.setBounds(30, 60, 740, 240);

    // disable the text area so the user can't type inside it 
    storyText.setEnabled(false);

    // change the text color in storyText
    Font font = new Font ("Times New Roman", Font.PLAIN, 22);
    storyText.setForeground(Color.red);
    storyText.setFont(font);
    

    // put text inside the text area 
    storyText.setText("");

    // change the storyText background 
    storyText.setBackground(Color.BLACK);

    // add the text area to the gameScreen 
    gameScreen.add(storyText);

    
    // create an array for the choice buttons 
    choiceButtons = new JButton[5];

    // use a for loop to go through and create each button and set the getActionCommand
    for(int i = 1; i < choiceButtons.length; i++){
      // initialize the buttons 
      JButton button = new JButton ("" + i);
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

    // set setActionCommand to the buttons 
    choiceButtons[1].setActionCommand("choice1");
    choiceButtons[2].setActionCommand("choice2");
    choiceButtons[3].setActionCommand("choice3");
    choiceButtons[4].setActionCommand("choice4");

    // change font size of the buttons 
    choiceButtons[1].setFont (choiceButtons[1].getFont ().deriveFont(20.0f));
    choiceButtons[2].setFont (choiceButtons[2].getFont ().deriveFont(20.0f));
    choiceButtons[3].setFont (choiceButtons[3].getFont ().deriveFont(20.0f));
    choiceButtons[4].setFont (choiceButtons[4].getFont ().deriveFont(20.0f));

    // make the JButton not visible 
    choiceButtons[1].setVisible(true);
    choiceButtons[2].setVisible(false);
    choiceButtons[3].setVisible(false);
    choiceButtons[4].setVisible(false);

    // add the choiceButtons to the gameScreen 
    gameScreen.add(choiceButtons[1]);
    gameScreen.add(choiceButtons[2]);
    gameScreen.add(choiceButtons[3]);
    gameScreen.add(choiceButtons[4]);
    
    // set up the title screen
    titleScreen = new JPanel();
    titleScreen.setLayout(null);
    // change background color of titleScreen 
    titleScreen.setBackground(Color.BLACK);

    // create title for the game 
    titleLabel = new JLabel("VALOR CITY 2077", SwingConstants.CENTER);
    Font font2 = new Font ("Times New Roman", Font.BOLD, 50);
    titleLabel.setForeground(Color.red);
    titleLabel.setFont(font2);
    // set setBounds
    titleLabel.setBounds(100, 30, 600, 300);
    titleScreen.add(titleLabel);

    // create the button to start game 
    startButton = new JButton("BEGIN");
    startButton.setBounds(300, 350, 200, 100);
    startButton.setFont (startButton.getFont ().deriveFont(25.0f));
    startButton.addActionListener(this);
    startButton.setActionCommand("begin");

    titleScreen.add(startButton);

    // create the screen jpanel manager 
    screens = new CardLayout();

    mainPanel = new JPanel();
    mainPanel.setLayout(screens);

    // add screens to the card layout 
    mainPanel.add(titleScreen, "titleScreen");
    mainPanel.add(gameScreen, "gameScreen");

    frame.add(mainPanel);
    
    // sets the screen to show by asking the card layout 
    screens.show(mainPanel, "titlescreen");
    

  }
    // create methods for different choices 
    public void streetThug(){
      // declare what the marker will be so it can be called in a switch
      marker = "street thug";
      // set what the storyText will say
      storyText.setText("The year 2077 is a time where crime runs rampant through\nValor City, hence the name, you will need to be courageous in\nthe face of danger in this crime filled metropolis. Street thugs\nhave small dreams of becoming a legend in Valor City, taking\nthe ugly way or not. You are a Street Thug, they call you Ripper.\nYou want to become a legend, what faster way then to\ngain immortality and become a force to be reckoned with!");

      // set what the buttons will display
      choiceButtons[1].setText("Continue");
      
      // set which buttons are visible and which ones are not 
      choiceButtons[1].setVisible(true);
      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
      choiceButtons[4].setVisible(false);

      
    }

    public void continueGame(){
      marker = "continue";
      
      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(true);
      choiceButtons[4].setVisible(true);
      
      storyText.setText("The phone is ringing\nYou pick it up, and to your surprise, no caller ID\nHesitant, you answer\n\"You're Ripper, right?\" Says the man on the other side\n");

      choiceButtons[1].setText("1");
      choiceButtons[2].setText("2");
      choiceButtons[3].setText("3");
      choiceButtons[4].setText("4");
    }

    public void test(){
      marker = "test";
      
      storyText.setText("hello");
      choiceButtons[1].setText("hey");

    }

    public void test2(){
      marker = "test2";
      
      storyText.setText(" this is a test");

      choiceButtons[1].setText("test2");
      choiceButtons[2].setText("test3");
      choiceButtons[3].setText("test27");
      choiceButtons[4].setText("test5");
    }
    
    

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if (command.equals("begin")){
      // switch the screen to gameScreen
      screens.show(mainPanel, "gameScreen");
      streetThug();
    }
    
    
    switch (marker){
    case "street thug":
        switch(command){
        case "choice1": continueGame(); break;
        }
        break;
    case "continue":
        switch (command){
        case "choice1": test(); break;
        case "choice2": test(); break;
        case "choice3": test(); break;
        case "choice4": test(); break;
        }
        break;
    case "test":
        switch (command){
          case "choice1": test2(); break;  
        }
        break;
   }
  }
  


  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

