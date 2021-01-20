
/**
 * Write a description of class Map here.
 *
 * @author (Luke Limkee)
 * @version (20/1/21)
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
        Room outside, mainHall, kitchen, masterBedroom, library, guestRoom, upstairsLanding, secretRoom, bathroom,
        diningRoom, closet, garden, pantry, study;
        Item book, key, pocketWatch, locket, goldenPlate, fancyClothes, candleHolder, cash;
      
        // create the rooms
        outside = new Room("outside the main entrance of the manor", "you see the outside of the manor the door wide open inviting you in, cold air blowing towards you", 0);
        mainHall = new Room("in the main hall", "you find yourself in a huge empty hall with dimly lit candles all around, a small book lays on a table", 0);
        kitchen = new Room("in the manor kitchen", "the kitchen is cold with rusty utensils scattered around the room", 2);
        masterBedroom = new Room("in the master bedroom", "there is a thick layer of dust around the room however you spy a small pocket watch beside the bed, looks valuable", 0);
        library = new Room("in a huge library", "you peer around at the many books and notice a slight gap between two of the books", 0);
        guestRoom = new Room("in a small guest room", "you notice this room in pretty well kept and upon snooping around more you notice a small key in the bedside table", 1);
        upstairsLanding = new Room("on the upstairs landing", "you look down from above at the great hall as you hear the tikking of the clock", 0);
        secretRoom = new Room("in a dusty old hidden room", "you notice a small glass box, inside is a golden heart shaped locket", 2);
        bathroom = new Room("in a luxuarious bathroom", "you wonderaround the bathroom, nothing of value here", 0);
        closet = new Room("in a vaste walk in closet", "you look around and find many valuable silks and clothes", 0);
        diningRoom = new Room("in a grand hall used for dining", "you notice at the centre of the room is a orante candle holder made of solid gold and some fancy food", 2);
        garden = new Room("in a rotting and dead garden", "nothing around here but a few still good apples", 2);
        pantry = new Room("in a mostly emprty pantry", "you snoop around the panrty but the only thing you find is a box of cookies", 1);
        study = new Room("in a small study room", "you look around through the draws in the desk and find a stack of cash", 0);
        
        //create items
        book = new Item("Book", 100);
        key = new Item("Key", 500);
        pocketWatch = new Item("Pocket Watch", 300);
        locket = new Item("Heart Locket", 1000);
        goldenPlate = new Item ("Golden Plate", 600);
        fancyClothes = new Item ("Fancy Clothes", 500);
        candleHolder = new Item ("Candle Holder", 500);
        cash = new Item ("Stack of cash", 500);
        
        //initialise room items
        mainHall.getItemsArray().add(book);
        masterBedroom.getItemsArray().add(pocketWatch);
        secretRoom.getItemsArray().add(locket);
        guestRoom.getItemsArray().add(key);
        kitchen.getItemsArray().add(goldenPlate);
        closet.getItemsArray().add(fancyClothes);
        diningRoom.getItemsArray().add(candleHolder);
        study.getItemsArray().add(cash);
        
        // initialise room exits
        outside.setExit("north", mainHall);
        
        garden.setExit("south", kitchen);
        
        pantry.setExit("north", kitchen);
        
        study.setExit("south", library);
        
        diningRoom.setExit("west", kitchen);
        
        mainHall.setExit("north", upstairsLanding);
        mainHall.setExit("east", kitchen);
        mainHall.setExit("south", outside);
        mainHall.setExit("west", library);
        
        kitchen.setExit("west", mainHall);
        kitchen.setExit("south", pantry);
        kitchen.setExit("north", garden);
        kitchen.setExit("east", diningRoom);
        
        secretRoom.setExit("north", library);
        
        guestRoom.setExit("east", upstairsLanding);
        
        upstairsLanding.setExit("south", mainHall);
        upstairsLanding.setExit("east", masterBedroom);
        upstairsLanding.setExit("west", guestRoom);
        
        masterBedroom.setExit("west", upstairsLanding);
        masterBedroom.setExit("east", closet);
        
        library.setExit("north", study);
        library.setExit("south", secretRoom);
        library.setExit("east", mainHall);
        
        spawn = outside;
    }
    
      /**
     * @returns the current map spawn room
     */
    public Room getSpawn()
    {
        return spawn;
    }
}
