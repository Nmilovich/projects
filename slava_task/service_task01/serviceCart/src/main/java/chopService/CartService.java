package chopService;

import dataSets.UserCartDataSet;


import javax.persistence.EntityManager;
import java.util.List;

public interface CartService {

    public List<UserCartDataSet>  getUserCart(EntityManager em, String login);
}
