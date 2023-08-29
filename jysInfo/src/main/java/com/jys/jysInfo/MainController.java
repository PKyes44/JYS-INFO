package com.jys.jysInfo;

import com.jys.jysInfo.excel.ExcelRead;
import com.jys.jysInfo.excel.ReadOption;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/universityInfo")
    public String universityInfo(Model model) {
        return "UniversityInfo";
    }
    @ResponseBody
    @PostMapping(value = {"/universityInfo"})
    public ResponseEntity universityExcelSearch(
            @RequestParam(value = "searchText", defaultValue = "") String q,
            HttpServletRequest req, HttpServletResponse res,
            @RequestParam(defaultValue = "0", value = "page") int page) {
        Pageable pageable = Pageable.builder()
                .offset(page)
                .pageSize(20)
                .build();

        List<UniversityInformation> uniInfoList = uniService.searchUniversity(q, pageable);

        int dataCount = uniService.getDataCount();

        Map<String, Object> response = new HashMap<>();
        response.put("tableData", uniInfoList);
        response.put("dataCount", dataCount);

        return ResponseEntity.status(200).body(response);
    }
}
