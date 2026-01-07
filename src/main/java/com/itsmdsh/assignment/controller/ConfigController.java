package com.itsmdsh.assignment.controller;

import com.itsmdsh.assignment.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
/**
 * Author: Mohammad
 * College: College Of Engineering And Management,Kolaghat
 * Date: Jan 7, 2026
 */

@RestController
@RequestMapping("/api/config")
public class ConfigController {
    @Autowired private ConfigService configService;

    @GetMapping
    public Map<String, Object> getConfig(@RequestParam String sectionName) {
        return configService.getConfig(sectionName);
    }
}