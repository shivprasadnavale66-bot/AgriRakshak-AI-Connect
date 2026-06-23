package com.agrirakshak.backend.scheme.controller;

import com.agrirakshak.backend.scheme.entity.Scheme;
import com.agrirakshak.backend.scheme.service.SchemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
@RequiredArgsConstructor
public class SchemeController {

    private final SchemeService service;

    @PostMapping("/add")
    public Scheme add(@RequestBody Scheme scheme) {
        return service.addScheme(scheme);
    }

    @GetMapping("/all")
    public List<Scheme> getAll() {
        return service.getAllSchemes();
    }

    @GetMapping("/{state}")
    public List<Scheme> getByState(@PathVariable String state) {
        return service.getByState(state);
    }
}