package com.jys.jysInfo;

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
	public void paginationTest() {
		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		uniInfo.setBaseYear(2022);
		uniInfo.setEstablishSeparate("사립");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation uniInfo2 = new UniversityInformation();
		uniInfo2.setSchoolName("우송대학교");
		uniInfo2.setBaseYear(2021);
		uniInfo2.setEstablishSeparate("공립");
		Long uniInfoId2 = uniRepo.save(uniInfo2);

		UniversityInformation uniInfo3 = new UniversityInformation();
		uniInfo3.setSchoolName("한양대학교");
		uniInfo3.setBaseYear(2021);
		uniInfo3.setEstablishSeparate("사립");
		Long uniInfoId3 = uniRepo.save(uniInfo3);

		int baseYear = 2022;
		String establishSeparate = "공립";

		Pageable pageable = Pageable.builder()
				.offset(0)
				.pageSize(1)
				.build();

		List<UniversityInformation> result = uniRepo.findList(2022, establishSeparate, null, null, null, null, pageable);

		Assertions.assertThat(pageable.getPageSize() >= result.size());
	}
	
	@Test
	@Transactional
	public void readTest() {
		UniversityInformation uniInfo = new UniversityInformation();
		uniInfo.setSchoolName("서울대학교");
		uniInfo.setBaseYear(2022);
		uniInfo.setSchoolType("사립");
		Long uniInfoId = uniRepo.save(uniInfo);

		UniversityInformation uniInfo2 = new UniversityInformation();
		uniInfo2.setSchoolName("우송대학교");
		uniInfo2.setBaseYear(2021);
		uniInfo2.setSchoolType("공립");
		Long uniInfoId2 = uniRepo.save(uniInfo2);

		UniversityInformation uniInfo3 = new UniversityInformation();
		uniInfo3.setSchoolName("한양대학교");
		uniInfo3.setBaseYear(2021);
		uniInfo3.setSchoolType("사립");
		Long uniInfoId3 = uniRepo.save(uniInfo3);

		int baseYear = 2022;
		String establishSeparate = "공립";

		Pageable pageable = Pageable.builder()
				.offset(0)
				.pageSize(2)
				.build();

		List<UniversityInformation> result = uniRepo.findList(baseYear, establishSeparate, null, null, null, null, pageable);

		for (UniversityInformation findUniInfo : result) {
			System.out.println("findUniInfo.getSchoolName() = " + findUniInfo.getSchoolName());
			if (findUniInfo.getId().equals(uniInfo.getId())) {
				Assertions.assertThat(findUniInfo.getSchoolName().equals(uniInfo.getSchoolName()));
				Assertions.assertThat(findUniInfo.getSchoolType().equals(uniInfo.getSchoolType()));
				Assertions.assertThat(findUniInfo.equals(uniInfo));
			}
			if (findUniInfo.getId().equals(uniInfo2.getId())) {
				Assertions.assertThat(findUniInfo.getSchoolName().equals(uniInfo2.getSchoolName()));
				Assertions.assertThat(findUniInfo.getSchoolType().equals(uniInfo2.getSchoolType()));
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
