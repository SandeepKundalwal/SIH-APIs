package in.ac.iitmandi.SmartParkingBackend.service;

import in.ac.iitmandi.SmartParkingBackend.model.GetParkingStationDetails;
import in.ac.iitmandi.SmartParkingBackend.repositories.ParkingStationRepository;
import in.ac.iitmandi.SmartParkingBackend.model.GetNearbyParkingSpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static in.ac.iitmandi.SmartParkingBackend.constants.Constants.EarthRadius;

@Service
public class ParkingServiceImpl implements ParkingService {

    private static final Logger LOG = LoggerFactory.getLogger(ParkingServiceImpl.class);
    @Autowired
    private ParkingStationRepository parkingStationRepository;

    @Override
    public List<GetNearbyParkingSpot> findNearbyParkingSpots(Double latitude, Double longitude, Double range) {
        List<GetNearbyParkingSpot> nearbyParkingSlots = new ArrayList<>();
        try {
            List<GetNearbyParkingSpot> allParkingSlots = parkingStationRepository.findAllParkingSlots();
            for(GetNearbyParkingSpot parkingSlot : allParkingSlots){
                if(HaversineDistance(latitude, longitude, parkingSlot.getLatitude(), parkingSlot.getLongitude()) <= range){
                    nearbyParkingSlots.add(parkingSlot);
                }
            }
        } catch (Exception ex) {
            LOG.info("ParkingServiceImpl.findNearbyParkingSpots.Exception : ", ex);
        }
        return nearbyParkingSlots;
    }

    /**
     * Implementation of Haversine Distance Algorithm between two places
     */
    private Double HaversineDistance(Double userLatitude, Double userLongitude, Double currentLatitude, Double currentLongitude) {
        double deltaLatitude = Math.toRadians(currentLatitude - userLatitude);
        double deltaLongitude = Math.toRadians(currentLongitude - userLongitude);

        double haversineFormula = Math.sin(deltaLatitude / 2.0) * Math.sin(deltaLatitude / 2.0)
                + Math.cos(Math.toRadians(userLatitude)) * Math.cos(Math.toRadians(currentLatitude)) * Math.sin(deltaLongitude / 2.0) * Math.sin(deltaLongitude / 2.0);

        return EarthRadius * (2 * Math.atan2(Math.sqrt(haversineFormula), Math.sqrt(1 - haversineFormula)));
    }


    @Override
    public GetParkingStationDetails getParkingStationDetails(String regNo){
        GetParkingStationDetails getParkingStationDetails = new GetParkingStationDetails();
        try{
            getParkingStationDetails = parkingStationRepository.getParkingStationDetails(regNo);
        } catch (Exception ex){
            LOG.info("ParkingServiceImpl.getParkingStationDetails.Exception : ", ex);
        }
        return getParkingStationDetails;
    }
}
