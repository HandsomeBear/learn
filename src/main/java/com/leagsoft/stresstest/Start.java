package com.leagsoft.stresstest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Start {

	private static final Logger logger = LoggerFactory.getLogger(Start.class);

	public static void main(String[] args) {
		logger.info("Execute main!");

		ExecutorService pool = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 600; i++) {
			if ((i & 1) != 0) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			pool.submit(new ApproveResultTask());
		}
	}

}
