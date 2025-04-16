package com.lescours.volcaniaapi.controller;

import com.lescours.volcaniaapi.model.Volcano;
import com.lescours.volcaniaapi.service.VolcanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("volcano")
public class VolcanoController {

    @Autowired
    private VolcanoService volcanoService;

    @GetMapping("{id}")
    public Volcano getVolcano(@PathVariable Long id) {
        return volcanoService.findById(id);
    }

    @GetMapping("all")
    public List<Volcano> getVolcanoes() {
        return volcanoService.getAll();
    }

    @GetMapping("highest")
    public List<Volcano> getTenHighest() {
        return volcanoService.findTenHighest();
    }

    @GetMapping("lowest")
    public List<Volcano> getTenLowest() {
        return volcanoService.findTenLowest();
    }

    @GetMapping("most-recent-activity")
    public List<Volcano> getTenRecentActivity() {
        return volcanoService.findTenMostRecentActivities();
    }

    @GetMapping("highest/stratovolcano")
    public List<Volcano> getTenMostRecentStratovolcanoActivities() {
        return volcanoService.findTenStratovolcanoByElevationDesc();
    }

    @GetMapping("most-recent-activity/europe")
    public List<Volcano> getTenMostRecentEuropeanActivities() {
        return volcanoService.findTenMostRecentEuropeanActivities();
    }

    @GetMapping("most-recent-activity/america")
    public List<Volcano> getTenMostRecentAmericanActivities() {
        return volcanoService.findTenMostRecentAmericanActivities();
    }

}
