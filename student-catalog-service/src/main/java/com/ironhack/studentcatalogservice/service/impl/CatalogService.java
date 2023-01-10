package com.ironhack.studentcatalogservice.service.impl;

import com.ironhack.studentcatalogservice.client.GradesDataService;
import com.ironhack.studentcatalogservice.client.StudentInfoService;
import com.ironhack.studentcatalogservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {

    @Autowired
    StudentInfoService studentInfoService;

    @Autowired
    GradesDataService gradesDataService;


    public Catalog getCatalog(@PathVariable Integer courseCode){

        Course course = gradesDataService.getCourseById(courseCode);
        CourseGrade grades = gradesDataService.getGradesByCourseId(courseCode);

        Catalog catalog = new Catalog();
        catalog.setCourseName(course.getCourseName());
        List<StudentGrade> studentGrades = new ArrayList<>();

        for(Grade grade : grades.getGrades()){
            Student student = studentInfoService.getStudentById();
            studentGrades.add(new StudentGrade(student.getStudentName(), student.getStudentAge(), grade));
        }

        catalog.setStudentGrades(studentGrades);
        return catalog;

    }
}
