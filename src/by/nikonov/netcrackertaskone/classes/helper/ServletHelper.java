package by.nikonov.netcrackertaskone.classes.helper;

import by.nikonov.netcrackertaskone.classes.connection.СonnectionGiver;
import by.nikonov.netcrackertaskone.classes.stone.PreciousStone;
import by.nikonov.netcrackertaskone.classes.stone.SemipreciousStone;
import by.nikonov.netcrackertaskone.classes.stone.Stone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by valua on 10/19/2016.
 */
public class ServletHelper
{

    public static final String STONE_INSERT = "INSERT INTO stone(STONE_NAME,STONE_TYPE," +
            "STONE_COLOUR,STONE_SOLIDITY,STONE_DENCITY" +
            ", STONE_CARAT,STONE_PRICE) VALUES (?,?,?,?,?,?,?)";
    public static final String STONE_SELECT_ID = "SELECT STONE_ID FROM stone WHERE " +
            "STONE_NAME = ? and STONE_TYPE = ? and " +
            "STONE_COLOUR = ? and STONE_SOLIDITY = ? " +
            "and STONE_DENCITY = ? and STONE_CARAT = ?" +
            "and STONE_PRICE = ?";
    public static final String SEMIPRECIOUS_STONE_INSERT = "INSERT INTO semiprecious_stone(STONE_ID, COLOUR_FEATURES) VALUES (?,?)";
    public static final String PRECIOUS_STONE_INSERT = "INSERT INTO precious_stone(STONE_ID, SYNGONY) VALUES (?,?)";


    public void addStone(String dataType, HttpServletRequest request, HttpServletResponse response){
        Connection conn = СonnectionGiver.getInstance().getConnection();
        int id = 0;

        try {
            PreparedStatement statement = conn.prepareStatement(STONE_INSERT);

            switch(dataType) {
                case "semiprecious":
                    SemipreciousStone semipreciousStone = new SemipreciousStone();
                    createSemipresiousStone(semipreciousStone,request);

                    buildStatement(statement,semipreciousStone);
                    statement.executeUpdate();


                    statement = conn.prepareStatement(STONE_SELECT_ID);
                    buildStatement(statement,semipreciousStone);

                    ResultSet SemipreciousRes = statement.executeQuery();
                    if(SemipreciousRes.next())
                        id = SemipreciousRes.getInt(1);

                    statement = conn.prepareStatement(SEMIPRECIOUS_STONE_INSERT);
                    statement.setInt(1,id);
                    statement.setString(2,semipreciousStone.getColorFeatures());
                    statement.executeUpdate();

                    break;
                case "precious":
                    PreciousStone preciousStone = new PreciousStone();
                    createPresiousStone(preciousStone,request);

                    buildStatement(statement,preciousStone);
                    statement.executeUpdate();


                    statement = conn.prepareStatement(STONE_SELECT_ID);
                    buildStatement(statement,preciousStone);

                    ResultSet preciousRes = statement.executeQuery();
                    if(preciousRes.next())
                        id = preciousRes.getInt(1);

                    statement = conn.prepareStatement(PRECIOUS_STONE_INSERT);
                    statement.setInt(1,id);
                    statement.setString(2,preciousStone.getSyngony());
                    statement.executeUpdate();

                    break;
            }


            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void createSemipresiousStone(SemipreciousStone stone, HttpServletRequest request){
        stone.setName(request.getParameter("sname"));
        stone.setType(request.getParameter("stype"));
        stone.setColorFeatures(request.getParameter("sfeature"));
        stone.setSolidity(Double.parseDouble(request.getParameter("ssolidity")));
        stone.setColour(request.getParameter("scolour"));
        stone.setDensity(Double.parseDouble(request.getParameter("sdencity")));
        stone.setCarat(Double.parseDouble(request.getParameter("scarat")));
        stone.setPrice(Double.parseDouble(request.getParameter("sprice")));

    }
    private void createPresiousStone(PreciousStone stone, HttpServletRequest request){
        stone.setName(request.getParameter("sname"));
        stone.setType(request.getParameter("stype"));
        stone.setSyngony(request.getParameter("ssyngony"));
        stone.setSolidity(Double.parseDouble(request.getParameter("ssolidity")));
        stone.setColour(request.getParameter("scolour"));
        stone.setDensity(Double.parseDouble(request.getParameter("sdencity")));
        stone.setCarat(Double.parseDouble(request.getParameter("scarat")));
        stone.setPrice(Double.parseDouble(request.getParameter("sprice")));

    }
    private void buildStatement(PreparedStatement statement, Stone stone){
        try {
            statement.setString(1,stone.getName());
            statement.setString(2,stone.getType());
            statement.setString(3,stone.getColour());
            statement.setDouble(4,stone.getSolidity());
            statement.setDouble(5,stone.getDensity());
            statement.setDouble(6,stone.getCarat());
            statement.setDouble(7,stone.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
