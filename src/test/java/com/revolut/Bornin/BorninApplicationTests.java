package com.revolut.Bornin;


import com.revolut.Bornin.controller.BirthdayController;

import com.revolut.Bornin.jpa.JpaTests;
import com.revolut.Bornin.service.BirthdayService;
import com.revolut.Bornin.service.BirthdayServiceTest;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value={"test"})
class BorninApplicationTests {

	@BeforeClass
	public static void setUpClass(){
		ApplicationContext context = new AnnotationConfigApplicationContext(BorninApplication.class);
	}

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
