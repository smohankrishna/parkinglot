package in.mohan.parkinglot.service;

import in.mohan.parkinglot.dto.ParkSlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mohan on 19/03/21
 */
public class ParkingLotService {

    private static ParkSlot[] parkingLot;

    public String createParkingLot(Integer capacity) {
        if (Objects.nonNull(capacity) && capacity > 0) {
            parkingLot = new ParkSlot[capacity];
            return "Created parking of " + capacity + " slots";
        } else {
            return null;
        }
    }

    public String parkCar(String carNumber, Integer driverAge) {
        if(Objects.nonNull(parkingLot)) {
            for (int i = 0; i < parkingLot.length; i++) {
                if (Objects.isNull(parkingLot[i])) {
                    ParkSlot parkSlot = new ParkSlot(carNumber, driverAge);
                    parkingLot[i] = parkSlot;
                    return "Car with vehicle registration number \"" + carNumber + "\" has been parked at slot number " + (i + 1);
                }
            }
        }
        return null;
    }

    public String leaveParking(Integer parkingSlot) {
        if (Objects.nonNull(parkingLot) && Objects.nonNull(parkingSlot) && parkingSlot < parkingLot.length) {
            ParkSlot parkSlot = parkingLot[parkingSlot - 1];
            parkingLot[parkingSlot - 1] = null;
            return "Slot number 2 vacated, the car with vehicle registration number \"" + parkSlot.getCarNumber() + "\" left the space, the driver of the car was of age " + parkSlot.getDriverAge();
        }
        return null;
    }

    public Integer getSlotNumberForCarNumber(String carNumber) {
        if(Objects.nonNull(parkingLot)) {
            for (int i = 0; i < parkingLot.length; i++) {
                ParkSlot parkSlot = parkingLot[i];
                if (Objects.nonNull(parkSlot) && parkSlot.getCarNumber().equals(carNumber)) {
                    return i + 1;
                }
            }
        }
        return null;
    }

    public String getVehicleNumbersForDriverOfAge(Integer age) {
        if(Objects.isNull(parkingLot)) {
            return null;
        }
        List<String> vehicleNumbers = Arrays.stream(parkingLot).filter(Objects::nonNull)
                .filter(p -> p.getDriverAge().equals(age))
                .map(ParkSlot::getCarNumber)
                .collect(Collectors.toList());
        return vehicleNumbers.isEmpty()? null : String.join(",", vehicleNumbers);
    }

    public String getSlotNumbersForDriverOfAge(Integer age) {
        ArrayList<String> slotNumbers = new ArrayList<>();
        if(Objects.nonNull(parkingLot)) {
            for (int i = 0; i < parkingLot.length; i++) {
                ParkSlot parkSlot = parkingLot[i];
                if (Objects.nonNull(parkSlot) && parkSlot.getDriverAge().equals(age)) {
                    slotNumbers.add(String.valueOf(i + 1));
                }
            }
        }
        return slotNumbers.isEmpty()? null : String.join(",", slotNumbers);
    }

}
