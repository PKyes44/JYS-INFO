package com.jys.jysInfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JysInfoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UniversityRepository uniRepo;
	@Test
	public void Test1() {
//		int baseYear = 2022;
//		String establishSeparate = "공립";
//
//		String result = uniRepo.findList(baseYear, establishSeparate, null, null, null, null);
//		System.out.println("result = " + result);
	}
}
