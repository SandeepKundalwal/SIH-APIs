package in.ac.iitmandi.SmartParkingBackend.repositories;

import in.ac.iitmandi.SmartParkingBackend.constants.DbConstants;
import in.ac.iitmandi.SmartParkingBackend.constants.QueryConstants;
import in.ac.iitmandi.SmartParkingBackend.model.GetNearbyParkingSpot;
import in.ac.iitmandi.SmartParkingBackend.model.GetParkingStationDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ParkingStationRepositoryImpl implements ParkingStationRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ParkingStationRepositoryImpl.class);

    @Resource(name = "smartParkingJdbcTemplateRead")
    private JdbcTemplate smartParkingJdbcTemplateRead;

    @Resource(name = "smartParkingJdbcTemplateWrite")
    private JdbcTemplate smartParkingJdbcTemplateWrite;

    @Override
    public List<GetNearbyParkingSpot> findAllParkingSlots() {
        List<GetNearbyParkingSpot> allParkingSpots = new ArrayList<>();
        try {
            String SQLQuery = QueryConstants.GET_COORDINATES;
            List<Map<String, Object>> allParkingSpotsQueryResponse = smartParkingJdbcTemplateRead.queryForList(SQLQuery);
            for(Map<String, Object> parkingSpot : allParkingSpotsQueryResponse) {
                GetNearbyParkingSpot getNearbyParkingSpot = new GetNearbyParkingSpot();
                getNearbyParkingSpot.setRegNo(parkingSpot.get(DbConstants.ParkingStationInfo.REG_NO) != null ? (String) parkingSpot.get(DbConstants.ParkingStationInfo.REG_NO) : null);
                getNearbyParkingSpot.setLatitude(parkingSpot.get(DbConstants.ParkingStationInfo.LATITUDE) != null ? (Double) parkingSpot.get(DbConstants.ParkingStationInfo.LATITUDE) : null);
                getNearbyParkingSpot.setLongitude(parkingSpot.get(DbConstants.ParkingStationInfo.LONGITUDE) != null ? (Double) parkingSpot.get(DbConstants.ParkingStationInfo.LONGITUDE) : null);
                allParkingSpots.add(getNearbyParkingSpot);
            }
        } catch (DataAccessException ex) {
            LOG.error("ParkingStationRepositoryImpl.findAllParkingSlots.DataAccessException : ", ex);
        }
        return allParkingSpots;
    }

    @Override
    public GetParkingStationDetails getParkingStationDetails(String regNo){
        GetParkingStationDetails currentParkingStationDetail = new GetParkingStationDetails();
        try{
            String SQLQuery = QueryConstants.GET_PARKING_STATION_DETAILS + "'" + regNo + "';";
            Map<String, Object> currentParkingStationDetailsQueryResponse = smartParkingJdbcTemplateRead.queryForMap(SQLQuery);
            currentParkingStationDetail.setRegNo(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.REG_NO) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.REG_NO) : null);
            currentParkingStationDetail.setParkingStationName(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.PARKING_STATION_NAME) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.PARKING_STATION_NAME) : null);
            currentParkingStationDetail.setContactNo(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.CONTACT_NO) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.CONTACT_NO) : null);
            currentParkingStationDetail.setArea(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.AREA) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.AREA) : null);
            currentParkingStationDetail.setCity(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.CITY) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.CITY) : null);
            currentParkingStationDetail.setPincode(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.PINCODE) != null ? (Integer) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.PINCODE) : null);
            currentParkingStationDetail.setDistrict(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.DISTRICT) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.DISTRICT) : null);
            currentParkingStationDetail.setState(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.STATE) != null ? (String) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationInfo.STATE) : null);
            currentParkingStationDetail.setCurrentBikePrice(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.CURRENT_BIKE_PRICE) != null ? (BigDecimal) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.CURRENT_BIKE_PRICE) : null);
            currentParkingStationDetail.setCurrentCarPrice(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.CURRENT_CAR_PRICE) != null ? (BigDecimal) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.CURRENT_CAR_PRICE) : null);
            currentParkingStationDetail.setAvailableBikeSpaces(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.AVAILABLE_BIKE_SPACES) != null ? (Integer) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.AVAILABLE_BIKE_SPACES) : null);
            currentParkingStationDetail.setAvailableCarSpaces(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.AVAILABLE_CAR_SPACES) != null ? (Integer) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.AVAILABLE_CAR_SPACES) : null);
            currentParkingStationDetail.setTotalBikeSpaces(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.TOTAL_BIKE_SPACES) != null ? (Integer) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.TOTAL_BIKE_SPACES) : null);
            currentParkingStationDetail.setTotalCarSpaces(currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.TOTAL_CAR_SPACES) != null ? (Integer) currentParkingStationDetailsQueryResponse.get(DbConstants.ParkingStationStatus.TOTAL_CAR_SPACES) : null);
        } catch (DataAccessException ex){
            LOG.error("ParkingStationRepositoryImpl.getParkingStationDetails.DataAccessException : ", ex);
        }
        return currentParkingStationDetail;
    }
}
