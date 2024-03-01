package in.ac.iitmandi.SmartParkingBackend.service;

import in.ac.iitmandi.SmartParkingBackend.model.GetNearbyParkingSpot;
import in.ac.iitmandi.SmartParkingBackend.model.GetParkingStationDetails;

import java.util.List;

public interface ParkingService {
    List<GetNearbyParkingSpot> findNearbyParkingSpots(Double latitude, Double longitude, Double range);
    GetParkingStationDetails getParkingStationDetails(String regNo);
}
