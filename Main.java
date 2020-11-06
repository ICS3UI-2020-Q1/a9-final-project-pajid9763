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

      storyText.setText(" \"You have a better a idea, let's hear it then!\"Demands Flash\n\"Hear me out, there's a street race happening not too far from here on\nHollow Street, some of the biggest betters are rumoured to join in on the fun. Whaddya say I enter, win the damn thing and you'll have more than enough money to buy yourself the best looking katanas on the market?\" You say confidentally.\n\"Well if you're so confident, go for it, but if you don't win. Boy you won't wanna know the consequences!\"Flash said with an evil look in his eyes.\nAnd with that you were off to Hollow Street.");

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

      storyText.setText("You charge at the officer, trying to get an early knockout on him,but his\nreflexes are too quick. Before you can even get remotely close to him he pulls a gun on you.\n\"What the hell do you think you're doing?\" The officer asks.\nThink fast, do you throw a smokescreen or do you pelt him in the head\nwith a rock?");

      choiceButtons[1].setText("Smokescreen");
      choiceButtons[2].setText("Throw rock");
    }

    public void smokeScreen(){
      marker = "smokescreen";

      storyText.setText("You quickly throw a smoke screen on the ground.\nThe VCPD officer is starting to panic, he doesn't know where you are.\nThen, like a ninja in the shadows, you come up behind the officer and\nknock him out in one swift blow.");

      choiceButtons[1].setText("Change outfits");
      choiceButtons[2].setVisible(false);
    }

    public void throwRock(){
      marker = "throw rock";

      storyText.setText(" You have a pretty big looking rock in your right hand behind your back.\nYou quickly hurl it at the officer. His reflexes kick in once again and he\nmanages to safely dodge it.\nWithout a second thought he pulls the trigger.");

      choiceButtons[1].setText("Game Over!");
      choiceButtons[2].setVisible(false);
    }

    public void gameOver(){
      marker = "game over";

      storyText.setText("Tough luck, guess it just wasn't your day!\nHere, try again.");

      choiceButtons[1].setText("Restart");
    }

    public void waitPatiently(){
      marker = "wait";

      storyText.setText("You wait patiently for the officer to get closer then you peek around the\ncorner and give him a sucker punch right in the nose. He's knocked out\non the ground.");

      choiceButtons[1].setText("Change outfits");
      choiceButtons[2].setVisible(false);
    }

    public void changeOutfit(){
      marker = "change outfit";

      storyText.setText("Wasting no time, you change outfits with the officer and now your\ndisguise is perfect. You should have no trouble entering the HQ of the\nVCPD. You enter the inside the HQ and you think of 2 possible options of how you could go about this. 1. You could ask someone for the key to the storage unit and act like you're going to get something. 2. You could try\nto sneak your way into the storage that way you don't have to talk to\nanyone. Which option will you take?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Option 1");
      choiceButtons[2].setText("Option 2");
    }

    public void optionOne(){
      marker = "option 1";

      storyText.setText("You look at the name tag of the person at the desk\n\"Hey Mark, can I get the keys to the storage room I think I forgot\nsomething in there.\"You say hoping he wouldn't get too suspicious.\n\"Yeah here, catch!\"Mark says while throwing you the keys.\n\"Thanks man I'll be right back!\"You exclaim as you quickly leave for the\nstorage room.\nYou get to the storage room, unlock the door and find Flash's 3 katanas.\nNow for your escape, do you break the window and climb through, if you do so, the VCPD will remember your face and you will be branded a\ncriminal. Or do you try walking through the front door with the 3 katanas?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Climb through window");
      choiceButtons[2].setText("Go through the front");
    }

    public void optionTwo(){
      marker = "option 2";

      storyText.setText("Without looking at anyone, you go to the storage room and start to pick the lock, after a few seconds the door opens. You find the 3 katanas and make your way to the window.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Climb through window");
    }

    public void goFront(){
      marker = "go through front";

      storyText.setText("You try going through the front, you toss the keys back to Mark and make your way for the door.\nYou're about to make it to the door when you here an officer shout\n\"GET HIM, HE'S GOT FLASH'S KATANAS!!\"\nWithout any chance to get out, you are quickly brought to the ground.\nThis journey's over.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Game Over!");
    }

    public void seriously(){
      marker = "seriously";

      storyText.setText("You really thought going through the front would work?\nCmon just restart the damn thing.");

      choiceButtons[1].setText("Resart");
    }

    public void climbWindow(){
      marker = "climb window";

      storyText.setText("You proceed to use the hilts of the sword to break the window.\nAs you are climbing through the window, another officer enters the room because of the loud noise of the window breaking.\n\"Hey! Get back here!\"The officer shouts.\nBut it was too late as you have already left through the window. You go\nback to Little Tokyo where Flash and his crew are waiting.\n\"Nice job Ripper! Welcome to the team, now let's get this heist under\nway!\"");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Start Heist");
    }

    public void hollowStreet(){
      marker = "hollow";

      storyText.setText("You reach Hollow Street right as the other racers are arriving. You also\nsee some big names on the scene. Everybody begins to place their bets. And without further ado, the race begins! You start somewhere in the\nmiddle of the pack out of 16 racers. First big corner is coming up, do you\ndangerously take the inside, play it carefully and take the outside, or do\nyou play it slow and stay back and let the other drivers in front?");

      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(true);

      choiceButtons[1].setText("Take the inside");
      choiceButtons[2].setText("Take the outside");
      choiceButtons[3].setText("Stay back");
    }

    public void takeInside(){
      marker = "take inside";

      storyText.setText("You decide to be risky and take the inside. Before you know it another car rams into your left side, your car flips over and is near completely\nunusable. You have lost the race and your hopes for joining\nFlash's team.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void takeOutside(){
      marker = "take outside";

      storyText.setText("You play it carefully and take the outside. Smart move, you manage to\navoid the chaos and you continue the race. Fourteen racers remain,\n2 racers crashed and you are in 6th place.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Continue the race");
    }

    public void stayBack(){
      marker = "stay back";

      storyText.setText("You decide to stay back just a little bit and let the other racers infront.\nClever choice, if you had tried to get infront you would have ended up\nlike one of the 2 racers that just crashed. Fourteen racers remain and\nyou are in 6th place.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Continue the race");
    }

    public void continueRace(){
      marker = "continue race";

      storyText.setText("The next bit of the race is going fine, you move up to 5th place. The\nending is near and you need to make a big play. You see a ramp in the\ndistance, if you use the ramp you could skip a whole corner and gain a big\nadvantage. Are you willing to take that risk?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Don't take the ramp");
      choiceButtons[2].setText("Take the ramp"); 
    }

    public void noRamp(){
      marker = "no ramp";

      storyText.setText("You decided not to take the ramp and just take the corner like everybody else. Well, before you knew it the race was coming to an end and you\nwere only in 4th place.\nBetter luck next time!");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void takeRamp(){
      marker = "take ramp";

      storyText.setText("You decide to take the ramp and you were successful!\nYou manage to overtake 3 racers and now you're in 2nd place! The final\nstretch of the race is coming up, it's just you and one other racer. You\nare starting to catch up to him when..\n\"What the hell, is that a grenade!?\" You say worriedly.\nBefore you can even finish your train of thought, the racer in front throws the grenade back at you. Think fast, what do you do?");

      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(true);

      choiceButtons[1].setText("Throw it back at the driver");
      choiceButtons[2].setText("Drive by it");
      choiceButtons[3].setText("Throw it up");
      
    }

    public void throwBack(){
      marker = "throw it back";

      storyText.setText("You manage to catch the grenade mid air. Before it explodes you throw it back to the driver that threw it at you. You thought you've won it but as you're about to overtake him, the grenade goes off. Both your car and the racer's car in first place are caught in the explosion. This is the end of\nthe road for you.");

      choiceButtons[1].setText("Restart");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
    }
    public void driveBy(){
      marker = "drive by it";

      storyText.setText("You try to drive by the grenade to avoid it but that doesn't really work out and you get caught in the explosion.");

      choiceButtons[1].setText("Restart");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
    }
    public void throwUp(){
      marker = "throw it up";

      storyText.setText("You catch the grenade mid air and you immediately throw it up. Perfect\ncalculation as the grenade blows up while it's still in the air. You\nweren't affected at all. The dirty racer in front that tried eliminating you\nlost his way and ended up crashing into a wall. You breeze by him to get to the finish line. First place and the $300,000 is yours. You collect your\nearnings and head back to Little Tokyo. You present Flash Fang with the money, he congratulates you as he goes to buy the latest and\ngreatest katanas. When he comes back he says\n\"Nice job Ripper! Welcome to the team, now let's get this heist under\nway!\" ");

      choiceButtons[1].setText("Start Heist");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
    }

    public void startHeist(){
      marker = "start heist";

      storyText.setText(" \"This is the day that we break into MecaTech and steal the chip of\nimmortality. This is the plan. I have a guy working from the inside, he'll\ncut the cameras as we enter through a vent on the west side of the\nbuilding. We'll split into 2 teams, we and Ripper will go and wait outside\nof the door where the chip is being held and take care of the guards. You two (pointing at the other crewmates) Johnny, you're the hackerman,\nopen the doors guarding the chip, and Zoro you protect him from any\nharm that comes his way. Let's do this!\"");

      choiceButtons[1].setText("Roll out");
    }

    public void rollOut(){
      marker = "roll out";

      storyText.setText("The crew arrives at the MecaTech building. You start to make your way to the west side of the building avoiding guards as you go. Flash pulls out\nhis phone and sends a message to the guy he has working for him on the inside. The cameras cut and we started going in through the vents.\nJohnny and Zoro went for the control room to open the door and you and\nFlash go to the room guarding the chip. As you are about to enter the\nroom, you spot two guards. How do you go about this?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Jump down and fight");
      choiceButtons[2].setText("Take them out from above");
    }

    public void jumpDown(){
      marker = " jump down";

      storyText.setText("As soon as you and Flash jump down, the guards spot you and immediately call emergency. You and Flash quickly take them out. Now, what will you do about this emergency call?");

      choiceButtons[1].setText("Stand and wait");
      choiceButtons[2].setText("Say it was a false alarm");
    }

    public void standWait(){
      marker = "stand and wait";

      storyText.setText("You and Flash decide to do nothing about this emergency call. Not such a good idea as a few minutes later, the room is swarmed with MecaTech soldiers. That's the end of the story for you.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void falseAlarm(){
      marker = "false alarm";

      storyText.setText("You grab the walkie talkie from the guard that you just knocked out.\n\"Sorry boss, that was a false alarm, can you order all soldiers to stand down. I repeat this was a false alarm\"\n\"Cmon man, don't go scaring me like that, I'll deal with you later just get back to work!\"\nAfter what could have been an unfortunate turn of events, you and Flash wait for Johnny and Zoro to open the door.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Wait for the door");
    }

    public void fromAbove(){
      
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
          case "choice1": hollowStreet(); break;
        }
        break;
    case "follow officer":
        switch(command){
          case "choice1": chargeAttack(); break;
          case "choice2": waitPatiently(); break;
        }
        break;
    case "charge attack":
        switch (command){
          case "choice1": smokeScreen(); break;
          case "choice2": throwRock(); break;
        }
        break;
    case "smokescreen":
        switch (command){
          case "choice1": changeOutfit(); break;
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
        break;
    case "wait":
        switch (command){
          case "choice1": changeOutfit(); break;
        }
        break;
    case "change outfit": 
        switch (command){
          case "choice1": optionOne(); break;
          case "choice2": optionTwo(); break;
        }
        break;
    case "option 1":
        switch (command){
          case "choice1": climbWindow(); break; 
          case "choice2": goFront(); break;
        }
        break;
    case "option 2":
        switch (command){
          case "choice1": climbWindow(); break;
        }
        break;
    case "go through front":
        switch (command){
          case "choice1": seriously(); break;
        }
        break;
    case "seriously":
        switch (command){
          case "choice1": streetThug();
        }
        break;
    case "climb window":
        switch (command){
          case "choice1": startHeist(); break;
        }
        break;
    case "hollow":
        switch (command){
          case "choice1": takeInside(); break;
          case "choice2": takeOutside(); break;
          case "choice3": stayBack(); break;
        }
        break;
    case "take inside":
        switch (command){
          case "choice1": streetThug();
        }
        break;
    case "take outside":
        switch (command){
          case "choice1": continueRace(); break;
        }
        break;
    case "stay back":
        switch (command){
          case "choice1": continueRace(); break;
        }
        break;
    case "continue race":
        switch (command){
          case "choice1": noRamp(); break;
          case "choice2": takeRamp(); break;
        }
        break;
    case "no ramp":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "take ramp":
        switch (command){
          case "choice1": throwBack(); break;
          case "choice2": driveBy(); break;
          case "choice3": throwUp(); break;
        }
        break;
    case "throw it back":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "drive by it":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "throw it up":
        switch (command){
          case "choice1": startHeist(); break;
        }
        break;
    case "start heist":
        switch (command){
          case "choice1": rollOut(); break;
        }
    case "roll out":
        switch (command){
          case "choice1": break;
          case "choice2": break;
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

