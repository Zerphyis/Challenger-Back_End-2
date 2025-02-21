package dev.Zerphyis.planinha.services;

import dev.Zerphyis.planinha.entity.expenses.DataExpenses;
import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.repositorys.RepositoryExpenses;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceExpenses {
@Autowired
    RepositoryExpenses repository;

    @Transient
    public Expenses registerExpenses(DataExpenses data){
        YearMonth monthYear = YearMonth.from(data.data());
        LocalDate startOfMonth = monthYear.atDay(1);
        LocalDate endOfMonth = monthYear.atEndOfMonth();

        Optional<Expenses> existingExpenses = repository.findByDescriptionAndDataBetween(
                data.description(), startOfMonth, endOfMonth);

        if (existingExpenses.isPresent() && YearMonth.from(existingExpenses.get().getData()).equals(monthYear)) {
            throw new IllegalArgumentException("Já existe uma Despesa com essa descrição para este mês específico.");
        }

        Expenses newExpenses = new Expenses(data);
        return repository.save(newExpenses);
    }

    public List<Expenses> listAllExpenses(){
        return  repository.findAll();
    }

    public Optional listIdExpenses(Long id){
        return repository.findById(id);
    }

    public List<Expenses> listByDescription(String descricao) {
        return repository.findByDescriptionContaining(descricao);
    }

    @Transient
    public Expenses updateExpenses(Long id,DataExpenses data){
        Optional<Expenses> idExpenses =  repository.findById(id);
        if (idExpenses.isPresent()) {
            Expenses updateExpenses = idExpenses.get();
            updateExpenses.setDescription(data.description());
            updateExpenses.setValue(data.value());
            updateExpenses.setData(data.data());
            updateExpenses.setType(data.type());

            return repository.save(updateExpenses);
        } else {
            throw new RuntimeException("Receita não encontrado com o ID: " + id);
        }
    }


    public List<Expenses> listByMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        return repository.findByDataBetween(startOfMonth, endOfMonth);
    }


    @Transient
    public void DeleteExpenses(Long id){
        repository.deleteById(id);
    }



}
