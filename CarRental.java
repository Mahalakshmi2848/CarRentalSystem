package carrental;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRental {

    static ArrayList<Car> cars = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        cars.add(new Car(101, "Toyota", "Innova", 1500));
        cars.add(new Car(102, "Hyundai", "Creta", 1200));
        cars.add(new Car(103, "Maruti", "Swift", 900));

        while (true) {

            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Search Car");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addCar();
                    break;

                case 2:
                    viewCars();
                    break;

                case 3:
                    rentCar();
                    break;

                case 4:
                    returnCar();
                    break;

                case 5:
                    searchCar();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Price Per Day: ");
        double price = sc.nextDouble();

        cars.add(new Car(id, brand, model, price));

        System.out.println("Car added successfully!");
    }

    static void viewCars() {

        System.out.println("\n===== ALL CARS =====");

        for (Car car : cars) {
            car.displayCar();
        }
    }

    static void rentCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Car selectedCar = findCar(id);

        if (selectedCar == null) {
            System.out.println("Car not found!");
            return;
        }

        if (!selectedCar.available) {
            System.out.println("Car is already rented!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(name, phone);

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        double total = selectedCar.pricePerDay * days;

        selectedCar.available = false;

        System.out.println("\n===== RENTAL DETAILS =====");
        System.out.println("Customer : " + customer.name);
        System.out.println("Phone    : " + customer.phone);
        System.out.println("Car      : " +
                selectedCar.brand + " " + selectedCar.model);
        System.out.println("Days     : " + days);
        System.out.println("Total    : ₹" + total);

        System.out.println("Car rented successfully!");
    }

    static void returnCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();

        Car car = findCar(id);

        if (car == null) {
            System.out.println("Car not found!");
            return;
        }

        if (car.available) {
            System.out.println("This car is already available!");
        } else {
            car.available = true;
            System.out.println("Car returned successfully!");
        }
    }

    static void searchCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();

        Car car = findCar(id);

        if (car == null) {
            System.out.println("Car not found!");
        } else {
            car.displayCar();
        }
    }

    static Car findCar(int id) {

        for (Car car : cars) {

            if (car.carId == id) {
                return car;
            }
        }

        return null;
    }
}