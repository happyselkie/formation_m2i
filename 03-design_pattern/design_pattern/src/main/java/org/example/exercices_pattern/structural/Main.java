package org.example.exercices_pattern.structural;


import com.sun.source.doctree.TextTree;
import org.example.exercices_pattern.structural.classes.*;

public class Main {
    public static void main(String[] args) {
        Text simpleText = new SimpleText();
        System.out.println(simpleText.transform());

        Text textLower = new TextLower(simpleText);
        System.out.println(textLower.transform());

        Text textUpper = new TextUpper(simpleText);
        System.out.println(textUpper.transform());

        Text textPrefix = new TextPrefix(simpleText, "Ceci est un préfixe.");
        System.out.println(textPrefix.transform());

        Text textColor = new TextColor(simpleText, "red");
        System.out.println(textColor.transform());
    }
}
