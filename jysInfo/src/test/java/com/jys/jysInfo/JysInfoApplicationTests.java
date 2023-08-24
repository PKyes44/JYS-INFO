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
//	@Test
//	public void readTest() {
//		int baseYear = 2022;
//		String establishSeparate = "공립";
//
//		Pageable pageable = Pageable.builder()
//				.offset(0)
//				.pageSize(1)
//				.build();
//
//		String result = uniRepo.findList(baseYear, establishSeparate, null, null, null, null, pageable);
//		System.out.println("result = " + result);
//	}

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
