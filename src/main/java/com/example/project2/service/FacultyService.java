package com.example.project2.service;

import com.example.project2.model.FacultyModel;
import com.example.project2.repository.FacultyModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyModelRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyModelRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    /**
     * Получение всех факультетов.
     * @return список всех факультетов
     */
    public List<FacultyModel> getAllFaculties() {
        return facultyRepository.findAll();
    }

    /**
     * Получение факультета по идентификатору.
     * @param id идентификатор факультета
     * @return объект FacultyModel
     * @throws RuntimeException если факультет не найден
     */
    public FacultyModel getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Факультет не найден"));
    }

    /**
     * Создание нового факультета.
     * @param faculty объект FacultyModel
     * @return сохраненный объект FacultyModel
     */
    public FacultyModel createFaculty(FacultyModel faculty) {
        return facultyRepository.save(faculty);
    }

    /**
     * Обновление существующего факультета.
     * @param faculty объект FacultyModel
     * @return обновленный объект FacultyModel
     */
    public FacultyModel updateFaculty(FacultyModel faculty) {
        return facultyRepository.save(faculty);
    }

    /**
     * Удаление факультета по идентификатору.
     * @param id идентификатор факультета
     */
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
