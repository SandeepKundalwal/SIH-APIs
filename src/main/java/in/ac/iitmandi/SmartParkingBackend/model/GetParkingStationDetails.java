package in.ac.iitmandi.SmartParkingBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class GetParkingStationDetails {
    @JsonProperty("regNo")
    private String regNo;

    @JsonProperty("parkingStationName")
    private String parkingStationName;

    @JsonProperty("contactNo")
    private String contactNo;

    @JsonProperty("area")
    private String area;

    @JsonProperty("pincode")
    private Integer pincode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("district")
    private String district;

    @JsonProperty("state")
    private String state;

    @JsonProperty("currentBikePrice")
    private BigDecimal currentBikePrice;

    @JsonProperty("currentCarPrice")
    private BigDecimal currentCarPrice;

    @JsonProperty("availableBikeSpaces")
    private Integer availableBikeSpaces;

    @JsonProperty("availableCarSpaces")
    private Integer availableCarSpaces;

    @JsonProperty("totalBikeSpaces")
    private Integer totalBikeSpaces;

    @JsonProperty("totalCarSpaces")
    private Integer totalCarSpaces;

    public String getRegNo() {
        return regNo;
    }

    public String getParkingStationName() {
        return parkingStationName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getArea() {
        return area;
    }

    public Integer getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getCurrentBikePrice() {
        return currentBikePrice;
    }

    public BigDecimal getCurrentCarPrice() {
        return currentCarPrice;
    }

    public Integer getAvailableBikeSpaces() {
        return availableBikeSpaces;
    }

    public Integer getAvailableCarSpaces() {
        return availableCarSpaces;
    }

    public Integer getTotalBikeSpaces() {
        return totalBikeSpaces;
    }

    public Integer getTotalCarSpaces() {
        return totalCarSpaces;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setParkingStationName(String parkingStationName) {
        this.parkingStationName = parkingStationName;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCurrentBikePrice(BigDecimal currentBikePrice) {
        this.currentBikePrice = currentBikePrice;
    }

    public void setCurrentCarPrice(BigDecimal currentCarPrice) {
        this.currentCarPrice = currentCarPrice;
    }

    public void setAvailableBikeSpaces(Integer availableBikeSpaces) {
        this.availableBikeSpaces = availableBikeSpaces;
    }

    public void setAvailableCarSpaces(Integer availableCarSpaces) {
        this.availableCarSpaces = availableCarSpaces;
    }

    public void setTotalBikeSpaces(Integer totalBikeSpaces) {
        this.totalBikeSpaces = totalBikeSpaces;
    }

    public void setTotalCarSpaces(Integer totalCarSpaces) {
        this.totalCarSpaces = totalCarSpaces;
    }

    @Override
    public String toString() {
        return "GetParkingStationDetails{" +
                "regNo='" + regNo + '\'' +
                ", parkingStationName='" + parkingStationName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", area='" + area + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", currentBikePrice=" + currentBikePrice +
                ", currentCarPrice=" + currentCarPrice +
                ", availableBikeSpaces=" + availableBikeSpaces +
                ", availableCarSpaces=" + availableCarSpaces +
                ", totalBikeSpaces=" + totalBikeSpaces +
                ", totalCarSpaces=" + totalCarSpaces +
                '}';
    }
}
