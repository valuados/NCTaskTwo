package by.nikonov.netcrackertaskone.classes.stone;

/**
 * Created by valua on 10/7/2016.
 */
public class PreciousStone extends Stone {
    private String syngony;

    public String getSyngony() {
        return syngony;
    }

    public void setSyngony(String syngony) {
        this.syngony = syngony;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(", syngony- ")
                .append(syngony)
                .append(super.toString());
        return result.toString();
    }
}
