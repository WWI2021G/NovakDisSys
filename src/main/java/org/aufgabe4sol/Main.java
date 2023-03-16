package org.aufgabe4sol;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(10);

        List<Auto> autos = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            Auto auto = new Auto("Auto-" + i);
            autos.add(auto);
        }

        parkhaus.einausfahrt(autos);

        System.out.println("Ein- und Ausfahrten-Protokoll:");
        for (Auto auto : parkhaus.getProtokoll()) {
            System.out.println(auto.getKennzeichen());
        }
    }
}
