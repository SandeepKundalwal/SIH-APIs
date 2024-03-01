package in.ac.iitmandi.SmartParkingBackend.repositories;

import in.ac.iitmandi.SmartParkingBackend.model.GetNearbyParkingSpot;
import in.ac.iitmandi.SmartParkingBackend.model.GetParkingStationDetails;

import java.util.List;

public interface ParkingStationRepository {
    List<GetNearbyParkingSpot> findAllParkingSlots();
    GetParkingStationDetails getParkingStationDetails(String regNo);
}
