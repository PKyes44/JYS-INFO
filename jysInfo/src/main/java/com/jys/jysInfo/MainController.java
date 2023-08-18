package com.jys.jysInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
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

        ReadOption ro = new ReadOption();
        ro.setFilePath("C:\\Users\\Yang\\OneDrive\\바탕 화면\\포폴제출용\\JYS-INFO\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
        ro.setOutputColumns("A", "B");
        ro.setStartRow(1);

        List<Map<String, String>> result = ExcelRead.read(ro);

        for(Map<String, String> map : result) {
            System.out.println(map.get("A"));
        }

        return "UniversityInfo";
    }

}
