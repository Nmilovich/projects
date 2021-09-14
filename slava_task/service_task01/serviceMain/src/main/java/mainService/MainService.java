package mainService;

import dataSets.UserCartDataSet;
import dataSets.UserDataSet;

import java.util.List;

public interface MainService {

    public List<UserCartDataSet> getUserCart(String login);
    public List<UserDataSet> getUser(String login);
}
