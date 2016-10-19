package by.nikonov.netcrackertaskone.classes.factory;


import by.nikonov.netcrackertaskone.classes.stone.PreciousStone;
import by.nikonov.netcrackertaskone.classes.stone.SemipreciousStone;
import by.nikonov.netcrackertaskone.classes.stone.Stone;

import javax.servlet.ServletException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by valua on 10/8/2016.
 */
public class StoneFactory {

    public static Stone getStone(ResultSet res) throws ServletException {
        try{
            if(res.getString(8) == null){
                SemipreciousStone stone = new SemipreciousStone();
                stone.setName(res.getString(1));
                stone.setType(res.getString(2));
                stone.setSolidity(res.getDouble(3));
                stone.setDensity(res.getDouble(4));
                stone.setColour(res.getString(5));
                stone.setPrice(res.getDouble(6));
                stone.setCarat(res.getDouble(7));
                stone.setColorFeatures(res.getString(9));
                stone.setSonClass(2);

                return stone;
            }

            if(res.getString(9) == null){
                PreciousStone stone = new PreciousStone();
                stone.setName(res.getString(1));
                stone.setType(res.getString(2));
                stone.setSolidity(res.getDouble(3));
                stone.setDensity(res.getDouble(4));
                stone.setColour(res.getString(5));
                stone.setPrice(res.getDouble(6));
                stone.setCarat(res.getDouble(7));
                stone.setSyngony(res.getString(8));
                stone.setSonClass(1);


                return  stone;
            }
        }catch (SQLException e) {
                throw new ServletException(e);
            }

        return null;
    }
}
