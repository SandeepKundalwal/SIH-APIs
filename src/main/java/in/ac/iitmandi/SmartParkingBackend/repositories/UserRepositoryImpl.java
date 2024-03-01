package in.ac.iitmandi.SmartParkingBackend.repositories;

import in.ac.iitmandi.SmartParkingBackend.constants.DbConstants;
import in.ac.iitmandi.SmartParkingBackend.constants.QueryConstants;
import in.ac.iitmandi.SmartParkingBackend.model.GetUserParkingHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Resource(name = "smartParkingJdbcTemplateRead")
    private JdbcTemplate smartParkingJdbcTemplateRead;

    @Resource(name = "smartParkingJdbcTemplateWrite")
    private JdbcTemplate smartParkingJdbcTemplateWrite;

    @Override
    public List<GetUserParkingHistory> getUserParkingHistory(String UID) {
        try {

        } catch (DataAccessException ex){
            LOG.error("UserRepositoryImpl.getUserHistory.DataAccessException : ", ex);
        }
        return null;
    }
}
