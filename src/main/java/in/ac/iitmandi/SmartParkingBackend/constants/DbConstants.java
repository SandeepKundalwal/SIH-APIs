package in.ac.iitmandi.SmartParkingBackend.constants;

public class DbConstants {

    public static class ParkingStationInfo {
        public static final String REG_NO = "reg_no";
        public static final String PARKING_STATION_NAME = "parking_station_name";
        public static final String CONTACT_NO = "contact_no";
        public static final String LATITUDE = "LATITUDE";
        public static final String LONGITUDE = "LONGITUDE";
        public static final String CAR_BASE_FARE = "car_base_fare";
        public static final String BIKE_BASE_FARE = "bike_base_fare";
        public static final String AREA = "area";
        public static final String CITY = "city";
        public static final String PINCODE = "pin_code";
        public static final String DISTRICT = "district";
        public static final String STATE = "state";
    }

    public static class ParkingStationStatus {
        public static final String REG_NO = "reg_no";
        public static final String CURRENT_BIKE_PRICE = "current_bike_price";
        public static final String CURRENT_CAR_PRICE = "current_car_price";
        public static final String TOTAL_BIKE_SPACES = "total_bike_spaces";
        public static final String TOTAL_CAR_SPACES = "total_car_spaces";
        public static final String AVAILABLE_BIKE_SPACES = "available_bike_spaces";
        public static final String AVAILABLE_CAR_SPACES = "available_car_spaces";
    }
}
