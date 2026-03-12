package com.example.springbootWithJsp;

import org.springframework.stereotype.Component;


import jakarta.annotation.PreDestroy;

@Component
public class ShutdownTask {

	static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShutdownTask.class);
	
    @PreDestroy
    public void onShutdown() {
    	log.info("Application shutting down...");
        // ทำสิ่งที่ต้องการ เช่น
        // - ปิด connection
        // - flush log
        // - notify monitoring
    }
}