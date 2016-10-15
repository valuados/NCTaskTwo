package by.nikonov.netcrackertaskone.classes.stone;

/**
 * Created by valua on 10/7/2016.
 */
public class SemipreciousStone extends Stone {
    private String colorFeatures;

    public String getColorFeatures() {
        return colorFeatures;
    }

    public void setColorFeatures(String colorFeatures) {
        this.colorFeatures = colorFeatures;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        /*carat;
    private String colour;
    private double solidity;//tverdost'
    private double density;//plotnost'
    private double price;*/
        result.append(", colour features- ")
                .append(colorFeatures)
                .append(super.toString());
        return result.toString();
    }
}
