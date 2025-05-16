package org.example.exercice_tp;

import java.util.HashMap;
import java.util.Map;

abstract class Products {
    protected String ref;

    protected static Map<String, Products> allProducts = new HashMap<>();

    protected Products(String ref) {
        this.ref = ref;
        allProducts.put(ref, this);
    }

    protected abstract  Map<String, Products> getAllProducts();

    protected abstract String getRef();

    protected abstract Products getProduct();

    protected abstract double getPrice();

    protected abstract String getName();
}
