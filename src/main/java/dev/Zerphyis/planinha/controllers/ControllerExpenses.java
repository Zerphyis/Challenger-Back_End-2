package dev.Zerphyis.planinha.controllers;

import dev.Zerphyis.planinha.entity.expenses.DataExpenses;
import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.services.ServiceExpenses;
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
    public ResponseEntity<Expenses> register(@RequestBody DataExpenses data){
        Expenses returnData =service.registerExpenses(data);
 return  ResponseEntity.status(201).body(returnData);
    }

    @GetMapping
    public  ResponseEntity<List<Expenses>> listAll(){
        return ResponseEntity.ok(service.listAllExpenses());

    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Expenses>> searchByDescription(@RequestParam String descricao) {
        return ResponseEntity.ok(service.listByDescription(descricao));
    }

    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<List<Expenses>> listByMonth(
            @PathVariable int ano,
            @PathVariable int mes) {
        List<Expenses> expenses = service.listByMonth(ano, mes);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional> listById(@PathVariable Long id) {
        return ResponseEntity.ok(service.listIdExpenses(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expenses> update(@PathVariable Long id, @RequestBody DataExpenses data) {
        return ResponseEntity.ok(service.updateExpenses(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.DeleteExpenses(id);
        return ResponseEntity.noContent().build();
    }
}
