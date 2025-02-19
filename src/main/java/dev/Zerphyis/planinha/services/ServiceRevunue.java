package dev.Zerphyis.planinha.services;

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
    RepositoryRevenue reposiory;

    @Transient
    public Revenue registerRevunue(DataRevunue data){
        YearMonth monthYear = YearMonth.from(data.data());
        LocalDate startOfMonth = monthYear.atDay(1);
        LocalDate endOfMonth = monthYear.atEndOfMonth();

        Optional<Revenue> existingRevenue = reposiory.findByDescriptionAndDataBetween(
                data.description(), startOfMonth, endOfMonth);

        if (existingRevenue.isPresent() && YearMonth.from(existingRevenue.get().getData()).equals(monthYear)) {
            throw new IllegalArgumentException("Já existe uma receita com essa descrição para este mês específico.");
        }

        var newRevunue = new Revenue(data);
        return reposiory.save(newRevunue);
    }

    public List<Revenue> listAllRevenue(){
        return  reposiory.findAll();
    }

    public Optional listIdRevenue(Long id){
        return reposiory.findById(id);
    }

    @Transient
    public Revenue updateRevunue(Long id,DataRevunue data){
        Optional<Revenue> idRevenue =  reposiory.findById(id);
        if (idRevenue.isPresent()) {
            Revenue updateRevenue = idRevenue.get();
            updateRevenue.setDescription(data.description());
            updateRevenue.setValue(data.value());
            updateRevenue.setData(data.data());

            return reposiory.save(updateRevenue);
        } else {
            throw new RuntimeException("Receita não encontrado com o ID: " + id);
        }
    }

    @Transient
    public void DeleteRevunue(Long id){
        reposiory.deleteById(id);
    }




}
