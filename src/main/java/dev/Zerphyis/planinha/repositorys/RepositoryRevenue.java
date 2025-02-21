package dev.Zerphyis.planinha.repositorys;

import dev.Zerphyis.planinha.entity.expenses.Expenses;
import dev.Zerphyis.planinha.entity.revunue.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryRevenue extends JpaRepository<Revenue, Long > {
    Optional<Revenue> findByDescriptionAndDataBetween(String description, LocalDate startDate, LocalDate endDate);

    List<Revenue> findByDescriptionContaining(String descricao);

    List<Revenue> findByDataBetween(LocalDate startDate, LocalDate endDate);

}
