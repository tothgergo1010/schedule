package hu.nye.progkor.schedule.controller;

import hu.nye.progkor.schedule.model.Class;
import hu.nye.progkor.schedule.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Class getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public Class createClass(@RequestBody Class classObject) {
        return classService.createClass(classObject);
    }

    @PutMapping("/{id}")
    public Class updateClass(@PathVariable Long id, @RequestBody Class classObject) {
        return classService.updateClass(id, classObject);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
