package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal_data")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Поле 'passportSeria' не может быть пустым")
    @Column(length = 4)
    private String passportSeria;

    @NotBlank(message = "Поле 'passportNumber' не может быть пустым")
    @Column(unique = true, length = 6)
    private String passportNumber;

    @NotBlank(message = "Поле 'kod' не может быть пустым")
    @Column(length = 16)
    private String kod;
}
