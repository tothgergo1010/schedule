package hu.nye.progkor.schedule.service;

import hu.nye.progkor.schedule.model.Class;
import hu.nye.progkor.schedule.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return classRepository.findById(id).orElse(null);
    }

    public Class createClass(Class newClass) {
        return classRepository.save(newClass);
    }

    public Class updateClass(Long id, Class updatedClass) {
        if (classRepository.existsById(id)) {
            updatedClass.setId(id);
            return classRepository.save(updatedClass);
        }
        return null;
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}
