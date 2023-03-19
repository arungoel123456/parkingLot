import com.demo.dto.*;
import com.demo.dto.account.*;
import com.demo.dto.parkingSpot.*;
import com.demo.dto.vehicle.*;
import com.demo.exceptions.*;
import com.demo.interfaces.*;
import com.demo.parkingStrategy.*;
import com.demo.services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot= ParkingLot.getInstance();
        DisplayBoard displayBoard= DisplayBoard.getInstance();
        parkingLot.addEntrancePanel(new EntrancePanel("first"));
        parkingLot.addExitPanel(new ExitPanel("first"));

        ParkingSpot a1= new Compact(0);
        ParkingSpot a2= new Compact(0);

        ParkingSpot b1= new Large(0);
        ParkingSpot b2= new Large(0);

        ParkingSpot c1= new Mini(0);
        ParkingSpot c2= new Mini(0);

        parkingLot.addParkingSpot(a1);
        parkingLot.addParkingSpot(a2);
        parkingLot.addParkingSpot(b1);
        parkingLot.addParkingSpot(b2);
        parkingLot.addParkingSpot(c1);
        parkingLot.addParkingSpot(c2);

        Vehicle v1= new Car();
        Vehicle v2= new Car();
        Vehicle v3= new Car();

        ParkingServiceImpl parkingLotService= new ParkingServiceImpl(new FarthestFirstStrategy());
        PaymentService paymentService= new PaymentServiceImpl();

        try {
            ParkingTicket parkingTicket1= parkingLotService.entry(v1);
            System.out.println("parking ticket 1: " +  parkingTicket1);
            System.out.println( "parking ticket 1 with vehicle id: " +  parkingTicket1.getVehicle().getId());

            ParkingTicket parkingTicket2= parkingLotService.entry(v2);
            parkingLotService.addWash(parkingTicket2);
            System.out.println("parking ticket 2: " +  parkingTicket2);
            System.out.println( "parking ticket 2 with vehicle id: " +  parkingTicket2.getVehicle().getId());

            parkingLotService.exit(v2, parkingTicket2);
            int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());

            System.out.println("cost: "+ cost);
            paymentService.acceptCashPayment(cost);

            ParkingTicket parkingTicket3= parkingLotService.entry(v3);
            System.out.println("parking ticket 3: " +  parkingTicket3);
            System.out.println("parking ticket 3 with vehicle id: " +  parkingTicket3.getVehicle().getId());

        } catch (SpotNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParkingSpotTypeNotFound e) {
            throw new RuntimeException(e);
        } catch (InvalidTicketException e) {
            throw new RuntimeException(e);
        }

    }
}


