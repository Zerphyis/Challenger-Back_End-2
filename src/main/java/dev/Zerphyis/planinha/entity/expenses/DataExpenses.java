package dev.Zerphyis.planinha.entity.expenses;



import java.time.LocalDate;

public record DataExpenses(String description, Double value, LocalDate data, TypeExpenses type) {
}
