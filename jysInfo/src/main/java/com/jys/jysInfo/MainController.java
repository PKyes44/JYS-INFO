package com.jys.jysInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String universityInfo(Model model) {
        return "UniversityInfo";
    }

    @ResponseBody
    @PostMapping(value = {"/universityInfo"})
    public List<Map<String, String>> universityExcelSearch(HttpServletRequest req, HttpServletResponse res,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "20") int size) {
        ReadOption ro = new ReadOption();
        ro.setFilePath("C:\\Users\\rugat\\OneDrive\\바탕 화면\\JYS-Information\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
        ro.setOutputColumns("A","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U");
        ro.setStartRow(1);

        List<Map<String, String>> result = ExcelRead.read(ro);

        // 페이징 처리를 위해 데이터를 sublist로 추출
        int startIdx = page * size;
        int endIdx = Math.min(startIdx + size, result.size());
        List<Map<String, String>> pageData = result.subList(startIdx, endIdx);

        return pageData;
    }

}
