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

    roleLabel.setForeground(Color.red);

    // add the label to the main panel 
    gameScreen.add(roleLabel);


    // initialize the JTextArea 
    storyText = new JTextArea("");

    // set the size and location of the JTextArea 
    storyText.setBounds(30, 60, 740, 240);

    // wrap text in storyText
    storyText.setLineWrap(true);

    // disable the text area so the user can't type inside it 
    storyText.setEnabled(false);

    // change the text color in storyText
    Font font = new Font ("Times New Roman", Font.PLAIN, 20);
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
      choiceButtons[3].setVisible(false);
      choiceButtons[4].setVisible(false);
      
      storyText.setText("The phone is ringing\nYou pick it up, and to your surprise, no caller ID\nHesitant, you answer\n\"You're Ripper, right?\" Says the man on the other side\n\"Yes... who is this calling\" You say with a hint of concern\n\"That's not important, just come to Little Tokyo if you're about it,\nand come alone\"\n\"Wait you don't mean -\" The mysterious man ended the call before you\ncould finish ");

      choiceButtons[1].setText("<html><center>"+"Go meet him in"+"<br>"+"Little Tokyo alone"+"</center></html>Go meet him in Little Tokyo alone");
      choiceButtons[2].setText("<html><center>"+"Go meet him in"+"<br>"+"Little Tokyo with a group"+"</center></html>");
    }

    public void meetAlone(){
      marker = "meetAlone";
      
      storyText.setText("You go to Little Tokyo by yourself. When you get there you cannot believe your eyes. The man standing infront of you is the famous Flash Fang.\nKnown for being incredibly fast and as ferocious as a wolf. He's basically what every one of us lowly thugs want to become.\n\"Flash Fang, i- what an honour to be in your presen-\"\n\"Cut the small talk Ripper, I'm building a team to perform the greatest\nheist Valor City has ever seen. We're gonna steal the chip of immortality and I will then become the king that city has always needed!\" ");
      
      choiceButtons[1].setText("Say no more, I'm in!");

      choiceButtons[2].setVisible(false);
    }

    public void meetGroup(){
      marker = "meetGroup";
      
      storyText.setText("\"You really don't know how to follow orders boy,\nI can't have an airhead like you on my team! Get lost before you regret\nit!\"");

      choiceButtons[1].setText("Resart");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
      choiceButtons[4].setVisible(false); 
    }

    public void testJoin(){
      marker = "test to join";

      storyText.setText(" \"Slow down kid, your skills look good on paper but I'm not just gonna\ngive you the spot without seeing you in action. You're gonna do\nsomething for me and then we'll see.\" Flash Fang proclaimed\n\"What needs to be done to join?\" You ask\n\"You see, in a little shootout last week, I lost my 3 katanas to the VCPD\n(Valor City Police Department) and I need you to retrieve them. That\nsound like something you can do?\"");

      choiceButtons[1].setText("I'll be back in no time");
      choiceButtons[2].setText("I have a better idea");

      choiceButtons[2].setVisible(true);
    }
    
    public void stealPolice(){
      marker = "steal from police";

      storyText.setText(" You say your goodbyes to Flash Fang and the rest of his crew as you\ndepart for the VCPD's main headquarters. Flash provided you with a\nmapped out layout of the HQ, all you have to do is follow this map to\nwhere the storage area is and find Flash Fang's 3 katanas.\nThe plan is simple, the easiest way to get inside unnoticed is if you act\nlike one of them. In order for that to work you will need a VCPD outfit.\nYou stake out outside of the building until someone comes out.\nFinally after half an hour of waiting it looks like an officer has left the\nbuilding.");

      choiceButtons[1].setText("Follow the officer");
      choiceButtons[2].setVisible(false);

    }

    public void streetRace(){
      marker = "street race";

      storyText.setText(" \"You have a better a idea, let's hear it then!\"Demands Flash\n\"Hear me out, there's a street race happening not too far from here on\nHollow Street, some of the biggest betters are rumoured to join in on the fun. Whaddya say I enter, win the damn thing and you'll have more than enough money to buy yourself the best looking katanas on the market?\" You say confidentally\n\"Well if you're so confident, go for it, but if you don't win. Boy you won't wanna know the consequences!\"Flash said with an evil look in his eyes.\nAnd with that you were off to Hollow Street.");

      choiceButtons[1].setText("Arrive at Hollow Street");
      choiceButtons[2].setVisible(false);
    }

    public void followOfficer(){
      marker = "follow officer";

      storyText.setText("You start to follow the officer. You then figure out the general path he\nwill be taking and move ahead of him to intercept him. The area that you have chosen is pratically a ghost town, no one in sight. You hide behind one of the buildings. The officer is starting to get closer. What do you do?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("<html><center>"+"Charge at the officer to"+"<br>"+"try to get the jump on him"+"</center></html>");
      choiceButtons[2].setText("<html><center>"+"Wait patiently for him"+"<br>"+"to turn the corner"+"</center></html>");
      
    }
    
    public void chargeAttack(){
      marker = "charge attack";

      storyText.setText("You charge at the officer, trying to get an early knockout on him,but his reflexes are too quick. Before you can even get remotely close to him he pulls a gun on you.\n\"What the hell do you think you're doing?\" The officer asks.\nThink fast, do you throw a smokescreen or do you pelt him in the head with a rock?");

      choiceButtons[1].setText("Smokescreen");
      choiceButtons[2].setText("Throw rock");
    }

    public void throwRock(){
      marker = "throw rock";

      storyText.setText(" You have a pretty big looking rock in your right hand behind your back.\nYou quickly hurl it at the officer. His reflexes kick in once again and he manages to safely dodge it.\nWithout a second thought he pulls the trigger");

      choiceButtons[1].setText("Game Over!");
      choiceButtons[2].setVisible(false);
    }

    public void gameOver(){
      marker = "game over";

      storyText.setText("Tough luck, guess it just wasn't your day!\nHere, try again");

      choiceButtons[1].setText("Restart");
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
        case "choice1": meetAlone(); break;
        case "choice2": meetGroup(); break;
        }
        break;
    case "meetAlone":
        switch (command){
          case "choice1": testJoin(); break;  
        }
        break;
    case "meetGroup":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "test to join":
        switch (command){
          case "choice1": stealPolice(); break;
          case "choice2": streetRace(); break;
        }
        break;
    case "steal from police": 
        switch (command){
          case "choice1": followOfficer(); break;
        }
        break;
    case "street race":
        switch (command){
          case "choice1": break;
        }
        break;
    case "follow officer":
        switch(command){
          case "choice1": chargeAttack(); break;
          case "choice2":  break;
        }
        break;
    case "charge attack":
        switch (command){
          case "choice1": break;
          case "choice2": throwRock(); break;
        }
        break;
    case "throw rock":
        switch (command){
          case "choice1": gameOver();
        }
        break;
    case "game over":
        switch (command){
          case "choice1": streetThug();
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

