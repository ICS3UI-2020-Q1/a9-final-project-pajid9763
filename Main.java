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
  JButton beginButton;

  CardLayout screens;

  String marker; // marks where you are in the story 
  

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

    // change the text colour to red
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

    // change the font settings for storyText
    Font font = new Font ("Times New Roman", Font.PLAIN, 20);
    storyText.setFont(font);

    // change the storyText background color
    storyText.setBackground(Color.BLACK);

    // add the text area to the gameScreen 
    gameScreen.add(storyText);

    
    // create an array for the choice buttons 
    choiceButtons = new JButton[4];

    // use a for loop to go through and create each button
    for(int i = 1; i < choiceButtons.length; i++){
      // initialize the buttons 
      JButton button = new JButton ("" + i);
      // put the button in the array 
      choiceButtons[i] = button;
    }

    // set the size and location of the buttons 
    choiceButtons[1].setBounds(30, 320, 360, 100);
    choiceButtons[2].setBounds(410, 320, 360, 100);
    choiceButtons[3].setBounds(220, 440, 360, 100);

    // add action listener to the buttons 
    choiceButtons[1].addActionListener(this);
    choiceButtons[2].addActionListener(this);
    choiceButtons[3].addActionListener(this);

    // set setActionCommand to the buttons 
    choiceButtons[1].setActionCommand("choice1");
    choiceButtons[2].setActionCommand("choice2");
    choiceButtons[3].setActionCommand("choice3");

    // change font size of the buttons 
    choiceButtons[1].setFont (choiceButtons[1].getFont ().deriveFont(20.0f));
    choiceButtons[2].setFont (choiceButtons[2].getFont ().deriveFont(20.0f));
    choiceButtons[3].setFont (choiceButtons[3].getFont ().deriveFont(20.0f));

    // make the JButton non visible 
    choiceButtons[1].setVisible(true);
    choiceButtons[2].setVisible(false);
    choiceButtons[3].setVisible(false);

    // add the choiceButtons to the gameScreen 
    gameScreen.add(choiceButtons[1]);
    gameScreen.add(choiceButtons[2]);
    gameScreen.add(choiceButtons[3]);
    
    // set up the title screen
    titleScreen = new JPanel();
    titleScreen.setLayout(null);
    // change background color of titleScreen 
    titleScreen.setBackground(Color.BLACK);

    // create title for the game 
    titleLabel = new JLabel("VALOR CITY 2077", SwingConstants.CENTER);
    // change font settings for the title
    Font font2 = new Font ("Times New Roman", Font.BOLD, 50);
    titleLabel.setForeground(Color.red);
    titleLabel.setFont(font2);
    // set setBounds for the titleLabel
    titleLabel.setBounds(100, 30, 600, 300);
    titleScreen.add(titleLabel);

    // create the button to begin the game 
    beginButton = new JButton("BEGIN");
    beginButton.setBounds(300, 350, 200, 100);
    // change font size
    beginButton.setFont (beginButton.getFont ().deriveFont(25.0f));
    beginButton.addActionListener(this);
    beginButton.setActionCommand("begin");

    // add beginButton to titleScreen
    titleScreen.add(beginButton);


    // create the screen jpanel manager 
    screens = new CardLayout();

    mainPanel = new JPanel();
    mainPanel.setLayout(screens);

    // add screens to the card layout 
    mainPanel.add(titleScreen, "titleScreen");
    mainPanel.add(gameScreen, "gameScreen");

    // add the mainPanel to the frame
    frame.add(mainPanel);
    
    // sets the screen to show by asking the card layout 
    screens.show(mainPanel, "titlescreen");
    
  }
  
    // create methods for different choices (this is the same format for every single method) 
    public void streetThug(){
      // declare what the marker will be so it can be called in a switch case
      marker = "street thug";
      // set what the storyText will say
      storyText.setText("The year 2077 is a time where crime runs rampant through\nValor City, hence the name, you will need to be courageous in\nthe face of danger in this crime filled metropolis. Street thugs\nhave small dreams of becoming a legend in Valor City, taking\nthe ugly way or not. You are a Street Thug, they call you Ripper.\nYou want to become a legend, what faster way then to\ngain immortality and become a force to be reckoned with!");

      // set what the buttons will display
      choiceButtons[1].setText("Continue");
      
      // set which buttons are visible and which ones are not 
      choiceButtons[1].setVisible(true);
      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
    }

    public void continueGame(){
      marker = "continue";
      
      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(false);
      
      storyText.setText("The phone is ringing\nYou pick it up, and to your surprise, no caller ID.\nHesitant, you answer.\n\"You're Ripper, right?\" Says the man on the other side.\n\"Yes... who is this calling\" You say with a hint of concern.\n\"That's not important, just come to Little Tokyo if you're about it,\nand come alone\"\n\"Wait you don't mean -\" The mysterious man ended the call before you\ncould finish ");

      // this lets there be multiple lines in a button
      choiceButtons[1].setText("<html><center>"+"Go meet him in"+"<br>"+"Little Tokyo alone"+"</center></html>Go meet him in Little Tokyo alone");
      choiceButtons[2].setText("<html><center>"+"Go meet him in"+"<br>"+"Little Tokyo with a group"+"</center></html>");
    }

    public void meetAlone(){
      marker = "meetAlone";
      
      storyText.setText("You go to Little Tokyo by yourself. When you get there you cannot believe your eyes. The man standing infront of you is the famous Flash Fang.\nKnown for being incredibly fast and as ferocious as a wolf. He's basically what every one of us lowly thugs want to become.\n\"Flash Fang, i- what an honour to be in your presen-\"\n\"Cut the small talk Ripper, I'm building a team to perform the greatest\nheist Valor City has ever seen. We're gonna steal the chip of immortality and I will then become the king this city has always needed!\" ");
      
      choiceButtons[1].setText("Say no more, I'm in!");

      choiceButtons[2].setVisible(false);
    }

    public void meetGroup(){
      marker = "meetGroup";
      
      storyText.setText("\"You really don't know how to follow orders boy,\nI can't have an airhead like you on my team! Get lost before you regret\nit!\"");

      choiceButtons[1].setText("Resart");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);
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

      storyText.setText(" \"You have a better a idea, let's hear it then!\"Demands Flash\n\"Hear me out, there's a street race happening not too far from here on\nHollow Street, some of the biggest betters are rumoured to join in on the fun. Whaddya say I enter, win the damn thing and you'll have more than enough money to buy yourself the best looking katanas on the market?\" You say confidentally.\n\"Well if you're so confident, go for it, but if you don't win. Boy you don't wanna know the consequences!\"Flash said with an evil look in his eyes.\nAnd with that you were off to Hollow Street.");

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

      storyText.setText("You look at the name tag of the person at the desk\n\"Hey Mark, can I get the keys to the storage room I think I forgot\nsomething in there.\"You say hoping he wouldn't get too suspicious.\n\"Yeah here, catch!\"Mark says while throwing you the keys.\n\"Thanks man I'll be right back!\"You exclaim as you quickly leave for the\nstorage room.\nYou get to the storage room, unlock the door and find Flash's 3 katanas.\nNow for your escape, do you break the window and climb through, if you do so, the VCPD will remember your face and you will be branded a\ncriminal.Or do you try walking through the front door with the 3 katanas?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Climb through window");
      choiceButtons[2].setText("Go through the front");
    }

    public void optionTwo(){
      marker = "option 2";

      storyText.setText("Without looking at anyone, you go to the storage room and start to pick\nthe lock, after a few seconds the door opens. You find the 3 katanas\nand make your way to the window.");

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

      storyText.setText("The next bit of the race is going fine, you move up to 5th place. The\nending is near and you need to make a big play. You see a ramp in the\ndistance, if you use the ramp you could skip a whole corner and gain a\nbig advantage. Are you willing to take that risk?");

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

      storyText.setText(" \"This is the day that we break into MecaTech and steal the chip of\nimmortality. This is the plan. I have a guy working from the inside, he'll\ncut the cameras as we enter through a vent on the west side of the\nbuilding. We'll split into 2 teams, me and Ripper will go and wait outside\nof the door where the chip is being held and take care of the guards. You two (pointing at the other crewmates) Johnny, you're the hackerman,\nopen the doors guarding the chip, and Zoro you protect him from any\nharm that comes his way. Let's do this!\"");

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
      marker = "jump down";

      storyText.setText("As soon as you and Flash jump down, the guards spot you and\nimmediately call emergency. You and Flash quickly take them out.\nNow, what will you do about this emergency call?");

      choiceButtons[1].setText("Stand and wait");
      choiceButtons[2].setText("Say it was a false alarm");
    }

    public void standWait(){
      marker = "stand and wait";

      storyText.setText("You and Flash decide to do nothing about this emergency call. Not such a good idea as a few minutes later, the room is swarmed with MecaTech\nsoldiers. That's the end of the story for you.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void falseAlarm(){
      marker = "false alarm";

      storyText.setText("You grab the walkie talkie from the guard that you just knocked out.\n\"Sorry boss, that was a false alarm, can you order all soldiers to stand\ndown. I repeat this was a false alarm\"\n\"Cmon man, don't go scaring me like that, I'll deal with you later just get back to work!\"\nAfter what could have been an unfortunate turn of events, you and Flash wait for Johnny and Zoro to open the door.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Wait for the door");
    }

    public void fromAbove(){
      marker = "from above";

      storyText.setText("You and Flash coordinate an aerial attack that knocks out both guards\nprotecting the door. Now the two of you wait for Johnny and Zoro\nto finish opening the door.");
      
      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("Wait for the door");
    }

    public void doorOpen(){
      marker = "door open";

      storyText.setText("After a few minutes the door opens. And whaddya know, the chip of\nimmortality is sitting right there in front of you. Flash goes forward\nand grabs it, puts it in his pocket and says\n\"Let's move, no time to waste.\"\nAs we were leaving, Flash gets a call from Johnny.\n\"Flash, were in a bit of trouble over here, if you can -- over - here...pleas-\"The call cuts off.\n\"Flash, let's go we gotta help them!\" You say worriedly.\n\"No Ripper are you stupid!? If we go over there we'll die, you\nunderstand? Now let's save ourselves and not those bozos!\"\nWhat will you do in this situation?");

      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(true);

      choiceButtons[1].setText("Oppose Flash's orders");
      choiceButtons[2].setText("Go with Flash");
      choiceButtons[3].setText("Go save the others");
    }

    public void opposeOrder(){
      marker = "oppose order";

      storyText.setText("\"No! Flash, we're going to save them!\" You say.\n\"Fine. That's one less loose end.\" Flash says as he shoots you in the\nstomach and leaves on his own.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Game over!");
    }

    public void shepard(){
      marker = "shepard";

      storyText.setText("That kind of reminds you of Shepard from Modern Warfare 2 doesn't it?\nAnyways, try again.");

      choiceButtons[1].setText("Restart");
    }

    public void goWithFlash(){
      marker = "go with flash";

      storyText.setText("You decide to go with Flash. You two are about to make it to the exit\nwhen you are stopped by mulitple soldiers.\n\"On the ground! NOW!\" One soldier yells.\nWhat do you do?");

      choiceButtons[2].setVisible(true);
      choiceButtons[3].setVisible(true);

      choiceButtons[1].setText("Charge at the soldiers");
      choiceButtons[2].setText("Run the opposite way");
      choiceButtons[3].setText("Get on the ground");
    }

    public void chargeSoldier(){
      marker = "charge at soldier";

      storyText.setText("\"Ripper, you charge at them and I'll hit them with a sneak attack.\"\nWhispers Flash.\nWithout hesitation, you charge at the soldiers. You look back, Flash is\ngone, he took the chance to escape while all this commotion was going\non. Now your stuck rushing at the soldiers with no back up.\nThey mow you down. Game over!");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void runAway(){
      marker = "run away";

      storyText.setText("You try running in the opposite direction of the soldiers. You are instantly shot. Game over!");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Restart");      
    }

    public void onTheGround(){
      marker = "ground";

      storyText.setText("You and Flash do as they say and get on the ground. You are both\narrested and sent to prison. Game over!");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void saveOthers(){
      marker = "save others";

      storyText.setText("You run away from Flash before he could notice and you shout back\n\"Screw you Flash, you selfish bastard!\"\nA bullet whistles by your left ear.\n\"We will meet again, Flash Fang!\" You yell as you go to save Johnny and Zoro.\nYou reach the control room where the others are. They are in trouble for\nsure, they are hiding behind a desk with 5 soldiers shooting at them.\nYou kick down the door and start spraying. You tell Johnny and Zoro\nabout the situation and tell them that we have to escape now.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Escape");
    }

    public void escape(){
      marker = "escape";

      storyText.setText("You, Zoro, and Johnny are making your way through the building. The\nexit is within reach. As soon as you were about to reach the exit, a group\nof soldiers appear.\nWhat do you do?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Avoid combat");
      choiceButtons[2].setText("Fight your way through");
    }

    public void avoidCombat(){
      marker = "avoid combat";

      storyText.setText("You and the others decide to avoid getting into a fight so you all start\nsprinting away from the scene. That wasn't such a bright idea as you all\nget brought down and arrested. Game over!");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Restart");
    }

    public void fightBack(){
      marker = "fight back";

      storyText.setText("You all have the same idea, in unison the three of you start to lower your weapons to the ground, but as soon as you're about the drop them,\nyou spring right back up and defeat all the soldiers in the room.\nThe three of you safely escape the building and now start to look\nfor Flash.");

      choiceButtons[2].setVisible(false);
      choiceButtons[3].setVisible(false);

      choiceButtons[1].setText("Find Flash Fang");      
    }

    public void findFlash(){
      marker = "find flash";

      storyText.setText("You, Zoro, and Johnny start to look for Flash, he can't be far as he's on\nfoot as well. Johnny, being the hackerman that he is, starts to track down Flash and in less than a minute, you have acquired Flash's position. A few\nminutes later you catch up to Flash and he is the first to talk\n\"Oh so you guys made it out, isn't that wonderful!\"\n\"Cut the crap Flash, you didn't give a damn about us since the\nbeginning! Now hand over the chip of immortality, someone like\nyou doesn't deserve to be the king of this city! You shout.\n\"Over my dead body..\" Flash responds as he fires his pistol from the hip.\nThis shot is heading towards Zoro. What happens next?");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Jump infront of Zoro");
      choiceButtons[2].setText("Push Zoro out of the way");
    }

    public void jumpInfront(){
      marker = "jump infront";

      storyText.setText("You jump infront of Zoro, taking a bullet right to the chest. Zoro goes to\nyour aid but it's no use. You tell him\n\"Live on, do it for me...\"\nYou pass away but your wish was fulfilled. Zoro avenged you and became the king of Valor City, in the name of a simple street thug who turned\nout to be quite the comrade, Ripper.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("The End");
    }

    public void pushAway(){
      marker = "push him away";

      storyText.setText("You push Zoro out of the way, but you get shot in the left shoulder. You\ncontinue to limp towards Flash, before he can fire again, Johnny shoots\nFlash's left hand, forcing him to drop the pistol.\n\"No please, spare me Ripper, I'll do whatever you want just spare\nme please!\"\nFinal decision is up to you.");

      choiceButtons[2].setVisible(true);

      choiceButtons[1].setText("Spare him");
      choiceButtons[2].setText("Finish him!");
    }

    public void spareHim(){
      marker = "spare him";

      storyText.setText("\"Okay I'll spare you, but don't try to pull any funn-\"Before you could\nfinish Flash sweep kicks you.\n\"Naive fools, all of you!\" Flash shouts as he reveals a secret weapon that he has behind his back that he use to take down you, Zoro, and Johnny.\nFlash walks away from the scene and soon after becomes the king of\nValor City.");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("The End");
    }

    public void finishHim(){
      marker = "finish him";

      storyText.setText("\"This is the end of the road for you you worhtless scum!\"You shout as you finish him off.\nYou take the chip of immortality from Flash and you insert it into\nyourself. With this, you become the king of Valor City, with your two\ngreat comrades Zoro and Johnny right beside you!");

      choiceButtons[2].setVisible(false);

      choiceButtons[1].setText("The End");
    }

    public void theEnd(){
      marker = "the end";

      storyText.setText("Congratulations! You have reached the end of the story!\nThank you for playing and I thank the upcoming greatest game of all\ntime Cyberpunk 2077 for the inspiration!");

      choiceButtons[1].setText("Play again");
    }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // if begin button is pressed
    if (command.equals("begin")){
      // switch the screen to gameScreen
      screens.show(mainPanel, "gameScreen");
      // start out on the streetThug method
      streetThug();
    }
    
    // this is a switch case for the marker, based on where the user is in the story another switch case will occur
    switch (marker){
    case "street thug":
        // switch case for what choice button the user presses, based on the button, another method will be called (this is the same for every single switch case for the command)
        switch(command){
          case "choice1": continueGame(); break;
        }
        break; // break is here so the program doesn't read past this break
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
        break;
    case "roll out":
        switch (command){
          case "choice1": jumpDown(); break;
          case "choice2": fromAbove(); break;
        }
        break;
    case "jump down":
        switch (command){
          case "choice1": standWait(); break;
          case "choice2": falseAlarm(); break;
        }
        break;
    case "stand and wait":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "false alarm":
        switch (command){
          case "choice1": doorOpen(); break;
        }
        break;
    case "from above":
        switch (command){
          case "choice1": doorOpen(); break;
        }
        break;
    case "door open":
        switch (command){
          case "choice1": opposeOrder(); break;
          case "choice2": goWithFlash(); break;
          case "choice3": saveOthers(); break;
        }
        break;
    case "oppose order":
        switch (command){
          case "choice1": shepard(); break;
        }
        break;
    case "shepard":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "go with flash":
        switch (command){
          case "choice1": chargeSoldier(); break;
          case "choice2": runAway(); break;
          case "choice3": onTheGround(); break;
        }
        break;
    case "charge at soldier":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "run away":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "ground":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "save others":
        switch (command){
          case "choice1": escape(); break;
        }
        break;
    case "escape":
        switch (command){
          case "choice1": avoidCombat(); break;
          case "choice2": fightBack(); break;
        }
        break;
    case "avoid combat":
        switch (command){
          case "choice1": streetThug(); break;
        }
        break;
    case "fight back":
        switch (command){
          case "choice1": findFlash(); break;
        }
        break;
    case "find flash":
        switch (command){
          case "choice1": jumpInfront(); break;
          case "choice2": pushAway(); break;
        }
        break;
    case "jump infront":
        switch (command){
          case "choice1": theEnd(); break;
        }
        break;
    case "push him away":
        switch (command){
          case "choice1": spareHim(); break;
          case "choice2": finishHim(); break;
        }
        break;
    case "spare him":
        switch (command){
          case "choice1": theEnd(); break;
        }
        break;
    case "finish him":
        switch (command){
          case "choice1": theEnd(); break;
        }
        break;
    case "the end":
        switch (command){
          // if the user chooses to play again, send them to the title screen
          case "choice1": screens.show(mainPanel, "titleScreen"); break;
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

