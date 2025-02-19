package dev.Zerphyis.planinha.controllers;

import dev.Zerphyis.planinha.entity.revunue.DataRevunue;
import dev.Zerphyis.planinha.entity.revunue.Revenue;
import dev.Zerphyis.planinha.services.ServiceRevunue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ControllerRevunue {
    @Autowired
    ServiceRevunue service;

    @PostMapping
    public ResponseEntity<Revenue> register(@RequestBody DataRevunue data){
       Revenue returnData =service.registerRevunue(data);
        return  ResponseEntity.status(201).body(returnData);
    }

    @GetMapping
    public  ResponseEntity<List<Revenue>> listAll(){
        return ResponseEntity.ok(service.listAllRevenue());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional> listById(@PathVariable Long id) {
      return ResponseEntity.ok(service.listIdRevenue(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revenue> update(@PathVariable Long id, @RequestBody DataRevunue data) {
        return ResponseEntity.ok(service.updateRevunue(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.DeleteRevunue(id);
        return ResponseEntity.noContent().build();
    }
}





