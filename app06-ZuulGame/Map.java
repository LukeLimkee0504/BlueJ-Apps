
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room spawn;
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
       createMap();
    }
    
    /**
     * Create all the rooms and link their exits together.
     * Also create all the items and add them to room arraylists.
     */
    public void createMap()
    {
        Room outside, mainHall, kitchen, masterBedroom, library, guestRoom, upstairsLanding, secretRoom;
        Item book, key, pocketWatch, hierloom, goldenPlate;
      
        // create the rooms
        outside = new Room("outside the main entrance of the manor", "you see the outside of the manor the door wide open inviting you in, cold air blowing towards you");
        mainHall = new Room("in the main hall", "you find yourself in a huge empty hall with dimly lit candles all around, a small book lays on a table");
        kitchen = new Room("in the manor kitchen", "the kitchen is cold with rusty utensils scattered around the room");
        masterBedroom = new Room("in the master bedroom", "there is a thick layer of dust around the room however you spy a small pocket watch beside the bed, looks valuable");
        library = new Room("in a huge library", "you peer around at the many books and notice a slight gap between two of the books and engraved under is a key symbol");
        guestRoom = new Room("in a small guest room", "you notice this room in pretty well kept and upon snooping around more you notice a small key in the bedside table");
        upstairsLanding = new Room("on the upstairs landing", "you look down from above at the great hall as you hear the tikking of the clock");
        secretRoom = new Room("in a dusty old hidden room", "you notice a small glass box, inside is a golden heart shaped locked, this is what you came here for");
        
        //create items
        book = new Item("Book", 100);
        key = new Item("Key", 500);
        pocketWatch = new Item("Pocket Watch", 300);
        hierloom = new Item("Hierloom", 1000);
        goldenPlate = new Item ("Golden Plate", 600);
        
        //initialise room items
        mainHall.getItemsArray().add(book);
        masterBedroom.getItemsArray().add(pocketWatch);
        secretRoom.getItemsArray().add(hierloom);
        guestRoom.getItemsArray().add(key);
        kitchen.getItemsArray().add(goldenPlate);
        
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
        
        // (need to create unlock function before accessable)
        //  library.setExit("south", secretRoom);
        library.setExit("east", mainHall);
        
        spawn = outside;
    }
    
    public Room getSpawn()
    {
        return spawn;
    }
}
