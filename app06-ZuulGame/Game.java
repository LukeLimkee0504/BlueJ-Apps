/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Luke Lim-kee
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
    }

    /**
     * Create all the rooms and link their exits together.
     * Also create all the items and add them to room arraylists.
     */
    private void createRooms()
    {
        Room outside, mainHall, kitchen, masterBedroom, library, guestRoom, upstairsLanding, secretRoom;
        Item book, key, pocketWatch, hierloom;
      
        // create the rooms
        outside = new Room("outside the main entrance of the manor", "you see the outside of the manor the door wide open inviting you in, cold air blowing towards you");
        mainHall = new Room("in the main hall", "you find yourself in a huge empty hall with dimly lit candles all around");
        kitchen = new Room("in the manor kitchen", "the kitchen is cold with rusty utensils scattered around the room");
        masterBedroom = new Room("in the master bedroom", "there is a thick layer of dust around the room however you spy a small pocket watch beside the bed, looks valuable");
        library = new Room("in a huge library", "you peer around at the many books and notice a slight gap between two of the books and engraved under is a key symbol");
        guestRoom = new Room("in a small guest room", "you notice this room in pretty well kept and upon snooping around more you notice a small key in the bedside table");
        upstairsLanding = new Room("on the upstairs landing", "you look down from above at the great hall as you hear the tikking of the clock");
        secretRoom = new Room("in a dusty old hidden room", "you notice a small glass box, inside is a golden heart shaped locked, this is what you came here for");
        
        //create items
        book = new Item("Book", 100);
        key = new Item("Key", 100);
        pocketWatch = new Item("Pocket Watch", 100);
        hierloom= new Item("Hierloom", 100);
        
        //initialise room items
        mainHall.getItemsList().add(book);
        masterBedroom.getItemsList().add(pocketWatch);
        secretRoom.getItemsList().add(hierloom);
        guestRoom.getItemsList().add(key);
        
        // initialise room exits
        outside.setExit("north", mainHall);
        
        mainHall.setExit("north", upstairsLanding);
        mainHall.setExit("east", kitchen);
        mainHall.setExit("south", outside);
        mainHall.setExit("west", library);
        
        kitchen.setExit("west", mainHall);
        
        secretRoom.setExit("north", library);
        
        guestRoom.setExit("east", upstairsLanding);
        
        upstairsLanding.setExit("south", mainHall);
        upstairsLanding.setExit("east", masterBedroom);
        upstairsLanding.setExit("west", guestRoom);
        
        masterBedroom.setExit("west", upstairsLanding);

        library.setExit("south", secretRoom);
        library.setExit("east", mainHall);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        if (player.getEnergy() == 0)
        {
            finished = true;
        }
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Durst Manor!");
        System.out.println("Your goal is to get into the secret room within the manor and steal the family heirloom.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
            
            case INSPECT:
                inspectRoom();
                break;
            
            case PICKUP:
                pickupItem(command);
                break;
                
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the decrepit old manor.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no exit that way!");
        }
        else {
            player.useEnergy(20);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            System.out.println("----------------------------------------------");
            System.out.println("You now have " + player.getEnergy() +" energy");
            
        }
    }
    
    private void pickupItem(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            System.out.println("Pickup what?");
            return;
        }
        
        String item = command.getSecondWord();
        
        if (currentRoom.getItemsList().contains(item))
        {
            System.out.println("success");
        }
        
        return;
    }
    
    private void inspectRoom()
    {
        player.useEnergy(20);
        System.out.println("You take a closer look around");  
        System.out.println(currentRoom.getInspectDescription());
        System.out.println("You now have " + player.getEnergy() +" energy");
        System.out.println(""); 
        System.out.println("Items:"); 
        currentRoom.printItems();
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }  
}
