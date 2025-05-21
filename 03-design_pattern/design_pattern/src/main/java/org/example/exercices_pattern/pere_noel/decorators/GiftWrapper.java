package org.example.exercices_pattern.pere_noel.decorators;

import org.example.exercices_pattern.pere_noel.factories.Toy;

public class GiftWrapper extends GiftDecorator{

    private String wrapper;

    public GiftWrapper(Toy toy, String wrapper) {
        super(toy);
        this.wrapper = wrapper;
    }

    @Override
    public String getToy() {
        return super.getToy() + ", emballé dans un paquet "+wrapper;
    }
}
