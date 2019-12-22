package pl.camp.it.gui;

import pl.camp.it.bd.CarRepository;
import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.Truck;
import pl.camp.it.model.Vehicle;

import java.util.Scanner;

public class Gui {

    //static CarRepository carRepository = new CarRepository();   //SINGLETON

    public static void showMainMenu(){

        printMainMeny();

        switch (readChoose()){
            case "1": showAllVehicle();
                      break;
            case "2": showAllCars();
                      break;
            case "3": showAllBuses();
                      break;
            case "4": showAllTrucks();
                      break;
            case "5": showRentScreen();
                      break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("\n\n\n Zła wartość !!!");
                break;
        }

        showMainMenu();
    }

    private static void showAllVehicle(){
        Vehicle[] availableVehicles = CarRepository.getBaza().getAvailableVehicle();
        for (Vehicle availableVehicle: availableVehicles){
            if (availableVehicle != null) {
                System.out.println(availableVehicle);
            }
        }
    }

    private static void showAllCars(){
        Car[] availableCars = CarRepository.getBaza().getAvailableCars();
        for (Vehicle availableCar: availableCars){
            if (availableCar != null) {
                System.out.println(availableCar);
            }
        }
    }

    private static void showAllBuses(){
        Bus[] availableBuses = CarRepository.getBaza().getAvailableBuses();
        for (Vehicle availableBus: availableBuses){
            if (availableBus != null) {
                System.out.println(availableBus);
            }
        }
    }

    private static void showAllTrucks(){
        Truck[] availableTrucks = CarRepository.getBaza().getAvailableTrucks();
        for (Vehicle availableTruck: availableTrucks){
            if (availableTruck != null) {
                System.out.println(availableTruck);
            }
        }
    }

    private static void showRentScreen(){
        System.out.println("Wpisz Vin: ");

        Scanner scanner= new Scanner(System.in);
        String vin = scanner.nextLine();

        boolean rentResult = CarRepository.getBaza().rentVehicle(vin);

        if (rentResult) {
            System.out.println("Udało się !!!");
        } else{
            System.out.println("Zły VIN !!!");
        }
    }

    public static void printMainMeny(){
        System.out.println("1. Wyświetl dostępne pojazdy");
        System.out.println("2. Wyświetl dostępne samochody");
        System.out.println("3. Wyświetl dostępne busy");
        System.out.println("4. Wyświetl dostępne ciężarówki");
        System.out.println("5. Wypożycz pojazd");
        System.out.println("6. Wyjdź");
    }

    private static String readChoose(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
