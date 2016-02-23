/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.marta.laba0.web;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.marta.laba0.dao.StudentDAO;
import ru.marta.laba0.domain.Student;

/**
 *
 * @author Marta
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDAO dao;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String readAllStudents(Model model) {
        model.addAttribute("students", dao.readAllStudents());
        return "/student/all";
    }

    @RequestMapping(value = "/about/{id}", method = RequestMethod.GET)
    public String readStudent(@PathVariable("id") int id, Model model) {
        Student student = dao.readStudent(id);
        if (student == null) {
            throw new NotFoundException();
        }
        model.addAttribute("student", student);
        return "/student/about";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(Model model) {
        return "/student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute Student student, Model model) {
        int id = dao.createNewStudent(student);
        return "redirect:/student/all";
    }

    @RequestMapping(value = "/up/{id}", method = RequestMethod.GET)
    public String updateStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", dao.readStudent(id));
        return "/student/up";
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute Student student, Model model) {
        if (dao.updateStudent(student)) {
            return "redirect:/student/all";
        } else {
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", dao.readStudent(id));
        return "/student/del";
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delStudent(@RequestParam(name = "id", required = true) int id, Model model) {
        if (dao.deleteStudent(id)) {
            return "redirect:/student/all";
        } else {
            return "redirect:/error";
        }
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Entity with specified id not found")
    public void handleNotFoundException(NotFoundException ex,
            HttpServletResponse response) throws IOException {
    }
}
