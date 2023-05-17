package fooddelivery.common;

import fooddelivery.MypageApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { MypageApplication.class })
public class CucumberSpingConfiguration {}
