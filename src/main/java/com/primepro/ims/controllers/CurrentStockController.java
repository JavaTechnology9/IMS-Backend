package com.primepro.ims.controllers;

import com.primepro.ims.model.CurrentStock;
import com.primepro.ims.repository.CurrentStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currentStock")
public class CurrentStockController {

    @Autowired
    private CurrentStockRepository currentStockRepository;

    @GetMapping("/loadCurrentStock")
    public Iterable<CurrentStock> loadCurrentStockData(){
        return currentStockRepository.findAll();
    }
}
