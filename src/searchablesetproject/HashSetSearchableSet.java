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
import java.util.HashSet;
import java.util.Set;

public class HashSetSearchableSet implements SearchableSetInterface {

    private Set<String> set;

    public HashSetSearchableSet(int capacity) {
        // to calculate a good initial capacity for the HashSet
        int hashSetCapacity = (int) (capacity / 0.75f) + 1;
        set = new HashSet<>(hashSetCapacity);
    }

    @Override
    public void add(String id) {
        set.add(id);
    }

    @Override
    public boolean contains(String id) {
        return set.contains(id);
    }
}