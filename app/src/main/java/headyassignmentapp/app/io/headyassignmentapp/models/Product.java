package headyassignmentapp.app.io.headyassignmentapp.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manish on 01/12/17.
 */

public class Product implements Serializable {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private ArrayList<Variant> variants;
    @Expose
    private List<Product> elements;

    public int getProductID() {
        return id;
    }

    public void setProductID(int id) {
        this.id = id;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public ArrayList<Variant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<Variant> variants) {
        this.variants = variants;
    }

    public List<Product> getElements() {
        return elements;
    }

    public void setElements(List<Product> elements) {
        this.elements = elements;
    }
}
