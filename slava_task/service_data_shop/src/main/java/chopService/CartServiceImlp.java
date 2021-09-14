package chopService;

import dao.Dao;
import dataSets.UserCartDataSet;
import dataSets.UserDataSet;

import javax.persistence.EntityManager;
import java.util.List;

public class CartServiceImlp implements CartService {

    public List<UserCartDataSet>  getUserCart(EntityManager em, String login){
        Dao dao = new Dao(em);
        return dao.getUserCart(login);
    }
}
