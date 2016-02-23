/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.marta.laba0.dao;

import java.util.List;
import ru.marta.laba0.domain.Student;

/**
 *
 * @author Marta
 */
public interface StudentDAO {
    List<Student> readAllStudents();
    Student readStudent(int id);
    int createNewStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
