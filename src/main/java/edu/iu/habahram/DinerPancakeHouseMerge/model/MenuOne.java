package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.List;

public class MenuOne extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public MenuOne(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        List<MenuItem> items = new ArrayList<MenuItem>();
        for (MenuComponent menuComponent : menuComponents) {
            MenuItem[] menuItems = menuComponent.getItems();
            for (MenuItem menuItem : menuItems) {
                items.add(menuItem);
            }
        }
        return items.toArray(new MenuItem[0]);
    }
}