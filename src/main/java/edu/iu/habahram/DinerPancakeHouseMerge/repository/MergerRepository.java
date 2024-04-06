package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MergerRepository {

    MenuComponent allMenus;

    public MergerRepository() {
        MenuComponent allMenus = new MenuOne("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        this.allMenus = allMenus;
    }

    public  List<MenuItemRecord> getTheMenuItems() {
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getVegetarianItems() {
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).filter(MenuItemRecord::vegetarian).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getBreakfastItems() {
        MenuItem[] menuItems = allMenus.getChild(1).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getLunchItems() {
        MenuItem[] menuItems = allMenus.getChild(0).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }

    public List<MenuItemRecord> getSupperItems() {
        MenuItem[] menuItems = allMenus.getChild(2).getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).sorted((item1, item2) -> item1.name().compareTo(item2.name())).collect(Collectors.toList());
        return records;
    }
}