package dataService;

import dao.DaoData;
import dataSets.UserDataSet;

import javax.persistence.EntityManager;
import java.util.List;

public class DataServiceImpl implements  DataService{

    public List<UserDataSet> getUser(EntityManager em, String login){
        DaoData dao = new DaoData(em);
        return dao.getUser(login);
    }
}
