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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSearchableSet implements SearchableSetInterface {

    private List<String> list;
    private boolean sorted;

    public ListSearchableSet(int capacity) {
        list = new ArrayList<>(capacity);
        sorted = false;
    }

    @Override
    public void add(String id) {
        list.add(id);
        sorted = false;
    }

    public void sortList() {
        if (!sorted) {
            Collections.sort(list);
            sorted = true;
        }
    }

    @Override
    public boolean contains(String id) {
        if (!sorted) {
            // This implementation needs sorting before efficient search
            // You MUST call sortList() after adding all items
            // For simplicity, we throw an error if not sorted
            throw new IllegalStateException("List must be sorted before calling contains.");
        }
        int index = Collections.binarySearch(list, id);
        return index >= 0;
    }
}