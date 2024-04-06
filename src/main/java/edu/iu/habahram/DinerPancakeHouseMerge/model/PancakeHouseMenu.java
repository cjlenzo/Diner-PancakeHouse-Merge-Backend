package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu extends MenuOne {
    List<MenuItem> menuItems;

    public PancakeHouseMenu(String Name, String Description) {
        super(Name, Description);

        menuItems = new ArrayList<MenuItem>();

        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[menuItems.size()];
        items = menuItems.toArray(items);
        return items;
    }



    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getItems()) {
            stringBuilder.append(item.toString());
        }
        return  stringBuilder.toString();
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }

    // other menu methods here
}
