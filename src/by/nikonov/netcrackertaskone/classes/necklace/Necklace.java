package by.nikonov.netcrackertaskone.classes.necklace;


import by.nikonov.netcrackertaskone.classes.comparators.CaratComparator;
import by.nikonov.netcrackertaskone.classes.comparators.CostComparator;
import by.nikonov.netcrackertaskone.classes.stone.Stone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by valua on 10/8/2016.
 */
public class Necklace {
    private List<Stone> necklace;

    public Necklace() {
        this.necklace = new ArrayList<>();
    }

    public Stone getNecklace(int i) {
        if(i< necklace.size())
        return necklace.get(i);
        else
            return null;
    }

    public List<Stone> getNecklace() {
        return necklace;
    }

    public void setNecklace(List<Stone> necklace) {
        this.necklace = necklace;
    }

    public void setNecklace(Stone stone) {
        this.necklace.add(stone);
    }

    public void sortByCarat(){ Collections.sort(necklace, new CaratComparator());
    }

    public void sortByCost(){
        Collections.sort(necklace, new CostComparator());
    }

    public String showInThePriceRange(double min, double max){
        int i=0;
        StringBuilder result=new StringBuilder();

        this.sortByCost();
        result.append("Necklace with price range from "+ min +"$ to "+max+"$:\n");
        while (necklace.get(i).getCarat()*necklace.get(i).getPrice()>=min &&
                necklace.get(i).getCarat()*necklace.get(i).getPrice()<=max && i<necklace.size()){
            double cost = necklace.get(i).getCarat()*necklace.get(i).getPrice();
            result.append("Price: "+ cost +"$"+'\n');
            result.append(necklace.get(i).toString()+ '\n');
            i++;
        }
        return result.toString();
    }

     public double countWeight(){
        return necklace.stream().mapToDouble(Stone::getCarat).sum();
     }

    public double countPrise(){
        return necklace.stream().mapToDouble(Stone::getPrice).sum();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Stone s: necklace){
            result.append(s.toString());
            result.append('\n');
        }
        return  result.toString();

    }

}
