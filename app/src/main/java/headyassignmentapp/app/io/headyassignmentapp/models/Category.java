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
    private int categoryID;
    @Expose
    private String categoryName;
    @Expose
    private ArrayList<Product> products;
    @Expose
    private List<Category> elements;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
