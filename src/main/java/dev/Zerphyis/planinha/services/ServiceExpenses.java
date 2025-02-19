package dev.Zerphyis.planinha.services;

import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.entity.revunue.DataRevunue;
import dev.Zerphyis.planinha.entity.revunue.Revenue;
import dev.Zerphyis.planinha.repositorys.RepositoryExpenses;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceExpenses {
@Autowired
    RepositoryExpenses repository;

    @Transient
    public Expenses registerExpenses(DataRevunue data){
        YearMonth monthYear = YearMonth.from(data.data());
        LocalDate startOfMonth = monthYear.atDay(1);
        LocalDate endOfMonth = monthYear.atEndOfMonth();

        Optional<Expenses> existingExpenses = repository.findByDescriptionAndDataBetween(
                data.description(), startOfMonth, endOfMonth);

        if (existingExpenses.isPresent() && YearMonth.from(existingExpenses.get().getData()).equals(monthYear)) {
            throw new IllegalArgumentException("Já existe uma receita com essa descrição para este mês específico.");
        }

        var newExpenses = new Expenses(data);
        return repository.save(newExpenses);
    }

    public List<Expenses> listAllExpenses(){
        return  repository.findAll();
    }

    public Optional listIdExpenses(Long id){
        return repository.findById(id);
    }

    @Transient
    public Expenses updateExpenses(Long id,DataRevunue data){
        Optional<Expenses> idExpenses =  repository.findById(id);
        if (idExpenses.isPresent()) {
            Expenses updateExpenses = idExpenses.get();
            updateExpenses.setDescription(data.description());
            updateExpenses.setValue(data.value());
            updateExpenses.setData(data.data());

            return repository.save(updateExpenses);
        } else {
            throw new RuntimeException("Receita não encontrado com o ID: " + id);
        }
    }

    @Transient
    public void DeleteExpenses(Long id){
        repository.deleteById(id);
    }



}
