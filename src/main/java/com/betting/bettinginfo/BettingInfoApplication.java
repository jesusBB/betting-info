package com.betting.bettinginfo;

import com.betting.bettinginfo.config.CustomRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class, CustomRedisConfig.class})
@EnableCaching
public class BettingInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BettingInfoApplication.class, args);
	}
}
