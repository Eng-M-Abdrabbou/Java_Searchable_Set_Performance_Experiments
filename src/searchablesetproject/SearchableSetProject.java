/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchablesetproject;

/**
 *
 * @author Hp
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchableSetProject {
    private static final String UNIQUE_IDS_FILE = "unique_ids.txt";
    private static final String CONTAINED_IDS_FILE = "contained_ids.txt";
    private static final String NON_CONTAINED_IDS_FILE = "non_contained_ids.txt";
    private static final int NUM_EXPERIMENTS = 10;
    private static final int NUM_UNIQUE_IDS = 70000;

    public static void main(String[] args) throws IOException {
        List<String> uniqueIds = readIds(UNIQUE_IDS_FILE);
        List<String> containedIds = readIds(CONTAINED_IDS_FILE);
        List<String> notContainedIds = readIds(NON_CONTAINED_IDS_FILE);

        double[][][] results = new double[3][3][NUM_EXPERIMENTS];

        for (int run = 0; run < NUM_EXPERIMENTS; run++) {
            SearchableSetInterface bag = new BagSearchableSet(NUM_UNIQUE_IDS);
            results[0][0][run] = timeAdd(uniqueIds, bag);
            results[0][1][run] = timeContains(containedIds, bag);
            results[0][2][run] = timeContains(notContainedIds, bag);

            ListSearchableSet list = new ListSearchableSet(NUM_UNIQUE_IDS);
            long start = System.nanoTime();
            for (String id : uniqueIds) list.add(id);
            list.sortList();
            results[1][0][run] = (System.nanoTime() - start) / 1e6;
            results[1][1][run] = timeContains(containedIds, list);
            results[1][2][run] = timeContains(notContainedIds, list);

            SearchableSetInterface hash = new HashSetSearchableSet(NUM_UNIQUE_IDS);
            results[2][0][run] = timeAdd(uniqueIds, hash);
            results[2][1][run] = timeContains(containedIds, hash);
            results[2][2][run] = timeContains(notContainedIds, hash);
        }

        System.out.println("Average Times (ms):");
        printAverages("Add", average(results[0][0]), average(results[1][0]), average(results[2][0]));
        printAverages("Contains (valid)", average(results[0][1]), average(results[1][1]), average(results[2][1]));
        printAverages("Contains (invalid)", average(results[0][2]), average(results[1][2]), average(results[2][2]));
    }

    private static List<String> readIds(String filename) throws IOException {
        List<String> ids = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) 
            if (!line.isEmpty()) ids.add(line);
        reader.close();
        return ids;
    }

    private static double timeAdd(List<String> ids, SearchableSetInterface set) {
        long start = System.nanoTime();
        for (String id : ids) set.add(id);
        return (System.nanoTime() - start) / 1e6;
    }

    private static double timeContains(List<String> ids, SearchableSetInterface set) {
        long start = System.nanoTime();
        for (String id : ids) set.contains(id);
        return (System.nanoTime() - start) / 1e6;
    }

    private static double average(double[] times) {
        double sum = 0;
        for (double t : times) sum += t;
        return sum / times.length;
    }

    private static void printAverages(String step, double bag, double list, double hash) {
        System.out.printf("%s - Bag: %.1f | List: %.1f | Hash: %.1f%n", step, bag, list, hash);
    }
}
