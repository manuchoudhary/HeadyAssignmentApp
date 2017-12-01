package headyassignmentapp.app.io.headyassignmentapp.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by manish on 01/12/17.
 */

public class Variant implements Serializable {

    @Expose
    private int variantID;
    @Expose
    private String variantColor;
    @Expose
    private int variantSize;
    @Expose
    private double variantPrice;

    public int getVariantID() {
        return variantID;
    }

    public void setVariantID(int variantID) {
        this.variantID = variantID;
    }

    public String getVariantColor() {
        return variantColor;
    }

    public void setVariantColor(String variantColor) {
        this.variantColor = variantColor;
    }

    public int getVariantSize() {
        return variantSize;
    }

    public void setVariantSize(int variantSize) {
        this.variantSize = variantSize;
    }

    public double getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(double variantPrice) {
        this.variantPrice = variantPrice;
    }
}
