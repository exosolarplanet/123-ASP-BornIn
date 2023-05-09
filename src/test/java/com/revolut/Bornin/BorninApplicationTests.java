package com.revolut.Bornin;

import com.revolut.Bornin.Controller.BirthdayControllerTests;
import com.revolut.Bornin.controller.BirthdayController;
import com.revolut.Bornin.jpa.JpaTests;
import com.revolut.Bornin.service.BirthdayServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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
