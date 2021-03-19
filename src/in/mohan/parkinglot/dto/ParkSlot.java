package in.mohan.parkinglot.dto;

/**
 * Created by mohan on 19/03/21
 */
public class ParkSlot {

    private String carNumber;

    private Integer driverAge;

    public ParkSlot(String carNumber, Integer driverAge) {
        this.carNumber = carNumber;
        this.driverAge = driverAge;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    @Override
    public String toString() {
        return "ParkSlot{" +
                "carNumber='" + carNumber + '\'' +
                ", driverAge='" + driverAge + '\'' +
                '}';
    }
}
