package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseIterator implements Iterator {

    List<MenuItem> list;
    int currentIndex;

    public PancakeHouseIterator(List<MenuItem> list) {
        this.list = list;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        if (currentIndex >= list.size() || list.get(currentIndex) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more elements in the iterator.");
        }
        MenuItem menuItem = list.get(currentIndex);
        currentIndex = currentIndex + 1;
        return menuItem;
    }
}
