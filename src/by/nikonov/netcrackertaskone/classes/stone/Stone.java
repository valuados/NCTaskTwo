package by.nikonov.netcrackertaskone.classes.stone;

/**
 * Created by valua on 10/7/2016.
 */
public abstract class Stone {
    private double carat;
    private String colour;
    private double solidity;
    private double density;
    private double price;
    private String name;
    private String type;
    private int sonClass;

    public Integer getSonClass() {
        return sonClass;
    }

    public void setSonClass(int sonClass) {
        this.sonClass = sonClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCarat() {
        return carat;
    }

    public void setCarat(double carat) {
        this.carat = carat;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getSolidity() {
        return solidity;
    }

    public void setSolidity(double solidity) {
        this.solidity = solidity;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name)
                .append(": type- ")
                .append(type)
                .append(", colour- ")
                .append(colour)
                .append(", solidity- ")
                .append(solidity)
                .append(", density- ")
                .append(density)
                .append(", weight- ")
                .append(carat)
                .append(" carat, average price per carat- ")
                .append(getPrice())
                .append("$.");
        return result.toString();
    }
}
