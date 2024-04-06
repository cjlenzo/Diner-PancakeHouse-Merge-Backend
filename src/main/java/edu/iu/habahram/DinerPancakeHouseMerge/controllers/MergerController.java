package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CustomerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        List<MenuItemRecord> items = mergerRepository.getVegetarianItems();
        return items;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        List<MenuItemRecord> items = mergerRepository.getBreakfastItems();
        return items;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems() {
        List<MenuItemRecord> items = mergerRepository.getLunchItems();
        return items;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperItems() {
        List<MenuItemRecord> items = mergerRepository.getSupperItems();
        return items;
    }
}