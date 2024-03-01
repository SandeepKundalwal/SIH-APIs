package in.ac.iitmandi.SmartParkingBackend.service;

import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;
import in.ac.iitmandi.SmartParkingBackend.repositories.UserRepository;
import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GetUserParkingHistory> getUserParkingHistory(String UID){
        List<GetUserParkingHistory> userParkingHistory = null;
        try {

        } catch (Exception ex) {
            LOG.info("UserServiceImpl.getUserParkingHistory.Exception : ", ex);
        }
        return userParkingHistory;
    }
}
