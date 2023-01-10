package com.ironhack.studentcatalogservice.client;

import com.ironhack.studentcatalogservice.model.Course;
import com.ironhack.studentcatalogservice.model.Grade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient
public interface GradesDataService {

    @GetMapping("/api/courses/{id}")
    Course getCourseById(@PathVariable(name="id") Integer courseCode);

    @GetMapping("/api/courses/{courseId}/grades")
    Course getGradesByCourseId(@PathVariable (name = "courseId") Integer courseCode);

    @GetMapping("/api/grades")
    List<Grade> getAllGrades();
}
