package com.jys.jysInfo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JysInfoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Resource
	FirebaseService firebaseService;

	@Test
	public void Test() throws Exception {
		Member member = Member.builder()
				.id("0")
				.name("user1").build();
		firebaseService.getUserDetails(member);
	}
}
