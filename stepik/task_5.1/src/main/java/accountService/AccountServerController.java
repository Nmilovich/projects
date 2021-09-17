package accountService;

public class AccountServerController implements AccountServerControllerMBean {

    private AccountServer accountService;

    public AccountServerController(AccountServer accountService){
        this.accountService = accountService;

    }

    @Override
    public int getUserLimit() {
        return accountService.getUserLimit();
    }

    @Override
    public void setUserLimit(int userLimit) {
        accountService.setUserLimit(userLimit);
    }
}
