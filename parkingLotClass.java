import java.lang.String;
import java.util.*;

enum parkingType {
    REGULAR,
    PREGNANT_LADY,
    HANDICAPPED,
    CARPOOL,
    UNDER_MAINTAINENCE,
    PREMIUM,
    LONG_TIME;
};
class Car {
    String make;
    String color;
    int reg_no;
    Car () {
    }
    Car (String m, String c, int n) {
        make = m;
        color = c;
        reg_no = n;
    }
};
class Owner {
    String name;
    String dl_details;
    Car car;
};
class parkingSpace {
    int parkingNum;
    int floor;
    boolean isOccupied;
    Owner owner;
    int time_in;
    int time_out;
    parkingType type;
    Car car;
    parkingSpace (int num_floors, int parkingspot) {
        owner = new Owner();
        car = new Car();
        parkingNum = parkingspot;
        floor = num_floors;
        isOccupied = false;
        time_in = 0;
        time_out = 0;
        if (parkingspot < 80) {
            type = parkingType.REGULAR;
        } else {
            type = parkingType.PREMIUM;  
        }
    }
}
class parkingLot {
    parkingSpace[][] parkingSlot = new parkingSpace[2][4];
    parkingLot(int num_space, int floors) {
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < num_space; j++) {
                parkingSlot[i][j] = new parkingSpace(i,j); 
            }
        }       
    }
    boolean searchSpot(Car car) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (!(parkingSlot[i][j].isOccupied)) {
                    parkingSlot[i][j].isOccupied = true;
                    parkingSlot[i][j].car.make = car.make;
                    return true;
                }
            }
        }
        return false;
    }
}
public class parkingLotClass {
    static boolean park(Car park_car) {
        System.out.println("I am parking method\n");
        return false;
    }
    boolean unpark() {
        return true;
    }
    public static void main(String args[]) {
        parkingLot googleMlcp = new parkingLot(4, 2);
        Car car = new Car("audi", "red", 3421);
        if (googleMlcp.searchSpot(car)) {
            System.out.println("Car parked\n");
        } else {
            System.out.println("No pasrking slot available\n");
        } 
    }
}
