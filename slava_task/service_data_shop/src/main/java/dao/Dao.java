package dao;

import dataSets.UserCartDataSet;
import dataSets.UserDataSet;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Dao {

    private final EntityManager em;

    public Dao(EntityManager em) {
        this.em = em;
    }

    public List<UserCartDataSet> getUserCart(String login){
        Query query = em.createQuery("from UserCartDataSet where login =: login");
        query.setParameter("login",login);

        return  (List<UserCartDataSet>)query.getResultList();
    }

    public List<UserDataSet> getUser(String login){
        Query query = em.createQuery("from UserDataSet where login =: login");
        query.setParameter("login",login);

        return  (List<UserDataSet>)query.getResultList();
    }

}
