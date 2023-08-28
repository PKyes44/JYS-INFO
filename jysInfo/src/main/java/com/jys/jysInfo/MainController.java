package com.jys.jysInfo;

import com.jys.jysInfo.excel.ExcelRead;
import com.jys.jysInfo.excel.ReadOption;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final UniversityService uniService;
    public MainController(UniversityService uniService) {
        this.uniService = uniService;
    }

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
//    @GetMapping("/universityInfo")
//    public String universityInfo(Model model) {
//        return "UniversityInfo";
//    }

    @ResponseBody
    //
    @RequestMapping("/universityInfo/{}")
    public ResponseEntity universityExcelSearch(HttpServletRequest req, HttpServletResponse res,
                                                @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = Pageable.builder()
                .offset(page)
                .pageSize(15)
                .build();



        Map<String, List<Map<String,String>>> response = new HashMap<>();

        return ResponseEntity.status(200).body(response);
    }
}
