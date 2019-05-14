package fr.tblf.model;

import fr.tblf.SunburstUtils;

import java.util.Arrays;

public class Slice {
    private String name;
    private String color;
    private Slice[] children;
    private double size;

    public Slice() {
        this.color = SunburstUtils.getRandomColor();
    }

    public Slice(String name, String color) {
        this.name = name;
        this.color = color;
        children = new Slice[0];
    }

    public Slice(String name, double size) {
        this.name = name;
        this.size = size;
        this.color = SunburstUtils.getRandomColor();
    }

    public Slice(String name, Slice[] children, double size) {
        this.name = name;
        this.children = children;
        this.size = size;
        this.color = SunburstUtils.getRandomColor();
    }

    public Slice(String name, Slice[] children) {
        this.name = name;
        this.children = children;
        this.color = SunburstUtils.getRandomColor();
    }

    public Slice(String name, String color, double size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public Slice(String name, String color, Slice[] children) {
        this.name = name;
        this.color = color;
        this.children = children;
    }

    public Slice(String name, String color, Slice[] children, double size) {
        this.name = name;
        this.color = color;
        this.children = children;
        this.size = size;
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

    public Slice[] getChildren() {
        return children;
    }

    public void setChildren(Slice[] children) {
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
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getChildren(), slice.getChildren());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getChildren());
        temp = Double.doubleToLongBits(getSize());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
