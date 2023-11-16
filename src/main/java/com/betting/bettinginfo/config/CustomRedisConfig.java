package com.betting.bettinginfo.config;

import io.lettuce.core.ClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class CustomRedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        // Disable automatic reconnection
        ClientOptions clientOptions = ClientOptions.builder()
                .autoReconnect(false).disconnectedBehavior(ClientOptions.DisconnectedBehavior.ACCEPT_COMMANDS)
                .build();

        // Create Lettuce client configuration
        LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
                .clientOptions(clientOptions)
                .build();

        // Create Redis standalone configuration
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("localhost"); // Set your Redis host
        redisStandaloneConfiguration.setPort(6379); // Set your Redis port
        // Create Lettuce connection factory using builder
        return new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
    }
}