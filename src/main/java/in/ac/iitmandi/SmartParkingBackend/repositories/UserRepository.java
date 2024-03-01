package in.ac.iitmandi.SmartParkingBackend.repositories;

import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;

import java.util.List;

public interface UserRepository {
    List<GetUserParkingHistory> getUserParkingHistory(String UID);
}
