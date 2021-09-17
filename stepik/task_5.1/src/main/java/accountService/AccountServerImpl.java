package accountService;

public class AccountServerImpl implements AccountServer {

    private int userLimit = 10;

    public int getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }
}
