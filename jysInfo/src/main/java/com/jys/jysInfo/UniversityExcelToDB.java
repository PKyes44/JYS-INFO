//package com.jys.jysInfo;
//
//import com.jys.jysInfo.excel.ExcelRead;
//import com.jys.jysInfo.excel.ReadOption;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class UniversityExcelToDB implements CommandLineRunner {
//    private final UniversityService uniService;
//
//    public UniversityExcelToDB(UniversityService uniService) {
//        this.uniService = uniService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        ReadOption ro = new ReadOption();
//        ro.setFilePath("C:\\document\\JYS-Information\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
//        ro.setStartRow(1);
//        // [{A: 2022, C: 사립 ..} ..]
//        List<Map<String, String>> result = ExcelRead.read(ro);
//
//        System.out.println("result = " + result);
//        result.remove(0);
//
//        for (Map<String, String> row : result) {
//            UniversityInformation goDBInfo = UniversityInformation.builder()
//                    .baseYear(row.get("A"))
//                    .schoolType(row.get("B"))
//                    .establishSeparate(row.get("C"))
//                    .schoolName(row.get("D")).capacitySeparate(row.get("E"))
//                    .admissionType(row.get("F"))
//                    .admissionMainName(row.get("G"))
//                    .admissionMediumName(row.get("H"))
//                    .admissionSmallName(row.get("I"))
//                    .earlyDecisionRecruit(row.get("J"))
//                    .earlyDecisionSignCnt(row.get("K"))
//                    .earlyDecisionSignPercent(row.get("L"))
//                    .regularDecisionRecruit(row.get("M"))
//                    .regularDecisionSignCnt(row.get("N"))
//                    .regularDecisionSignPercent(row.get("O"))
//                    .addRecruit(row.get("P"))
//                    .addSignCnt(row.get("Q"))
//                    .addSignPercent(row.get("R"))
//                    .finalRecruit(row.get("S"))
//                    .finalSignCnt(row.get("T"))
//                    .finalSignPercent(row.get("U"))
//                    .build();
//            uniService.saveUniversityInfo(goDBInfo);
//        }
//    }
//}
