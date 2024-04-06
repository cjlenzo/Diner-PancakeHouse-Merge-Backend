package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;
    int dayOfWeek;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar date = Calendar.getInstance();
        this.dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek % 2 == 0) {
            this.position = 0;
        }
        else {
            this.position = 1;
        }
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position += 2;
        return menuItem;
    }
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}