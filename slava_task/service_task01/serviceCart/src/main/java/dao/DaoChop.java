package dao;

import dataSets.UserCartDataSet;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DaoChop {

    private final EntityManager em;

    public DaoChop(EntityManager em) {
        this.em = em;
    }

    public List<UserCartDataSet> getUserCart(String login){
        Query query = em.createQuery("from UserCartDataSet where login =: login");
        query.setParameter("login",login);

        return  (List<UserCartDataSet>)query.getResultList();
    }

}
