package mainService;

import chopService.CartService;
import chopService.CartServiceImlp;
import dataService.DataService;
import dataService.DataServiceImpl;
import dataSets.UserCartDataSet;
import dataSets.UserDataSet;
import servlets.Servlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public final class MainServiceImpl implements MainService{

    private final String PERSISTENT_UNIT_NAME = "persistence";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
    private final EntityManager em = emf.createEntityManager();

    CartService cartService = new CartServiceImlp();
    DataService dataService = new DataServiceImpl();

    private static MainServiceImpl mainService;

    private MainServiceImpl(){
    }

    public static MainServiceImpl getMainServiceImpl() {
        if (mainService == null) {
            mainService = new MainServiceImpl();
        }
        return mainService;
    }

    public List<UserCartDataSet> getUserCart(String login){

        return cartService.getUserCart(em,login);
    }

    public List<UserDataSet> getUser(String login){

        return dataService.getUser(em,login);
    }

}
