package headyassignmentapp.app.io.headyassignmentapp.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shirishtulsian on 01/12/17.
 */

public class Category implements Serializable {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private ArrayList<Product> products;
    @Expose
    private List<Category> elements;

    public int getCategoryID() {
        return id;
    }

    public void setCategoryID(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Category> getElements() {
        return elements;
    }

    public void setElements(List<Category> elements) {
        this.elements = elements;
    }
}
