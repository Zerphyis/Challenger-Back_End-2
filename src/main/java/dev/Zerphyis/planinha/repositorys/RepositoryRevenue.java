package dev.Zerphyis.planinha.repositorys;

import dev.Zerphyis.planinha.entity.revunue.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RepositoryRevenue extends JpaRepository<Revenue, Long > {
    Optional<Revenue> findByDescriptionAndDataBetween(String description, LocalDate startDate, LocalDate endDate);
}
