package org.example.exercices_pattern.pere_noel;

import org.example.exercices_pattern.pere_noel.decorators.GiftRibbon;
import org.example.exercices_pattern.pere_noel.decorators.GiftWrapper;
import org.example.exercices_pattern.pere_noel.factories.FactoryPlant;
import org.example.exercices_pattern.pere_noel.factories.FurbyFactory;
import org.example.exercices_pattern.pere_noel.factories.GameboyFactory;
import org.example.exercices_pattern.pere_noel.factories.Toy;
import org.example.exercices_pattern.pere_noel.observers.ElfObserver;
import org.example.exercices_pattern.pere_noel.observers.GiftList;
import org.example.exercices_pattern.pere_noel.observers.Observer;

public class Main {
    public static void main(String[] args) {


        FactoryPlant factoryPlant = new FactoryPlant();
        factoryPlant.saveFactory("furby", new FurbyFactory());
        factoryPlant.saveFactory("gameboy", new GameboyFactory());

        Observer elfObserver = new ElfObserver("lutins");
        Observer giftList = new GiftList("Liste de cadeaux");

        factoryPlant.addObserver(elfObserver);
        factoryPlant.addObserver(giftList);

        Toy furbyForTom = factoryPlant.buildToy("furby", "Tom");
        Toy gameboyForLily = factoryPlant.buildToy("gameboy", "Lily");
        Toy furbyForLucy = factoryPlant.buildToy("furby", "Lucy");
        Toy gameboyForNathan = factoryPlant.buildToy("gameboy", "Nathan");


        furbyForLucy = new GiftWrapper(furbyForLucy, "à lignes");
        System.out.printf(furbyForLucy.getToy()+"\n");

        gameboyForLily = new GiftRibbon(gameboyForLily, "rouge");
        System.out.printf(gameboyForLily.getToy()+"\n");
        gameboyForLily = new GiftWrapper(gameboyForLily, "à pois verts");
        System.out.println(gameboyForLily.getToy());
    }
}
