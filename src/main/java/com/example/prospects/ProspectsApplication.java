package com.example.prospects;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.prospects.controller.AppControl;
//import com.example.prospects.repository.Data;
//import com.example.prospects.services.Services;
//import com.example.prospects.vue.Display;

@SpringBootApplication
public class ProspectsApplication
//	implements CommandLineRunner
	{
	
//	@Autowired
//	private Services services;
//	@Autowired
//	private Display disp;
//	@Autowired
//	private AppControl control;

	public static void main(String[] args) {
		SpringApplication.run(ProspectsApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		control.run();
////		disp.dispayClientsList(services.getData());
//	}

}
