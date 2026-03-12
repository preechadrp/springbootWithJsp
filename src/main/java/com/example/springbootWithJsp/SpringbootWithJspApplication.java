package com.example.springbootWithJsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan  //ให้ไป scan หาพวกที่ใช้ @WebServlet,@WebFilter,@WebListener
@SpringBootApplication
public class SpringbootWithJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithJspApplication.class, args);
	}

}
