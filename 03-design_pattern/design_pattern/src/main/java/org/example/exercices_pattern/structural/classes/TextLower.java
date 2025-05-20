package org.example.exercices_pattern.structural.classes;

public class TextLower extends TextDecorator{

    public TextLower(Text text) {
        super(text);
    }

    @Override
    public String transform() {
        return super.transform().toLowerCase();
    }

}
