package org.example.exercice_tp;

public class Line {

    private Products article;
    int quantity;
    double total;

    public Line(String ref, int quantity) {
        this.article = Products.allProducts.get(ref);
        this.quantity = quantity;
        this.total = article.getPrice() * quantity;
    }



    public String displayLine(){
        return quantity + " - " + article.getRef() + " - " + article.getName() + " - " + article.getPrice() + " - " + total;
    }

    public double getTotal() {
        return total;
    }
}
