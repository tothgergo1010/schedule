package hu.nye.progkor.schedule.controller;

import hu.nye.progkor.schedule.model.Class;
import hu.nye.progkor.schedule.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public String getAllClasses(Model model) {
        List<Class> classes = classService.getAllClasses();
        model.addAttribute("classes", classes);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("class", new Class());
        return "new-class";
    }

    @PostMapping
    public String createClass(@ModelAttribute("class") Class newClass) {
        classService.createClass(newClass);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Class existingClass = classService.getClassById(id);
        model.addAttribute("class", existingClass);
        return "edit-class";
    }

    @PostMapping("/update")
    public String updateClass(@ModelAttribute("class") Class updatedClass) {
        classService.updateClass(updatedClass.getId(), updatedClass);
        return "redirect:/classes";
    }

    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable("id") Long id) {
        classService.deleteClass(id);
        return "redirect:/classes";
    }
}
