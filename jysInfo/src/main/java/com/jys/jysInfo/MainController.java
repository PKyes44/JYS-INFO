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
    public ResponseEntity universityExcelSearch(HttpServletRequest req, HttpServletResponse res,
                                                @RequestParam(defaultValue = "0") int page) {
        ReadOption ro = new ReadOption();
        ro.setFilePath("C:\\Users\\Yang\\OneDrive\\바탕 화면\\포폴제출용\\JYS-Information\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
        ro.setOutputColumns("A","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U");
        ro.setStartRow(1);

        List<Map<String, String>> result = ExcelRead.read(ro);

        List<Map<String, String>> columns = new ArrayList<>();
        columns.add(result.get(0));
        result.remove(0);

        int size = 90;
        int startIdx = page * size;
        int endIdx = Math.min(startIdx + size, result.size());
        List<Map<String, String>> pageData = result.subList(startIdx, endIdx);

        System.out.println("pageData = " + pageData);

        Map<String, List<Map<String,String>>> response = new HashMap<>();
        response.put("pageData", pageData);

        return ResponseEntity.status(200).body(response);
    }
}
