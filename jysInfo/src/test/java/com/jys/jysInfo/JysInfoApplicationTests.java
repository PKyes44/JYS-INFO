package com.jys.jysInfo;

import com.jys.jysInfo.excel.ExcelRead;
import com.jys.jysInfo.excel.ReadOption;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class JysInfoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UniversityRepository uniRepo;

	@Test
	@Transactional
	public void countTest() {

		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		uniInfo.setBaseYear("2022");
		uniInfo.setEstablishSeparate("공립");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation uniInfo2 = new UniversityInformation();
		uniInfo2.setSchoolName("우송대학교");
		uniInfo2.setBaseYear("2022");
		uniInfo2.setEstablishSeparate("공립");
		Long uniInfoId2 = uniRepo.save(uniInfo2);

		UniversityInformation uniInfo3 = new UniversityInformation();
		uniInfo3.setSchoolName("한양대학교");
		uniInfo3.setBaseYear("2022");
		uniInfo3.setEstablishSeparate("사립");
		Long uniInfoId3 = uniRepo.save(uniInfo3);

		int count = uniRepo.CountById();
		Assertions.assertThat(count == 3);
	}

	@Test
	@Transactional
	public void excelToDatabaseTest() {
		ReadOption ro = new ReadOption();
		ro.setFilePath("C:\\document\\JYS-Information\\jysInfo\\src\\main\\resources\\static\\입학전형유형별선발결과현황.xlsx");
		ro.setStartRow(1);
		// [{A: 2022, C: 사립 ..} ..]
		List<Map<String, String>> result = ExcelRead.read(ro);

		System.out.println("result = " + result);
		result.remove(0);

		for (Map<String, String> row : result) {
			UniversityInformation goDBInfo = UniversityInformation.builder()
					.baseYear(row.get("A"))
					.schoolType(row.get("B"))
					.establishSeparate(row.get("C"))
					.schoolName(row.get("D")).capacitySeparate(row.get("E"))
					.admissionType(row.get("F"))
					.admissionMainName(row.get("G"))
					.admissionMediumName(row.get("H"))
					.admissionSmallName(row.get("I"))
					.earlyDecisionRecruit(row.get("J"))
					.earlyDecisionSignCnt(row.get("K"))
					.earlyDecisionSignPercent(row.get("L"))
					.regularDecisionRecruit(row.get("M"))
					.regularDecisionSignCnt(row.get("N"))
					.regularDecisionSignPercent(row.get("O"))
					.addRecruit(row.get("P"))
					.addSignCnt(row.get("Q"))
					.addSignPercent(row.get("R"))
					.finalRecruit(row.get("S"))
					.finalSignCnt(row.get("T"))
					.finalSignPercent(row.get("U"))
					.build();
			uniRepo.save(goDBInfo);
		}
	}
	
	@Test
	@Transactional
	public void paginationTest() {
		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		uniInfo.setBaseYear("2022");
		uniInfo.setEstablishSeparate("공립");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation uniInfo2 = new UniversityInformation();
		uniInfo2.setSchoolName("우송대학교");
		uniInfo2.setBaseYear("2022");
		uniInfo2.setEstablishSeparate("공립");
		Long uniInfoId2 = uniRepo.save(uniInfo2);

		UniversityInformation uniInfo3 = new UniversityInformation();
		uniInfo3.setSchoolName("한양대학교");
		uniInfo3.setBaseYear("2022");
		uniInfo3.setEstablishSeparate("사립");
		Long uniInfoId3 = uniRepo.save(uniInfo3);

		Pageable pageable = Pageable.builder()
				.offset(0)
				.pageSize(1)
				.build();

		List<UniversitySearchDAO> result = uniRepo.findList("공립", pageable);

		Assertions.assertThat(pageable.getPageSize() >= result.size());
	}
	
	@Test
	@Transactional
	public void readTest() {
		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		uniInfo.setBaseYear("2022");
		uniInfo.setSchoolType("공립");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation uniInfo2 = new UniversityInformation();
		uniInfo2.setSchoolName("우송대학교");
		uniInfo2.setBaseYear("2022");
		uniInfo2.setSchoolType("공립");
		Long uniInfoId2 = uniRepo.save(uniInfo2);

		UniversityInformation uniInfo3 = new UniversityInformation();
		uniInfo3.setSchoolName("한양대학교");
		uniInfo3.setBaseYear("2022");
		uniInfo3.setSchoolType("사립");
		Long uniInfoId3 = uniRepo.save(uniInfo3);

		Pageable pageable = Pageable.builder()
				.offset(0)
				.pageSize(2)
				.build();

		List<UniversitySearchDAO> result = uniRepo.findList("공립", pageable);

		for (UniversitySearchDAO findUniInfo : result) {
			System.out.println("findUniInfo.getSchoolName() = " + findUniInfo.getSchoolName());
			if (findUniInfo.getId().equals(uniInfo.getId())) {
				Assertions.assertThat(findUniInfo.getSchoolName().equals(uniInfo.getSchoolName()));
				Assertions.assertThat(findUniInfo.equals(uniInfo));
			}
			if (findUniInfo.getId().equals(uniInfo2.getId())) {
				Assertions.assertThat(findUniInfo.getSchoolName().equals(uniInfo2.getSchoolName()));
				Assertions.assertThat(findUniInfo.equals(uniInfo2));
			}
		}

	}

	@Test
	@Transactional
	public void writeTest() {
		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation findUniInfo = uniRepo.findOne(uniInfoId);

		Assertions.assertThat(findUniInfo.getId().equals(uniInfo.getId()));
		Assertions.assertThat(findUniInfo.getSchoolName().equals(uniInfo.getSchoolName()));
		Assertions.assertThat(findUniInfo.equals(uniInfo));
	}
}
