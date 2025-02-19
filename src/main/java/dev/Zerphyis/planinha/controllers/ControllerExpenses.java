package dev.Zerphyis.planinha.controllers;

import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.entity.revunue.DataRevunue;
import dev.Zerphyis.planinha.entity.revunue.Revenue;
import dev.Zerphyis.planinha.services.ServiceExpenses;
import dev.Zerphyis.planinha.services.ServiceRevunue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/despesas")
public class ControllerExpenses {
    @Autowired
    ServiceExpenses service;

    @PostMapping
    public ResponseEntity<Expenses> register(@RequestBody DataRevunue data){
        Expenses returnData =service.registerExpenses(data);
        return  ResponseEntity.status(201).body(returnData);
    }

    @GetMapping
    public  ResponseEntity<List<Expenses>> listAll(){
        return ResponseEntity.ok(service.listAllExpenses());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional> listById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listIdExpenses(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expenses> update(@PathVariable Long id, @RequestBody DataRevunue data) {
        return ResponseEntity.ok(service.updateExpenses(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.DeleteExpenses(id);
        return ResponseEntity.noContent().build();
    }
}
