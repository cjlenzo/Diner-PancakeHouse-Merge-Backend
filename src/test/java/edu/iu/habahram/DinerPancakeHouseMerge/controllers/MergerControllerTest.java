package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergerControllerTest {

    @Test
    public void testGetAll() {
        MergerRepository mergerRepository = new MergerRepository();
        MergerController mergerController = new MergerController(mergerRepository);
        List<MenuItemRecord> allMenuItems = mergerController.get();
        for (MenuItemRecord item : allMenuItems) {
            System.out.println(item);
        }
        //

    }
}