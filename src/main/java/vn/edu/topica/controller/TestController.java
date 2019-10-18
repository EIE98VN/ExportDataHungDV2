package vn.edu.topica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.topica.model.JackfruitCourse;
import vn.edu.topica.service.CsvIOService;
import vn.edu.topica.service.ExportService;
import vn.edu.topica.service.JackFruitCourseService;

@RestController
public class TestController {

    @Autowired
    JackFruitCourseService jackFruitCourseService;

    @Autowired
    ExportService exportService;

    @Autowired
    CsvIOService csvIOService;

    @GetMapping("/test")
    public void test(){
        csvIOService.write();
    }

}
