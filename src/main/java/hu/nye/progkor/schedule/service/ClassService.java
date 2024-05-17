package hu.nye.progkor.schedule.service;

import hu.nye.progkor.schedule.model.Class;
import hu.nye.progkor.schedule.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(Long id) {
        Optional<Class> classOptional = classRepository.findById(id);
        return classOptional.orElse(null);
    }

    public Class createClass(Class classObject) {
        return classRepository.save(classObject);
    }

    public Class updateClass(Long id, Class classObject) {
        if (classRepository.existsById(id)) {
            classObject.setId(id);
            return classRepository.save(classObject);
        }
        return null;
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
