package com.cos.newssave01.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


public class TestBatch {

	int num = 1;
	
	@Scheduled(cron = "0 * * * * *", zone = "Asia/Seoul")
	public void testCount() {
		System.out.println("숫자 카운트 : "+num);
		num++;
	}
}