package com.revolut.Bornin;

import com.revolut.Bornin.controller.BirthdayController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value={"test"})
class BorninApplicationTests {

	@Autowired
	private BirthdayController controller;

 	@Test
	void contextLoads() {
	}

 	@Test
	public void contextLoadsController() throws Exception {
 		assertThat(controller).isNotNull();
 	}

 }
