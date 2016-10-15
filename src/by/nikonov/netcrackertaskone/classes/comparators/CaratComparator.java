package by.nikonov.netcrackertaskone.classes.comparators;


import by.nikonov.netcrackertaskone.classes.stone.Stone;

import java.util.Comparator;

/**
 * Created by valua on 10/8/2016.
 */
public class CaratComparator implements Comparator<Stone> {
    @Override
    public int compare(Stone a, Stone b) {
        return a.getCarat() < b.getCarat() ?
                -1 : a.getCarat() == b.getCarat() ? 0 : 1;
    }
}
