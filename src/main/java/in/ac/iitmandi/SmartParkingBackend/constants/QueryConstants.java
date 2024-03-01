package in.ac.iitmandi.SmartParkingBackend.constants;

public class QueryConstants {
    public static final String GET_COORDINATES = "SELECT reg_no, ST_X(coordinate) AS LATITUDE, ST_Y(coordinate) AS LONGITUDE FROM ParkingStationInfo;";

    public static final String GET_PARKING_STATION_DETAILS = "Select ParkingStationInfo.reg_no, ParkingStationInfo.parking_station_name, ParkingStationInfo.contact_no, ParkingStationInfo.area, ParkingStationInfo.city, ParkingStationInfo.pin_code, ParkingStationInfo.district, ParkingStationInfo.state, ParkingStationStatus.current_bike_price, ParkingStationStatus.current_car_price, ParkingStationStatus.total_car_spaces,ParkingStationStatus.total_bike_spaces, ParkingStationStatus.available_car_spaces, ParkingStationStatus.available_bike_spaces from ParkingStationInfo, ParkingStationStatus where ParkingStationInfo.reg_no=ParkingStationStatus.reg_no AND ParkingStationInfo.reg_no=";


}
