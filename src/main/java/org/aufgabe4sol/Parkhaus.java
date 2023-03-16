package org.aufgabe4sol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parkhaus {

    private final int anzahlPlaetze;
    private final Semaphore semaphore;
    private final List<Auto> Protokoll;

    public Parkhaus(int anzahlPlaetze) {
        this.anzahlPlaetze = anzahlPlaetze;
        this.semaphore = new Semaphore(anzahlPlaetze, true);
        this.Protokoll = Collections.synchronizedList(new ArrayList<>());
    }

    public boolean einfahren(Auto auto) {
        boolean success = false;
        try {
            semaphore.acquire();
            success = Protokoll.add(auto);
            System.out.println("Auto " + auto.getKennzeichen() + " ist eingefahren.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean ausfahren(Auto auto) {
        boolean success = Protokoll.remove(auto);
        semaphore.release();
        System.out.println("Auto " + auto.getKennzeichen() + " ist ausgefahren.");
        return success;
    }

    public List<Auto> getProtokoll() {
        return Protokoll;
    }

    public void einausfahrt(List<Auto> autos) {
        List<Thread> threads = new ArrayList<>();
        for (Auto auto : autos) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000)); // Zeit bis zum Einfahren
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                einfahren(auto);
                try {
                    Thread.sleep(new Random().nextInt(5000)); // Zeit bis zum Ausfahren
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ausfahren(auto);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
