package org.example.exercices_pattern.pere_noel.factories;

public class Furby implements Toy{

    String kid;

    public Furby(String kid) {
        this.kid = kid;
    }

    @Override
    public String getToy() {
        return "Un furby pour "+kid;
    }

    @Override
    public String toString() {
        return this.getToy();
    }
}
