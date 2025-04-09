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
// BagSearchableSet.java
import searchablesetproject.ArrayBag;

public class BagSearchableSet implements SearchableSetInterface {

    private ArrayBag<String> bag;

    public BagSearchableSet(int capacity) {
        // Ensure capacity is at least 60000 for this project
        if (capacity < 60000) {
            capacity = 60000;
        }
        bag = new ArrayBag<>(capacity);
    }

    @Override
    public void add(String id) {
        bag.add(id);
    }

    @Override
    public boolean contains(String id) {
        return bag.contains(id);
    }
}