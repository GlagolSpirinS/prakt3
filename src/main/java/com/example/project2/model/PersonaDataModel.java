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

    @NotBlank(message = "Серия паспорта не может быть пустой")
    @Column(length = 5000000)  // Проверка длины строки
    private String passportSeria;

    @NotBlank(message = "Номер паспорта не может быть пустым")
    @Column(unique = true, length = 500000)  // Проверка длины строки
    private String passportNumber;

    @NotBlank(message = "Код не может быть пустым")
    @Column(length = 50000)  // Проверка длины строки
    private String kod;
}

