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
  JButton streetThugPath;
  JButton corpoAgentPath;
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
    roleLabel = new JLabel("");
    
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
    storyText.setText("The year 2077 is a time where crime runs rampant through\nValor City, hence the name, you will need to be courageous in\nthe face of danger in this crime filled metropolis. Street thugs\nhave small dreams of becoming a legend in Valor City, taking\nthe ugly way or not. Coporate Agents are above the regular\ncitizens, but they're working for a brainwashed company that\ndoesn't care about others.\n                                      Who will you be?");

    // change the storyText background 
    storyText.setBackground(Color.BLACK);

    // add the text area to the gameScreen 
    gameScreen.add(storyText);

    
    // create an array for the choice buttons 
    choiceButtons = new JButton[4];

    // use a for loop to go through and create each button and set the getActionCommand
    for(int i = 0; i < choiceButtons.length; i++){
      // initialize the buttons 
      JButton button = new JButton ("" + i);
      // put the button in the array 
      choiceButtons[i] = button;
    }

    // set the size and location of the buttons 
    choiceButtons[0].setBounds(30, 320, 360, 100);
    choiceButtons[1].setBounds(410, 320, 360, 100);
    choiceButtons[2].setBounds(30, 440, 360, 100);
    choiceButtons[3].setBounds(410, 440, 360, 100);

    // add action listener to the buttons 
    choiceButtons[0].addActionListener(this);
    choiceButtons[1].addActionListener(this);
    choiceButtons[2].addActionListener(this);
    choiceButtons[3].addActionListener(this);

    // set setActionCommand to the buttons 
    choiceButtons[0].setActionCommand("choice1");
    choiceButtons[1].setActionCommand("choice2");
    choiceButtons[2].setActionCommand("choice3");
    choiceButtons[3].setActionCommand("choice4");

    // change font size of the buttons 
    choiceButtons[0].setFont (choiceButtons[0].getFont ().deriveFont(20.0f));
    choiceButtons[1].setFont (choiceButtons[1].getFont ().deriveFont(20.0f));
    choiceButtons[2].setFont (choiceButtons[2].getFont ().deriveFont(20.0f));
    choiceButtons[3].setFont (choiceButtons[3].getFont ().deriveFont(20.0f));

    // make the JButton not visible 
    choiceButtons[0].setVisible(false);
    choiceButtons[1].setVisible(false);
    choiceButtons[2].setVisible(false);
    choiceButtons[3].setVisible(false);

    // add the choiceButtons to the gameScreen 
    gameScreen.add(choiceButtons[0]);
    gameScreen.add(choiceButtons[1]);
    gameScreen.add(choiceButtons[2]);
    gameScreen.add(choiceButtons[3]);

    // make the role path buttons 
    streetThugPath = new JButton("Street Thug");
    corpoAgentPath = new JButton("Corporate Agent");

    streetThugPath.setBounds(30, 320, 360, 100);
    corpoAgentPath.setBounds(410, 320, 360, 100);

    streetThugPath.setFont (streetThugPath.getFont ().deriveFont(20.0f));
    corpoAgentPath.setFont (corpoAgentPath.getFont ().deriveFont(20.0f));

    streetThugPath.addActionListener(this);
    corpoAgentPath.addActionListener(this);

    streetThugPath.setActionCommand("street");
    corpoAgentPath.setActionCommand("corpo");

    gameScreen.add(streetThugPath);
    gameScreen.add(corpoAgentPath);

    
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
      streetThugPath.setVisible(false);
      corpoAgentPath.setVisible(false);
      marker = "street thug";
      storyText.setText("You are a Street Thug, they call you Ripper.\nWho are they, you might ask? The other thugs you see roaming\nthe streets. You want to become a legend, what faster way then to\ngain immortality and become a force to be reckoned with!");
      choiceButtons[0].setVisible(true);
      choiceButtons[1].setVisible(false);
      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[0].setText("Continue");
    }

    public void continueGame(){
      marker = "continue";
      storyText.setText("test");
      choiceButtons[0].setText("1");
      choiceButtons[1].setText("2");
      choiceButtons[2].setText("3");
      choiceButtons[3].setText("4");
    }

    public void test(){
      marker = "test";
      storyText.setText("hello");
      choiceButtons[1].setText("hey");
    }
    
    

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if (command.equals("begin")){
      // switch the screen to gameScreen
      screens.show(mainPanel, "gameScreen");
    }

    if (command.equals("street")){
    streetThug(); 
    switch (marker){
    case "street thug":
        switch(command){
        case "choice1": 
        continueGame(); 
        break;
        case "choice2":  
        break;
        case "choice3":  
        break;
        case "choice4": 
        break;
      }
      case "continue":
          switch(command){
          case "choice1": 
          test(); 
          break;
        }
        break;
    }
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

