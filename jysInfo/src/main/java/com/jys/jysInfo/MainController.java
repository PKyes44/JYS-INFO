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
    @GetMapping("/universityInfo")
    public String universityInfo(Model model) {
        return "/university/InformationTable";
    }
    @ResponseBody
    @PostMapping(value = {"/universityInfo"})
    public ResponseEntity universitySearch(
            @RequestParam(value = "searchText", defaultValue = "") String q,
            @RequestParam(defaultValue = "1", value = "page") int page) {
        int pageSize = 15;

        System.out.println("page = " + page);

        Pageable pageable = Pageable.builder()
                .offset((page-1) * pageSize)
                .pageSize(pageSize)
                .build();

        List<UniversityInformation> uniInfoList = uniService.getSearchUniversity(q, pageable);

        List<CountDAO> dataCount = new ArrayList<>();
        if (q.isEmpty()) {
            dataCount = uniService.getDataCount();
        } else {
            dataCount = uniService.getSearchCount(q);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("tableData", uniInfoList);
        response.put("dataCount", dataCount.get(0));
        response.put("pageSize", pageSize);

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = {"/universityInfo/detail"})
    public String universityDetail(@RequestParam(value = "id") long id, Model model) {
        System.out.println("id = " + id);
        UniversityInformation universityInfo = uniService.getUniversityInfo(id);
        model.addAttribute("detailData", universityInfo);
        return "university/Detail";
    }
}
