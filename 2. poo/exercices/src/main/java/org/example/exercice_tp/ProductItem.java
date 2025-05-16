package org.example.exercice_tp;

import java.util.Map;

public class ProductItem extends Products{

    private String ref;
    private String name;
    private double price;

    public ProductItem(String ref, String name, double price) {
        super(ref);
        this.name = name;
        this.price = price;
    }

    public Map<String, Products> getAllProducts() {
        return allProducts;
    }

    public Products getProduct(String ref) {
        return allProducts.get(ref);
    }

    protected String getRef() {
        return this.ref;
    }

    @Override
    protected Products getProduct() {
        return this;
    }

    protected void setRef(String ref) {
        this.ref = ref;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

}
