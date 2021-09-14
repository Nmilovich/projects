package dataService;

import dao.Dao;
import dataSets.UserDataSet;

import javax.persistence.EntityManager;
import java.util.List;

public class DataServiceImpl implements  DataService{

    public List<UserDataSet> getUser(EntityManager em, String login){
        Dao dao = new Dao(em);
        return dao.getUser(login);
    }
}
