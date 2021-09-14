package dao;

import dataSets.UserDataSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DaoData {

    private final EntityManager em;

    public DaoData(EntityManager em) {
        this.em = em;
    }

    public List<UserDataSet> getUser(String login){
        Query query = em.createQuery("from UserDataSet where login =: login");
        query.setParameter("login",login);

        return  (List<UserDataSet>)query.getResultList();
    }

}
