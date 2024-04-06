package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    MergerRepository mergerRepository;
    CafeRepository cafeRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository, CafeRepository cafeRepository, MergerRepository mergerRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.cafeRepository = cafeRepository;
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        ArrayList<MenuItem> items = new ArrayList<>();
        ArrayList<Menu> menuItems = mergerRepository.getTheMenus();
        Iterator<MenuItem> lunchItems = dinerRepository.getTheMenuIterator();
        while(lunchItems.hasNext()) {
            items.add(lunchItems.next());
        }

        Iterator<MenuItem> breakfastItems = pancakeHouseRepository.getTheMenuIterator();
        while(breakfastItems.hasNext()) {
            items.add(breakfastItems.next());
        }

        Iterator<MenuItem> cafeItems = cafeRepository.getTheMenuIterator();
        while(cafeItems.hasNext()) {
            items.add(cafeItems.next());
        }

        items.sort((item1, item2) -> item1.getName().compareTo(item2.getName()));

        return items;
    }
}
