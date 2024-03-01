package in.ac.iitmandi.SmartParkingBackend.controller;

import in.ac.iitmandi.SmartParkingBackend.model.GetNearbyParkingSpot;
import in.ac.iitmandi.SmartParkingBackend.model.GetParkingStationDetails;
import in.ac.iitmandi.SmartParkingBackend.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingService parkingService;
    private static final Logger LOG = LoggerFactory.getLogger(ParkingController.class);
    @RequestMapping(value = "/getNearbyParkingSpots", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<GetNearbyParkingSpot> getNearbyParkingSpots(@RequestParam(value = "latitude") String latitude,
                                                  @RequestParam(value = "longitude") String longitude,
                                                  @RequestParam(value = "range", required = false, defaultValue = "2.0") String nearbyRadius) {
        LOG.info(String.format("/parking/getNearbyParkingSpots called : latitude - %s, longitude - %s, nearbyRadius - %s", latitude, longitude, nearbyRadius));
        List<GetNearbyParkingSpot> res = null;
        try {
            res = parkingService.findNearbyParkingSpots(Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(nearbyRadius));
        } catch (RestClientException ex) {
            LOG.error("PrivateController.getNearbyParkingSpots.RestClientException : ", ex);
        }
        return res;
    }

    @RequestMapping(value = "/getParkingStationDetails", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public GetParkingStationDetails getParkingStationDetails(@RequestParam(value = "regNo") String regNo) {
        LOG.info(String.format("/parking/getParkingStationDetails called : regNo - %s", regNo));
        GetParkingStationDetails getParkingStationDetails = new GetParkingStationDetails();
        try {
            getParkingStationDetails = parkingService.getParkingStationDetails(regNo);
        } catch (RestClientException ex) {
            LOG.error("PrivateController.getParkingStationDetails.RestClientException : ", ex);
        }
        return getParkingStationDetails;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String test() {
        return "Hello world!";
    }
}
