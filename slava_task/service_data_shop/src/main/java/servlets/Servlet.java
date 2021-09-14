package servlets;

import dataSets.UserCartDataSet;
import dataSets.UserDataSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mainService.MainService;
import pageGenerator.PageGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servlet extends HttpServlet {
    private final MainService mainService;

    public Servlet(MainService mainService){
        this.mainService = mainService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");

        List<UserCartDataSet> userCartDataSets = mainService.getUserCart(login);
        List<UserDataSet> userDataSets = mainService.getUser(login);

        Map<String, Object> pageVariables = createPageVariablesMap(req, userCartDataSets, userDataSets);

        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().println(PageGenerator.instance().getPage("index.html", pageVariables));

    }
    private static Map<String, Object> createPageVariablesMap(HttpServletRequest req, List<UserCartDataSet> userCartDataSets,  List<UserDataSet> userDataSets)  {
        Map<String, Object> pageMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (UserCartDataSet uc : userCartDataSets){
            sb.append(uc.getThing()).append(" (").append(uc.getCount()).append(") ");
        }
        for (UserDataSet ud : userDataSets){
            pageMap.put("Login", ud.getLogin());
            pageMap.put("number", ud.getPhoneNumber());
        }
        pageMap.put("Cart", sb);


        return pageMap;
    }


}
