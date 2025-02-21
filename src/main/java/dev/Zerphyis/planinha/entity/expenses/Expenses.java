package dev.Zerphyis.planinha.entity.expenses;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "tb_expenses")
@EqualsAndHashCode(of = "id")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private  String description;
    @NotNull
    private Double value;
    @PastOrPresent
    private LocalDate data;

    TypeExpenses type;

    public  Expenses(){


    }

    public  Expenses(DataExpenses data){
        this.description=data.description();
        this.value= data.value();
        this.data=data.data();
        this.type= (data.type() != null) ? data.type() : TypeExpenses.OUTRAS;
    }

    public Expenses(Long id, String description, Double value, LocalDate data, TypeExpenses type) {

    }


    public void setType(TypeExpenses type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeExpenses getType() {
        return type;
    }
}
