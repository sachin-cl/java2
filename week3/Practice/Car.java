package week3.Practice;

public class Car {
   
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }
        // Method to start the engine
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    // Method to stop the engine
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    // Method to display car information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
    }

    // Method to get the age of the car
    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }

    public static void main(String[] args) {
        // Create 3 different Car objects with different attributes
        Car car1 = new Car("Toyota", "Camry", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");

        // Demonstrate calling methods on each object
        car1.startEngine();
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge());
        car1.stopEngine();
        System.out.println();

        car2.displayInfo();
        car2.startEngine();
        System.out.println("Age: " + car2.getAge());
        car2.stopEngine();
        System.out.println();

        car3.displayInfo();
        car3.startEngine();
        System.out.println("Age: " + car3.getAge());
        car3.stopEngine();
        System.out.println();

    }
}   