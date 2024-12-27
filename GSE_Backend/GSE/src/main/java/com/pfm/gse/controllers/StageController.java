package com.pfm.gse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfm.gse.models.Stage;
import com.pfm.gse.services.StageService;

@RestController
@RequestMapping("api/stage")
public class StageController {
    @Autowired
    private StageService stageService;

    @GetMapping("/{numero}")
    public Stage findByNumero(@PathVariable String numero) {
        return stageService.findByNumero(numero);
    }

    @GetMapping("/")
    public List<Stage> findAll() {
        return stageService.findAll();
    }

    @DeleteMapping("/{numero}")
    public void deleteByNumero(@PathVariable String numero) {
        stageService.deleteByNumero(numero);
    }

    @PostMapping("/")
    public Stage save(@RequestBody Stage stage) {
        return stageService.save(stage);
    }

    @PutMapping("/")
    public Stage update(@RequestBody Stage stage) {
        return stageService.update(stage);
    }

}
