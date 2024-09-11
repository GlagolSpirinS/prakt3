package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="faculties")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле 'name' не может быть пустым")
    private String name;

    @Override
    public String toString() {
        return "FacultyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
