/**
 *
 */
public class Car extends Vehicle {
    String make;
    String model;
    String color;
    int engineSize;     // in horsepower
    int fuelTank;       // in gallons
    private static int vin = 1000;

    // Need to set top speeds for each of the makes and models
    public void accelerate(int magnitude) {
        if (engineSize == 200) { setSpeed(getSpeed() + (2 * magnitude)); }
        else if (engineSize == 400) { setSpeed(getSpeed() + (5 * magnitude)); }
        else if (engineSize == 600) { setSpeed(getSpeed() + (8 * magnitude)); }
        else if (engineSize == 800) { setSpeed(getSpeed() + (12 * magnitude)); }

        System.out.println("\nYou are traveling at " + getSpeed() + " mph.");
    }

    // Need to set the minimum speed to 0 if the speed goes below 0
    public void decelerate(int magnitude) {
        if (engineSize == 200) { setSpeed(getSpeed() - (2 * magnitude)); }
        else if (engineSize == 400) { setSpeed(getSpeed() - (5 * magnitude)); }
        else if (engineSize == 600) { setSpeed(getSpeed() - (8 * magnitude)); }
        else if (engineSize == 800) { setSpeed(getSpeed() - (12 * magnitude)); }

        System.out.println("\nYou are traveling at " + getSpeed() + " mph.");
    }

    public String getStatus () {
        StringBuilder sbd = new StringBuilder();


        return sbd.toString();
    }

    // Constructors
    Car() {
        make = "Cheverolet";
        model = "Malabu";
        color = "blue";
        engineSize = 200;
    }

    Car(String make, String model, String color, int engineSize) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.engineSize = engineSize;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}