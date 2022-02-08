package com.test_md4_tuan4.controller;

import com.test_md4_tuan4.model.Student;
import com.test_md4_tuan4.service.ClassRoomService;
import com.test_md4_tuan4.service.StudenSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Studencontroller {
@Autowired
    StudenSevice studenSevice;
@Autowired
    ClassRoomService classRoomService;
    @GetMapping("/student")
    public ModelAndView findAll(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("student", studenSevice.findAll(PageRequest.of(page, 3)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createform() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classroom", classRoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createStuden(@ModelAttribute(value = "student") Student student) {
        studenSevice.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editform(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", studenSevice.findById(id));
        modelAndView.addObject("classroom", classRoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editStaff( @ModelAttribute(value = "student") Student student) {
        studenSevice.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteform(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("mess", studenSevice.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        studenSevice.delete(id);
        return "redirect:/student";
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("student", studenSevice.findByName(search));
        return modelAndView;
    }


    @GetMapping("/detail")
    public ModelAndView detailForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("student", studenSevice.findById(id));
        return modelAndView;
    }

}
