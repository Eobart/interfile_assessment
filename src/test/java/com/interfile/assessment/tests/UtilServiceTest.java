package com.interfile.assessment.tests;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.interfile.assessment.services.UtilService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilServiceTest {
	@Autowired
	UtilService utilService;

	@Test
	void testProcess() {
		utilService.processXML(new java.io.File("C:\\Users\\Christopher\\Downloads\\StatementMultiple.xml"));
	}

	@Test
	void testPDFGeneration() {
		System.out.println("Start");
		utilService.generatePDF();
		System.out.println("Done");
	}
}
