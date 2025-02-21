package dev.Zerphyis.planinha.services;

import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.entity.revunue.DataRevunue;
import dev.Zerphyis.planinha.entity.revunue.Revenue;
import dev.Zerphyis.planinha.repositorys.RepositoryRevenue;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRevunue {
    @Autowired
    RepositoryRevenue repository;

    @Transient
    public Revenue registerRevunue(DataRevunue data){
        YearMonth monthYear = YearMonth.from(data.data());
        LocalDate startOfMonth = monthYear.atDay(1);
        LocalDate endOfMonth = monthYear.atEndOfMonth();

        Optional<Revenue> existingRevenue = repository.findByDescriptionAndDataBetween(
                data.description(), startOfMonth, endOfMonth);

        if (existingRevenue.isPresent() && YearMonth.from(existingRevenue.get().getData()).equals(monthYear)) {
            throw new IllegalArgumentException("Já existe uma receita com essa descrição para este mês específico.");
        }

        var newRevunue = new Revenue(data);
        return repository.save(newRevunue);
    }

    public List<Revenue> listAllRevenue(){
        return  repository.findAll();
    }

    public Optional listIdRevenue(Long id){
        return repository.findById(id);
    }

    public List<Revenue> listByDescription(String descricao) {
        return repository.findByDescriptionContaining(descricao);
    }

    @Transient
    public Revenue updateRevunue(Long id,DataRevunue data){
        Optional<Revenue> idRevenue =  repository.findById(id);
        if (idRevenue.isPresent()) {
            Revenue updateRevenue = idRevenue.get();
            updateRevenue.setDescription(data.description());
            updateRevenue.setValue(data.value());
            updateRevenue.setData(data.data());

            return repository.save(updateRevenue);
        } else {
            throw new RuntimeException("Receita não encontrado com o ID: " + id);
        }
    }

    public List<Revenue> listByMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        return repository.findByDataBetween(startOfMonth, endOfMonth);
    }

    @Transient
    public void DeleteRevunue(Long id){
        repository.deleteById(id);
    }




}
