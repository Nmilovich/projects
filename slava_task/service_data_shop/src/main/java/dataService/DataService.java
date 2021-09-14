package dataService;

import dataSets.UserDataSet;

import javax.persistence.EntityManager;
import java.util.List;

public interface DataService {

    public List<UserDataSet> getUser(EntityManager em, String login);
}
