package in.mohan.parkinglot;

import in.mohan.parkinglot.service.ParkingLotService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mohan on 19/03/21
 */
public class Main {


    public static void main(String... args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        try {
            FileReader fileReader = new FileReader("input");
            BufferedReader input = new BufferedReader(fileReader);
            String line;
            while ((line = input.readLine()) != null) {
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                    case "Create_parking_lot":
                        System.out.println(parkingLotService.createParkingLot(convertToInteger(tokens[1])));
                        break;
                    case "Park":
                        String carNumber = tokens[1];
                        Integer driverAge = convertToInteger(tokens[3]);
                        System.out.println(parkingLotService.parkCar(carNumber, driverAge));
                        break;
                    case "Slot_numbers_for_driver_of_age":
                        driverAge = convertToInteger(tokens[1]);
                        System.out.println(parkingLotService.getSlotNumbersForDriverOfAge(driverAge));
                        break;
                    case "Slot_number_for_car_with_number":
                        carNumber = tokens[1];
                        System.out.println(parkingLotService.getSlotNumberForCarNumber(carNumber));
                        break;
                    case "Vehicle_registration_number_for_driver_of_age":
                        driverAge = convertToInteger(tokens[1]);
                        System.out.println(parkingLotService.getVehicleNumbersForDriverOfAge(driverAge));
                        break;
                    case "Leave":
                        Integer slotNumber = convertToInteger(tokens[1]);
                        System.out.println(parkingLotService.leaveParking(slotNumber));
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    private static Integer convertToInteger(String str){
        return Integer.valueOf(str);
    }
}
