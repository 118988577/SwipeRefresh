package com.example.swiperefresh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Dummy data.
 */
public class Cheeses {
    static final String[] CHEESES = {
            "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale",
            "Aisy Cendre", "Allgauer Emmentaler", "Alverca", "Ambert", "American Cheese",
            "Ami du Chambertin", "Anejo Enchilado", "Anneau du Vic-Bilh", "Anthoriro", "Appenzell",
            "Aragon", "Ardi Gasna", "Ardrahan", "Armenian String", "Aromes au Gene de Marc",
            "Asadero", "Asiago", "Aubisque Pyrenees", "Autun", "Avaxtskyr", "Baby Swiss",
            "Babybel", "Baguette Laonnaise", "Bakers", "Baladi", "Balaton", "Bandal", "Banon",
    };

    public static ArrayList<String> asList() {
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0, z = CHEESES.length ; i < z ; i++) {
            items.add(CHEESES[i]);
        }
        return items;
    }

    /**
     * Return a list of random cheeses.
     *
     * @param count the amount of cheeses to return.
     */
    public static ArrayList<String> randomList(int count) {
        Random random = new Random();
        HashSet<String> items = new HashSet<String>();

        // Make sure that don't infinity loop
        count = Math.min(count, CHEESES.length);

        while (items.size() < count) {
            items.add(CHEESES[random.nextInt(CHEESES.length)]);
        }
        return new ArrayList<String>(items);
    }
}