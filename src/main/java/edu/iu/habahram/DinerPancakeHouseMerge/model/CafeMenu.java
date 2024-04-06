package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.*;

public class CafeMenu extends MenuOne{
    HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();

    public CafeMenu(String name, String description) {
        super(name, description);

        addItem("Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name, menuItem);
    }

    public MenuItem[] getItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        for (Map.Entry<String, MenuItem> entry : menuItems.entrySet()) {
            MenuItem menuItem = entry.getValue();
            items.add(menuItem);
        }

        MenuItem[] returnList = new MenuItem[items.size()];
        returnList = items.toArray(returnList);
        return returnList;
    }

    public Iterator<MenuItem> createIterator() {
        return menuItems.values().iterator();
    }


}