package com.itsmdsh.assignment.controller;

import com.itsmdsh.assignment.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
public class PriceController {
    @Autowired private PriceService priceService;

    @GetMapping
    public String getPrice(@RequestParam String skuid, @RequestParam(required = false) String time) {
        return priceService.findPrice(skuid, time);
    }
}
/**
 * Author: Mohammad
 * College: College Of Engineering And Management,Kolaghat
 * Date: Jan 7, 2026
 */
