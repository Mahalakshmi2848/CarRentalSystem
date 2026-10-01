package carrental;

public class Car {

    int carId;
    String brand;
    String model;
    double pricePerDay;
    boolean available;

    public Car(int carId, String brand, String model, double pricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public void displayCar() {
        System.out.println("Car ID       : " + carId);
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Price/Day    : ₹" + pricePerDay);
        System.out.println("Availability : "
                + (available ? "Available" : "Rented"));
        System.out.println("----------------------------");
    }
}