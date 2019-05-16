package fr.tblf.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.tblf.SunburstUtils;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Slice {
    private String name;
    private String color;
    private double size;
    private ArrayList<Slice> children;

    public Slice() {
        this.color = SunburstUtils.getRandomColor();
    }

    public Slice(String name) {
        this.name = name;
    }

    public Slice(String name, String color) {
        this.name = name;
        this.color = color;
        children = new ArrayList<>();
    }

    public Slice(String name, double size) {
        this.name = name;
        this.size = size;
        this.color = SunburstUtils.getRandomColor();
        children = new ArrayList<>();
    }

    public Slice(String name, String color, double size) {
        this.name = name;
        this.color = color;
        this.size = size;
        children = new ArrayList<>();
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Slice> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Slice> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slice)) return false;

        Slice slice = (Slice) o;

        if (Double.compare(slice.getSize(), getSize()) != 0) return false;
        if (getName() != null ? !getName().equals(slice.getName()) : slice.getName() != null) return false;
        if (getColor() != null ? !getColor().equals(slice.getColor()) : slice.getColor() != null) return false;
        return getChildren() != null ? getChildren().equals(slice.getChildren()) : slice.getChildren() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        temp = Double.doubleToLongBits(getSize());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getChildren() != null ? getChildren().hashCode() : 0);
        return result;
    }
}
