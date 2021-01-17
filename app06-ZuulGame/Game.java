    import java.util.ArrayList;
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
        private Map map;
            
        /**
         * Create the game and initialise its internal map.
         */
        public Game() 
        {
            map = new Map();
            map.createMap();
            setSpawn();
            parser = new Parser();
            player = new Player();
        }
        
        private void setSpawn()
        {
            currentRoom = map.getSpawn();
        }
    
        /**
         *  Main play routine.  Loops until end of play.
         */
        public void play() 
        {            
            printWelcome();
    
            // Enter the main command loop.  Here we repeatedly read commands and
            // if the players health reaches zero the game end. 
            // execute them until the game is over.
                    
            boolean finished = false;
    
            while (! finished) 
            {
                Command command = parser.getCommand();
                finished = processCommand(command);
                
                if (player.getEnergy() == 0)
            {
                System.out.println("--------------------------------------------------------");
                System.out.println("You pass out from exuastion and the world fades to black");
                System.out.println("");
                System.out.println("---------------------GAME OVER-------------------------");
                System.out.println("Final score - " + (player.getScore()));
                System.out.println("--------------------------------------------------------");
                finished = true;
            }
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
                pickupItem();
                break;
                
            case EAT:  
                eat();
                break;
                
            case INVENTORY:  
                player.printInventory();
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

        if (nextRoom == null)
          {
            System.out.println("There is no exit that way!");
          }
        else  
        {
            player.useEnergy(20);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            System.out.println("----------------------------------------------");
            System.out.println("You now have " + player.getEnergy() +" energy");
            
        }
    }
    
    private void pickupItem()
    {
        ArrayList<Item> tempItems = currentRoom.getItemsArray();
        
        int roomFood;
        roomFood = currentRoom.getFoodAmount();
        
        if (roomFood > 0) 
        {
            player.addFood(roomFood);
        }
      
        for (Item item : tempItems)
        {
            player.addToInventory(item);
            int itemvalue = item.getValue();
            player.addScore(itemvalue);
            System.out.println("You picked up a " + (item) + (" and ") + (player.getFood()) + (" food!"));
            System.out.println("Your score is now " + player.getScore());
        }       
    }
    
    private void inspectRoom()
    {
        player.useEnergy(20);
        System.out.println("You take a closer look around");  
        System.out.println(currentRoom.getInspectDescription());
        System.out.println("----------------------------------------------");
        System.out.println("You now have " + player.getEnergy() +" energy");
        System.out.println("----------------------------------------------");
        System.out.println("Items:"); 
        currentRoom.printItems();
        System.out.println("Food: " + (currentRoom.getFoodAmount())); 
    }
    
    private void eat()
    {
        
        if(player.getFood() > 0)
        {
            player.removeFood(1);
            player.addEnergy(100);
            System.out.println("You take some time to eat and rest");
            System.out.println("You now have " + (player.getEnergy()) + (" energy and ") + (player.getFood()) + (" food"));
        }
        else
        {
            System.out.println("You dont have any food!");
        }
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
