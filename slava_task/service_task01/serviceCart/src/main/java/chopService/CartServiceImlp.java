package chopService;

import dao.DaoChop;
import dataSets.UserCartDataSet;

import javax.persistence.EntityManager;
import java.util.List;

public class CartServiceImlp implements CartService {

    public List<UserCartDataSet>  getUserCart(EntityManager em, String login){
        DaoChop dao = new DaoChop(em);
        return dao.getUserCart(login);
    }
}
