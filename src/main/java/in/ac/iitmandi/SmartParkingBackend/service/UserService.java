package in.ac.iitmandi.SmartParkingBackend.service;

import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;

import java.util.List;

public interface UserService {
    List<GetUserParkingHistory> getUserParkingHistory(String UID);
}
