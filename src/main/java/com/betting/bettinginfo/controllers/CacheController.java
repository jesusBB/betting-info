package com.betting.bettinginfo.controllers;

import com.betting.bettinginfo.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/clearAllCaches")
    public String clearAllCaches() {
        cacheService.clearAllCaches();
        return "All caches cleared";
    }

}
