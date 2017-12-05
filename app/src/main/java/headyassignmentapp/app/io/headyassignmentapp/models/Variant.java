package headyassignmentapp.app.io.headyassignmentapp.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by manish on 01/12/17.
 */

public class Variant implements Serializable {

    @Expose
    private int id;
    @Expose
    private String color;
    @Expose
    private int size;
    @Expose
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
