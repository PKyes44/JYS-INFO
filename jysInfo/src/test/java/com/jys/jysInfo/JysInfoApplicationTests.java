package com.jys.jysInfo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JysInfoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void Test() throws Exception {
		ReadOption ro = new ReadOption();
		ro.setFilePath("C:\\Users\\rugat\\OneDrive\\바탕 화면\\JYS-Information\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
		ro.setOutputColumns("A","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U");
		ro.setStartRow(1);

		List<List<String>> result = ExcelRead.read(ro);
		List<String> columns = new ArrayList<String>();
		List<List<String>> rows = new ArrayList<>();

//		for (String col : ro.getOutputColumns()) {
//			// Map 상태의 Column을 List로 변환
//			Map<String, String> tempColumns = result.get(0);
//			columns.add(tempColumns.get(col));
//		}
//		for (int i = 1; i < result.size(); i++) {
//			List<String> row = new ArrayList<String>();
//			for (String col : ro.getOutputColumns()) {
//				Map<String, String> tempRows = result.get(i);
//				row.add(tempRows.get(col));
//			}
//			rows.add(row);
//		}
		System.out.println("columns = " + columns);
		System.out.println("rows = " + rows);
	}
}
