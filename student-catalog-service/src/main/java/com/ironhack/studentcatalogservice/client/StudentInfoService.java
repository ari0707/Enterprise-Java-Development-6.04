package com.ironhack.studentcatalogservice.client;

import com.ironhack.studentcatalogservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("student-info-service")
public interface StudentInfoService {

    @GetMapping("/api/student/{studentId}")
    Student getStudentById();
}
