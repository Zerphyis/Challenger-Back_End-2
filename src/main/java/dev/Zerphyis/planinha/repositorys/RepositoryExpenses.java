package dev.Zerphyis.planinha.repositorys;

import dev.Zerphyis.planinha.entity.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface RepositoryExpenses  extends JpaRepository<Expenses , Long> {
    Optional<Expenses> findByDescriptionAndDataBetween(String description, LocalDate startDate, LocalDate endDate);


    List<Expenses> findByDescriptionContaining(String descricao);

    List<Expenses> findByDataBetween(LocalDate startDate, LocalDate endDate);
}
