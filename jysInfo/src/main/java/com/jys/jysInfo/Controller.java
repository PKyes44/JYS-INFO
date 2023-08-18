package com.jys.jysInfo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String menu() {
        return "Menu";
    }
    @GetMapping("/companyInfo")
    public String companyInfo() {
        return "CompanyInfo";
    }
    @GetMapping("/majorInfo")
    public String majorInfo() {
        return "MajorInfo";
    }
    @GetMapping("/universityInfo")
    public String universityInfo() {
        return "UniversityInfo";
    }

}
