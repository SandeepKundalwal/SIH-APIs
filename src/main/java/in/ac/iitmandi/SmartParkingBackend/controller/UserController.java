package in.ac.iitmandi.SmartParkingBackend.controller;

import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;
import in.ac.iitmandi.SmartParkingBackend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(ParkingController.class);
    @RequestMapping(value = "/getUserParkingHistory", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<GetUserParkingHistory> getNearbyParkingSpots(@RequestParam(value = "UID") String UID) {
        LOG.info(String.format("/user/getUserParkingHistory called : UID - %s", UID));
        List<GetUserParkingHistory> res = null;
        try {
            res = userService.getUserParkingHistory(UID);
        } catch (RestClientException ex) {
            LOG.error("PrivateController.getNearbyParkingSpots.RestClientException : ", ex);
        }
        return res;
    }

}
