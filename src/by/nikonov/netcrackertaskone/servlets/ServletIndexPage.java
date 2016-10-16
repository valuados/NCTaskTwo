package by.nikonov.netcrackertaskone.servlets;

import by.nikonov.netcrackertaskone.classes.connection.СonnectionGiver;
import by.nikonov.netcrackertaskone.classes.factory.StoneFactory;
import by.nikonov.netcrackertaskone.classes.necklace.Necklace;
import by.nikonov.netcrackertaskone.classes.stone.Stone;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by valua on 10/13/2016.
 */
public class ServletIndexPage extends HttpServlet {

    private  static  final long serialVersionUID = 1L;
    public static final String ALL_STONES_SELECT ="SELECT st.STONE_NAME,st.STONE_TYPE," +
            " st.STONE_SOLIDITY, st.STONE_DENCITY," +
            "  st.STONE_COLOUR, st.STONE_PRICE, st.STONE_CARAT, pr.SYNGONY," +
            "  sem.COLOUR_FEATURES from STONE st LEFT OUTER JOIN PRECIOUS_STONE pr ON" +
            "  st.STONE_ID=pr.STONE_ID LEFT OUTER JOIN SEMIPRECIOUS_STONE sem" +
            "    ON st.STONE_ID= sem.STONE_ID;";

    public static final String SELECT_PRICE = "SELECT STONE_PRICE, STONE_CARAT from STONE;";

    public static final String SELECT_WEIGHT = "SELECT SUM(STONE_CARAT) from STONE;";

    public static final String SHOW="show",
            SHOW_SORTED_BY_WEIGHT="show by weight",
            SHOW_SORTED_BY_PRICE="show by price",
            SHOW_GENERAL_PRICE="price",
            SHOW_GENERAL_WEIGHT="weight";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        request.getParameter("command");
        Necklace necklace;
        switch (request.getParameter("command")){
            case SHOW:
                necklace = new Necklace();
                createNecklace(necklace);
                request.removeAttribute("necklace");
                request.setAttribute("necklace", necklace.getNecklace());
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

                break;
            case SHOW_SORTED_BY_WEIGHT:
                necklace = new Necklace();
                createNecklace(necklace);
                necklace.sortByCarat();
                request.removeAttribute("necklace");
                request.setAttribute("necklace", necklace.getNecklace());
                request.
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

                break;
            case SHOW_SORTED_BY_PRICE:
                necklace = new Necklace();
                createNecklace(necklace);
                necklace.sortByCost();
                request.removeAttribute("necklace");
                request.setAttribute("necklace", necklace.getNecklace());
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

                break;
            case SHOW_GENERAL_PRICE:

                double price = countPrice();
                write(response,"price",price);
                break;

            case SHOW_GENERAL_WEIGHT:
                double weight = countWeight();
                write(response,"weight",weight);
                break;

        }

    }

    private double countWeight() {
        double result=0;

        try{
            Connection conn = СonnectionGiver.getInstance().getConnection();

            Statement statement = conn.createStatement();

            ResultSet res = statement.executeQuery(SELECT_WEIGHT);
                result+=res.getDouble(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    private void createNecklace(Necklace necklace) throws ServletException {
        try{
            Connection conn = СonnectionGiver.getInstance().getConnection();

            Statement statement = conn.createStatement();

            ResultSet res = statement.executeQuery(ALL_STONES_SELECT);

            while(res.next()){
                Stone stone = StoneFactory.getStone(res);
                necklace.setNecklace(stone);
            }
            try {
                conn.close();
            } catch(SQLException e ){
                e.printStackTrace();
            }

        }
        catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private Double countPrice(){
        double result=0;

        try{
        Connection conn = СonnectionGiver.getInstance().getConnection();

        Statement statement = conn.createStatement();

        ResultSet res = statement.executeQuery(SELECT_PRICE);
        while(res.next()){
            result+=res.getDouble(1)*res.getDouble(2);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return result;
    }

    private void write(HttpServletResponse response, String str, double param) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        Map<String,Double> map = new HashMap<>();
        map.put(str, param);
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }

}
