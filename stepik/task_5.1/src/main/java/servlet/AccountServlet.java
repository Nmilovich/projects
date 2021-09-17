package servlet;

import accountService.AccountServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AccountServlet  extends HttpServlet {

    static final Logger logger = LogManager.getLogger(AccountServlet.class.getName());
    private AccountServer accountService;
    
    public static final String PAGE_URL = "/admin";

    public AccountServlet(AccountServer accountService){
        this.accountService = accountService;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().println(accountService.getUserLimit());

        logger.info("Limit: {}", accountService.getUserLimit());

    }
}
