package dev.Zerphyis.planinha.entity.revunue;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "tb_Revenue")
@EqualsAndHashCode(of = "id")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private  String description;
    @NotNull
    private Double value;
    @PastOrPresent
    private LocalDate data;

    public  Revenue(){


    }

    public  Revenue(DataRevunue data){
        this.description=data.description();
        this.value= data.value();
        this.data=data.data();

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

    public long getId() {
        return id;
    }
}
