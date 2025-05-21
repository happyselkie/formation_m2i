package org.example.exercices_pattern.pere_noel.factories;

public class Gameboy implements Toy{

    String kid;

    public Gameboy(String kid) {
        this.kid = kid;
    }

    @Override
    public String getToy() {
        return "Un gameboy pour "+kid;
    }

    @Override
    public String toString() {
        return this.getToy();
    }
}
