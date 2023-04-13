import java.util.ArrayList;

/**
 * The Robot class represents a robot that can perform various actions such as grabbing, dropping, examining,
 * using, walking, flying, growing, shrinking, resting, and undoing actions. It implements the Contract interface.
 */
public class Robot implements Contract {

    boolean holding_something;
    public ArrayList<String> methodSequence = new ArrayList<>();
    public String lastdirection;
    int size;
    int energyLevel;

    /**
     * Constructs a new Robot with a size of 100 and an energy level of 100.
     */
    public Robot(){
        size = 100;
        energyLevel = 100;
    }

    /**
     * Grabs the specified item.
     * @param item the item to be grabbed
     */
    public void grab(String item){
        if(holding_something){
            System.out.println("I already have an item in my hand. If you want me to drop it please use the drop() function.");
        }
        else{
            System.out.println("Grabbing " + item);
            holding_something = true;
            methodSequence.add("Grabbed item");

        }
    };

    /**
     * Drops the specified item.
     * @param item the item to be dropped
     * @return the dropped item
     */
    public String drop(String item){
        if(holding_something){
            System.out.println("Dropping " + item);
            holding_something = false;
            methodSequence.add("Dropped item");
            return item;
        }
        else { 
            System.out.println("I wasn't holding anything! ");
            return item;
        }
        }

    /**
     * Examines the specified item.
     * @param item the item to be examined
     */
    public void examine(String item){
        if (holding_something){
            System.out.println("Examining " + item);
            methodSequence.add("Examined item");

        }
        else {
            System.out.println("I am not holding something to examine. Please give me something to examine with the grab() method. ");
        }
    };

    /**
     * Uses the specified item.
     * @param item the item to be used
     */
    public void use(String item){
        if (holding_something){
            System.out.println("Using " + item);
            methodSequence.add("Used item");
            System.out.println("Ooh this is a fun item! ");
        }
        else {
            System.out.println("I am not holding something to use. Please give me something to examine with the grab() method. ");
        }

    }

    /**
     * Walks in the specified direction.
     * @param direction the direction to walk in (either "North" or "South")
     * @return true if the direction is valid, false otherwise
     */
    public boolean walk(String direction){

        if (direction.equals("North")){
            lastdirection = "North";
            methodSequence.add("walk(" + direction + ")");
        }
        else if (direction.equals("South")){
            lastdirection = "South";
            methodSequence.add("walk(" + direction + ")");
        }
        else{
            System.out.println("Please enter either 'North' or 'South'.");
        }
        return true;

    };
/**
 * Flies the robot to the specified (x, y) coordinates.
 *
 * @param x the x coordinate to fly to
 * @param y the y coordinate to fly to
 * @return always returns true
 */
    public boolean fly(int x, int y){
        if (x >= 0 && y >= 0) {
            // Fly to (x, y)
            methodSequence.add("Flew");
        } else {
            System.out.println("Invalid coordinates: (" + x + ", " + y + ")");
        }
        return true;
    };
/**
 * Shrinks the robot by 1 and adds the method name to the methodSequence ArrayList.
 *
 * @return the new size of the robot after shrinking
 */
    public Number shrink(){
        methodSequence.add("Shrink");
        return size -= 1;
    };
/**
 * Grows the robot by 1 and adds the method name to the methodSequence ArrayList.
 *
 * @return the new size of the robot after growing
 */
    public Number grow(){
        methodSequence.add("Grow");
        return size += 1;
    };
/**
 * Restores the robot's energy level to 100 if it is less than or equal to 50, and adds the method name to the methodSequence ArrayList.
 */
    public void rest(){
        if (energyLevel <=50){
            energyLevel = 100;
            methodSequence.add("Rest");
        }
        else{
            System.out.println("I have enough energy, I don't need to rest! ");
        }

    };
/**
 * Undoes the last method called on the robot. Invokes the opposite method to undo the action and removes the method name from the methodSequence ArrayList.
 * If the methodSequence ArrayList is empty, prints an error message.
 */
    public void undo(){
        if (!methodSequence.isEmpty()) {
            String lastMethod = methodSequence.remove(methodSequence.size() - 1);

            // Invoke opposite method to undo action
            if (lastMethod.equals("walk(north)")) {
                this.walk("South");

            } else if (lastMethod.equals("walk(south)")) {
                this.walk("North");

            } else if (lastMethod.equals("Grabbed item")){
                System.out.println("Dropped item");
                holding_something = false;
            }

            else if (lastMethod.equals("Dropped item")){
                holding_something = true;
                System.out.println("Grabbed item");
            }

            else if(lastMethod.equals("Examined item")){
                holding_something = false;
                System.out.println("Item dropped.");
            }

            else if(lastMethod.equals("Used item")){
                holding_something = false;
                System.out.println("Item dropped.");
            }
            
            else if(lastMethod.equals("Used item")){
                holding_something = false;
                System.out.println("Item dropped.");
            }

            else if(lastMethod.equals("Flew")){
                System.out.println("Returned to ground");
            }

            else if(lastMethod.equals("Shrink")){
                this.grow();
            }

            else if(lastMethod.equals("Grow")){
                this.shrink();
            }

            else if(lastMethod.equals("Rest")){
                this.energyLevel = 50;   
            }

            else {System.out.println("Invalid method name in sequence: " + lastMethod);
            }
        } 
        else {
            System.out.println("No methods in sequence");

    }}

    public static void main(String[] args) {
        Robot robot = new Robot();
    }}