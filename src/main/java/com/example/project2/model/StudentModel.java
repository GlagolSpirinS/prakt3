package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле 'name' не может быть пустым")
    private String name;

    @Email(message = "Некорректный формат электронной почты")
    @NotBlank(message = "Поле 'email' не может быть пустым")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Поле 'password' не может быть пустым")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonaDataModel personaDataModel;

    @Transient
    private Long facultyId; // Временное поле для хранения ID факультета

    @ManyToOne
    @JoinColumn(name = "faculty_id") // Внешний ключ
    private FacultyModel facultyModel;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PredmetModel> predmetModel;

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", faculty=" + (facultyModel != null ? facultyModel.getName() : "не назначен") +
                '}';
    }
}
