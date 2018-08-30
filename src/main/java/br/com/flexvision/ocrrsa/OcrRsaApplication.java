package br.com.flexvision.ocrrsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OcrRsaApplication {

	// Static variable for the capture Window
	@Autowired
	public static CaptureWindow windowReader;
	
	public static void main(String[] args) {
		SpringApplication.run(OcrRsaApplication.class, args);
	}
}
