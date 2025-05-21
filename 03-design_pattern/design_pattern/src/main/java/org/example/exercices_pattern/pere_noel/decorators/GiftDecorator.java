package org.example.exercices_pattern.pere_noel.decorators;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public abstract class GiftDecorator implements Toy {
    protected Toy toy;

    public GiftDecorator(Toy toy) {
        this.toy = toy;
    }

    @Override
    public String getToy() {
        return toy.getToy();
    }
}
