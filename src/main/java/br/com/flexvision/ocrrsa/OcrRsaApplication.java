package br.com.flexvision.ocrrsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OcrRsaApplication {

	// Static variable for the capture Window
	@Autowired
	public static CaptureWindow windowReader;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(OcrRsaApplication.class).headless(false).run(args);
		CaptureWindow appFrame = context.getBean(CaptureWindow.class);
	}
}
