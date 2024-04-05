package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergerControllerTest {

    @Test
    public void testGetAll() {
        DinerRepository dinerRepository = new DinerRepository();
        PancakeHouseRepository pancakeHouseRepository = new PancakeHouseRepository();
        MergerController mergerController = new MergerController(dinerRepository, pancakeHouseRepository);
        List<MenuItem> allMenuItems = mergerController.getAll();
        for (MenuItem item : allMenuItems) {
            System.out.println(item);
        }

    }
}